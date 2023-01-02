import Vue from 'vue'
import Vuex from 'vuex'

import { auth } from "./auth.module.js";

Vue.use(Vuex)

export default new Vuex.Store({

  namespaced : true,
  modules: {
    auth
  },
  // 아이디 찾기에서 받은 아이디 정보 저장용 변수
  state : {
    username : "",
  },
  actions: {
    clickButton() {
    }
  },
  // 아이디 찾기에서 받은 아이디 정보 저장용 함수
  mutations : {
    saveId : function(state, value) {
      state.username = value;
    },
  },
  
})
