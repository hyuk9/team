<template>
  <div>
    <!-- 최상단 시작 -->
    <section class="py-5 overflow-hidden bg-warning" id="home">
      <div class="container">
        <div class="row flex-center">
          <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
            <a class="img-landing-banner" href="#!"
              ><img
                class="img-fluid"
                src="../../../public/assets/img/gallery/hero-header.png"
                alt="hero-header"
            /></a>
          </div>
          <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
            <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">
              여기는 유저정보 <br />
              디테일 입니다
            </h1>
            <h1 class="text-800 mb-5 fs-4">최상단만 제작</h1>
          </div>
        </div>
      </div>
    </section>
    <!-- 최상단 끝 -->
    <div v-if="currentUser" class="container-fluid w-50 bg bg-danger mt-5 mb-5">
      <div>
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

        <div class="form-group">
          <label for="password">권한</label>
          <select class="form-select" v-model="currentUser.role[0].name">
            <option>ROLE_USER</option>
            <option>ROLE_ADMIN</option>
          </select>
        </div>

        <button class="mt-3 btn btn-danger" @click="deleteUser">삭제하기</button>

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
import UserDataService from "../../services/UserDataService";

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
              alert("수정완료")
            })
            .catch((e) => {
              console.log(e);
            });
        }
      });
    },
    deleteUser() {
      UserDataService.delete(this.currentUser.id)
        .then((response) => {
          console.log(response.data);
          alert("삭제 성공")
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
  },
  mounted() {
    this.message = "";
    this.getUser(this.$route.params.id);
  },
};
</script>

<style scoped></style>
