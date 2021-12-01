<template>

  <div>
    <h2 style="margin-left: 50px">出售车辆</h2>

    <el-form ref="sellForm" :model="sellForm" :rules="sellRules" class="demo-ruleForm" label-width="100px">
      <el-form-item label="品牌" prop="brand">
        <el-input v-model="sellForm.brand" placeholder="品牌"></el-input>
      </el-form-item>
      <el-form-item label="车型" prop="model">
        <el-input v-model="sellForm.model" placeholder="车型"></el-input>
      </el-form-item>

      <el-form-item label="上牌时间" required>
        <el-col :span="11">
          <el-form-item prop="registerDate">
            <el-date-picker v-model="sellForm.registerDate" placeholder="选择日期" style="width: 100%;"
                            type="date"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-form-item>

      <el-form-item label="表显里程" prop="mileage">
        <el-input v-model="sellForm.mileage" placeholder="表显里程（万公里）" type="number"></el-input>
      </el-form-item>

      <el-form-item label="排量" prop="displacement">
        <el-input v-model="sellForm.displacement" placeholder="排量"></el-input>
      </el-form-item>

      <el-form-item label="变速箱" prop="gearbox">
        <el-radio-group v-model="sellForm.gearbox">
          <el-radio label="手动"></el-radio>
          <el-radio label="自动"></el-radio>
          <el-radio label="手自一体"></el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="标价" prop="oldPrice">
        <el-input v-model="sellForm.oldPrice" placeholder="标价（万）"></el-input>
      </el-form-item>

      <el-form-item label="售价" prop="price">
        <el-input v-model="sellForm.price" placeholder="售价（万）"></el-input>
      </el-form-item>

      <el-form-item label="对买家说" prop="remark">
        <el-input v-model="sellForm.remark" placeholder="对买家说"></el-input>
      </el-form-item>

      <el-upload
          list-type="picture-card"
          :limit=5
          action="http://127.0.0.1:9000/common/upload/img"
          :auto-upload=true
          :on-exceed="uploadExceed"
          :on-success="uploadSuccess"
          :before-remove="uploadRemove"
          accept="image/png, image/jpeg"
      >
        <i slot="default" class="el-icon-plus"></i>
        <div slot="file" v-for="file in fileList">
          <img :src="file.url" alt="" class="el-upload-list__item-thumbnail">
          <span class="el-upload-list__item-actions">
            <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleRemove(file)">
              <i class="el-icon-delete"></i>
            </span>
          </span>
        </div>
      </el-upload>
      <el-dialog :visible.sync="dialogVisible">
        <img :src="dialogImageUrl" alt="" width="100%">
      </el-dialog>

      <el-form-item>
        <el-button type="primary" @click="commitCar">立即创建</el-button>
      </el-form-item>
    </el-form>


  </div>

</template>

<script>
// import {removeItem} from "@/assets/js/ArrayUtilCustom";

export default {
  name: "sell",
  data() {
    return {
      loginStatus: '',
      sellDialog: false,
      sellForm: {
        brand: '',
        model: '',
        registerDate: '',
        mileage: '',
        displacement: '',
        gearbox: '',
        price: '',
        oldPrice: '',
        remark: '',
        imgList: ''
      },
      sellRules: {
        brand: [{required: true, message: '请输入品牌', trigger: 'blur'}],
        model: [{required: true, message: '请输入车系', trigger: 'blur'}],
        registerDate: [{required: true, message: '请选择上牌时间', trigger: 'blur'}],
        mileage: [{required: true, message: '请输入表显里程', trigger: 'blur'}],
        displacement: [{required: true, message: '请输入排量', trigger: 'blur'}],
        gearbox: [{required: true, message: '请选择变速箱', trigger: 'blur'}],
        price: [{required: true, message: '请输入售价', trigger: 'blur'}],
        oldPrice: [{required: true, message: '请输入标价', trigger: 'blur'}],
        remark: [{required: true, message: '请填写对买家说', trigger: 'blur'}]
      },
      imgList: [],
      fileList: [],
      dialogImageUrl: '',
      dialogVisible: false,
      disabled: false
    }
  },
  methods: {
    handleRemove(file) {
      console.log(file);
    },
    uploadExceed() {
      this.$message.warning("最多只能上传五张照片")
    },
    uploadSuccess(response, file, fileList) {
      this.imgList.push({
        name: file.name,
        url: response.data.url
      })
      console.log(this.imgList)
    },
    uploadRemove(file, fileList) {
      return this.$confirm(`确定移除 ${ file.name }？`).then(value => {
        if (value === "confirm") {
          console.log(this.imgList.length)
          for (let i = 0; i < this.imgList.length; i++) {
            if (this.imgList[i].name === file.name) {
              this.imgList = removeItem(this.imgList, [this.imgList[i]])
            }
          }
        }
      })
    },
    commitCar() {
      let _this = this;
      if (_this.imgList.length === 0) {
        _this.$message.error("至少需要添加一张车辆照片")
        return;
      }
      _this.sellForm['imgList'] = JSON.stringify(_this.imgList)
      _this.$axios.post("/car/save", _this.sellForm).then((response) => {
        if (response.data.success) {
          _this.$message.success(response.data.message)
          let time = 3;
          let timer = setInterval(function () {
            time--;
            if (time <= 0) {
              _this.$router.push("/")
              clearInterval(timer)
            }
          })
        }
        console.log(response)
      })
    }
  }
}
</script>

<style scoped>

</style>