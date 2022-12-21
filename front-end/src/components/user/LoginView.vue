<template>
  <div>
    <link
      href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"
      rel="stylesheet"
    />

    <div class="login">
      <div class="login_middle">
        <!-- 토마토 사진 삭제 -->
        <!-- <div class="login__img">
          <img src="assets/img/gallery/hero-tomato.png" alt="user login" />
        </div> -->
        <div class="login__forms">
          <!--         create account form -->
          <form
            action=""
            class="login__create"
            id="login-up"
            name="form"
            @submit.prevent="handleLogin"
          >
            <div v-if="!successful">
              <!-- <h1 class="login__title">로그인</h1> -->
              <div class="login__upperbox">
                <h5>아이디</h5>
                <div class="login__box">
                  <i class="bx bx-user login__icon"></i>
                  <input
                    v-model="user.username"
                    v-validate="'required'"
                    type="text"
                    placeholder="아이디를 입력해주세요."
                    class="login__input"
                    name="username"
                  />
                </div>
              </div>

              <div class="login__upperbox">
                <h5>비밀번호</h5>
                <div class="login__box">
                  <i class="bx bx-lock login__icon"></i>
                  <input
                    v-model="user.password"
                    v-validate="'required'"
                    type="password"
                    placeholder="비밀번호를 입력해주세요"
                    class="login__input"
                    name="password"
                  />
                </div>
              </div>

              <button class="login__button">로그인</button>

              <div class="separator">
                <p>또는</p>
              </div>
              <div class="mb-3 snsLogin">
                <!-- 구글 로그인 -->
                <a href="#" role="button"
                  ><img
                    src="../../../public/assets/img/loginButton/google.png"
                    class="img-fluid"
                /></a>
                <!-- 네이버 로그인 -->
                <a href="#" role="button"
                  ><img
                    src="../../../public/assets/img/loginButton/naver.png"
                    class="img-fluid"
                /></a>
                <!-- 카카오 로그인 -->
                <a href="#" role="button"
                  ><img
                    src="../../../public/assets/img/loginButton/kakao.png"
                    class="img-fluid"
                /></a>
              </div>
              <div>
                <span class="login__account login__account--account"
                  >회원이 아직 아니신가요?</span
                >
                &nbsp;

                <!-- 회원가입페이지로 이동과 로그인 모달창을 끄는것을 동시에 하기 위해
                 라우터 링크와 버튼 2개를 사용 -->
                <router-link to="/register">
                  <button
                    class="login__signup login__signup--signup"
                    id="sign-in"
                    @click="close()"
                  >
                    회원가입 하기
                  </button></router-link
                >
                <!-- @click="$bvModal.hide('bv-modal-example')" -->
              </div>

              <!-- <div class="login__social">
                <a href="#" class="login__social--icon"
                  ><i class="bx bxl-facebook"></i
                ></a>
                <a href="#" class="login__social--icon"
                  ><i class="bx bxl-twitter"></i
                ></a>
                <a href="#" class="login__social--icon"
                  ><i class="bx bxl-google"></i
                ></a>
                <a href="#" class="login__social--icon"
                  ><i class="bx bxl-github"></i
                ></a>
              </div> -->
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import User from "@/model/user";

export default {
  data() {
    return {
      user: new User("", ""), // user 생성자 호출
      loading: false, // 로그인 버튼 활성화/비활성화 속성
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
    // 로그인 버튼 클릭시 실행되는 함수
    handleLogin() {
      //아이디나 비밀번호가 입력되지 않았다면 알림창을 띄우는 함수 실행
      this.alertLoginError();
      // 로그인 로직 처리
      this.loading = true;
      // vee-validate 함수 처리 방법
      this.$validator.validateAll().then((isValid) => {
        // validateAll() 모두 통과하면 -> isValid = true  (유효함)
        //                             -> isValid = false (유효하지 않음)
        if (!isValid) {
          this.loading = false;
          return; // 함수 탈출(break)
        }

        // isValid 가 true 이면 아래 로그인 실행(axios 실행)
        if (this.user.username && this.user.password) {
          // 공통함수 login 호출 :
          // this.$store.dispatch("모듈명/함수명", 매개변수)
          this.$store
            .dispatch("auth/login", this.user)
            .then(() => {
              // alert 라이브러리 효과
              this.$swal({
                icon: "success",
                title: "로그인 성공",
                showConfirmButton: false,
                timer: 1000,
              });
              this.$router.push("/profile"); // 로그인 성공하면 강제 /profile 페이지 이동
              // 모달창 닫기
              this.close();
            })
            // 참고) if/else 문 대신에 -> or(||) and(&&) 연산자를 사용할때도 있음
            // 로직체크 순서 : true || false, false && true
            .catch((error) => {
              this.loading = false; // 로그인 버튼 활성화
              this.message =
                (error.response &&
                  error.response.data &&
                  error.response.data.message) ||
                error.message ||
                error.toString();
              //        this.$swal({
              //   icon: "error",
              //   title: "로그인 실패",
              //   text: "",
              //   confirmButtonColor: "#E1793D",
              //   confirmButtonText: "확인",
              // });
            });
        }
      });
    },
    // 아이디나 비밀번호가 입력되지 않았다면 알림창을 띄우는 함수
    alertLoginError() {
      if (this.errors.has("username") && this.errors.has("password")) {
        // alert 라이브러리 효과
        this.$swal({
          icon: "error",
          title: "로그인 실패",
          text: "아이디와 비밀번호가 필요합니다",
          confirmButtonColor: "#E1793D",
          confirmButtonText: "확인",
        });
      } else if (this.errors.has("username")) {
        // alert 라이브러리 효과
        this.$swal({
          icon: "error",
          title: "로그인 실패",
          text: "아이디가 필요합니다",
          confirmButtonColor: "#E1793D",
          confirmButtonText: "확인",
        });
      } else if (this.errors.has("password")) {
        // alert 라이브러리 효과
        this.$swal({
          icon: "error",
          title: "로그인 실패",
          text: "비밀번호가 필요합니다",
          confirmButtonColor: "#E1793D",
          confirmButtonText: "확인",
        });
      } else if (this.message) {
        // alert 라이브러리 효과
        this.$swal({
          icon: "error",
          title: "로그인 실패",
          text: this.message,
          confirmButtonColor: "#E1793D",
          confirmButtonText: "확인",
        });
      }
    },
    close() {
      this.$store.dispatch("clickButton");
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap");
*,
::before,
::after {
  box-sizing: border-box;
}

body {
  margin: 0;
  padding: 0;
  font-family: "Open Sans", sans-serif;
  font-size: 0.938rem;
  color: #23004d;
}
/* 
h1 {
  margin: 0;
} */

h5 {
  text-align: left;
  color: #ffb30e;
  margin: 20px 0 20px 10px;
}

a {
  text-decoration: none;
}

/* img {
  max-width: 100%;
  max-height: 100%;
  height: auto;
  display: block;
} */

.login {
  display: grid;
  grid-template-columns: 100%;
  height: 100vh;
  margin-left: 1.5rem;
  margin-right: 1.5rem;
}
/* .login__content {
  display: grid;
} */
/* .login__img {
  justify-self: center;
}
.login__img img {
  width: 310px;
  margin-top: 1.5rem;
} */
.login__forms {
  /* position: relative; */
  /* height: 368px; */
}
.login__register,
.login__create {
  /* position: absolute; */
  /* bottom: 1rem; */
  width: 100%;
  max-height: 100%;
  /* background-color: #f2f2f2; */
  /* padding: 2rem 1rem; */
  /* border-radius: 1rem; */
  text-align: center;
  /* box-shadow: 0 8px 20px rgba(35, 0, 77, 0.2); */
  animation-duration: 0.4s;
  animation-name: animateLogin;
}
.login__title {
  color: #ffb30e;
  font-size: 1.5rem;
  margin-bottom: 2rem;
}

.login__upperbox {
  width: 504px;
  max-width: 100%;
  display: inline-block;
}

.login__box {
  width: 100%;
  display: grid;
  grid-template-columns: max-content 1fr;
  column-gap: 0.5rem;
  padding: 1.125rem 1rem;
  background-color: #fff;
  margin-top: 1rem;
  border-radius: 0.5rem;
  border: solid 2px #0f132a1a;
}
.login__icon {
  font-size: 1.5rem;
  color: #ffb30e;
}
.login__input {
  border: none;
  outline: none;
  font-size: 0.938rem;
  font-weight: 700;
  color: #23004d;
  width: 100%;
}
.login__input::placeholder {
  font-size: 0.938rem;
  font-family: "Open Sans", sans-serif;
  color: rgb(128, 128, 128, 0.6) !important;
}
.login__forgot {
  display: block;
  width: max-content;
  margin-left: auto;
  margin-top: 0.5rem;
  font-size: 0.813rem;
  font-weight: 600;
  color: #a49eac;
}
.login__button {
  width: 504px;
  max-width: 100%;
  height: 93px;
  margin: 2rem 0 0 0;
  background-color: #ffb30e;
  color: #fff;
  font-size: 50px;
  font-weight: 400;
  text-align: center;
  border-radius: 0.5rem;
  transition: 0.3s;
  border: 0;
  font-family: ONE-Mobile-POP !important;
}
.login__button:hover {
  background-color: #ffb30ea8;
}
.login__account,
.login__signin,
.login__signup {
  font-weight: 600;
  font-size: 0.813rem;
}
.login__account--account,
.login__signin--account,
.login__signup--account {
  color: #23004d;
}
.login__account--signin,
.login__account--signup,
.login__signin--signin,
.login__signin--signup,
.login__signup--signin,
.login__signup--signup {
  color: #ffb30e;
  cursor: pointer;
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
/* 
.login__social {
  margin-top: 2rem;
}
.login__social--icon {
  font-size: 1.5rem;
  color: #23004d;
  margin: 0 1rem;
} */

/* '회원가입하러 가기' 버튼 디자인 */
.login__signup {
  border: none;
  background: #fff;
  font-family: ONE-Mobile-POP;
}

/* 사진 크기 제어 */
.snsLogin {
  text-align: center;
}

/* 사진 크기 제어 */
.snsLogin a {
  display: block;
}

.block {
  display: block;
}

.none {
  display: none;
}

@keyframes animateLogin {
  0% {
    transform: scale(1, 1);
  }
  50% {
    transform: scale(1.1, 1.1);
  }
  100% {
    transform: scale(1, 1);
  }
}
@media screen and (min-width: 576px) {
  .login__forms {
    /* width: 348px; */
    justify-self: center;
  }
}
@media screen and (min-width: 1024px) {
  .login {
    height: 100vh;
    overflow: hidden;
  }
  .login__content {
    grid-template-columns: repeat(2, max-content);
    justify-content: center;
    align-items: center;
    margin-left: 10rem;
  }
  .login__img {
    display: flex;
    width: 600px;
    height: 588px;
    background-color: #fff;
    border-radius: 1rem;
    padding-left: 1rem;
  }
  .login__img img {
    width: 100%;
    margin-top: 0;
  }
  .login__register,
  .login__create {
    left: -11rem;
  }
  .login__register {
    bottom: -2rem;
  }
  .login__create {
    bottom: -5.5rem;
  }
}
</style>
