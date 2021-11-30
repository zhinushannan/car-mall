<template>

  <div>

    <div>
      <el-row :gutter="10">

        <el-col :lg="12" :md="12" :sm="12" :xl="12" :xs="12">
          <el-image
              :preview-src-list="carDetail.imgList"
              :src="carDetail.img[0].url"
              fit="cover"
              style="width: 100%; height: 400px"></el-image>
        </el-col>

        <el-col :lg="12" :md="12" :sm="12" :xl="12" :xs="12" style="padding-left: 30px; padding-right: 30px">

          <h1 style="margin-top: 0">{{ carDetail.brand }} {{ carDetail.model }} {{ carDetail.displacement }}</h1>

          <el-row :gutter="10">

            <el-col :lg="5" :md="5" :sm="5" :xl="5" :xs="5">
              <div class="car-info">
                <h3>{{ carDetail.registerDate.split("-")[0] }}年</h3>
                <span class="car-info-title">上牌时间</span>
              </div>
            </el-col>

            <el-col :lg="5" :md="5" :sm="5" :xl="5" :xs="5">
              <div class="car-info">
                <h3>{{ carDetail.mileage }}万公里</h3>
                <span class="car-info-title">表显里程</span>
              </div>
            </el-col>


            <el-col :lg="4" :md="4" :sm="4" :xl="4" :xs="4">
              <div class="car-info">
                <h3>{{ carDetail.displacement }}T</h3>
                <span class="car-info-title">排量</span>
              </div>
            </el-col>

            <el-col :lg="4" :md="4" :sm="4" :xl="4" :xs="4">
              <div class="car-info">
                <h3>{{ carDetail.gearbox }}</h3>
                <span class="car-info-title">变速箱</span>
              </div>
            </el-col>


          </el-row>

          <div style="margin-top: 20px">
            <p style="margin-bottom: 0">到手价</p>
            <h3 style="color: #F56C6C; font-size: 20px; display: inline-block; margin-top: 0">{{ carDetail.price }}
              万</h3>
            <p style="color: #909399; text-decoration: line-through; font-size: 16px; display: inline-block; line-height: 16px;">
              &nbsp;{{ carDetail.showPrice }} 万</p>
          </div>

          <el-tag style="height: 100px; width: 65%; padding: 15px 15px 15px 25px;color: #606266;" type="warning">
            <p style="font-size: 15px; margin-bottom: 10px; margin-top: 0">售后保障</p>

            <el-row :gutter="10">

              <el-col :lg="8" :md="8" :sm="8" :xl="8" :xs="8"><span><i class="el-icon-s-claim"
                                                                       style="color: #e6a23c"></i>不满意退全款</span></el-col>

              <el-col :lg="8" :md="8" :sm="8" :xl="8" :xs="8"><span><i class="el-icon-s-claim"
                                                                       style="color: #e6a23c"></i>30天全面保修</span>
              </el-col>

              <el-col :lg="8" :md="8" :sm="8" :xl="8" :xs="8"><span><i class="el-icon-s-claim"
                                                                       style="color: #e6a23c"></i>1年售后</span></el-col>

            </el-row>

          </el-tag>

          <div style="margin-top: 20px">
            <el-button type="primary" @click="appointment">预约看车</el-button>
          </div>
        </el-col>

      </el-row>
    </div>

    <div style="margin-top: 50px">
      <h1 style="margin-top: 0">{{ carDetail.brand }} {{ carDetail.model }} {{ carDetail.displacement }} 基本信息</h1>

      <el-descriptions :column="3" border class="margin-top">
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            品牌
          </template>
          {{ carDetail.brand }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            车系
          </template>
          {{ carDetail.model }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-location-outline"></i>
            上牌日期
          </template>
          {{ carDetail.registerDate }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            表显里程
          </template>
          {{ carDetail.mileage }}万公里
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            排量
          </template>
          {{ carDetail.displacement }}T
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            变速箱
          </template>
          {{ carDetail.gearbox }}
        </el-descriptions-item>
      </el-descriptions>
    </div>

    <div style="margin-top: 50px">
      <h1 style="margin-top: 0">{{ carDetail.brand }} {{ carDetail.model }} {{ carDetail.displacement }} 车辆照片</h1>

      <div v-for="img in carDetail.img" class="demo-image__preview"
           style="margin-top: 10px; margin-bottom: 10px; display: inline-block; width: 45%; margin-right: 5%">
        <el-image
            :preview-src-list="carDetail.imgList"
            :src="img.url"
            style="width: 100%; height: 400px">
        </el-image>
      </div>


    </div>

  </div>

</template>

<script>
export default {
  name: "car_detail",
  data() {
    return {
      carDetail: {}
    }
  },
  mounted() {
    let _this = this;
    _this.$axios.get("/car/query?id=" + _this.$route.params.id).then((response) => {
      let data = response.data;
      _this.carDetail = data.data;
      _this.carDetail["imgList"] = []
      for (let i = 0; i < _this.carDetail.img.length; i++) {
        _this.carDetail["imgList"].push(_this.carDetail.img[i].url)
      }
    })
  }
}
</script>

<style scoped>
.car-info {
  float: left;
  text-align: center;
  width: 100px;
}

.car-info-title {
  color: #909399;
}

.split-line {
  float: left;
  display: inline-block;
  width: 1px;
  height: 200px;
  background-color: #909399;
}

</style>