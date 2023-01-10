<template>
  <div>
    <main class="main" id="top">
      <div class="card mb-4">
        <!-- AddDiner.vue -->
        <div class="form mt-5 mb-5 card-header">
          <!-- 새 양식 폼 시작 -->
          <div v-if="!submitted" class="card-body">
            <h1 class="mt-5"><i class="bi bi-journal-plus"></i> 리뷰쓰기</h1>
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
              <h4 class="text-center mt-6 text-900"><i class="bi bi-bookmark-star"></i> 평점 5가지를 선택해주세요!</h4>
              <h5>맛</h5>
              <b-form-rating
                class="wd"
                v-model="review.taste"
                variant="warning"
              ></b-form-rating>

              <h5>서비스</h5>
              <b-form-rating
                class="wd"
                v-model="review.service"
                variant="warning"
              ></b-form-rating>

              <h5>접근성</h5>
              <b-form-rating
                class="wd"
                v-model="review.loc"
                variant="warning"
              ></b-form-rating>

              <h5>분위기</h5>
              <b-form-rating
                class="wd"
                v-model="review.mood"
                variant="warning"
              ></b-form-rating>

              <h5>가성비</h5>
              <b-form-rating
                class="wd"
                v-model="review.cost"
                variant="warning"
              ></b-form-rating>
            </div>

            <div class="input__block">
              <h5>리뷰내용</h5>
              <textarea
                class="form-control wd1"
                placeholder="리뷰를 작성해주세요."
                id="content"
                v-model="review.content"
              ></textarea>
            </div>

            <!-- 식당이름 -->
            <!-- <div class="form-group">
              <label for="rphoto">사진</label>
              <input
                type="text"
                class="form-control"
                id="rphoto"
                v-model="review.rphoto"
                name="rphoto"
              />
            </div> -->

            <!-- 서버 에러 메세지가 있을 경우 아래 출력 시작 -->
            <div v-if="message" class="alert alert-secondary" role="alert">
              {{ message }}
            </div>
            <!-- 서버 에러 메세지가 있을 경우 아래 출력 끝 -->

            <div class="mt-5 mb-3 text-center">
              <button
                type="submit"
                @click="saveReview"
                class="reservation__btn2"
              >
                추가하기
              </button>
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>

<script>
import ReviewDataService from "@/services/ReviewDataService";
import DinerDataService from "@/services/DinerDataService";
import UserDataService from '@/services/UserDataService';

export default {
  data() {
    return {
      review: {
        id: null,
        writer: "",
        dno: null,
        content: "",
        taste: null,
        service: null,
        loc: null,
        mood: null,
        cost: null,
        gender: "",
      },

      // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
      submitted: false,

      // todo 성별 저장용 유저 정보
      findgender : [],
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
      // todo : 성별 정보 가져오기 추가 0110
      UserDataService.get(this.currentUser.id)
        .then((response) => {
          this.findgender = response.data;
          this.review.gender = this.findgender.gender;
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(no) 자동생성되므로 빼고 전송함
      let data = {
        id: this.currentUser.id,
        writer: this.currentUser.username,
        dno: this.$route.params.dno,
        content: this.review.content,
        taste: this.review.taste,
        service: this.review.service,
        loc: this.review.loc,
        mood: this.review.mood,
        cost: this.review.cost,
        gender: this.review.gender,
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
          console.log("리뷰저장 실패", e);
        });
        })
        .catch ((e) => {
          console.log(e);
        })
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
