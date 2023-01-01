import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// 유효성 체크 라이브러리 : vee-validate ( Vue 전용 ) *한국어로 설정바꾸어 주기
import VeeValidate from "vee-validate";
import ko from "vee-validate/dist/locale/ko.js";

// 네이버 지도 api 이용을 위한 소스
import naver from 'vue-naver-maps';
Vue.use(naver, {
  // clientID : 네이버에서 개인이 발급받은 키 
  clientID: '372sam0uw0',
  useGovAPI: false, //공공 클라우드 API 사용 (선택)
  subModules:'' // 서브모듈 (선택)
});
// 네이버 지도 api 이용을 위한 소스 끝

const config = {
  locale: "ko",
  dictionary: {
    ko,
  },
};

// bootstrap-vue import
import { BootstrapVue } from 'bootstrap-vue'
import 'bootstrap-vue/dist/bootstrap-vue.css'


// VueSweetalert2
import VueSweetalert2 from 'vue-sweetalert2';

// If you don't need the styles, do not connect
import 'sweetalert2/dist/sweetalert2.min.css';


Vue.use(VeeValidate, config);

Vue.use(VueSweetalert2);

// bootstrap-vue 모듈 사용
Vue.use(BootstrapVue)
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
