<template>
  <!-- ReviewDetail.vue -->
  <div>
    <!-- 수정 양식 폼 시작 -->
    <div class="edit-form mt-5 mb-5">
      <h4>식당 정보</h4>
      <form>
        <div class="form-group">
          <label for="dname">작성자</label>
          <input
            type="text"
            class="form-control"
            id="id"
            required
            v-model="currentUser.username"
            v-bind:disabled="true"
            name="id"
          />
        </div>

        <!-- 평점 -->
        <div class="form-group">
          <label for="rating">평점</label>
          <select
            class="form-select"
            id="rating"
            required
            v-model="currentReview.rating"
            name="rating"
            aria-label="Default select example"
          >
            <option selected>평점을 선택해주세요.</option>
            <option value="1">1점</option>
            <option value="2">2점</option>
            <option value="3">3점</option>
            <option value="4">4점</option>
            <option value="5">5점</option>
          </select>
        </div>

        <div class="form-group">
          <label for="rcontent">리뷰내용</label>
          <textarea
            class="form-control"
            placeholder="리뷰를 작성해주세요."
            id="rcontent"
            v-model="currentReview.rcontent"
            style="height: 100px"
          ></textarea>
        </div>

        <!-- 식당이름 -->
        <div class="form-group">
          <label for="rphoto">사진</label>
          <input
            type="text"
            class="form-control"
            id="rphoto"
            v-model="currentReview.rphoto"
            name="rphoto"
          />
        </div>
      </form>

      <button class="mt-3 btn btn-danger" @click="deleteReview">삭제</button>

      <button
        type="submit"
        class="ms-3 mt-3 btn btn-success"
        @click="updateReview"
      >
        수정
      </button>
    </div>
    <!-- 수정 양식 폼 끝 -->
<!-- 
    <div v-else>
      <br />
      <p>Please click on a Review…</p>
    </div> -->
  </div>
</template>

<script>
import ReviewDataService from "@/services/ReviewDataService";

export default {
  data() {
    return {
      currentReview: null,
      message: "",
    };
  },
  methods: {

    // 부서번호(rno)로 조회 요청하는 함수
    getReview(rno) {
      // axios 공통함수 호출
      ReviewDataService.getRno(rno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentReview = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 수정 요청하는 함수
    updateReview() {
      // axios 공통함수 호출
      ReviewDataService.update(this.currentReview.rno, this.currentReview)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          alert("수정이 완료되었습니다!");
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /review
          this.$router.push("/diner");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 삭제 요청하는 함수
    deleteReview() {
      // axios 공통함수 호출
      ReviewDataService.delete(this.currentReview.rno)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          alert("삭제가 완료되었습니다!");
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /review
          this.$router.push("/diner");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
  },
  // 화면이 뜨자 마자 실행되는 이벤트
  mounted() {
    // 클라이언트쪽 디버깅
    // alert(this.$route.params.rno);
    // console.log(this.$route.params.rno);

    this.message = "";
    //  this.$route.params.rno : 이전페이지에서 전송한 매개변수는 $route.params 안에 있음
    // $route 객체 : 주로 url 매개변수 정보들이 있음
    // router/index.js 상세페이지 url의 매개변수명 : :rno
    this.getReview(this.$route.params.rno);
    console.log('테스트', this.currentReview);
  },
  computed: {
    // 현재 유저
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },
  },
};
</script>

<style>
.edit-form {
  max-width: 500px;
  margin: auto;
}
</style>
