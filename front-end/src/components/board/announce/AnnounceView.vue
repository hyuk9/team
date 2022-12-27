<template>
  <div>
    <!-- 최상단 시작 -->
    <section class="py-5 overflow-hidden bg-warning" id="home">
      <div class="container">
        <div class="row flex-center">
          <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
            <!-- TODO: 이미지가 안나와서 이미지 경로 수정 -->
            <a class="img-landing-banner" href="#!"><img class="img-fluid"
                src="../../../../public/assets/img/gallery/hero-header.png" alt="hero-header" /></a>
          </div>
          <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
            <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">
              여기는 공지사항 <br />
              페이지 입니다
            </h1>
            <h1 class="text-800 mb-5 fs-4">최상단만 제작</h1>
          </div>
        </div>
      </div>
    </section>
    <!-- 최상단 끝 -->
    <div class="container col-8 mb-2 mt-2">
      <div class="AnnounceView-header">
        <h1><strong>공지사항 게시판</strong></h1>
      </div>
      <div class="AnnounceView-title">
        <table class="table">
          <colgroup>
            <col style="width:15%">
            <col style="width:85%">
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
              <td scope="col" v-text="currentAnnounce.title"></td>
            </tr>
            <tr>
              <th scope="row">작성자</th>
              <td scope="row" v-text="currentAnnounce.writer"></td>
            </tr>
            <tr>
              <td colspan="2" scope="row" style="padding:10px" v-text="currentAnnounce.content"></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <div class="mb-3" v-if="showAdminBoard">
      <router-link :to="'/announce/' + currentAnnounce.ano">
        <button class="btn btn-warning offset-2" type="button">수정&삭제</button>
      </router-link>
    </div>

  </div>
</template>

<script>
import AnnounceDataService from "../../../services/AnnounceDataService";
export default {
  data() {
    return {
      currentAnnounce: null,
      message: "",
    };
  },
  methods: {
    // 부서번호(ano)로 조회 요청하는 함수
    getAnnounce(ano) {
      // axios 공통함수 호출
      AnnounceDataService.get(ano)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentAnnounce = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 수정 요청하는 함수
    updateAnnounce() {
      // axios 공통함수 호출
      AnnounceDataService.update(this.currentAnnounce.ano, this.currentAnnounce)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.message = "The Announce was updated successfully!";
          location.href = "/announce";
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });

    },
    // 부서정보를 삭제 요청하는 함수
    deleteAnnounce() {
      // axios 공통함수 호출
      AnnounceDataService.delete(this.currentAnnounce.ano)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /announce
          this.$router.push("/announce");
          location.href = "/announce";
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
    this.getAnnounce(this.$route.params.ano);
  },
}
</script>

<style>

</style>
