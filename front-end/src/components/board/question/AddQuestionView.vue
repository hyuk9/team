<template>
  <div>
    <!-- Addquestion Start -->
    <!-- <div class="container" v-if="!submitted">
      <div class="mb-3">
        <label for="questioner" class="form-label">작성자</label>
        <input
          type="questioner"
          class="form-control"
          id="questioner"
          required
          name="questioner"
          v-model="question.questioner"
        />
      </div>
      <div class="mb-3">
        <label for="title" class="form-label">제목</label>
        <input
          type="title"
          class="form-control"
          id="title"
          required
          name="title"
          v-model="question.title"
        />
      </div>
      <div class="mb-3">
        <label for="content" class="form-label">내용</label>
        <textarea
          class="form-control form-control-lg"
          id="content"
          rows="8"
          required
          name="content"
          v-model="question.content"
        ></textarea>
      </div>
      <div class="mb-3">
        <button @click="savequestion" class="btn btn-primary">Submit</button>
      </div>
    </div> -->
    <!-- Addquestion End -->

    <div>
      <div class="container col-6 mb-2 mt-2">
        <div class="AnnounceView-header mt-5">
          <h1>
            <strong>질문 등록</strong>
          </h1>
        </div>
        <div class="AnnounceView-title">


          <div class="input-group mt-3 mb-4">
            <span class="input-group-text">제목</span>
            <input type="text" class="form-control" style="height:50px" id="title" required name="title"
              v-model="question.title" />
          </div>
          <div class="input-group mb-4">
            <span class="input-group-text">작성자</span>
            <input type="text" class="form-control" style="height:50px" id="title" required name="title"
              v-model="question.questioner" />
          </div>

          <div class="mb-5">
            <textarea class="form-control form-control-lg" id="content" rows="8" required name="content"
              v-model="question.content"></textarea>
          </div>

        </div>


        <div class="mb-3">
          <button @click="savequestion" class="btn btn-primary">글쓰기</button>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import QuestionDataService from "@/services/QustionDataService";
export default {
  data() {
    return {
      question: {
        qno: null,
        questioner: "",
        title: "",
        content: "",
      },
      // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
      submitted: false,
    };
  },
  methods: {
    savequestion() {
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(no) 자동생성되므로 빼고 전송함
      let data = {
        questioner: this.question.questioner,
        title: this.question.title,
        content: this.question.content,
      };

      // insert 요청 함수 호출(axios 공통함수 호출)
      QuestionDataService.create(data)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          this.question.qno = response.data.qno;
          // 콘솔 로그 출력(response.data)
          console.log(response.data);
          // 변수 submitted
          this.submitted = true;
          alert("성공했습니다.");
          this.$router.push("/question");
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    newquestion() {
      // 새양식 다시 보여주기 함수, 변수 초기화
      this.submitted = false;
      this.question = {};
    },

    returnquestion() {
      this.$router.push("/question");
    },
  },
};
</script>

<style>

</style>