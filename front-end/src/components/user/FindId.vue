<template>
  <!-- 아이디 찾는 페이지 -->
  <div class="container">
    <!-- Heading -->
    <h1>아이디 찾기</h1>

    <!-- 아이디 찾기 시작 -->
    <h2>확인되었습니다. 회원님의 아이디는...</h2>
      <div>
        <!-- 아이디 보여주는 곳 -->
        <div class="idBlock">
            <!-- 예상 로직: <p>{{user.username}}</p> 일단 주석처리 -->
            <p>forbob@naver.com</p>
            <h2>입니다.</h2>
        </div>
 

        <!-- 비밀번호 찾기로 가기 버튼 -->
        <h5>비밀번호도 찾고 싶으신가요?</h5>
        <!-- /findIdPw 페이지의 id가 "password" 로 이동하는 버튼 -->
        <router-link :to="{path : '/findIdPw' , hash: '#password'}" class="toFindPw__btn mt-1">비밀번호 찾기</router-link>
      </div>

    <!-- 아이디 찾기 끝 -->
  </div>
</template>

<script>
import User from "@/model/user";

export default {
  data() {
    return {
      // 기본적으로 ROLE_USER로 받고 ROLE 정보를 화면에서 수정할 수 있는 기능을 추가
      // TODO: user 객체 role 매개변수 추가
      user: new User("", "", "", "", "", "", "", "", "ROLE_USER"),
      submitted: false,
      successful: false,
      message: "",
    };
  },
};
</script>

<style scoped>
body {
  font-family: "Montserrat", sans-serif;
  background: white;
}

.container {
  display: block;
  max-width: 680px;
  width: 80%;
  margin: 250px auto;
  text-align: center;
}

h1 {
  color: #ffb30e;
  font-size: 48px;
  letter-spacing: -3px;
  text-align: center;
  margin: 120px 0 80px 0;
  transition: 0.2s linear;
}

h5 {
  display: inline-block;
  color: #ffb30e;
  margin: 30px 0 30px 30px;
  transition: 0.2s linear;
}

.idBlock {
  margin: 80px auto 200px;
  width: 90%;
  height: 50px;
  background-color: rgba(15, 19, 42, 0.1);
  text-align: center;
  line-height: 50px;
  border-radius: 8px;
  display: inline-block;
  position: relative;
}
.idBlock.first-idBlock::before {
  content: "";
  position: absolute;
  top: -15px;
  left: 50px;
  display: block;
  width: 0;
  height: 0;
  background: transparent;
  border-left: 15px solid transparent;
  border-right: 15px solid transparent;
  border-bottom: 15px solid rgba(15, 19, 42, 0.1);
  transition: 0.2s linear;
}
.idBlock.signup-idBlock::before {
  content: "";
  position: absolute;
  top: -15px;
  left: 150px;
  display: block;
  width: 0;
  height: 0;
  background: transparent;
  border-left: 15px solid transparent;
  border-right: 15px solid transparent;
  border-bottom: 15px solid rgba(15, 19, 42, 0.1);
  transition: 0.2s linear;
}
.idBlock input {
  display: block;
  width: 90%;
  max-width: 680px;
  height: 50px;
  margin: 0 auto;
  border-radius: 8px;
  border: none;
  background: rgba(15, 19, 42, 0.1);
  color: #23004d;
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  padding: 0 10px;
}

.idBlock input:focus,
.idBlock input:active {
  outline: none;
  border: none;
  color: #0f132a;
}
.idBlock p {
  margin-bottom: 20px;
}


.toFindPw__btn {
  background: #ffb30e;
  color: white;
  display: block;
  width: 92.5%;
  max-width: 680px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  cursor: pointer;
  font-size: 20px;
  font-family: ONE-Mobile-POP;
  box-shadow: 0 15px 30px #ffb30e5c;
  transition: 0.2s linear;
  text-align: center;
  line-height: 50px;
}
.toFindPw__btn:hover {
  box-shadow: 0 0 0 rgba(233, 30, 99, 0);
}

::placeholder {
  color: rgb(128, 128, 128, 0.6) !important;
}

.register-alert {
  display: block;
  width: 90%;
  max-width: 680px;
  height: 30px;
  margin: 10px auto 0 auto;
  border-radius: 8px;
  border: none;
  background: #ffb30e5c;
  padding: 0 0 0 15px;
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
}

.register-alert p {
  line-height: 30px;
}
</style>
