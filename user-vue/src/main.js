import Vue from 'vue'
import App from './App.vue'
import router from './router'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import layer from "vue-layer";
import "vue-layer/lib/vue-layer.css";

import $ from 'jquery'

import axios from "axios";

window.jQuery = $
window.$ = $

Vue.config.productionTip = false
Vue.use(ElementUI);

Vue.prototype.$axios = axios
axios.defaults.baseURL="http://localhost:9000/user/"

Vue.prototype.$layer = layer(Vue, {
  msgtime: 3 //目前只有一项，即msg方法的默认消失时间，单位：秒
});

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
