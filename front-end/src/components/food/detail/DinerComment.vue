<template>
  <div class="container-fluid px-1 py-5 mx-auto">
    <div class="row justify-content-center">
      <div class="col-xl-12 col-lg-12 col-md-12 col-12 text-center mb-5">
        <div class="card">
          <div class="row justify-content-left d-flex">
            <div class="col-md-4 d-flex flex-column">
              <div class="rating-box">
                <h1 class="pt-4">4.0</h1>
                <p class="">out of 5</p>
              </div>
              <div>
                <span class="fa fa-star star-active mx-1"></span>
                <span class="fa fa-star star-active mx-1"></span>
                <span class="fa fa-star star-active mx-1"></span>
                <span class="fa fa-star star-active mx-1"></span>
                <span class="fa fa-star star-inactive mx-1"></span>
              </div>
            </div>
            <div class="col-md-8">
              <div class="rating-bar0 justify-content-center">
                <table class="text-left mx-auto">
                  <tr>
                    <td class="rating-label">최고</td>
                    <td class="rating-bar">
                      <div class="bar-container">
                        <div class="bar-5"></div>
                      </div>
                    </td>
                    <td class="text-right">123</td>
                  </tr>
                  <tr>
                    <td class="rating-label">만족해요</td>
                    <td class="rating-bar">
                      <div class="bar-container">
                        <div class="bar-4"></div>
                      </div>
                    </td>
                    <td class="text-right">23</td>
                  </tr>
                  <tr>
                    <td class="rating-label">그냥저냥</td>
                    <td class="rating-bar">
                      <div class="bar-container">
                        <div class="bar-3"></div>
                      </div>
                    </td>
                    <td class="text-right">10</td>
                  </tr>
                  <tr>
                    <td class="rating-label">안갈래요</td>
                    <td class="rating-bar">
                      <div class="bar-container">
                        <div class="bar-2"></div>
                      </div>
                    </td>
                    <td class="text-right">3</td>
                  </tr>
                  <tr>
                    <td class="rating-label">최악</td>
                    <td class="rating-bar">
                      <div class="bar-container">
                        <div class="bar-1"></div>
                      </div>
                    </td>
                    <td class="text-right">0</td>
                  </tr>
                </table>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div
            class="card"
            :class="{ active: index == currentIndex }"
            v-for="(data, index) in review"
            :key="index"
            @click="setActiveDiner(data, index)"
          >
            <div class="row d-flex">
              <div>
                <img
                  class="profile-pic"
                  src="https://i.imgur.com/V3ICjlm.jpg"
                />
              </div>
              <div class="d-flex flex-column">
                <h3 class="mt-2 mb-0">{{ data.reviewWriter }}</h3>
                <div>
                  <p class="text-center">
                    <span class="text-muted">{{ data.reviewRating }}</span>
                    <span class="fa fa-star star-active ml-3"></span>
                    <span class="fa fa-star star-active"></span>
                    <span class="fa fa-star star-active"></span>
                    <span class="fa fa-star star-active"></span>
                    <span class="fa fa-star star-inactive"></span>
                  </p>
                </div>
              </div>
              <div class="ml-auto">
                <p class="text-muted pt-5 pt-sm-3">10 Sept</p>
              </div>
            </div>
            <div class="row text-left">
              <p class="content">
                {{ data.content }}
              </p>
            </div>
            <div class="row text-left">
              <img class="pic" src="https://i.imgur.com/kjcZcfv.jpg" />
              <img class="pic" src="https://i.imgur.com/SjBwAgs.jpg" />
              <img class="pic" src="https://i.imgur.com/IgHpsBh.jpg" />
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
  </div>
</template>

<script>
import ReviewDataService from "@/services/ReviewDataService";

export default {
  // 변수 정의하는 곳 : data(), 초기화
  data() {
    return {
      review: [],
      currentReview: null,
      currentIndex: -1,
      // dname: "", ->(변경) searchDname: "",
      reviewWriter: "",

      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 3, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      pageSizes: [3, 6, 9], // select box에 넣을 기본 데이터
    };
  },
  // 함수 정의하는 곳 : methods:
  methods: {
    // axios , 모든 부서 정보 조회 요청 함수
    retrieveReview() {
      // getAll() ->(변경) getAll(dname, page, size)
      ReviewDataService.getAll(this.reviewWriter, this.page - 1, this.pageSize)
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          // this.review = response.data -> (변경) const { review, totalItems } = response.data
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
    // select box 값 변경시 실행되는 함수(재조회)
    handlePageSizeChange(event) {
      this.pageSize = event.target.value; // 한페이지당 개수 저장(3, 6, 9)
      this.page = 1;
      // 재조회 함수 호출
      this.retrieveReview();
    },
    // 페이지 번호 변경시 실행되는 함수(재조회)
    handlePageChange(value) {
      this.page = value; // 매개변수값으로 현재페이지 변경
      // 재조회 함수 호출
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
          // currentReview, currentIndex 초기화
          this.currentReview = null;
          this.currentIndex = -1;
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 수정 요청하는 함수
    updateReview() {
      // axios 공통함수 호출
      ReviewDataService.update(this.currentReview.reviewId, this.currentReview)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.message = "The review was updated successfully!";
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 삭제 요청하는 함수
    deleteReview() {
      // axios 공통함수 호출
      ReviewDataService.delete(this.currentReview.reviewId)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /local
          this.$router.push("/diner");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
  },
  // 화면이 뜨자마자 실행되는 이벤트(라이프 사이클 함수) : mounted(), created()
  mounted() {
    this.retrieveReview(); // 화면 로딩시 전체 조회함수 실행
  },
};
</script>

<style>
body {
  background-image: linear-gradient(#4a148c, #e53935);
  background-repeat: no-repeat;
  color: #000;
  overflow-x: hidden;
}

a {
  text-decoration: none !important;
  color: inherit;
}

a:hover {
  color: #455a64;
}

.card {
  border-radius: 5px;
  background-color: #fff;
  padding-left: 30px;
  padding-right: 30px;
  margin-top: 30px;
  padding-top: 30px;
  padding-bottom: 30px;
}

.rating-box {
  width: 130px;
  height: 130px;
  margin-right: auto;
  margin-left: auto;
  background-color: #fbc02d;
  color: #fff;
}

.rating-label {
  font-weight: bold;
}

/* Rating bar width */
.rating-bar {
  width: 300px;
  padding: 8px;
  border-radius: 5px;
}

/* The bar container */
.bar-container {
  width: 100%;
  background-color: #f1f1f1;
  text-align: center;
  color: white;
  border-radius: 20px;
  cursor: pointer;
  margin-bottom: 5px;
}

/* Individual bars */
.bar-5 {
  width: 70%;
  height: 13px;
  background-color: #fbc02d;
  border-radius: 20px;
}
.bar-4 {
  width: 30%;
  height: 13px;
  background-color: #fbc02d;
  border-radius: 20px;
}
.bar-3 {
  width: 20%;
  height: 13px;
  background-color: #fbc02d;
  border-radius: 20px;
}
.bar-2 {
  width: 10%;
  height: 13px;
  background-color: #fbc02d;
  border-radius: 20px;
}
.bar-1 {
  width: 0%;
  height: 13px;
  background-color: #fbc02d;
  border-radius: 20px;
}

td {
  padding-bottom: 10px;
}

.star-active {
  color: #fbc02d;
  margin-top: 10px;
  margin-bottom: 10px;
}

.star-active:hover {
  color: #f9a825;
  cursor: pointer;
}

.star-inactive {
  color: #cfd8dc;
  margin-top: 10px;
  margin-bottom: 10px;
}

.blue-text {
  color: #0091ea;
}

.content {
  font-size: 18px;
}

.profile-pic {
  width: 90px;
  height: 90px;
  border-radius: 100%;
  margin-right: 30px;
}

.pic {
  width: 80px;
  height: 80px;
  margin-right: 10px;
}

.vote {
  cursor: pointer;
}
</style>