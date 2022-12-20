<template>
  <div class="container">
    <!-- Heading -->
    <h1>회원가입</h1>

    <!-- Form -->
    <form action="" name="form" @submit.prevent="handleRegister">
      <div>
        <!-- username input -->
        <div class="input__block">
          <h5>아이디</h5>
          <input
            v-model="user.username"
            v-validate="'required|min:3|max:20'"
            type="text"
            placeholder="아이디"
            class="input"
            id="text"
            name="아이디 "
          />
          <div v-if="submitted && errors.has('아이디 ')" class="register-alert">
            <p>{{ errors.first("아이디 ") }}</p>
          </div>
        </div>
        <!-- email input -->
        <div class="input__block">
          <h5>이메일</h5>
          <input
            v-model="user.email"
            v-validate="'required|email|max:50'"
            type="email"
            placeholder="이메일"
            class="input"
            id="email"
            name="이메일 "
          />
          <div v-if="submitted && errors.has('이메일 ')" class="register-alert">
            <p>{{ errors.first("이메일 ") }}</p>
          </div>
        </div>
        <!-- password input -->
        <div class="input__block">
          <h5>비밀번호</h5>
          <input
            v-model="user.password"
            v-validate="'required|min:6|max:40'"
            type="password"
            placeholder="비밀번호"
            class="input"
            id="password"
            name="비밀번호 "
          />
          <div
            v-if="submitted && errors.has('비밀번호 ')"
            class="register-alert"
          >
            <p>{{ errors.first("비밀번호 ") }}</p>
          </div>
        </div>
        <!-- repeat password input -->
        <div class="input__block">
          <h5>비밀번호 재확인</h5>
          <input
            v-validate="'required|min:6|max:40'"
            type="password"
            placeholder="비밀번호 재확인"
            class="input"
            id="passwordRe"
          />
        </div>
        <!-- 이름 -->
        <div class="input__block">
          <h5>이름</h5>
          <input
            v-validate="'required|min:6|max:40'"
            type="password"
            placeholder="비밀번호 재확인"
            class="input"
            id="passwordRe"
          />
        </div>
        <!-- 생년월일 -->
        <div class="input__block">
          <h5>생년월일</h5>
          <input type="date" class="input" id="date" />
        </div>
        <!-- 성별 -->
        <div class="input__block gender">
                      <h5>성별</h5>
          <div class="col-6 d-inline-block">

            <p class="d-inline-block col-6">남성</p>
            <input
              type="radio"
              class="input d-inline-block"
              id="gendermale"
              name="gender"
            />
          </div> 
          <div class="col-6  d-inline-block">
            <p class="d-inline-block col-6">여성</p>
            <input
              type="radio"
              class="input d-inline-block"
              id="genderfemale"
              name="gender"
            />
          </div>
        </div>
        <!-- 전화번호 -->
        <div class="input__block">
          <h5>전화번호</h5>
          <input type="text" placeholder="전화번호" class="input" id="phone" />
        </div>
        <!-- 주소 -->
        <div class="input__block">
          <h5>주소</h5>
          <input type="text" placeholder="주소" class="input" id="address" />
        </div>
        <!-- sign in button -->
        <button class="signin__btn mt-5">회원가입하기</button>
      </div>
    </form>
  </div>
</template>

<script>
import User from "@/model/user";

export default {
  data() {
    return {
      // 기본적으로 ROLE_USER로 받고 ROLE 정보를 화면에서 수정할 수 있는 기능을 추가
      // TODO: user 객체 role 매개변수 추가
      user: new User("", "", "", "ROLE_USER"),
      submitted: false,
      successful: false,
      message: "",
    };
  },
  computed: {
    // loggedIn 상태 확인
    loggedIn() {
      // this.$store.state.모듈명.state값
      return this.$store.state.auth.status.loggedIn;
    },
  },
  // created() : Vue 생성되자 마자 실행되는 이벤트(화면은 생성되지 않은 상태)
  created() {
    if (this.loggedIn) {
      // 로그인이 되어 있는 상태
      this.$router.push("/profile"); // 강제 /profile 로 이동
    }
  },
  methods: {
    // 회원가입 버튼 클릭시 실행되는 함수
    handleRegister() {
      this.message = "";
      this.submitted = true; //  회원가입 버튼 클릭 = true
      // vee-validate 함수 처리 방법
      this.$validator.validateAll().then((isValid) => {
        // validateAll() 모두 통과하면 -> isValid = true  (유효함)
        //                             -> isValid = false (유효하지 않음)
        if (!isValid) {
          return; // 함수 탈출(break)
        }

        // 공통함수 register 호출 :
        // this.$store.dispatch("모듈명/함수명", 매개변수)
        this.$store
          .dispatch("auth/register", this.user)
          .then((response) => {
            this.message = response.message;
            this.successful = true; // "회원가입이 성공했습니다." 화면 출력
            // 성공알림 띄우기
            this.$swal({
              icon: "success",
              title: "로그인 성공",
              showConfirmButton: false,
              timer: 1000,
            });
            // 로그인 화면으로 이동
            this.$router.push("/login");
          })
          // 참고) if/else 문 대신에 -> or(||) and(&&) 연산자를 사용할때도 있음
          // 로직체크 순서 : true || false, false && true
          .catch((error) => {
            this.successful = false; // 회원가입 실패 -> 회원가입폼 다시 화면에 나옴
            this.message =
              (error.response &&
                error.response.data &&
                error.response.data.message) ||
              error.message ||
              error.toString();
            // 실패알림 띄우기
            this.$swal({
              icon: "error",
              title: "로그인 실패",
              text: this.message,
              confirmButtonColor: "#E1793D",
              confirmButtonText: "확인",
            });
          });
      });
    },
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
  margin: 120px auto;
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
  color: #ffb30e;
  margin: 30px 0 30px 30px;
  transition: 0.2s linear;
}

form {
  width: 100%;
  max-width: 680px;
  margin: 40px auto 10px;
}
form .input__block {
  margin: 20px auto;
  display: block;
  position: relative;
}
form .input__block.first-input__block::before {
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
form .input__block.signup-input__block::before {
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
form .input__block input {
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
}

form .gender {
  margin: 0 0 0 30px;
}

form .gender h5 {
  margin: 30px 0 30px 0px;
}

form .gender input {

  width: 50%;
  max-width: 680px;
  height: 30px;
  margin: 0 auto;
  padding: 0 0 0 15px;
    vertical-align:middle;
}

form .input__block input:focus,
form .input__block input:active {
  outline: none;
  border: none;
  color: #0f132a;
}
form .input__block input.repeat__password {
  opacity: 0;
  display: none;
  transition: 0.2s linear;
}

form .signin__btn {
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
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  box-shadow: 0 15px 30px #ffb30e5c;
  transition: 0.2s linear;
}
form .signin__btn:hover {
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

button {
  font-family: ONE-Mobile-POP !important;
}

.separator {
  display: block;
  margin: 30px auto 10px;
  text-align: center;
  height: 40px;
  position: relative;
  background: transparent;
  color: rgba(15, 19, 42, 0.4);
  font-size: 13px;
  width: 90%;
  max-width: 680px;
}
.separator::before {
  content: "";
  position: absolute;
  top: 8px;
  left: 0;
  background: rgba(15, 19, 42, 0.2);
  height: 1px;
  width: 45%;
}
.separator::after {
  content: "";
  position: absolute;
  top: 8px;
  right: 0;
  background: rgba(15, 19, 42, 0.2);
  height: 1px;
  width: 45%;
}

.google__btn,
.github__btn {
  display: block;
  width: 90%;
  max-width: 680px;
  margin: 20px auto;
  height: 50px;
  cursor: pointer;
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  border-radius: 8px;
  border: none;
  line-height: 40px;
}
.google__btn.google__btn,
.github__btn.google__btn {
  background: #5b90f0;
  color: white;
  box-shadow: 0 15px 30px rgba(91, 144, 240, 0.36);
  transition: 0.2s linear;
}
.google__btn.google__btn .fa,
.github__btn.google__btn .fa {
  font-size: 20px;
  padding: 0 5px 0 0;
}
.google__btn.google__btn:hover,
.github__btn.google__btn:hover {
  box-shadow: 0 0 0 rgba(91, 144, 240, 0);
}
.google__btn.github__btn,
.github__btn.github__btn {
  background: #25282d;
  color: white;
  box-shadow: 0 15px 30px rgba(37, 40, 45, 0.36);
  transition: 0.2s linear;
}
.google__btn.github__btn .fa,
.github__btn.github__btn .fa {
  font-size: 20px;
  padding: 0 5px 0 0;
}
.google__btn.github__btn:hover,
.github__btn.github__btn:hover {
  box-shadow: 0 0 0 rgba(37, 40, 45, 0);
}
</style>
