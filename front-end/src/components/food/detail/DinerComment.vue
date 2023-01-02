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
              <a href="#">{{ total_comments }} Comments</a>
            </li>
          </ul>
        </div>
      </div>
      <div>
        <div class="row">
          <!-- form -->
          <form class="col-sm-12 col-sm-offset-4" v-on:submit.prevent="submit">
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
              <div v-if="submittedReviews.length === 0">
                <div class="alert alert-info">남겨진 리뷰가 없습니다.</div>
              </div>
              <ul v-else class="mb-0 pl-3">
                <li
                  :class="{ active: index == currentIndex }"
                  v-for="(data, index) in review"
                  :key="index"
                  @click="setActiveReview(data, index)"
                >
                  {{ data.rwriter }}
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
            >
              <form ref="form" @submit.stop.prevent="handleSubmit">
                <b-form-group
                  label="작성자"
                  label-for="name-input"
                  invalid-feedback="Name is required"
                  :state="nameState"
                >
                  <b-form-input
                    id="name-input"
                    v-model="rwriter"
                    :state="nameState"
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
                    v-model="rating"
                    show-value
                    required
                  ></b-form-rating>
                </b-form-group>

                <b-form-group
                  label="내용"
                  label-for="content-input"
                  invalid-feedback="Content is required"
                  :state="contentState"
                >
                  <b-form-input
                    id="content-input"
                    v-model="content"
                    :state="contentState"
                    required
                  ></b-form-input>
                </b-form-group>

                <b-form-group
                  label="사진"
                  label-for="photo-input"
                  :state="photoState"
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
      // name: "",
      // content: "",
      // rating: null,
      // photo: "",
      // nameState: null,
      // ratingState: null,
      // contentState: null,
      // photoState: null,
      review: [],
      currentReview: null,
      currentIndex: -1,
      searchDno: "",
      submittedReviews: [],

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
      ReviewDataService.getAll(this.searchDno, this.page - 1, this.pageSize)
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
      this.nameState = valid;
      this.ratingState = valid;
      this.contentState = valid;
      return valid;
    },
    resetModal() {
      this.name = "";
      this.nameState = null;
      this.rating = "";
      this.ratingState = null;
      this.content = "";
      this.contentState = null;
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
      this.submittedReviews.push(this.review);
      // Hide the modal manually
      this.$nextTick(() => {
        this.$bvModal.hide("modal-prevent-closing");
      });
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