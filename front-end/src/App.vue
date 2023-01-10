<template>
  <div id="app">
    <!-- 네비게이션 -->
    <SubnavCom />
    <!-- 특정 조건에서만 보여주는 함수 추가 -->
    <HeaderCom v-if="wantToShow()" />
    <router-view />
    <!-- 푸터 -->
    <FooterCom />
    <!-- 버튼 클릭시 최상단으로 이동 -->
    <button @click="topFunction()" id="myBtn" title="Go to top"><i class="bi bi-triangle-fill"></i></button>
  </div>
</template>

<script>
/* eslint-disable */

// 네비게이션 컴포넌트화
import SubnavCom from "@/components/common/SubnavCom.vue";
// 헤더 컴포넌트화
import HeaderCom from "@/components/common/HeaderCom.vue";
// 푸터 컴포넌트화
import FooterCom from "@/components/common/FooterCom.vue";
// 버튼 클릭시 최상단으로 이동하기
import ScollCom from "@/js/scroll-to-top";


export default {
  data() {
    return {
      
    };
  },
  methods: {
    // TODO: 특정 페이지를 제외하고 최상단 보여주는 함수
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

     // When the user clicks on the button, scroll to the top of the document
      topFunction() {
      document.body.scrollTop = 0; // For Safari
      document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
    }
  },

  // computed: {
  //   // When the user clicks on the button, scroll to the top of the document
  //   topFunction() {
  //     alert("11")
  //     document.body.scrollTop = 0; // For Safari
  //     document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
  //   }
  // },

  components: {
    SubnavCom,
    FooterCom,
    HeaderCom,
  },
  mounted() {
    ScollCom();
  },
};
</script>

<style lang="scss">
h1,
h2,
h3,
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

// 외부 폰트 불러오기
@font-face {
  font-family: "ONE-Mobile-POP";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2105_2@1.0/ONE-Mobile-POP.woff") format("woff");
  font-weight: lighter;
  font-style: normal;
}

#myBtn {
  display: none;
  /* Hidden by default */
  position: fixed;
  /* Fixed/sticky position */
  bottom: 20px;
  /* Place the button at the bottom of the page */
  right: 30px;
  /* Place the button 30px from the right */
  z-index: 99;
  /* Make sure it does not overlap */
  border: none;
  /* Remove borders */
  outline: none;
  /* Remove outline */
  background-color: rgb(238, 178, 12);
  /* Set a background color */
  color: white;
  /* Text color */
  cursor: pointer;
  /* Add a mouse pointer on hover */
  padding: 15px;
  /* Some padding */
  border-radius: 10px;
  /* Rounded corners */
  font-size: 20px;
  /* Increase font size */
}

#myBtn:hover {
  background-color: #555;
  /* Add a dark-grey background on hover */
}
</style>
