<template>

  <div id="table">
    <el-card class="box-card">
      <template>
        <el-table :data="page.data" border height="450" style="width: 100%">
          <el-table-column align="center" label="序号" type="index" width="50"/>
          <el-table-column label="邮箱" prop="email" width="180"/>
          <el-table-column align="center" label="注册时间" prop="createdGmt"/>
          <el-table-column align="center" label="上次修改时间" prop="modifiedGmt"/>
          <el-table-column align="center" label="上次登录时间" prop="lastLogin"/>
          <el-table-column align="center" fixed="right" label="操作" width="200">
            <template slot-scope="scope">
              <el-tooltip :content="'将密码重置为：' + scope.row.email" class="item" effect="dark" placement="bottom">
                <el-popconfirm title="确定重置该用户的密码吗？" @confirm="reset(scope.row.email)">
                  <el-button slot="reference" size="middle"><i class="el-icon-setting"></i>重置密码</el-button>
                </el-popconfirm>
              </el-tooltip>
            </template>
          </el-table-column>
        </el-table>
      </template>
      <!-- 分页 -->
      <div class="block" style="margin-top: 20px;">
        <el-pagination :current-page="page.page" :page-size="page.size" :page-sizes="[10, 20, 50, 100]"
                       :total="page.total"
                       background layout="total, sizes, prev, pager, next, jumper"
                       @size-change="handleSizeChange" @current-change="handleCurrentChange">
        </el-pagination>
      </div>
    </el-card>

  </div>

</template>

<script>
export default {
  name: "list",
  data() {
    return {
      page: {
        page: 1,
        size: 10
      }
    }
  },
  methods: {
    list() {
      let _this = this
      _this.$axios.post("user/list", _this.page).then((response) => {
        let data = response.data
        _this.page = data.data
      })
    },
    reset(email) {
      let _this = this
      _this.$axios.put("user/reset?email=" + email).then((response) => {
        let data = response.data
        _this.$message.success(data.message)
        _this.list()
      })
    },
    handleSizeChange(val) {
      let _this = this
      _this.page["size"] = val
      _this.list()
    },
    handleCurrentChange(val) {
      let _this = this
      _this.page["page"] = val
      _this.list()
    }
  },
  mounted() {
    let _this = this
    _this.list()
  }
}
</script>

<style scoped>

</style>