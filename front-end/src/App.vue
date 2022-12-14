<template>
  <div id="app">
    <NavCom v-if="wantToShow()" />
    <router-view />
    <FooterCom v-if="wantToShow()" />
  </div>
</template>


<script>
import NavCom from "@/components/common/NavCom.vue";
import FooterCom from "@/components/common/FooterCom.vue";
import Darkmode from "darkmode-js";

export default {
  data() {
    return {
      options: {
        bottom: "64px", // default: '32px'
        right: "unset", // default: '32px'
        left: "32px", // default: 'unset'
        time: "0.5s", // default: '0.3s'
        mixColor: "#fff", // default: '#fff'
        backgroundColor: "#fff", // default: '#fff'
        buttonColorDark: "#100f2c", // default: '#100f2c'
        buttonColorLight: "#fff", // default: '#fff'
        saveInCookies: false, // default: true,
        label: "🌓", // default: ''
        autoMatchOsTheme: true, // default: true
      },
    };
  },
  methods: {
    wantToShow() {
      if (this.$route.name == "login") {
        return false;
      } else {
        return true;
      }
    },
  },
  components: {
    NavCom,
    FooterCom,
  },
  mounted() {
    const darkmode = new Darkmode(this.options);
    darkmode.showWidget();
  },
};
</script>

<style lang="scss">
h1,
h5,
p,
span,
#menu,
.login,
.register,
.profile,
.logout,
#navbarNavDropdown {
  font-family: ONE-Mobile-POP;
}

@font-face {
  font-family: "ONE-Mobile-POP";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/ONE-Mobile-POP.woff")
    format("woff");
  font-weight: lighter;
  font-style: normal;
}


// #typed .typed-words {
//       position: relative; }
//       #typed .typed-words:before {
//         position: absolute;
//         height: 5px;
//         background-color: #ffd75f;
//         bottom: 0;
//         left: 0;
//         right: 0;
//         content: ""; 
//         }
</style>
