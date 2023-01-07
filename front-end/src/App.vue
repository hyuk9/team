<template>
  <div id="app">
    <!-- <NavCom /> -->
    <SubnavCom />
    <!-- 특정 조건에서만 보여주는 함수 추가 -->
    <HeaderCom v-if="wantToShow()" />
    <router-view />
    <FooterCom />
  </div>
</template>

<script>
// import NavCom from "@/components/common/NavCom.vue";
import SubnavCom from "@/components/common/SubnavCom.vue";
import FooterCom from "@/components/common/FooterCom.vue";
import HeaderCom from "@/components/common/HeaderCom.vue";
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
        label: "🍅", // default: ''
        autoMatchOsTheme: true, // default: true
      },
    };
  },
  methods: {
    // 특정 페이지를 제외하고 최상단 보여주는 함수
    wantToShow() {
      if (
        // 제외할 페이지 경로
        this.$route.path == "/" ||
        this.$route.path == "/register" ||
        this.$route.path == "/findIdPw" ||
        this.$route.path == "/findId" ||
        this.$route.path == "/findPw" ||
        this.$route.path == "/termsOfService"
      ) {
        return false;
      } else {
        return true;
      }
    },
  },
  components: {
    // NavCom,
    SubnavCom,
    FooterCom,
    HeaderCom,
  },
  mounted() {
    const darkmode = new Darkmode(this.options);
    darkmode.showWidget();
    // 브라우저 꺼지면 자동으로 로그아웃하기
    window.addEventListener('unload',()=> this.$store.dispatch("auth/logout"));
  },
};
</script>

<style lang="scss">
h1,
h2,
h4,
h5,
.dropdown-header,
p,
span,
#menu,
.login,
.register,
.profile,
.logout,
.swal2-title,
.swal2-container,
.swal2-confirm,
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

// 네이버 지도 확대 축소 깨지는 현상 수정
#vue-naver-maps a {
  padding: 0;
}
</style>
