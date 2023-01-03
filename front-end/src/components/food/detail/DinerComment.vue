<template>
  <div>
    <div id="comment_app" class="container">
      <div class="navbar navbar-default">
        <div class="navbar-header">
          <a class="navbar-brand"></a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="navbar-right navbar-nav nav">
            <li>
              <!-- <a href="#">{{ total_comments }} Comments</a> -->
            </li>
          </ul>
        </div>
      </div>
      <div>
        <div class="row">
          <!-- form -->
          <form class="col-sm-12 col-sm-offset-4">
            <h3>review</h3>
            <!-- <div class="form-group mt-3">
              <h6>평점을 입력해주세요</h6>
              <star-rating v-model="rating"></star-rating>
              <textarea
                required="required"
                placeholder="리뷰를 남겨주세요!"
                v-model="input"
                class="form-control"
              ></textarea>
            </div>
            <button class="btn btn-success float-right">작성하기</button>
            <br />
            <br />
            <legend></legend> -->
          </form>

          <!-- form -->
          <div class="cols-m-12">
            <div class="col-sm-12 col-sm-offset-4">
              <div v-if="review.length === 0">
                <div class="alert alert-info">남겨진 리뷰가 없습니다.</div>
              </div>
              <ul v-else class="mb-0 pl-3">
                <li
                  :class="{ active: index == currentIndex }"
                  v-for="(data, index) in review"
                  :key="index"
                  @click="setActiveReview(data, index)"
                >
                  {{ data }}
                  <!-- {{ data.rwriter }}
                  {{ data.rating }}
                  {{ data.rphoto }}
                  {{ data.rcontent }} -->
                </li>
              </ul>

              <!-- <div class="list-group">
                <div
                  class="list-group-item"
                  v-for="(comment, index) in comments"
                  :key="index"
                >
                  <p><strong>review: </strong> {{ comment.comment }}</p>
                  <p>
                    <strong>평점:</strong>
                    {{ comment.rating }}
                  </p>
                  <h5>댓글</h5>
                  <div class="list-group">
                    <div
                      class="list-group-item"
                      v-for="(reply, index) in comment.replies"
                      :key="index"
                    >
                      <p><strong>reply:</strong> {{ reply.reply }}</p>
                    </div>
                    <div class="list-group-item" style="padding: 00">
                      <form v-on:submit.prevent="addReply(index)">
                        <input
                          v-model="reply"
                          placeholder="reply"
                          class="form-control"
                        />
                      </form>
                    </div>
                  </div>
                </div>
              </div> -->
            </div>
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
                      <b-badge
                        v-if="names.length > 1"
                        variant="dark"
                        class="ml-1"
                      >
                        + {{ names.length - 1 }} More files
                      </b-badge>
                    </template>
                  </b-form-file>
                </b-form-group>
              </form>
            </b-modal>
          </div>
          <!-- Pagination-->
          <nav aria-label="Pagination mb-4">
            <hr class="my-0" />
            <ul class="pagination justify-content-center my-4">
              <b-pagination
                v-model="page"
                :total-rows="count"
                :per-page="pageSize"
                first-text="<<"
                last-text=">>"
                prev-text="Prev"
                next-text="Next"
                @change="handlePageChange"
              ></b-pagination>
            </ul>
          </nav>
        </div>
      </div>
    </div>
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

      currentReview: null,
      currentIndex: -1,
      searchRwriter: "",

      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 5, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      pageSizes: [3, 6, 9], // select box에 넣을 기본 데이터
    };
  },
  methods: {
    // axios , 모든 부서 정보 조회 요청 함수
    retrieveReview() {
      // getAll() ->(변경) getAll(dname, page, size)
      ReviewDataService.getAll(this.searchRwriter, this.page - 1, this.pageSize)
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          // this.emp = response.data -> (변경) const { emp, totalItems } = response.data
          // let(const) { 속성명1, 속성명2 } = 데이터 객체배열 (모던자바문법 구조분해할당)
          const { review, totalItems } = response.data; // springboot 의 전송한 맵 정보
          this.review = review; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // dno로 리뷰 요청하는 함수
    getReview(dno) {
      // axios 공통함수 호출
      ReviewDataService.get(dno)
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
    handlePageSizeChange(event) {
      this.pageSize = event.target.value; // 한페이지당 개수 저장(3, 6, 9)
      this.page = 1;
      // 재조회함수 호출
      this.retrieveReview();
    },
    // 페이지 번호 변경시 실행되는 함수(재조회)
    handlePageChange(value) {
      this.page = value; // 매개변수값으로 현재페이지 변경
      // 재조회함수 호출
      this.retrieveReview();
    },
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
      this.getReview(this.$route.params.dno);
      // 화면 로딩시 전체 조회함수 실행
      this.retrieveReview();
    },
  },
};
</script>

<style>
.navbar {
  border-radius: 0;
}
.navbar-header {
  float: none;
  width: 200px;
  margin: auto;
  position: absolute;
  left: 0;
  right: 0;
  text-align: center;
  height: 50px;
}
.navbar-brand {
  float: none;
  line-height: 50px;
}
</style>