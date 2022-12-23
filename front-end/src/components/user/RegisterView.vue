<template>
  <div class="container">
    <!-- Heading -->
    <h1>회원가입</h1>
    <!-- 필수 항목 안내 -->
    <i class="fas fa-star-of-life ms-4"> </i><span>는 필수 항목입니다.</span>

    <!-- Form -->
    <form action="" name="form" @submit.prevent="handleRegister">
      <div>
        <!-- username input -->
        <div class="input__block">
          <h5>아이디</h5>
          <i class="fas fa-star-of-life ms-2"></i>
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
        <!-- email input -->
        <div class="input__block">
          <h5>이메일</h5>
          <i class="fas fa-star-of-life ms-2"></i>
          <input
            v-model="user.email"
            v-validate="'required|email|max:50'"
            type="email"
            placeholder="이메일를 입력해 주세요."
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
          <i class="fas fa-star-of-life ms-2"></i>
          <input
            v-model="user.password"
            v-validate="'required|min:6|max:40'"
            type="password"
            placeholder="비밀번호를 입력해 주세요."
            class="input"
            id="password"
            name="비밀번호 "
            ref="password"
          />
          <div
            v-if="submitted && errors.has('비밀번호 ')"
            class="register-alert"
          >
            <p>{{ errors.first("비밀번호 ") }}</p>
          </div>
        </div>
        <!-- 비밀번호 재확인
        <div class="input__block">
          <h5>비밀번호 재확인</h5>
          <i class="fas fa-star-of-life ms-2"></i>
          <input
            v-validate="'required|confirmed:password|min:6|max:40'"
            type="password"
            placeholder="비밀번호를 다시 입력해 주세요."
            class="input"
            id="passwordRe"
            name="비밀번호 재확인 "
          />
          <div
            v-if="submitted && errors.has('비밀번호 재확인 ')"
            class="register-alert"
          >
            <p>{{ errors.first("비밀번호 재확인 ") }}</p>
          </div>
        </div> -->
        <!-- 이름 -->
        <div class="input__block">
          <h5>이름</h5>
            <i class="fas fa-star-of-life ms-2"></i>
          <input
              v-validate="'required'"
            v-model="user.name"
            type="text"
            placeholder="이름"
            class="input"
            id="username"
            name="이름 "
          />
               <div
            v-if="submitted && errors.has('이름 ')"
            class="register-alert"
          >
            <p>{{ errors.first("이름 ") }}</p>
          </div>
        </div>
        <!-- 생년월일 -->
        <!-- datepicker 찾아볼 예정 -->
        <div class="input__block">
          <h5>생년월일</h5>
          <input
            v-model="user.birthday"
            type="date"
            class="input"
            id="date"
            placeholder="날짜 선택"
          />
        </div>
        <!-- 성별 -->
        <div class="input__block gender">
          <h5 class="d-block">성별</h5>
          <div class="col-6 d-inline-block">
            <p class="d-inline-block col-6">남성</p>
            <input
              v-model="user.gender"
              type="radio"
              class="input d-inline-block"
              id="gendermale"
              name="gender"
              value="male"
            />
          </div>
          <div class="col-6 d-inline-block">
            <p class="d-inline-block col-6">여성</p>
            <input
              v-model="user.gender"
              type="radio"
              class="input d-inline-block"
              id="genderfemale"
              name="gender"
              value="female"
            />
          </div>
        </div>
        <!-- 전화번호 -->
        <div class="input__block">
          <h5>전화번호</h5>
          <input
            v-model="user.phone"
            type="text"
            placeholder="전화번호를 입력해 주세요."
            class="input"
            id="phone"
          />
        </div>
        <!-- 주소 -->
        <div class="input__block">
          <h5>주소</h5>
          <input
          v-model="user.address"
            type="text"
            placeholder="주소를 입력해 주세요."
            class="input"
            id="address"
          />
          <!-- @click="popupaddress" -->
        </div>
        <!-- sign in button -->
        <button class="signin__btn mt-5">회원가입하기</button>
      </div>
    </form>
  </div>
</template>

<script>
/* eslint-disable */
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
            // 홈 화면으로 이동
            this.$router.push("/");
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

    // 카카오 주소 api 보류
  // doopop () {
  //         new daum.Postcode({
  //       oncomplete: function (data) {
  //         let kakaoaddress = data.address;
  //         if (kakaoaddress !== "") {
  //           document.getElementById("address").value= kakaoaddress;
  //         } 
  //       },
  //       shorthand: false,
  //     }).open();
  //     },

    // 클릭시 카카오 주소 api 띄우고 주소검색 데이터를 input 태그로 가져오는 함수 ->보류
//     popupaddress() {
//  this.doopop ();
//  if(document.getElementById("address").value !="") {
//   alert("fdsf")
//  }
     
    
//     },
   
  },
  mounted() {
    // 날짜에 현재날짜로 placeholder 표시하기
    this.user.birthday = new Date().toISOString().substring(0, 10);
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
  display: inline-block;
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
  padding: 0 10px;
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
  vertical-align: middle;
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
</style>
