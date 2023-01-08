<template>
  <div>
    <section>
      <div>
        <h1>개인정보 수정</h1>
      </div>
      <div v-if="currentUser" class="container-fluid w-50 mt-5 mb-5">
        <div class="form">
          <!-- 아이디 -->
          <div class="input__block">
            <h5>아이디</h5>
            <!-- v-validate : 유효성 체크 -->
            <!-- v-validate="'required|min:3|max:20'" 체크함 -->
            <!-- errors.has('username') : 에러 발생했는지 검사 -->
            <!-- {{errors.first('username')}} : 에러 있으면 화면 출력됨, 없으면 안됨 -->
            <input
              v-model="currentUser.username"
              v-validate="'required|min:3|max:20'"
              v-bind:disabled="true"
              type="text"
              class="form-control"
              name="username"
            />
            <!-- 유효성 체크 후 에러 체크 : errors.hat(체크대상) -->
            <!-- errors.first(체크대상) : 에러 내용 출력 -->
            <div
              v-if="submitted && errors.has('username')"
              class="alert-danger"
            >
              {{ errors.first("username") }}
            </div>
          </div>

          <!-- 이메일 -->
          <div class="input__block">
            <h5>이메일</h5>
            <input
              v-model="currentUser.email"
              v-validate="'required|email|max:50'"
              v-bind:disabled="true"
              type="email"
              class="form-control"
              name="email"
            />
            <div v-if="submitted && errors.has('email')" class="alert-danger">
              {{ errors.first("email") }}
            </div>
          </div>

          <!-- 비밀번호 -->
          <div class="input__block">
            <h5>비밀번호</h5>
            <input
              v-model="currentUser.password"
              type="password"
              class="form-control"
              name="password"
              :disabled="!changePwd"
            />
            <button
              class="mt-3 ms-5 btn btn-warning btn-sm"
              @click="changePassword"
            >
              패스워드 변경
            </button>
          </div>

          <!-- 이름 -->
          <div class="input__block">
            <h5>이름</h5>
            <input
              v-model="currentUser.name"
              v-validate="'required|name|max:10'"
              v-bind:disabled="true"
              type="text"
              class="form-control"
              name="name"
            />
            <div v-if="submitted && errors.has('name')" class="alert-danger">
              {{ errors.first("name") }}
            </div>
          </div>

          <!-- 생년월일 -->
          <div class="input__block">
            <h5>생년월일</h5>
            <input
              v-model="currentUser.birthday"
              v-validate="'numeric'"
              v-bind:disabled="true"
              type="text"
              class="form-control"
              name="birthday"
            />
            <div
              v-if="submitted && errors.has('birthday')"
              class="alert-danger"
            >
              {{ errors.first("birthday") }}
            </div>
          </div>

          <!-- 성별 -->
          <div class="input__block gender">
            <h5 class="d-block">성별</h5>
            <div class="col-6 d-inline-block">
              <p class="d-inline col-6 mb-0 p-0">남성</p>
              <input
                v-model="currentUser.gender"
                type="radio"
                class="input d-inline-block"
                id="gendermale"
                name="gender"
                value="male"
              />
            </div>
            <div class="col-6 d-inline-block">
              <p class="d-inline col-6 mb-0 p-0">여성</p>
              <input
                v-model="currentUser.gender"
                type="radio"
                class="input d-inline-block"
                id="genderfemale"
                name="gender"
                value="female"
              />
            </div>
            <div v-if="submitted && errors.has('gender')" class="alert-danger">
              {{ errors.first("gender") }}
            </div>
          </div>

          <!-- 전화번호 -->
          <div class="input__block">
            <h5>전화번호</h5>
            <input
              v-model="currentUser.phone"
              v-bind:disabled="true"
              type="text"
              class="form-control"
              name="phone"
            />
            <div v-if="submitted && errors.has('phone')" class="alert-danger">
              {{ errors.first("phone") }}
            </div>
          </div>

          <!-- 주소 -->
          <div class="input__block">
            <h5>주소</h5>
            <input
              v-model="currentUser.address"
              type="text"
              class="form-control"
              name="address"
              @click="popupaddress"
            />
            <div v-if="submitted && errors.has('address')" class="alert-danger">
              {{ errors.first("address") }}
            </div>
          </div>

          <!-- 권한 -->
          <!-- <div class="input__block" v-if="showAdminBoard">
            <h5>권한</h5>
            <select class="form-select" v-model="currentUser.role[0].rname">
              <option>ROLE_USER</option>
              <option>ROLE_ADMIN</option>
            </select>
          </div> -->

          <!-- 권한 -->
          <div class="input__block gender" v-if="showAdminBoard">
            <h5 class="d-block">권한</h5>
            <div class="col-6 d-inline-block">
              <p class="d-inline col-6 mb-0 p-0">회원</p>
              <input
                v-model="currentUser.role[0].rname"
                type="radio"
                class="input d-inline-block"
                id="ROLE_USER"
                value="ROLE_USER"
              />
            </div>
            <div class="col-6 d-inline-block">
              <p class="d-inline col-6 mb-0 p-0">관리자</p>
              <input
                v-model="currentUser.role[0].rname"
                type="radio"
                class="input d-inline-block"
                id="ROLE_ADMIN"
                value="ROLE_ADMIN"
              />
            </div>
          </div>
          <div class="mt-5 mb-3 text-center">
            <button class="reservation__btn1 me-5" @click="deleteUser">
              회원탈퇴
            </button>

            <button
              type="submit"
              class="reservation__btn2"
              @click="updateUser(currentUser.id, changePwd, currentUser)"
            >
              수정하기
            </button>
          </div>
        </div>
      </div>

      <div v-else>
        <br />
        <p>Please click on a User...</p>
      </div>
    </section>
  </div>
</template>

<script>
/* eslint-disable */
import UserDataService from "@/services/UserDataService";

export default {
  data() {
    return {
      currentUser: null,
      submitted: false,
      message: "",
      changePwd: false,
    };
  },
  methods: {
    getUser(id) {
      UserDataService.get(id) // spring 요청
        //  성공/실패 모르겠지만
        //  성공하면 then안에 있는것이 실행
        .then((response) => {
          this.currentUser = response.data;
          console.log(response.data);
        })
        //  실패하면 catch안에 있는것이 실행
        .catch((e) => {
          console.log(e);
        });
    },
    updateUser(id, changePwd, user) {
      this.message = "";
      this.submitted = true;
      // form 유효성 체크 검사
      // this.$validator.validate() : 유효하면 isValid = true , 아니면 isValid = false
      this.$validator.validate().then((isValid) => {
        if (isValid) {
          // user 값 초기화
          // this.user = new User("", "", "", this.role);
          //  공유 저장소의 새사용자 등록 함수 실행
          UserDataService.update(id, changePwd, user)
            .then((response) => {
              console.log(response.data);
              alert("수정완료");
              this.$router.push("/user");
            })
            .catch((e) => {
              console.log(e);
              alert(e, "수정실패");
              this.$router.push("/user");
            });
        }
      });
    },
    deleteUser() {
      UserDataService.delete(this.currentUser.id)
        .then((response) => {
          console.log(response.data);
          // this.$store.dispatch("모듈명/함수명")
          this.$store.dispatch("auth/logout"); // 공통함수 logout 호출
          // alert 라이브러리 효과
          this.$swal({
            icon: "success",
            title: "탈퇴 성공",
            showConfirmButton: false,
            timer: 1000,
          });
          this.$router.push("/");
        })
        .catch((e) => {
          console.log(e);
        });
    },

    changePassword() {
      this.currentUser.password = "";
      this.changePwd = true;
    },

    // 클릭시 카카오 주소 api 띄우고 주소검색 데이터를 가져오는 함수
    popupaddress() {
      let currentUser = this.currentUser;
      new daum.Postcode({
        oncomplete: function (data) {
          let kakaoaddress = data.address;
          if (kakaoaddress !== "") {
            currentUser.address = kakaoaddress;
          }
        },
        shorthand: false,
      }).open();
    },
  },
  computed: {
    // 현재 유저
    loginedUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },
    // 관리자 접속인지 아닌지 확인하는 함수
    showAdminBoard() {
      if (this.loginedUser && this.loginedUser.roles) {
        // if ROLE_ADMIN 있으면 true
        //               없으면 false
        return this.loginedUser.roles.includes("ROLE_ADMIN");
      }
      // loginedUser 없으면 false (메뉴가 안보임)
      return false;
    },
  },

  mounted() {
    this.message = "";
    this.getUser(this.$route.params.id);
  },
};
</script>

<style lang="scss" scoped>
h1 {
  color: #ffb30e;
  font-size: 48px;
  letter-spacing: -3px;
  text-align: center;
  margin-bottom: 80px;
  transition: 0.2s linear;
}

h5 {
  display: inline-block;
  color: #ffb30e;
  margin: 30px 0 30px 30px;
  transition: 0.2s linear;
}

.form {
  width: 100%;
  max-width: 680px;
  margin: 40px auto 10px;
}

.input__block {
  margin: 20px auto;
  display: block;
  position: relative;
}

.input__block input {
  display: block;
  width: 90%;
  max-width: 680px;
  height: 50px;
  margin: 0 auto;
  border-radius: 8px;
  border: none;
  background: rgba(15, 19, 42, 0.1);
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  padding: 0 10px;
}

.gender {
  margin: 0 0 0 30px;
}

.gender h5 {
  margin: 30px 0 30px 0px;
}

.gender input {
  width: 50%;
  max-width: 680px;
  height: 30px;
  margin: 0 auto;
  padding: 0 0 0 15px;
  vertical-align: middle;
}
.reservation__btn1 {
  background: tomato;
  color: white;
  display: inline;
  width: 140px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  font-size: 18px;
  box-shadow: 0 10px 20px rgba(170, 71, 54, 0.377);
  transition: 0.2s linear;
}
.reservation__btn2 {
  background: rgba(76, 184, 43, 0.993);
  color: white;
  display: inline;
  width: 140px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  font-size: 18px;
  box-shadow: 0 10px 20px rgba(59, 138, 35, 0.493);
  transition: 0.2s linear;
}
.reservation__btn1:hover,
.reservation__btn2:hover {
  box-shadow: 0 0 0 rgba(233, 30, 99, 0);
}
button {
  font-family: ONE-Mobile-POP !important;
}
</style>
