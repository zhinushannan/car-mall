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
                <span class="car-price-old">{{ car.showPrice }}万</span>&nbsp;&nbsp;|&nbsp;&nbsp;<el-link
                    :href="'#/carDetail/' + car.id"
                    style="font-size: 14px"
                    type="primary">查看详情</el-link></span>
            </div>
            <div>
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
  name: "history",
  data() {
    return {
      page: {
        size: 8,
        page: 1
      }
    }
  },
  methods: {
    list() {
      let _this = this
      _this.$axios.post("/car/history", _this.page).then((response) => {
        let data = response.data
        _this.page = data.data
        console.log(_this.page)
      })
    },
    handleSizeChange(val) {
    },
    handleCurrentChange(val) {
    },
  },
  mounted() {
    let _this = this;
    _this.list()
  }
}
</script>

<style scoped>

</style>