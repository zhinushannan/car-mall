<template>

  <div>
    <el-container>
      <el-header>

        <div class="logo">
          <el-link href="/">ETAO</el-link>
        </div>
        <div class="link">
          <el-link v-show="!loginStatus" @click="loginDialog = true">我要卖车</el-link>
          <el-link v-show="loginStatus" href="#/sell">我要卖车</el-link>
          <el-link v-show="!loginStatus" @click="loginDialog = true"><i class="el-icon-user-solid"></i>
            <span>用户登录</span>
          </el-link>
          <el-link v-show="!loginStatus" @click="loginDialog = true">个人中心</el-link>

          <el-dropdown v-show="loginStatus">
            <span class="el-dropdown-link">
              <el-link>个人中心<i class="el-icon-arrow-down el-icon--right"></i></el-link>
            </span>
            <el-dropdown-menu slot="dropdown">
              <router-link to="/selling">
                <el-dropdown-item icon="el-icon-plus">我的汽车</el-dropdown-item>
              </router-link>
              <router-link to="/appointment">
                <el-dropdown-item icon="el-icon-plus">我的预约</el-dropdown-item>
              </router-link>
              <router-link to="/history">
                <el-dropdown-item icon="el-icon-circle-check">浏览记录</el-dropdown-item>
              </router-link>
              <router-link to="/profile">
                <el-dropdown-item icon="el-icon-circle-check">账号操作</el-dropdown-item>
              </router-link>
            </el-dropdown-menu>
          </el-dropdown>

          <el-link v-show="loginStatus" @click="feedbackVisible = true">反馈</el-link>

          <el-link v-show="loginStatus" @click="logout()"><i class="el-icon-user-solid"></i>
            <span>退出登录</span>
          </el-link>
          <el-link href="#">咨询热线：400-000-8000</el-link>
        </div>

      </el-header>

      <el-main>

        <router-view/>

      </el-main>

      <el-footer>&copy;18软件2毕业设计 - 李铭扬</el-footer>
    </el-container>

    <el-dialog
        :visible.sync="loginDialog"
        title="登录"
        width="30%"
        @open="openLoginDialog">
      <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="demo-ruleForm">
        <el-form-item label="账号" prop="email">
          <el-input v-model="loginForm.email"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="loginForm.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%; margin-top: 25px;" type="primary" @click="login()">登录</el-button>
          <div style="text-align: center;">
            <el-link style="display: inline;" type="primary" @click="registerDialog = true">注册</el-link>&nbsp;|&nbsp;<el-link
              style="display: inline;" type="primary">找回密码
          </el-link>
          </div>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-dialog
        :visible.sync="registerDialog"
        title="注册"
        width="30%"
        @open="openLoginDialog">
      <el-form ref="registerForm" :model="registerForm" :rules="registerRules" class="demo-ruleForm">
        <el-form-item prop="email">
          <el-input v-model="registerForm.email" placeholder="请输入邮箱"></el-input>
        </el-form-item>
        <el-form-item prop="code">
          <el-input v-model="registerForm.code" placeholder="请输入邮箱验证码" style="width: 60%; float:left;"></el-input>
          <div style="height: 1px; width: 5%; float:left;"></div>
          <el-button style="width: 35%; float:left;" type="primary" @click="code()">获取验证码</el-button>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="registerForm.password" placeholder="请输入重复密码"></el-input>
        </el-form-item>
        <el-form-item prop="repeatPassword">
          <el-input v-model="registerForm.repeatPassword" placeholder="请输入重复密码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%; margin-top: 25px;" type="primary" @click="register()">登录</el-button>
          <div style="text-align: center;">
            <el-link style="display: inline;" type="primary">注册</el-link>&nbsp;|&nbsp;<el-link style="display: inline;"
                                                                                               type="primary">
            找回密码
          </el-link>
          </div>
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      loginStatus: false,

      loginDialog: false,
      loginForm: {},
      loginRules: {
        email: [
          {required: true, message: '请输入账号', trigger: 'blur'},
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
        ]
      },

      registerDialog: false,
      registerForm: {},
      registerRules: {
        email: [
          {required: true, message: '请输入邮箱', trigger: 'blur'},
        ],
        code: [
          {required: true, message: '请输入邮箱验证码', trigger: 'blur'},
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
        ],
        repeatPassword: [
          {required: true, message: '请输入重复密码', trigger: 'blur'},
        ]
      }
    }
  },
  methods: {
    openLoginDialog() {
      let _this = this
      _this.loginForm = {}
    },
    login() {
      let _this = this
      _this.$refs['loginForm'].validate((valid) => {
        if (valid) {
          _this.$axios.post("/login", _this.loginForm).then((response) => {
            let data = response.data
            if (data.success) {
              _this.$message.success(data.message)
              _this.loginStatus = true
              _this.loginDialog = false
              _this.loginForm = {}
            } else {
              _this.$message.error(data.message)
            }
          })
        } else {
          _this.$message.error("请按要求输入相关内容！")
        }
      });
    },
    logout() {
      let _this = this
      _this.$axios.post("/logout").then((response) => {
        _this.$message.success(response.data.message)
        _this.$cookies.remove("email")
        _this.$cookies.remove("token")
      })
    },
    code() {
      let _this = this
      let email = _this.registerForm['email']
      if (email !== '' && email !== undefined && email !== null) {
        _this.$axios.post("/sendCode", _this.registerForm).then((response) => {
          let data = response.data
          if (data.success) {
            _this.$message.success(data.message)
          } else {
            _this.$message.error(data.message)
          }
        })
      } else {
        _this.$message.error("请输入邮箱！")
      }
    },
    register() {
      let _this = this
      _this.$refs['registerForm'].validate((valid) => {
        if (valid) {
          _this.$axios.post("/register", _this.registerForm).then((response) => {
            let data = response.data
            if (data.success) {
              _this.$message.success(data.message)
              _this.registerDialog = false
              _this.registerForm = {}
            } else {
              _this.$message.error(data.message)
            }
          })
        } else {
          _this.$message.error("请按要求输入相关内容！")
        }
      })
    }
  },
  mounted() {
    let _this = this
    _this.$router.push("main")

    if (_this.$cookies.get("email")) {
      _this.loginStatus = true
    }

  }
}
</script>

<style scoped>


.el-header {
  background-color: rgba(255, 255, 255, 0.7);
  text-align: center;
  line-height: 60px;
  padding-left: 150px;
  padding-right: 150px;
}

.el-footer {
  background-color: Transparent;
  color: #909399;
  text-align: center;
}

.logo {
  float: left;
}

.link {
  float: right;
}

.el-link {
  padding-left: 10px;
  padding-right: 10px;
  color: #333;
  font-size: 16px;
}

.el-main {
  padding-left: 160px;
  padding-right: 160px;
}

.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
}

.el-icon-arrow-down {
  font-size: 12px;
}

.demonstration {
  display: block;
  color: #8492a6;
  font-size: 14px;
  margin-bottom: 20px;
}

/*包含以下五种的链接*/
a {
  text-decoration: none;
}

/*正常的未被访问过的链接*/
a:link {
  text-decoration: none;
}

/*已经访问过的链接*/
a:visited {
  text-decoration: none;
}

/*鼠标划过(停留)的链接*/
a:hover {
  text-decoration: none;
}

/* 正在点击的链接，鼠标在元素上按下还没有松开*/
a:active {
  text-decoration: none;
}

/* 获得焦点的时候 鼠标松开时显示的颜色*/
a:focus {
  text-decoration: none;
}

</style>
