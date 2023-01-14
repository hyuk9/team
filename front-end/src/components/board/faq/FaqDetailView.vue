<template>
  <div>
    <div>
      <div class="container col-6 mb-2 mt-2">
        <div class="AnnounceView-header mt-5">
          <h1>
            <strong>자주묻는질문 수정</strong>
          </h1>
        </div>
        <div class="AnnounceView-title">
          <div class="input-group mt-3 mb-4">
            <span class="input-group-text">제목</span>
            <input
              type="text"
              class="form-control"
              style="height: 50px"
              id="title"
              required
              name="title"
              v-model="currentFaq.title"
            />
          </div>
          <div class="mb-5">
            <textarea
              class="form-control form-control-lg"
              id="content"
              rows="8"
              required
              name="content"
              v-model="currentFaq.content"
            ></textarea>
          </div>
        </div>

        <div class="mb-3">
          <button @click="updateFaq" class="btn btn-primary me-3">수정</button>
          <button @click="deleteFaq" class="btn btn-danger">삭제</button>
        </div>
        <div class="alert alert-success" role="alert" v-if="message">
          {{ message }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FaqDataService from "@/services/FaqDataService";
export default {
  data() {
    return {
      currentFaq: null,
      message: "",
    };
  },
  methods: {
    // TODO: FAQ pk로 조회 요청하는 함수
    getFaq(no) {
      // axios 공통함수 호출
      FaqDataService.get(no)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentFaq = response.data;
          // 콘솔 로그 출력
          console.log("FAQ 조회요청 성공 : ", response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log("FAQ 조회요청 실패 : ", e);
        });
    },
    // TODO: FAQ 정보를 수정 요청하는 함수
    updateFaq() {
      // axios 공통함수 호출
      FaqDataService.update(this.currentFaq.no, this.currentFaq)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log("FAQ 수정요청 성공 : ", response.data);
          this.message = "The Faq was updated successfully!";
          this.$router.push("/faq");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log("FAQ 수정요청 실패 : ", e);
        });
    },
    // TODO: FAQ정보를 삭제요청하는 함수
    deleteFaq() {
      // axios 공통함수 호출
      FaqDataService.delete(this.currentFaq.no)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log("FAQ 삭제요청 성공 : ", response.data);
          this.$swal({
            icon: "success",
            title: "삭제 성공",
            showConfirmButton: false,
            timer: 1000,
          });
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /faq
          this.$router.push("/faq");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log("FAQ 삭제요청 실패 : ", e);
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