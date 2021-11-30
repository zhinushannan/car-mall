<template>

  <div id="table">
    <el-card class="box-card">
      <template>
        <el-table :data="page.data" border height="450" style="width: 100%">
          <el-table-column align="center" label="序号" type="index" width="50"/>
          <el-table-column align="center" label="品牌" prop="brand" width="80"/>
          <el-table-column label="车系" prop="model" width="150"/>
          <el-table-column align="center" label="变速箱" prop="gearbox" width="100"/>
          <el-table-column align="center" label="表显里程" prop="mileage" width="80"/>
          <el-table-column align="center" label="售价" prop="price" width="80"/>
          <el-table-column align="center" label="车主邮箱" prop="userEmail" width="200"/>
          <el-table-column align="center" label="上牌日期" prop="registerDate"/>
          <el-table-column align="center" label="注册时间" prop="createdGmt"/>
          <el-table-column align="center" fixed="right" label="查看">
            <template slot-scope="scope">
              <el-button size="middle" @click="check(scope.row)"><i class="el-icon-search"></i>查看</el-button>
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