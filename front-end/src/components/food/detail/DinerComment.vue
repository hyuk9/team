<template>
  <div>
    <b-modal
      id="modal-prevent-closing"
      ref="modal"
      title="리뷰를 작성해주세요!"
      @show="resetModal"
      @hidden="resetModal"
      @ok="handleOk"
      @click="saveReview"
    >
      <form ref="form" @submit.stop.prevent="handleSubmit">
        <b-form-group
          label="작성자"
          label-for="rwriter-input"
          invalid-feedback="Name is required"
          :state="rwriterState"
        >
          <b-form-input
            id="rwriter-input"
            v-model="review.rwriter"
            :state="rwriterState"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          label="평점"
          label-for="rating-input"
          invalid-feedback="Rating is required"
          :state="ratingState"
        >
          <b-form-rating
            v-model="review.rating"
            show-value
            required
          ></b-form-rating>
        </b-form-group>

        <b-form-group
          label="내용"
          label-for="rcontent-input"
          invalid-feedback="Content is required"
          :state="rcontentState"
        >
          <b-form-input
            id="rcontent-input"
            v-model="review.rcontent"
            :state="rcontentState"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          label="사진"
          label-for="rphoto-input"
          v-model="review.rphoto"
          :state="rphotoState"
        >
          <b-form-file multiple>
            <template slot="file-name" slot-scope="{ names }">
              <b-badge variant="dark">{{ names[0] }}</b-badge>
              <b-badge v-if="names.length > 1" variant="dark" class="ml-1">
                + {{ names.length - 1 }} More files
              </b-badge>
            </template>
          </b-form-file>
        </b-form-group>
      </form>
    </b-modal>
  </div>
</template>

<script>
import ReviewDataService from "@/services/ReviewDataService";

export default {
  data() {
    return {
      review: [],

      rwriter: "",
      rcontent: "",
      rating: null,
      rphoto: [],

      rwriterState: null,
      ratingState: null,
      rcontentState: null,
      rphotoState: null,

      currentDiner: null,
      currentReview: null,
      message: "",
      currentIndex: -1,
      searchRwriter: "",
    };
  },
  methods: {
    // 목록을 클릭했을때 현재 부서객체, 인덱스번호를 저장하는 함수
    setActiveReview(data, index) {
      this.currentReview = data;
      this.currentIndex = index;
    },
    // axios, 모든 부서 정보 삭제 요청 함수
    removeAllReview() {
      ReviewDataService.deleteAll()
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
          // 전체 목록 재조회
          this.retrieveReview();
          // currentEmp, currentIndex 초기화
          this.currentReview = null;
          this.currentIndex = -1;
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    checkFormValidity() {
      const valid = this.$refs.form.checkValidity();
      this.rwriterState = valid;
      this.ratingState = valid;
      this.rcontentState = valid;
      return valid;
    },
    resetModal() {
      this.rwriter = "";
      this.rwriterState = null;
      this.rating = "";
      this.ratingState = null;
      this.rcontent = "";
      this.rcontentState = null;
    },
    handleOk(bvModalEvent) {
      // Prevent modal from closing
      bvModalEvent.preventDefault();
      // Trigger submit handler
      this.handleSubmit();
    },
    handleSubmit() {
      // Exit when the form isn't valid
      if (!this.checkFormValidity()) {
        return;
      }
      // Push the name to submitted names
      this.review.push(this.review.rwriter);
      this.review.push(this.review.rating);
      this.review.push(this.review.rphoto);
      this.review.push(this.review.rcontent);
      // Hide the modal manually
      this.$nextTick(() => {
        this.$bvModal.hide("modal-prevent-closing");
      });
    },
    // 리뷰 작성 form
    saveReview() {
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(no) 자동생성되므로 빼고 전송함
      let data = {
        rwriter: this.review.rwriter,
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
          // 변수 submitted
          this.submitted = true;
          alert("성공했습니다.");
          this.$router.push("/review");
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    mounted() {
      this.message = "";
      this.getReview(this.$route.params.dno);
      // 화면 로딩시 전체 조회함수 실행
      this.retrieveReview();
    },
  },
};
</script>

<style>
</style>