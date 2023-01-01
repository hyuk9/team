<template>
  <div>
    <!-- detali Start -->
    <div class="container" v-if="currentFaq">
      <div class="mb-3">
        <label for="title" class="form-label">title</label>
        <input
          type="text"
          class="form-control"
          id="title"
          required
          name="title"
          v-model="currentFaq.title"
        />
      </div>
      <div class="mb-3">
        <label for="content" class="form-label">content</label>
        <textarea
          class="form-control form-control-lg"
          id="content"
          rows="8"
          required
          name="content"
          v-model="currentFaq.content"
        ></textarea>
      </div>
      <div class="mb-3">
        <button @click="updateFaq" class="btn btn-primary me-3">Update</button>
        <button @click="deleteFaq" class="btn btn-danger">Delete</button>
      </div>
      <div class="alert alert-success" role="alert" v-if="message">
        {{ message }}
      </div>
    </div>
    <!-- detail End -->
  </div>
</template>

<script>
import FaqDataService from "../../../services/FaqDataService";
export default {
  data() {
    return {
      currentFaq: null,
      message: "",
    };
  },
  methods: {
    // 부서번호(no)로 조회 요청하는 함수
    getFaq(no) {
      // axios 공통함수 호출
      FaqDataService.get(no)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentFaq = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 수정 요청하는 함수
    updateFaq() {
      // axios 공통함수 호출
      FaqDataService.update(this.currentFaq.no, this.currentFaq)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.message = "The Faq was updated successfully!";
          this.$router.push("/faq");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 삭제 요청하는 함수
    deleteFaq() {
      // axios 공통함수 호출
      FaqDataService.delete(this.currentFaq.no)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /faq
          this.$router.push("/faq");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
  },
  // 화면이 뜨자 마자 실행되는 이벤트
  mounted() {
    this.message = "";
    this.getFaq(this.$route.params.no);
  },
};
</script>

<style>
</style>