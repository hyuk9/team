<template>
  <div>
    <div class="container mb-2 mt-2">
      <div class="FreeView-header">
        <h1><strong>1:1 문의 게시판</strong></h1>
      </div>
      <div class="FreeView-title">
        <table class="table">
          <colgroup>
            <col style="width: 15%" />
            <col style="width: 85%" />
          </colgroup>
          <thead>
            <tr>
              <th scope="col"></th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="col">제목</th>
              <td scope="col" v-text="currentFree.title"></td>
            </tr>
            <tr>
              <th scope="row">작성자</th>
              <td scope="row" v-text="currentFree.writer"></td>
            </tr>
            <tr>
              <td
                colspan="2"
                scope="row"
                style="padding: 10px"
                v-text="currentFree.content"
              ></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <div class="mb-3">
      <router-link :to="'/free/' + currentFree.fno">
        <button class="btn btn-warning offset-5" type="button">
          수정&삭제
        </button>
      </router-link>
    </div>
  </div>
</template>

<script>
import FreeDataService from "../../../services/FreeDataService";
export default {
  data() {
    return {
      currentFree: null,
      message: "",
    };
  },
  methods: {
    // 부서번호(fno)로 조회 요청하는 함수
    getFree(fno) {
      // axios 공통함수 호출
      FreeDataService.get(fno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentFree = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 수정 요청하는 함수
    updateFree() {
      // axios 공통함수 호출
      FreeDataService.update(this.currentFree.fno, this.currentFree)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.message = "The Free was updated successfully!";
          location.href = "/free";
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 삭제 요청하는 함수
    deleteFree() {
      // axios 공통함수 호출
      FreeDataService.delete(this.currentFree.fno)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /free
          this.$router.push("/free");
          location.href = "/free";
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
  },

  computed: {
    // 현재 유저
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },

    // 관리자 접속인지 아닌지 확인하는 함수
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        // if ROLE_ADMIN 있으면 true
        //               없으면 false
        return this.currentUser.roles.includes("ROLE_ADMIN");
      }
      // currentUser 없으면 false (메뉴가 안보임)
      return false;
    },
  },

  // 화면이 뜨자 마자 실행되는 이벤트
  mounted() {
    this.message = "";
    this.getFree(this.$route.params.fno);
  },
};
</script>

<style>
</style>
