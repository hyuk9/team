<template>
  <div>
    <div class="container col-8 mb-2 mt-2">
      <div class="QuestionView-header">
        <h1><strong>1:1 문의 게시판</strong></h1>
      </div>
      <div class="QuestionView-title">
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
              <td scope="col" v-text="currentQuestion.title"></td>
            </tr>
            <tr>
              <th scope="row">작성자</th>
              <td scope="row" v-text="currentQuestion.writer"></td>
            </tr>
            <tr>
              <td
                colspan="2"
                scope="row"
                style="padding: 10px"
                v-text="currentQuestion.content"
              ></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <div class="mb-3">
      <router-link :to="'/qna/' + currentQuestion.questionNo">
        <button class="btn btn-warning offset-5" type="button">
          수정&삭제
        </button>
      </router-link>
    </div>
  </div>
</template>

<script>
import QuestionDataService from "@/services/QustionDataService";
export default {
  data() {
    return {
      currentQuestion: null,
      message: "",
    };
  },
  methods: {
    // 부서번호(questionNo)로 조회 요청하는 함수
    getQuestion(questionNo) {
      // axios 공통함수 호출
      QuestionDataService.get(questionNo)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentQuestion = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 수정 요청하는 함수
    updateQuestion() {
      // axios 공통함수 호출
      QuestionDataService.update(this.currentQuestion.questionNo, this.currentQuestion)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.message = "The Question was updated successfully!";
          this.$router.push("/qna");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 삭제 요청하는 함수
    deleteQuestion() {
      // axios 공통함수 호출
      QuestionDataService.delete(this.currentQuestion.questionNo)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /qna
          this.$router.push("/qna");
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
    this.getQuestion(this.$route.params.questionNo);
  },
};
</script>

<style>
</style>
