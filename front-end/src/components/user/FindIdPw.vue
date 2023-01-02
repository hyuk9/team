<template>
  <!-- 아이디와 비번 찾는 페이지 -->
  <div class="container">
    <!-- Heading -->
    <h1>아이디/비밀번호 찾기</h1>

    <!-- 아이디 찾기 시작 -->
    <form action="" name="formOne" class="form_container"  @submit.prevent="handleFindId" data-vv-scope='findId'>
      <h2>아이디 찾기</h2>
      <div>
        <!-- 이메일 입력 input -->
        <div class="input__block">
          <h5>회원 가입 시 입력하신 이메일을 입력해 주세요</h5>

          <input
            v-model="user.email"
            v-validate="'required|email|max:50'"
            type="email"
            placeholder="이메일을 입력해 주세요."
            class="input"
            id="email"
            name="이메일 "
          />
          <div v-if="submitted && errors.has('이메일 ')" class="register-alert">
            <p>{{ errors.first("이메일 ") }}</p>
          </div>
        </div>

        <!-- 다음 절차 수행 버튼 -->
        <button class="signin__btn mt-5">다음</button>

      </div>
    </form>
    <!-- 아이디 찾기 끝 -->
    <!-- 비번 찾기 시작 -->
    <form action="" name="formTwo" id="password" class="form_container"  @submit.prevent="handleFindPw" data-vv-scope='findPw'>
      <h2>비밀번호 찾기</h2>
      <div>
        <!-- 아이디 입력 input  -->
        <div class="input__block">
          <h5>회원님의 아이디를 입력해 주세요.</h5>

          <input
            v-model="user.username"
            v-validate="'required|min:3|max:20'"
            type="text"
            placeholder="아이디를 입력해 주세요."
            class="input"
            id="text"
            name="아이디 "
          />
          <div v-if="submitted && errors.has('아이디 ')" class="register-alert">
            <p>{{ errors.first("아이디 ") }}</p>
          </div>
        </div>
           <!-- 이메일 입력 input  -->
        <div class="input__block">
          <h5>회원님의 이메일을 입력해 주세요.</h5>

          <input
            v-model="user.email"
            v-validate="'required|email|max:50'"
            type="email"
            placeholder="이메일을 입력해 주세요."
            class="input"
            id="text"
            name="이메일  "
          />
          <div v-if="submitted && errors.has('이메일 ')" class="register-alert">
            <p>{{ errors.first("이메일 ") }}</p>
          </div>
        </div>

        <!-- 다음 절차 수행 버튼 -->
        <button class="signin__btn mt-5">다음</button>
      </div>
    </form>
    <!-- 비번 찾기 끝 -->
  </div>
</template>

<script>
import User from "@/model/user";
import userDataService from "@/services/UserDataService"

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
  methods: {
    // 아이디 찾기 함수
      handleFindId() {
      this.message = "";
      this.submitted = true;

      // vee-validate 함수 처리 방법
      this.$validator.validateAll('findId').then((isValid) => {
        // validateAll() 모두 통과하면 -> isValid = true  (유효함)
        //                             -> isValid = false (유효하지 않음)
        if (!isValid) {
          return; // 함수 탈출(break)
        }

        userDataService.getId(this.user.email)
      .then((response) => {
            this.successful = true; 
            this.$store.commit("saveId" , response.data) 
            // 성공알림 띄우기
            this.$swal({
              icon: "success",
              title: "확인되었습니다.",
              showConfirmButton: false,
              timer: 1000,
            });
            this.$router.push("/findId");
          })
          .catch((error) => {
            this.successful = false; 
            this.message =
              (error.response &&
                error.response.data &&
                error.response.data.message) ||
              error.message ||
              error.toString();
            // 실패알림 띄우기
            this.$swal({
              icon: "error",
              title: "확인에 실패하였습니다.",
              text: this.message,
              confirmButtonColor: "#E1793D",
              confirmButtonText: "확인",
            });
          });
      });
    },
       // 비번 찾기 함수
      handleFindPw() {
      this.message = "";
      this.submitted = true;

      // vee-validate 함수 처리 방법
      this.$validator.validateAll('findPw').then((isValid) => {
        // validateAll() 모두 통과하면 -> isValid = true  (유효함)
        //                             -> isValid = false (유효하지 않음)
        if (!isValid) {
          return; // 함수 탈출(break)
        }

        userDataService.getPw(this.user.username,this.user.email)
      .then((response) => {
            this.successful = true; 
           if(response.data) {
              this.$store.commit("saveId" , response.data) 
              // 성공알림 띄우기
            this.$swal({
              icon: "success",
              title: "확인되었습니다.",
              showConfirmButton: false,
              timer: 1000,
            });
            this.$router.push("/findPw");
           } else {
              // 실패알림 띄우기
            this.$swal({
              icon: "error",
              title: "유저가 존재하지 않는것 같습니다.",
              confirmButtonColor: "#E1793D",
              confirmButtonText: "확인",
            });
           }

 
          })
          .catch((error) => {
            this.successful = false; 
            this.message =
              (error.response &&
                error.response.data &&
                error.response.data.message) ||
              error.message ||
              error.toString();
            // 실패알림 띄우기
            this.$swal({
              icon: "error",
              title: "확인에 실패하였습니다.",
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
  margin: 250px auto;
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

.form_container {
  margin: 10rem 0;
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
  padding: 0 10px;
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
  font-size: 20px;
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
</style>
