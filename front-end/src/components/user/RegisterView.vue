<template>
  <div class="container">
    <!-- Heading -->
    <router-link to="/"><h1>회원가입</h1></router-link>
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
          <div class="emailInput">
            <input
              v-model="startEmail"
              v-validate="'required|max:50'"
              type="text"
              placeholder="이메일를 입력해 주세요."
              class="input"
              id="email"
              name="이메일 "
            />
            <span class="atSign">@</span>
            <!-- 직접 입력 클릭시 추가 입력창 때문에 크기를 재조정해야함 -> 그 상황시 class 추가 -->
            <select name="" id="direct" :class="['endEmail', selectEmail ? '' : 'endEmailDirectInput']" v-model="endEmail" @click="inputEmailMyself">
              <option value="" selected>이메일 선택</option>
              <option value="naver.com">naver.com</option>
              <option value="gmail.com">gmail.com</option>
              <option value="hanmail.net">hanmail.net</option>
              <option value="daum.net">daum.net</option>
              <option value="nate.com">nate.com</option>
              <option value="icloud.com">icloud.com</option>
              <option value="outlook.kr">outlook.kr</option>
              <option value="yahoo.com">yahoo.com</option>
              <option value="direct" id="inputMyself">직접입력</option>
            </select>
            <input type="text" name="" class="endEmail endEmailDirectInput" placeholder="직접 입력" v-model="endEmail" v-if="!selectEmail">
          </div>
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
        <!-- 비밀번호 재확인 -->
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
        </div>
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
          <div class="dateInput">
            <input
              v-model="year"
              v-validate="'numeric'"
              type="text"
              class="input"
              id="date"
              placeholder="연도 선택"
              name="연도 "
            />
            <select v-model="month">
              <option value="" selected>월</option>
              <option :value="index" v-for="index in 12" :key="index">{{index}}</option>
            </select>  
            <select v-model="day">
              <option value="" selected>일</option>
              <option :value="index" v-for="index in 31" :key="index">{{index}}</option>
            </select>
          </div>
          <div
            v-if="submitted && errors.has('연도 ')"
            class="register-alert"
          >
            <p>{{ errors.first("연도 ") }}</p>
          </div>
        </div>
        <!-- 성별 -->
        <div class="input__block gender">
          <h5 class="d-block">성별</h5>
          <div class="col-6 d-inline-block">
            <p class="d-inline-block col-6 mb-0 p-0">남성</p>
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
            <p class="d-inline-block col-6 mb-0 p-0">여성</p>
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
          <div class="phoneInput">
            <input
              v-model="phoneFirstPart"
              type="text"
              class="input"
              id="phone1"
            />
            <span class="minus">-</span>
              <input
              v-model="phoneMiddlePart"
              type="text"
              class="input"
              id="phone2"
            />
            <span class="minus">-</span>
              <input
              v-model="phoneLastPart"
              type="text"
              class="input"
              id="phone3"
            />
          </div>
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
            @click="popupaddress"
          />
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
      // 이메일 입력창 앞부분
      startEmail : "",
      // 이메일 입력창 뒷부분(@뒤 select 부분)
      endEmail : "",
      // 이메일 뒷부분을 선택할지 본인이 직접 입력할지를 결정하는 변수
      selectEmail : true,
      // 생년월일의 연도
      year : "",
      // 생년월일의 월
      month : "",
      // 생년월일의 일
      day : "",
      // 전화번호의 앞자리
      phoneFirstPart : "",
      // 전화번호의 중간자리
      phoneMiddlePart : "",
      // 전화번호의 뒷자리
      phoneLastPart : "",
    };
  },
  computed: {
    // loggedIn 상태 확인
    loggedIn() {
      // this.$store.state.모듈명.state값
      return this.$store.state.auth.status.loggedIn;
    },
  },
  methods: {
    // 회원가입시 나눠진 일부 입력폼 합치는 함수
    registerInputCombine() {
      //  이메일 앞부분과 뒷부분 합쳐서 완성된 이메일 형식 만들기
      if(this.startEmail && this.endEmail) {
      this.user.email = this.startEmail +"@"+ this.endEmail;   
      }
      //  생년월일 앞부분과 뒷부분 합쳐서 완성된 생년월일 형식 만들기
            if(this.year && this.month && this.day) {
      this.user.birthday = this.year +"."+this.month +"."+ this.day;
            }
      //  전화번호 부분들 합쳐서 완성된 전화번호 형식 만들기
            if(this.phoneFirstPart && this.phoneMiddlePart && this.phoneLastPart) {
      this.user.phone = this.phoneFirstPart +"-"+this.phoneMiddlePart +"-"+ this.phoneLastPart;
            }
    },
    
    // 회원가입 버튼 클릭시 실행되는 함수
    handleRegister() {
      // 위의 함수 로그인 시 실행
      this.registerInputCombine();
      this.message = "";
      this.submitted = true; //  회원가입 버튼 클릭 = true
      // vee-validate 함수 처리 방법
      this.$validator.validateAll().then((isValid) => {
        // validateAll() 모두 통과하면 -> isValid = true  (유효함)
        //                             -> isValid = false (유효하지 않음)
        if (!isValid) {
          // 유효성 검사 결과 이상 발견 시 그곳으로 이동하는 함수
          document.querySelector(".register-alert:first-of-type").scrollIntoView( {block: "center"});
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
              title: "회원가입 성공",
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
              title: "회원가입 실패",
              text: this.message,
              confirmButtonColor: "#E1793D",
              confirmButtonText: "확인",
            });
          });
      });
    },

    // 클릭시 카카오 주소 api 띄우고 주소검색 데이터를 가져오는 함수 
    popupaddress() {
      let user = this.user;
      new daum.Postcode({
          oncomplete: function (data) {
            let kakaoaddress = data.address;
            if (kakaoaddress !== "") {
              user.address= kakaoaddress;
            } 
          },
          shorthand: false,
        }).open();
    },

    // 이메일 @의 뒷부분 중 "직접입력" 클릭시 입력창을 띄우는 함수 
    inputEmailMyself(e) {
      if(e.target.value == "direct" ) {
        document.getElementById("inputMyself").value = "";
        this.selectEmail = false;
      } else {
        this.selectEmail = true;
        document.getElementById("inputMyself").value = "direct";
      }
    }
   
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
  margin-bottom: 80px ;
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
  /* color: #23004d; */
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  padding: 0 10px;
}
/* 셀렉트 박스 둥글게  */
form select {
    border-radius: 8px;
}

/* 이메일 입력용 */
form .emailInput {
    display: block;
  width: 90%;
  max-width: 680px;
  height: 50px;
  margin: 0 auto;
  border-radius: 8px;
  border: none;
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  padding: 0;
}
/* 이메일 입력용 */
form .emailInput .input {
  display: inline-block;
  width: 50%;
}
/* 이메일 입력용 */
form .emailInput .atSign {
  display: inline-block;
  width: 10%;
    height: 50px;
  text-align: center;
}
/* 이메일 입력용 */
form .emailInput .endEmail {
  width: 40%;
    height: 30px;
}
/* 이메일 입력용 */
form .emailInput .endEmailDirectInput {
  display: inline-block;
  margin: 0;
  width: 20%;
  height: 30px;
}

/* 생년월일 입력용 */
form .dateInput {
    display: block;
  width: 90%;
  max-width: 680px;
  height: 50px;
  margin: 0 auto;
  border-radius: 8px;
  border: none;
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  padding: 0;
}
/* 생년월일 입력용 */
form .dateInput .input {
  display: inline-block;
  width: 32%;
  margin-right: 2%;
}
/* 생년월일 입력용 */
form .dateInput select {
  width: 32%;
  height: 50px;
}
/* 생년월일 입력용 */
form .dateInput select:first-of-type{
  margin-right: 2%;
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

/* 전화번호 입력용 */
form .phoneInput {
    display: block;
  width: 90%;
  max-width: 680px;
  height: 50px;
  margin: 0 auto;
  border-radius: 8px;
  border: none;
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  padding: 0;
}

/* 전화번호 입력용 */
form .phoneInput .input {
  display: inline-block;
  width: 30%;
}
/* 전화번호 입력용 */
form .phoneInput .minus {
  display: inline-block;
  width: 5%;
  text-align: center;
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
