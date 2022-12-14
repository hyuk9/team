import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// 유효성 체크 라이브러리 : vee-validate ( Vue 전용 )
import VeeValidate from 'vee-validate';

Vue.use(VeeValidate);

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
