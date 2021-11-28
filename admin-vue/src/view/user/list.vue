<template>

  <div id="table">
    <el-card class="box-card">
      <template>
        <el-table :data="page.data" height="450" border style="width: 100%">
          <el-table-column type="index" label="序号" align="center" width="50" />
          <el-table-column prop="email" label="邮箱" width="180" />
          <el-table-column prop="createdGmt" label="注册时间" align="center" />
          <el-table-column prop="modifiedGmt" label="上次修改时间" align="center" />
          <el-table-column prop="lastLogin" label="上次登录时间" align="center" />
          <el-table-column fixed="right" align="center" label="操作" width="200">
            <template slot-scope="scope">
              <el-tooltip class="item" effect="dark" :content="'将密码重置为：' + scope.row.email" placement="bottom">
                <el-popconfirm title="确定重置该用户的密码吗？" @confirm="reset(scope.row.email)">
                  <el-button size="middle" slot="reference"><i class="el-icon-setting"></i>重置密码</el-button>
                </el-popconfirm>
              </el-tooltip>
            </template>
          </el-table-column>
        </el-table>
      </template>
      <!-- 分页 -->
      <div class="block" style="margin-top: 20px;">
        <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="page.page"
                       :page-sizes="[20, 50, 100]" :page-size="20" layout="total, sizes, prev, pager, next, jumper" :total="page.total">
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
        size: 20
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