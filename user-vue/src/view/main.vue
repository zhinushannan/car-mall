<template>

  <div>

    <div class="car-containers">


      <el-row :gutter="25" class="car-container">
        <el-col v-for="car in page.data" :lg="6" :md="6" :sm="6" :xl="6" :xs="6" style="margin-top: 20px">
          <el-card shadow="hover">

            <el-image
                :src="car.img[0].url"
                fit="cover"
                style="width: 100%; height: 200px"></el-image>

            <div class="car-info" style="padding-right: 14px">
              <span class="car-name">{{ car.brand }} {{ car.model }} {{ car.displacement }} {{ car.gearbox }}</span>
              <span class="car-brief">{{ car.registerDate.split("-")[0] }}年 丨 {{ car.mileage }}万公里</span>
              <span class="car-price"><span class="car-price-now">{{ car.price }}万</span>&nbsp;
                <span class="car-price-old">{{ car.showPrice }}万</span>&nbsp;&nbsp;|&nbsp;&nbsp;<el-link :href="'#/carDetail/' + car.id"
                                                                                                         style="font-size: 14px"
                                                                                                         type="primary">查看详情</el-link></span>
            </div>
            <div v-if="loginStatus">
              <el-tag v-if="car.frequency">浏览过{{ car.frequency }}次，上次浏览{{ car.lastBrowse }}</el-tag>
              <el-tag v-else="car.frequency">未看过</el-tag>
            </div>
          </el-card>
        </el-col>
      </el-row>

    </div>

    <!-- 分页 -->
    <el-pagination
        :current-page="page.page"
        :page-size="page.size"
        :page-sizes="[8, 16, 32]"
        :total="page.total"
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange">
    </el-pagination>

  </div>

</template>

<script>
export default {
  name: "main",
  data() {
    return {
      loginStatus: false,
      page: {
        page: 1,
        size: 8
      },
    }
  },
  methods: {
    list() {
      let _this = this
      _this.$axios.post("/car/list", _this.page).then((response) => {
        let data = response.data
        _this.page = data.data
        console.log(_this.page)
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

    if (_this.$cookies.get("email")) {
      _this.loginStatus = true
    }

  }

}
</script>

<style scoped>
.conditions {
  border: #EBEEF5 1px solid;
}

.choice {
  display: inline-block;
}

.choice > .el-button {
  display: inline-block;
  border: none;
  padding: 10px;
  margin-left: 5px;
  margin-right: 5px;
}

.conditions-title {
  color: #606266;
  margin-left: 20px;
  margin-right: 20px;
}

.condition-div {
  border-bottom: #EBEEF5 1px solid;
  line-height: 48px;
}

.conditions:last-child {
  border-bottom: none;
}

.car-container {
  margin-bottom: 20px;
}

.car-info > span {
  display: block;
}

.car-name {
  width: 100%;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}

.car-brief {
  color: #909399;
}

.car-price-old {
  color: #909399;
  text-decoration: line-through;
}

.el-button-checked {
  background-color: #ecf5ff;
  color: #409eff;
}

</style>