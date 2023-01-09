<template>
  <div>
    <div class="container mb-2 mt-2">
      <div class="FreeView-header">
        <h1><strong>질문 게시판</strong></h1>
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
              <td scope="col" v-text="currentQuestion.title"></td>
            </tr>
            <tr>
              <th scope="row">작성자</th>
              <td scope="row" v-text="currentQuestion.writer"></td>
            </tr>
            <tr>
              <th scope="row">조회수</th>
              <td scope="row" v-text="currentfreeForViews.views"></td>
            </tr>
            <tr>
              <td colspan="2" scope="row">
                <div class="contentarea">
                  {{ currentQuestion.content }}
                </div>
              </td>
            </tr>
          </tbody>

          <!-- 댓글 창 -->
        </table>
        <!-- 댓글 창 만들어야 함
          <div v-for="(data, index) in comment" :key="index">
            <div>{{ data.writer }} 댓글:</div>
            <div>{{ data.content }}</div>
          </div> -->
        <div class="card">
          <div class="card-header pb-4">댓글 
            <ul class="list-group">
              <li class="list-group-item d-flex justify-content-between p-2" v-for="(data, index) in comment" :key="index">
                <p class="text-start col-2">{{ data.writer }} </p><p class="col-8">{{ data.content }}</p>
                <div class="d-flex">
                  <div class="front-italic">작성일:{{ data.insertTime }}&nbsp;</div>
                  <button class="badge bg-warning">수정</button>
                  <button class="badge bg-danger">삭제</button>
                </div>
                <!-- <h1>여기</h1> -->
              </li>
            </ul>
          </div>
        </div>

        <br />

        <div class="card">
          <div class="card-body input-group"><span class="input-group-text">댓글창</span><textarea class="form-control" row="1"></textarea><button type="button" class="btn btn-danger">등록</button></div>
        </div>

      </div>
    </div>

    <div class="mb-3">
      <router-link :to="'/question/' + currentQuestion.qno" v-if="showDetailBoard">
        <button class="btn btn-warning offset-5" type="button">
          수정&삭제
        </button>
      </router-link>
    </div>
  </div>
</template>

<script>
import QuestionDataService from "@/services/QustionDataService";
import CommentDataService from "@/services/CommentDataService";

export default {
  data() {
    return {
      currentQuestion: null,
      currentQuestionForViews: null, // 이게 뭔지 모르겠음

      currentComment: null,
      currentIndex: -1,

      comment: [],
      name: "",

      // 조회수용 변수 추가
      currentfreeForViews: null,

      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 8, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수
    };
  },
  methods: {
    // Todo : 질문번호로 조회 요청하는 함수
    getQuestion(qno) {
      // axios 공통함수 호출
      QuestionDataService.get(qno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(질문 객체)
          this.currentQuestion = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
          // 댓글 조회함수 실행
          this.getComment();
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
      // Todo : 조회수 증가하는 함수인거 같음
      QuestionDataService.getById(qno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentfreeForViews = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },

    // FIXME: 성공은 하는데 response.data에 아무것도 안들어감;
    // Todo : 댓글 정보를 조회요청하는 함수
    getComment() {
      CommentDataService.getCommentByQno(
        this.currentQuestion.qno,
        this.page - 1,
        this.pageSize
      )
        .then((response) => {
          // springboot 결과를 리턴함(질문 객체)
          const { comment, totalItems } = response.data; // springboot 의 전송한 맵 정보
          this.comment = comment; // 스프링부트에서 전송한 데이터
          this.count = totalItems;
          // 콘솔 로그 출력
          console.log("댓글 정보 조회 성공 : ", response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log("댓글 정보 조회 실패 : ", e);
        });
    },
    // Todo : 질문정보를 수정 요청하는 함수
    updateFree() {
      // axios 공통함수 호출
      QuestionDataService.update(this.currentQuestion.qno, this.currentQuestion)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.$router.push("/question" + this.currentQuestion.qno);
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // Todo : 질문정보를 삭제 요청하는 함수
    deleteQuestion() {
      // axios 공통함수 호출
      QuestionDataService.delete(this.currentQuestion.qno)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /free
          this.$router.push("/question");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
  },

  computed: {
    // Todo : 로컬 스토리지에 저장된 현재 유저 정보 가져오는 함수
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },

    // Todo : 글작성자 or 관리자일 경우 버튼이 보이게 하는 함수
    showDetailBoard() {
      if (this.currentUser && this.currentUser.roles) {
        // if ROLE_ADMIN 있으면 true 없으면 false 이거나 현재로그인한id == 글쓴사람id
        return (
          this.currentUser.roles.includes("ROLE_ADMIN") ||
          this.currentUser.id == this.currentQuestion.id
        );
      }
      // currentUser 없으면 false (메뉴가 안보임)
      return false;
    },
  },
  // 화면이 뜨자 마자 실행되는 이벤트
  mounted() {
    this.getQuestion(this.$route.params.qno);
  },
};
</script>

<style>
.contentarea {
  width: 1240px;
  height: 500px;
  padding: 30px;
}
</style>
