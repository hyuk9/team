<template>
  <div>
    <h1 class="text-danger">
      현재 수정할때 자동으로 user.role 셀렉트박스 지정이 안되는 문제 있음(기능은
      정상 작동)
    </h1>
    <h1 class="text-danger">아이디랑 이메일은 변경 불가능하게 막아둔 상태</h1>
    <div v-if="currentUser" class="container-fluid w-50 mt-5 mb-5">
      <div>
        <!-- 아이디 -->
        <div class="form-group">
          <label for="username">아이디</label>
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
          <div v-if="submitted && errors.has('username')" class="alert-danger">
            {{ errors.first("username") }}
          </div>
        </div>

        <!-- 이메일 -->
        <div class="form-group">
          <label for="email">이메일</label>
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
        <div class="form-group">
          <label for="password">비밀번호</label>
          <input
            v-model="currentUser.password"
            type="password"
            class="form-control"
            name="password"
            :disabled="!changePwd"
          />
          <button class="mt-3 btn btn-warning btn-sm" @click="changePassword">
            패스워드 변경
          </button>
        </div>

        <!-- 이름 -->
        <div class="form-group">
          <label for="name">이름</label>
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
        <div class="form-group">
          <label for="birthday">생년월일</label>
          <input
            v-model="currentUser.birthday"
            v-validate="'numeric'"
            v-bind:disabled="true"
            type="text"
            class="form-control"
            name="birthday"
          />
          <div v-if="submitted && errors.has('birthday')" class="alert-danger">
            {{ errors.first("birthday") }}
          </div>
        </div>

        <!-- 성별 -->
        <div class="form-group">
          <label for="gender">성별</label>
          <div class="col-6 d-inline">
            <p class="d-inline col-6 mb-0 p-0 me-2">남성</p>
            <input
              v-model="currentUser.gender"
              type="radio"
              class="input d-inline"
              id="gendermale"
              name="gender"
              value="male"
            />
          </div>
          <div class="col-6 d-inline">
            <p class="d-inline col-6 mb-0 p-0 me-2">여성</p>
            <input
              v-model="currentUser.gender"
              type="radio"
              class="input d-inline"
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
        <div class="form-group">
          <label for="phone">전화번호</label>
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
        <div class="form-group">
          <label for="address">주소</label>
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
        <div class="form-group" v-if="showAdminBoard">
          <label for="password">권한</label>
          <select class="form-select" v-model="currentUser.role[0].name">
            <option>ROLE_USER</option>
            <option>ROLE_ADMIN</option>
          </select>
        </div>

        <button class="mt-3 btn btn-danger" @click="deleteUser">
          삭제하기
        </button>

        <button
          type="submit"
          class="ms-3 mt-3 btn btn-success"
          @click="updateUser(currentUser.id, changePwd, currentUser)"
        >
          수정하기
        </button>
      </div>
    </div>

    <div v-else>
      <br />
      <p>Please click on a User...</p>
    </div>
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
          alert("삭제 성공");
          this.$router.push("/user");
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

<style scoped></style>
