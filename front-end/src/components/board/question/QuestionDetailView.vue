<template>
  <div>
    <!-- detali Start -->
    <!-- <div class="container col-6 mb-2 mt-2" v-if="currentQuestion">
      <h1 class="mt-5">
        <strong>질문 수정</strong>
      </h1>
      <div class="mb-4">
        <label for="title" class="form-label">제목</label>
        <input type="text" class="form-control" id="title" required name="title" v-model="currentQuestion.title" />
      </div>
      <div class="mb-3">
        <label for="questioner" class="form-label">질문 작성자</label>
        <input type="questioner" class="form-control" id="questioner" required name="questioner"
          v-model="currentQuestion.writer" />
      </div>
      <div class="mb-3">
        <label for="content" class="form-label">내용</label>
        <textarea class="form-control form-control-lg" id="content" rows="8" required name="content"
          v-model="currentQuestion.content"></textarea>
      </div>

      vfor로 답변 다 가져오기 쓸려고 하는데 작동이 안됨
      <div v-for="(data, index) in answer" :key="index">
        <div class="mb-3">
          <label for="answerer" class="form-label">답변 작성자</label>
          <p>{{ data.awriter }}</p>
        </div>
        <div class="mb-3">
          <label for="content" class="form-label">답변</label>
          <p>{{ data.acontent }}</p>
        </div>
      </div>
      vfor끝

      버튼 시작
      <div class="mb-3">
        <button @click="updateQuestion" class="btn btn-primary me-3">
          수정하기
        </button>
        <button @click="deleteQuestion" class="btn btn-danger me-3">
          삭제하기
        </button>
        <button @click="replyAnswer" class="btn btn-primary me-3">
          답글달기
        </button>
      </div>
      버튼 끝
      <div class="alert alert-success" role="alert" v-if="message">
        {{ message }}
      </div>
    </div> -->
    <!-- detail End -->

    <div>
      <div class="container col-6 mb-2 mt-2">
        <div class="AnnounceView-header mt-5">
          <h1>
            <strong>질문 수정</strong>
            <!-- <router-link :to="'/announce'">
            <button class="btn btn-warning offset-8" type="button">
              돌아가기
            </button>
          </router-link> -->
          </h1>
        </div>
        <div class="AnnounceView-title">


          <div class="input-group mt-3 mb-4">
            <span class="input-group-text">제목</span>
            <input type="text" class="form-control" style="height:50px" id="title" required name="title"
              v-model="currentQuestion.title" />
          </div>
          <div class="input-group mb-4">
            <span class="input-group-text">작성자</span>
            <input type="text" class="form-control" style="height:50px" id="title" required name="title"
              v-model="currentQuestion.writer" />
          </div>
          <!-- <td
                colspan="2"
                scope="row"
                style="padding: 10px"
              >{{ currentAnnounce.content }}</td> -->
          <div class="mb-5">
            <textarea class="form-control form-control-lg" id="content" rows="8" required name="content"
              v-model="currentQuestion.content"></textarea>
          </div>

        </div>

        <div class="mb-3">
          <button @click="updateQuestion" class="btn btn-primary me-3">
            수정하기
          </button>
          <button @click="deleteQuestion" class="btn btn-danger me-3">
            삭제하기
          </button>
        </div>
        <div class="alert alert-success" role="alert" v-if="message">
          {{ message }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import QuestionDataService from "@/services/QustionDataService";
// import CommentDataService from "@/services/CommentDataService";

export default {
  data() {
    return {
      answer: [],
      currentQuestion: null,
      currentAnswer: null,
      message: "",
      showAnswer: false,
    };
  },
  methods: {
    // 질문번호(qno)로 질문조회 요청하는 함수
    getQuestion(qno) {
      // axios 공통함수 호출
      QuestionDataService.get(qno)
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
    // 질문번호(qno)로 답변조회 요청하는 함수
    // getAnswer(qno) {
    //   // axios 공통함수 호출
    //   CommentDataService.get(qno)
    //     // 성공하면 .then() 결과가 리턴됨
    //     .then((response) => {
    //       // springboot 결과를 리턴함(부서 객체)
    //       this.currentAnswer = response.data;
    //       // 콘솔 로그 출력
    //       console.log(response.data);
    //     })
    //     // 실패하면 .catch() 에러메세지가 리턴됨
    //     .catch((e) => {
    //       console.log(e);
    //     });
    // },
    // vfor를 위한 함수
    // retrieveAnswer(qno) {
    //   CommentDataService.get(qno)
    //     // 성공하면 .then() 결과가 전송됨
    //     .then((response) => {
    //       const { answer, totalItems } = response.data; // springboot 의 전송된 맵 정보
    //       this.answer = answer; // 스프링부트에서 전송한 데이터
    //       this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)
    //       // 디버깅 콘솔에 정보 출력
    //       console.log(response.data);
    //     })
    //     // 실패하면 .catch() 에 에러가 전송됨
    //     .catch((e) => {
    //       console.log(e);
    //     });
    // },
    // 질문정보를 수정 요청하는 함수
    updateQuestion() {
      // axios 공통함수 호출
      QuestionDataService.update(
        this.currentQuestion.qno,
        this.currentQuestion
      )
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.message = "The Question was updated successfully!";
          this.$router.push("/question");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 질문정보를 삭제 요청하는 함수
    deleteQuestion() {
      // axios 공통함수 호출
      QuestionDataService.delete(this.currentQuestion.qno)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /question
          this.$router.push("/question");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 답글다는 함수 - 아직 안만듦
    replyAnswer() { },
  },
  computed: {
    // 현재 유저
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },

    // 글쓴이로 접속한건지 아닌지 확인하는 함수
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
    this.getQuestion(this.$route.params.qno);
    // this.getAnswer(this.$route.params.qno);
    this.retrieveAnswer(); // 화면 로딩시 전체 조회함수 실행
  },
};
</script>

<style>

</style>