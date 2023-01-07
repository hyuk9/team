<template>
  <div>
    <main class="main" id="top">
      <div class="card mb-4">
        <!-- AddDiner.vue -->
        <div class="submit-form mt-5 mb-5 card-header">
          <!-- 새 양식 폼 시작 -->
          <div v-if="!submitted" class="card-body" style="width: 500px">
            <!-- 식당이름 -->
            <div class="form-group">
              <label for="id">작성자</label>
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
                v-model="review.rating"
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
                v-model="review.rcontent"
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
                v-model="review.rphoto"
                name="rphoto"
              />
            </div>

            <!-- 서버 에러 메세지가 있을 경우 아래 출력 시작 -->
            <div v-if="message" class="alert alert-secondary" role="alert">
              {{ message }}
            </div>
            <!-- 서버 에러 메세지가 있을 경우 아래 출력 끝 -->

            <button @click="saveReview" class="btn btn-success mt-5 mb-3">
              Submit
            </button>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>

<script>
import ReviewDataService from "@/services/ReviewDataService";
import DinerDataService from "@/services/DinerDataService";

export default {
  data() {
    return {
      review: {
        id: null,
        // username: "",
        dno: null,
        rcontent: "",
        rating: null,
        rphoto: "",
      },

      // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
      submitted: false,
    };
  },
  methods: {
    // 부서번호(dno)로 조회 요청하는 함수
    getDiner(dno) {
      // axios 공통함수 호출
      DinerDataService.get(dno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentDiner = response.data;
          // 콘솔 로그 출력
          console.log("현재 음식점 데이터 : ", response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 리뷰 작성 form
    saveReview() {
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(no) 자동생성되므로 빼고 전송함
      let data = {
        id: this.currentUser.id,
        dno: this.$route.params.dno,
        rcontent: this.review.rcontent,
        rating: this.review.rating,
        rphoto: this.review.rphoto,
      };

      // insert 요청 함수 호출(axios 공통함수 호출)
      ReviewDataService.create(data)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          this.review.rno = response.data.rno;
          // 콘솔 로그 출력(response.data)
          console.log(response.data);
          alert("추가가 완료되었습니다!");
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /diner
          this.$router.push("/diner/" + this.$route.params.dno);
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    newReview() {
      // 새양식 다시 보여주기 함수, 변수 초기화
      this.submitted = false;
      this.review = {};
    },
  },
  computed: {
    // 현재 유저
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },
  },
  mounted() {
    this.getDiner(this.$route.params.dno);
    // this.dno = this.$route.params.dno;
    // alert(this.dno);
  },
};
</script>

<style>
.submit-form {
  max-width: 700px;
  margin: auto;
}
</style>
