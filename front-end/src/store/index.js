import Vue from 'vue'
import Vuex from 'vuex'

import { auth } from "./auth.module.js"; 

Vue.use(Vuex)

export default new Vuex.Store({
  namespaced : true,
  modules: {
    auth
  },
  actions: {
    clickButton({ commit }) {
      // Commit the "clickButton" mutation (if needed)
      commit('clickButton');
    }
  }
})
