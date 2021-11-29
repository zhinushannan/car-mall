<template>

  <div id="table">
    <el-card class="box-card">
      <template>
        <el-table :data="page.data" height="450" border style="width: 100%">
          <el-table-column type="index" label="序号" align="center" width="50" />
          <el-table-column prop="brand" label="品牌" align="center" width="80" />
          <el-table-column prop="model" label="车系" width="150" />
          <el-table-column prop="gearbox" label="变速箱" align="center" width="100" />
          <el-table-column prop="mileage" label="表显里程" align="center" width="80" />
          <el-table-column prop="price" label="售价" align="center" width="80" />
          <el-table-column prop="userEmail" label="车主邮箱" align="center" width="200" />
          <el-table-column prop="registerDate" label="上牌日期" align="center" />
          <el-table-column prop="createdGmt" label="注册时间" align="center" />
          <el-table-column fixed="right" align="center" label="查看">
            <template slot-scope="scope">
              <el-button size="middle" @click="check(scope.row)"><i class="el-icon-search"></i>查看</el-button>
            </template>
          </el-table-column>
        </el-table>
      </template>
      <!-- 分页 -->
      <div class="block" style="margin-top: 20px;">
        <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="page.page"
                       :page-sizes="[10, 20, 50, 100]" :page-size="page.size" layout="total, sizes, prev, pager, next, jumper" :total="page.total">
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
      _this.$axios.post("car/list", _this.page).then((response) => {
        let data = response.data
        _this.page = data.data
        console.log("结果", _this.page)
      })
    },
    check(row) {
      console.log(row)
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