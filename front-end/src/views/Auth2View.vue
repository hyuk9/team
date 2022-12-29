<template>
<!-- <!— TODO 3): 간편로그인 추가 , 리다이렉트 페이지 —> -->
  <div class="col-md-12">
  </div>
</template>

<script>
export default {
  data() {
    return {
      userData: {},
    };
  },
  mounted() {
    // 1) springboot : token과 함께 username, email 보냄 -> get 방식 보냄
    // 2) 이 페이지에서 받아서 localStorage user 이름으로 생성 
    // 3) window.location.href : 아래 url 가져오기
    // ex) http://localhost:8080/auth-redirect?accessToken=xxxx&username=forbob&email=forbob@naver.com
    let url = new URL(window.location.href); // 현재 url 가져오기 js 함수

    const urlParams = url.searchParams;
    const accessToken = urlParams.get("accessToken"); // URL accessToken 변수값 뽑아내기
    const username = urlParams.get("username"); // URL username 변수값 뽑아내기
    const email = urlParams.get("email");  // URL email 변수값 뽑아내기
    console.log(urlParams)
    console.log(accessToken);
    console.log(username);


    // 임시 객체 생성
    this.userData = {
      accessToken: accessToken,
      username: username,
      email: email,
      password: "",
      tokenType: "Bearer",
      roles: ["ROLE_USER"],
    };

//  4) 로컬스토리지에 키값 생성
    localStorage.setItem("user", JSON.stringify(this.userData));

//  5) 공유저장소에 loggedIn 변수 : true
    this.$store.commit('auth/loginSuccess', this.userData);
//  6) 로그인 할 때의 페이지로 리다이렉트(강제 이동)
    this.$router.go(-1);
  },
};
</script>
