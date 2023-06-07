import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import datePicker from 'vue-bootstrap-datetimepicker'

import { LayoutPlugin } from 'bootstrap-vue'
Vue.use(LayoutPlugin)

import { CardPlugin } from 'bootstrap-vue'
Vue.use(CardPlugin)

import { VBScrollspyPlugin } from 'bootstrap-vue'
Vue.use(VBScrollspyPlugin)

import { DropdownPlugin, TablePlugin } from 'bootstrap-vue'
Vue.use(DropdownPlugin)
Vue.use(TablePlugin)

Vue.use(BootstrapVue)
Vue.use(IconsPlugin)

Vue.use(datePicker);

Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;


new Vue({
  router,
  store,
    // data: {
    //   startDate: '',
    // },
    // mounted() {
    //   ("#startDate").datepicker().on(
    //     "changeDate", () => {this.startDate = ('#startDate').val()}
    //   );
    // },
  render: h => h(App)
}).$mount('#app')
