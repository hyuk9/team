import Vue from 'vue'
import App from './App.vue'

// bootstrap 5.x npm import
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.bundle.js'

// bootstrap-vue import
// bootstrap-vue import
import { BootstrapVue } from 'bootstrap-vue'
import 'bootstrap-vue/dist/bootstrap-vue.css'


import router from './router'
import store from './store'


// bootstrap vue모듈 사용
Vue.use(BootstrapVue)

// 유효성 체크 라이브러리 : vee-validate ( Vue 전용 )
import VeeValidate from 'vee-validate';

// fortawesome 아이콘들
import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
// faHome( 홈아이콘 ), faUser(유저아이콘) 등
import {
  faHome,
  faUser,
  faUserPlus,
  faSignInAlt,
  faSignOutAlt
} from '@fortawesome/free-solid-svg-icons';

library.add(faHome, faUser, faUserPlus, faSignInAlt, faSignOutAlt);

Vue.use(VeeValidate);
Vue.component('font-awesome-icon', FontAwesomeIcon);

// bootstrap-vue 모듈 사용
Vue.use(BootstrapVue)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
