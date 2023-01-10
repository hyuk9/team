<template>
  <main class="main" id="top">
    <!-- Page content-->
    <!-- <div v-if="currentDiner" class="edit-form"> -->
    <div v-if="currentDiner" class="container mt-5">
      <div class="row">
        <div class="col-lg-8">
          <!-- Post content-->
          <article>
            <!-- Post header-->
            <header class="mb-4">
              <!-- Post title-->
              <h1 class="fw-bolder text-900">
                {{ currentDiner.dname }}
                <i class="bi bi-shop-window"></i>
                <button
                  type="button"
                  class="btn text-danger btn-sm"
                  @click="saveFavorite"
                  v-if="!existFid"
                >
                  <i class="bi bi-heart fs-4"></i>
                </button>
                <button
                  type="button"
                  class="btn text-danger btn-sm"
                  @click="deleteFavorite"
                  v-if="existFid"
                >
                  <i class="bi bi-heart-fill fs-4"></i>
                </button>
                <router-link :to="'/diner/' + currentDiner.dno + '/edit'">
                  <button
                    type="button"
                    class="btn btn-success btn-sm"
                    v-if="confirmAdmin"
                  >
                    수정하기
                  </button>
                </router-link>
                <button
                  type="button"
                  class="btn btn-primary float-right"
                  v-on:click="reservationToggle"
                >
                  예약
                </button>
              </h1>
              <!-- 찜하기 숫자 표시 -->
              <!-- <span class="me-4">{{ fastshow }}</span> -->
              <p class="card-text text-800">
                <i class="fas fa-eye text-dark text-800 me-2 fs-0"></i>
                {{ currentDiner.views }}
                <i class="fas fa-heart text-dark text-800 ms-3 me-2 fs-0"></i>
                {{ fastshow }}
              </p>
            </header>
            <!-- Preview image figure-->
            <figure class="mb-4">
              <!-- <img
                class="img-fluid rounded"
                src="https://dummyimage.com/900x400/ced4da/6c757d.jpg"
                alt="..."
              /> -->
              <div
                id="carouselExampleIndicators"
                class="carousel slide"
                data-bs-ride="carousel"
              >
                <div class="carousel-indicators">
                  <button
                    type="button"
                    data-bs-target="#carouselExampleIndicators"
                    data-bs-slide-to="0"
                    class="active"
                    aria-current="true"
                    aria-label="Slide 1"
                  ></button>
                  <button
                    type="button"
                    data-bs-target="#carouselExampleIndicators"
                    data-bs-slide-to="1"
                    aria-label="Slide 2"
                  ></button>
                  <button
                    type="button"
                    data-bs-target="#carouselExampleIndicators"
                    data-bs-slide-to="2"
                    aria-label="Slide 3"
                  ></button>
                </div>
                <div class="carousel-inner">
                  <div class="carousel-item active">
                    <img
                      :src="currentDiner.photo1"
                      class="d-block w-100 img-fluid"
                      style="width: auto; height: 500px"
                      alt="..."
                    />
                  </div>
                  <div class="carousel-item">
                    <img
                      :src="currentDiner.photo2"
                      class="d-block w-100 img-fluid"
                      style="width: auto; height: 500px"
                      alt="..."
                    />
                  </div>
                  <div class="carousel-item img-fluid">
                    <img
                      :src="currentDiner.photo3"
                      class="d-block w-100 img-fluid"
                      style="width: auto; height: 500px"
                      alt="..."
                    />
                  </div>
                </div>
                <button
                  class="carousel-control-prev"
                  type="button"
                  data-bs-target="#carouselExampleIndicators"
                  data-bs-slide="prev"
                >
                  <span
                    class="carousel-control-prev-icon"
                    aria-hidden="true"
                  ></span>
                  <span class="visually-hidden">Previous</span>
                </button>
                <button
                  class="carousel-control-next"
                  type="button"
                  data-bs-target="#carouselExampleIndicators"
                  data-bs-slide="next"
                >
                  <span
                    class="carousel-control-next-icon"
                    aria-hidden="true"
                  ></span>
                  <span class="visually-hidden">Next</span>
                </button>
              </div>
            </figure>
          </article>
          <!-- 식당정보 시작 -->
          <div class="row">
            <div class="col">
              <div class="card text-dark bg-light border-primary mb-6 mt-5">
                <div class="card-header">
                  <i class="bi bi-shop"></i> 식당정보
                </div>
                <div class="card-body">
                  <h5 class="card-title">메뉴</h5>
                  <p class="card-text">
                    <a
                      class="badge bg-success text-decoration-none link-light"
                      href="#!"
                      >{{ currentDiner.menu }}</a
                    >
                  </p>
                </div>

                <div class="card-body">
                  <h5 class="card-title">테마</h5>
                  <p class="card-text">
                    <a
                      class="badge bg-warning text-decoration-none link-light"
                      href="#!"
                      >{{ currentDiner.theme }}</a
                    >
                  </p>
                </div>

                <div class="card-body">
                  <h5 class="card-title">평점</h5>
                  <p class="card-text">
                    <a
                      class="badge bg-danger text-decoration-none link-light"
                      href="#!"
                      >{{ currentDiner.score }}</a
                    >
                  </p>
                </div>

                <div class="card-body">
                  <h5 class="card-title">주소</h5>
                  <p class="card-text">
                    {{ currentDiner.loc }}
                  </p>
                </div>

                <div class="card-body">
                  <h5 class="card-title">전화번호</h5>
                  <p class="card-text">
                    {{ currentDiner.phone }}
                  </p>
                </div>
              </div>
            </div>
            <div class="col">
              <div class="card text-dark bg-light border-primary mb-6 mt-5">
                <div class="card-header">
                  <i class="bi bi-lamp-fill"></i> 대표메뉴
                </div>
                <!-- 메뉴 리스트 불러와서 v-for문으로 작동 -->
                <div>
                  <div class="card-body">
                    <h5 class="card-title">{{ currentDiner.menu1 }}</h5>
                    <p class="card-text">
                      {{ currentDiner.price1 | currency }}
                    </p>
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">{{ currentDiner.menu2 }}</h5>
                    <p class="card-text">
                      {{ currentDiner.price2 | currency }}
                    </p>
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">{{ currentDiner.menu3 }}</h5>
                    <p class="card-text">
                      {{ currentDiner.price3 | currency }}
                    </p>
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">{{ currentDiner.menu4 }}</h5>
                    <p class="card-text">
                      {{ currentDiner.price4 | currency }}
                    </p>
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">{{ currentDiner.menu5 }}</h5>
                    <p class="card-text">
                      {{ currentDiner.price5 | currency }}
                    </p>
                  </div>
                </div>
                <!--v-for 끝-->
              </div>
            </div>
          </div>

          <!--식당정보 끝-->

          <div class="my-3 row justify-content-around col">
            <h2>
              리뷰
              <i class="bi bi-chat-dots"></i>
            </h2>
            <button
              type="button"
              class="btn btn-lg btn-success output col-5"
              @click="needToLogin"
            >
              <!-- <router-link :to="'/add/review/' + currentDiner.dno"> -->
              <i class="bi bi-pencil"></i>
              리뷰 쓰기
              <!-- </router-link> -->
            </button>
          </div>

          <!-- Comments section-->
          <div
            class="card mb-4 border-success"
            id="card1"
            v-for="(data, index) in review"
            :key="index"
          >
            <div class="row d-flex mt-1">
              <div>
                <!-- FIXME:고쳐야하는데 이유는 아직 모름 -->
                <!-- <router-link :to="'/edit/review/' + data.rno" v-if="showDetailBoard"> -->
                <router-link
                  :to="'/edit/review/' + data.rno"
                  v-if="showDetailBoard(data)"
                >
                  <span class="badge bg-success float-right">수정하기</span>
                </router-link>
              </div>
              <div class="row">
                <div class="col">
                  <!-- TODO: 프로필 사진 넣을 예정 -->

                  <div class="d-flex flex-column">
                    <h5 class="mt-2 mb-0">{{ data.writer }}</h5>
                    <h5>
                      <span class="fa fa-star star-active ml-3"></span>
                      <span class="badge bg-primary"
                        >맛 : {{ data.taste }}점</span
                      >
                      <span class="fa fa-star star-active ml-3"></span>
                      <span class="badge bg-success"
                        >서비스 : {{ data.service }}점</span
                      >
                      <span class="fa fa-star star-active ml-3"></span>
                      <span class="badge bg-danger"
                        >접근성 : {{ data.loc }}점</span
                      >
                      <span class="fa fa-star star-active ml-3"></span>
                      <span class="badge bg-warning text-dark"
                        >분위기 : {{ data.mood }}점</span
                      >
                      <span class="fa fa-star star-active ml-3"></span>
                      <span class="badge bg-dark"
                        >가성비 : {{ data.cost }}점</span
                      >
                    </h5>
                  </div>
                </div>
              </div>
            </div>
            <div class="col mt-2">
              <p class="content">
                {{ data.content }}
              </p>
              <div>
                <p class="text-muted pt-5 pt-sm-3 float-right">
                  <!-- FIXME: 일단 이렇게 문자열 자르기를 사용했는데 더 좋은 방법이 있으면 써야할듯? -->
                  {{ data.insertTime.substring(0, 16) }}
                </p>
              </div>
            </div>
            <!-- <div class="row text-left">
              <img class="pic" :src="data.rphoto" />
              <img class="pic" src="https://i.imgur.com/SjBwAgs.jpg" />
              <img class="pic" src="https://i.imgur.com/IgHpsBh.jpg" />
            </div> -->
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

        <!-- Side widgets Map&Chart 시작 -->
        <div class="col-lg-4" v-if="mapNchart">
          <!-- Map widget-->
          <div class="card mb-4">
            <div class="card-header">
              <i class="bi bi-geo-alt-fill"></i> 지도
            </div>
            <div class="card-body" style="height: 600px">
              <MakerDetail />
            </div>
          </div>

          <!-- Chart widget-->
          <div class="card mb-4">
            <div class="card-header">
              <i class="bi bi-bar-chart-line-fill"></i> Chart
            </div>
            <div class="card-body">
              <Canvas />
            </div>
          </div>
        </div>
        <!-- Side widgets Map&Chart 끝 -->

        <!-- Side widgets 예약하기 시작 -->
        <div class="col-lg-4" v-if="showReservation">
          <AddReservation />
        </div>
        <!-- Side widgets 예약하기 끝 -->
      </div>
    </div>
  </main>
</template>

<script>
/* eslint-disable */
import DinerDataService from "@/services/DinerDataService";
import ReviewDataService from "@/services/ReviewDataService";
import DinerCommentVue from "./DinerComment.vue";
import AddReservation from "@/components/reservation/AddReservation.vue";
import FavoriteDataService from "@/services/FavoriteDataService";
import MenuDataService from "@/services/MenuDataService"; // 메뉴 리스트를 불러오기 위한 서비스 임포트
import MakerDetail from "@/components/food/detail/MakerDetail.vue";
import Canvas from "@/components/food/detail/CanvasView.vue";
import LastviewDataService from "@/services/LastviewDataService";
import User from "@/model/user";

export default {
  data() {
    return {
      menu: [],
      review: [],
      diner: [],
      score: [],
      currentReview: null,
      currentIndex: -1,

      currentDiner: null,
      currentMenu: null,
      currentScore: null,

      mapNchart: true,
      showReservation: false,

      // empty: true,
      // fill: false,

      favorite: {
        fid: null,
        dno: null,
        id: null,
      },

      lastview: {
        lid: null,
        dno: null,
        id: null,
      },

      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 4, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      // favorite 정보 저장용
      totalfavorite: null,
      // 찜하기 버튼에 따라 즉시 반응하기 위한 함수
      fastshow: 0,
    };
  },
  filters: {
    currency: function (value) {
      var num = new Number(value);
      return num.toFixed(0).replace(/(\d)(?=(\d{3})+(?:\.\d+)?$)/g, "$1,");
    },
  },
  components: {
    DinerCommentVue, // 식당 리뷰
    AddReservation, // 예약 추가
    MakerDetail, // 지도
    Canvas, // 차트
  },
  methods: {
    // TODO: 찜한가게 조회하는 함수
    retrieveFavorite() {
      // getAll() ->(변경) getAll(dname, page, size)
      FavoriteDataService.get(this.currentUser.id, this.$route.params.dno)
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          this.favorite = response.data; // 스프링부트에서 전송한 데이터
          // 디버깅 콘솔에 정보 출력
          console.log("찜한가게 데이터 조회 성공 : ", response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log("찜한가게 조회 에러 : ", e);
        });
    },
    // TODO: 음식점 데이터 조회하는 함수
    getDiner(dno) {
      // axios 공통함수 호출
      DinerDataService.get(dno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentDiner = response.data;
          // 콘솔 로그 출력
          console.log("현재 음식점 조회 성공 : ", response.data);

          FavoriteDataService.getFavorite(dno)
            // 성공하면 .then() 결과가 전송됨
            .then((response) => {
              // let(const) { 속성명1, 속성명2 } = 데이터 객체배열 (모던자바문법 구조 분해 할당)
              this.totalfavorite = response.data; // 스프링부트에서 전송한 데이터 받고 조회수 내림차순으로 가공
              // 디버깅 콘솔에 정보 출력
              console.log("찜한가게 조회 성공 : ", response.data);
              // favorite dno_count 를 diner dno_count에 복사
              this.currentDiner.dno_count = this.totalfavorite.dno_count;
              this.fastshow = this.currentDiner.dno_count;
            })
            // 실패하면 .catch() 에 에러가 전송됨
            .catch((e) => {
              console.log("찜한가게 조회 실패 : ", e);
            });
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log("현재 음식점 조회 실패 : ", e);
        });
    },
    // TODO: dno로 메뉴 조회요청하는 함수
    getMenu(dno) {
      // axios 공통함수 호출
      MenuDataService.get(dno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.menu = response.data;
          // 콘솔 로그 출력
          console.log("현재 메뉴 데이터 : ", response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },
    // Todo : dno로 리뷰 조회요청하는 함수
    // getReview(dno) {
    //   // axios 공통함수 호출
    //   ReviewDataService.get(dno)
    //     // 성공하면 .then() 결과가 리턴됨
    //     .then((response) => {
    //       // springboot 결과를 리턴함(부서 객체)
    //       this.review = response.data;
    //       // 콘솔 로그 출력
    //       console.log("현재 리뷰 데이터 : ", response.data);

    //       this.getScore();
    //     })
    //     // 실패하면 .catch() 에러메세지가 리턴됨
    //     .catch((e) => {
    //       console.log(e);
    //     });
    // },
    // TODO: 댓글 정보를 조회요청하는 함수
    getReview(dno) {
      ReviewDataService.getReviewByDno(dno, this.page - 1, this.pageSize)
        .then((response) => {
          // springboot 결과를 리턴함(질문 객체)
          const { review, totalItems } = response.data; // springboot 의 전송한 맵 정보
          this.review = review; // 스프링부트에서 전송한 데이터
          this.count = totalItems;
          // 콘솔 로그 출력
          console.log("리뷰 정보 조회 성공 : ", response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log("리뷰 정보 조회 실패 : ", e);
        });
    },
    handlePageChange(value) {
      this.page = value;
      this.getReview(this.$route.params.dno);
    },
    handlePageSizeChange(event) {
      this.pageSize = event.target.value;
      this.page = 1;
      this.getReview(this.$route.params.dno);
    },
    setActive(data, index) {
      console.log(data);
      this.currentData = data;
      this.currentIndex = index;
    },
    // TODO: 음식점 정보 수정요청하는 함수
    updateDiner() {
      // axios 공통함수 호출
      DinerDataService.update(this.currentDiner.dno, this.currentDiner)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log("음식점 정보 수정 성공 : ", response.data);
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log("음식점 정보 수정 실패 : ", e);
        });
    },
    // TODO: 음식점 정보 삭제요청하는 함수
    deleteDiner() {
      // axios 공통함수 호출
      DinerDataService.delete(this.currentDiner.dno)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log("음식점 정보 삭제 성공 : ", response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /diner
          this.$router.push("/diner");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log("음식점 정보 삭제 실패 : ", e);
        });
    },
    // TODO: 로그인이 필요한 항목에 대한 확인함수
    needToLogin() {
      if (this.currentUser.id == null) {
        this.$swal({
          icon: "error",
          title: "로그인이 필요한 서비스입니다",
          text: "로그인하시면 다양한 맞춤형 서비스를 이용할 수 있습니다",
          confirmButtonColor: "#E1793D",
          confirmButtonText: "확인",
        });
      } else {
        this.$router.push("/add/review/" + this.currentDiner.dno);
      }
    },

    // Todo : 카카오 지도 관련 함수들 시작 ==================
    onLoad(vue) {
      this.map = vue;
    },
    onWindowLoad(that) {},
    onMarkerClicked(event) {
      this.info = !this.info;
    },
    onMarkerLoaded(vue) {
      this.marker = vue.marker.set;
    },
    // Todo : 카카오 지도 관련 함수들 끝 ==================

    // Todo : 버튼 클릭시 지도 데이터와 예약하기 컴포넌트를 교체하는 함수
    reservationToggle() {
      this.mapNchart = !this.mapNchart;
      // mapNchart == false 이면 예약폼을 보여주고
      // mapNchart == true 이면 지도와 차트 보여주기
      if (this.mapNchart == false) {
        // 이미지 보여주기 : showReservation = true
        this.showReservation = true;
      } else {
        // 이미지 안보여주기
        this.showReservation = false;
      }
    },
    // Todo : 찜한가게 저장요청하는 함수
    saveFavorite() {
      if (this.currentUser.id != null) {
        let data = {
          // fid는 자동생성
          dno: this.currentDiner.dno,
          id: this.currentUser.id,
        };
        // insert 요청 함수 호출(axios 공통함수 호출)
        FavoriteDataService.create(data)
          // 성공하면 then() 결과가 전송됨
          .then((response) => {
            // this.favorite.fid = response.data.fid; --> 이거 처음에 이렇게 썼다가 오류났음. 이렇게 쓰면 안됨
            this.favorite = response.data;
            // 콘솔 로그 출력(response.data)
            console.log("찜한가게 저장 성공 : ", this.favorite);
            // 찜하기 숫자 변화
            this.fastshow++;
          })
          // 실패하면 .catch() 결과가 전송됨
          .catch((e) => {
            console.log("찜한가게 저장 실패 : ", e);
          });
      } else {
        this.$swal({
          icon: "error",
          title: "로그인이 필요한 서비스입니다",
          text: "로그인하시면 다양한 맞춤형 서비스를 이용할 수 있습니다",
          confirmButtonColor: "#E1793D",
          confirmButtonText: "확인",
        });
      }
    },

    // TODO: 찜한가게 삭제요청하는 함수
    deleteFavorite() {
      // axios 공통함수 호출
      FavoriteDataService.delete(this.favorite.fid)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log("찜한가게 삭제 성공 : ", response.data);
          this.retrieveFavorite();
          // 찜하기 숫자 변화
          this.fastshow--;
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log("찜한가게 삭제 실패 : ", e);
        });
    },

    // TODO: 최근본음식점 데이터 조회 요청하는 함수
    retrieveLastview() {
      if (this.currentUser.id != null) {
        LastviewDataService.get(this.currentUser.id, this.$route.params.dno)
          // 성공하면 .then() 결과가 전송됨
          .then((response) => {
            this.lastview = response.data; // 스프링부트에서 전송한 데이터
            // 디버깅 콘솔에 정보 출력
            console.log("최근본 가게 조회 성공 : ", response.data);
            // 현재 음식점이 최근본가게 테이블에 있으면
            if (this.lastview.lid != null) {
              // 최근본가게 테이블에서 삭제요청
              LastviewDataService.delete(this.lastview.lid)
                // 성공하면 then() 결과가 전송됨
                .then((response) => {
                  console.log(
                    "최근본가게 데이터에서 현재 음식점 정보 삭제 성공(중복제거)",
                    response.data
                  );
                  // 최근본가게 테이블에 새로 저장
                  this.saveLastview();
                })
                // 실패하면 .catch() 에러메세지가 전송됨
                .catch((e) => {
                  console.log(
                    "최근본가게 데이터에서 현재 음식점 정보 삭제 실패",
                    e
                  );
                });
            } else {
              // 현재 음식점이 최근본가게 테이블에 없으면 저장
              this.saveLastview();
            }
          })
          // 실패하면 .catch() 에 에러가 전송됨
          .catch((e) => {
            console.log("최근본가게 조회 실패 : ", e);
          });
      }
    },

    // TODO: 최근본가게 테이블에 저장요청하는 함수
    saveLastview() {
      let data = {
        // fid(pk)는 자동생성
        dno: this.$route.params.dno,
        id: this.currentUser.id,
      };
      // insert 요청 함수 호출(axios 공통함수 호출)
      LastviewDataService.create(data)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          // this.favorite.fid = response.data.fid; --> 이거 처음에 이렇게 썼다가 오류났음. 이렇게 쓰면 안됨
          this.lastview = response.data;
          console.log("최근본가게 저장 성공 : ", this.lastview);
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((e) => {
          console.log("최근본가게 저장 실패 : ", e);
        });
    },
    // TODO: 관리자거나 작성자라면 리뷰 수정하기 버튼 보이게하는 함수
    showDetailBoard(data) {
      if (this.currentUser.roles) {
        if (
          this.currentUser.roles.includes("ROLE_ADMIN") ||
          this.currentUser.id == data.id
        ) {
          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }
    },
  },

  // 화면이 뜨자 마자 실행되는 이벤트
  mounted() {
    this.retrieveLastview();

    // this.$route.params.dno : 이전페이지에서 전송한 매개변수는 $route.params 안에 있음
    // $route 객체 : 주로 url 매개변수 정보들이 있음
    // router/index.js 상세페이지 url의 매개변수명 : :dno
    this.getDiner(this.$route.params.dno);
    this.getReview(this.$route.params.dno);
    this.retrieveFavorite(); // 화면 로딩시 fid해당하는 조회함수 실행
  },

  computed: {
    // TODO: 로컬 스토리지에 저장된 현재 유저 정보 가져오는 함수
    currentUser() {
      // 만약 로컬스토리지에 유저객체가 없으면 빈유저 생성
      if (this.$store.state.auth.user == undefined) {
        let notLoggedUser = new User();
        return notLoggedUser;
      } else {
        // 모듈 저장소 : this.$store.state.모듈명.state값
        // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
        return this.$store.state.auth.user;
      }
    },

    // TODO: 관리자 접속인지 아닌지 확인하는 함수
    confirmAdmin() {
      if (this.currentUser && this.currentUser.roles) {
        // if ROLE_ADMIN 있으면 true
        //               없으면 false
        return this.currentUser.roles.includes("ROLE_ADMIN");
      }
      // currentUser 없으면 false (메뉴가 안보임)
      return false;
    },

    // TODO: 찜한가게 테이블에 데이터 존재 여부 확인하는 함수
    existFid() {
      if (this.favorite.fid != null) {
        // 데이터가 있으면
        return true;
      } else {
        // 데이터가 없으면
        return false;
      }
    },
  },
};
</script>
<style>
#card1 {
  border-radius: 5px;
  background-color: #fff;
  padding-left: 50px;
  padding-right: 30px;
  margin-top: 30px;
  padding-top: 10px;
  padding-bottom: 10px;
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

.rating-bar {
  width: 300px;
  padding: 8px;
  border-radius: 5px;
}

.bar-container {
  width: 100%;
  background-color: #f1f1f1;
  text-align: center;
  color: white;
  border-radius: 20px;
  cursor: pointer;
  margin-bottom: 5px;
}

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
  width: 60px;
  height: 60px;
  border-radius: 100%;
  margin-right: 30px;
  margin-top: 10px;
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
