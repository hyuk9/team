<template>
  <div>
    <!-- detali Start -->
    <div class="container" v-if="currentAnnounce">
      <div class="mb-3">
        <label for="writer" class="form-label">작성자</label>
        <input type="writer" class="form-control" id="writer" required name="writer"
          v-model="currentAnnounce.writer" />
      </div>
      <div class="mb-3">
        <label for="title" class="form-label">제목</label>
        <input type="text" class="form-control" id="title" required name="title" v-model="currentAnnounce.title" />
      </div>
      <div class="mb-3">
        <label for="content" class="form-label">내용</label>
        <textarea class="form-control form-control-lg " id="content" rows="8" required name="content"
          v-model="currentAnnounce.content"></textarea>
      </div>
      <div class="mb-3">
        <button @click="updateAnnounce" class="btn btn-primary me-3">수정</button>
        <button @click="deleteAnnounce" class="btn btn-danger">삭제</button>
      </div>
      <div class="alert alert-success" role="alert" v-if="message">
        {{ message }}
      </div>
    </div>
    <!-- detail End -->
  </div>
</template>

<script>
import AnnounceDataService from "@/services/AnnounceDataService";
export default {
  data() {
    return {
      currentAnnounce: null,
      message: "",
    };
  },
  methods: {
    // 부서번호(aid)로 조회 요청하는 함수
    getAnnounce(aid) {
      // axios 공통함수 호출
      AnnounceDataService.get(aid)
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
      AnnounceDataService.update(this.currentAnnounce.aid, this.currentAnnounce)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.message = "The Announce was updated successfully!";
          this.$router.push("/announce");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });

    },
    // 부서정보를 삭제 요청하는 함수
    deleteAnnounce() {
      // axios 공통함수 호출
      AnnounceDataService.delete(this.currentAnnounce.aid)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /announce
          this.$router.push("/announce");
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
    this.getAnnounce(this.$route.params.aid);
  },
}
</script>

<style>

</style>