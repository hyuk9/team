<template>
  <!-- ReviewDetail.vue -->
  <div>
    <!-- 수정 양식 폼 시작 -->
    <div class="form mt-6 mb-5">
      <h1 class="mt-6"><i class="bi bi-journal-plus"></i> 리뷰수정</h1>
      <!-- 이름 -->
      <div class="input__block">
        <h5>작성자</h5>
        <input
          type="text"
          class="form-control"
          id="writer"
          required
          v-model="currentUser.username"
          v-bind:disabled="true"
          name="writer"
        />
      </div>

      <!-- 평점 -->
      <div class="input__block">
        <h4 class="text-center mt-6 text-900">
          <i class="bi bi-bookmark-star"></i> 평점 5가지를 선택해주세요!
        </h4>
        <h5>맛</h5>
        <b-form-rating
          class="wd"
          v-model="currentReview.taste"
          variant="warning"
        ></b-form-rating>

        <h5>서비스</h5>
        <b-form-rating
          class="wd"
          v-model="currentReview.service"
          variant="warning"
        ></b-form-rating>

        <h5>접근성</h5>
        <b-form-rating
          class="wd"
          v-model="currentReview.loc"
          variant="warning"
        ></b-form-rating>

        <h5>분위기</h5>
        <b-form-rating
          class="wd"
          v-model="currentReview.mood"
          variant="warning"
        ></b-form-rating>

        <h5>가성비</h5>
        <b-form-rating
          class="wd"
          v-model="currentReview.cost"
          variant="warning"
        ></b-form-rating>
      </div>

      <div class="input__block">
        <h5>리뷰내용</h5>
        <textarea
          class="form-control wd1"
          placeholder="리뷰를 작성해주세요."
          id="content"
          v-model="currentReview.content"
        ></textarea>
      </div>

      <div class="mt-5 mb-5 text-center">
        <button class="reservation__btn1 me-5" @click="deleteReview">
          삭제
        </button>

        <button type="submit" class="reservation__btn2" @click="updateReview">
          수정
        </button>
      </div>
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
            this.$swal({
            icon: "success",
            title: "수정이 완료되었습니다",
            showConfirmButton: false,
            timer: 1000,
          });
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
            this.$swal({
            icon: "success",
            title: "삭제가 완료되었습니다",
            showConfirmButton: false,
            timer: 1000,
          });
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
    console.log("테스트", this.currentReview);
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

<style lang="scss" scoped>
h1 {
  color: #ffb30e;
  font-size: 48px;
  letter-spacing: -3px;
  text-align: center;
  margin-bottom: 80px;
  transition: 0.2s linear;
}

h5 {
  display: inline-block;
  color: #ffb30e;
  margin: 30px 0 30px 30px;
  transition: 0.2s linear;
}

.form {
  width: 100%;
  max-width: 680px;
  margin: 40px auto 10px;
}
.wd {
  margin: 0 auto;
  width: 90%;
  padding: 0 10px;
}
.wd1 {
  margin: 0 auto;
  height: 200px;
  width: 90%;
  padding: 0 10px;
}
.input__block {
  margin: 20px auto;
  display: block;
  position: relative;
}

.input__block input {
  display: block;
  width: 90%;
  max-width: 680px;
  height: 50px;
  margin: 0 auto;
  border-radius: 8px;
  border: none;
  background: rgba(15, 19, 42, 0.1);
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  padding: 0 10px;
}

.gender {
  margin: 0 0 0 30px;
}

.gender h5 {
  margin: 30px 0 30px 0px;
}

.gender input {
  width: 50%;
  max-width: 680px;
  height: 30px;
  margin: 0 auto;
  padding: 0 0 0 15px;
  vertical-align: middle;
}
.reservation__btn1 {
  background: tomato;
  color: white;
  display: inline;
  width: 140px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  font-size: 18px;
  box-shadow: 0 10px 20px rgba(170, 71, 54, 0.377);
  transition: 0.2s linear;
}
.reservation__btn2 {
  background: rgba(76, 184, 43, 0.993);
  color: white;
  display: inline;
  width: 140px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  font-size: 18px;
  box-shadow: 0 10px 20px rgba(59, 138, 35, 0.493);
  transition: 0.2s linear;
}
.reservation__btn1:hover,
.reservation__btn2:hover {
  box-shadow: 0 0 0 rgba(233, 30, 99, 0);
}
button {
  font-family: ONE-Mobile-POP !important;
}
</style>

