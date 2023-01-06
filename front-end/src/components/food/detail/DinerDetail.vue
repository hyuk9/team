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
              <h1 class="fw-bolder mb-1">
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
                    v-if="showAdminBoard"
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
                      src="https://dummyimage.com/900x400/ced4da/6c757d.jpg"
                      class="d-block w-100"
                      alt="..."
                    />
                  </div>
                  <div class="carousel-item">
                    <img
                      src="https://dummyimage.com/900x400/ced4da/6c757d.jpg"
                      class="d-block w-100"
                      alt="..."
                    />
                  </div>
                  <div class="carousel-item">
                    <img
                      src="https://dummyimage.com/900x400/ced4da/6c757d.jpg"
                      class="d-block w-100"
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
                <div class="card-header"><i class="bi bi-shop"></i> 식당정보</div>
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
                <div class="card-header"><i class="bi bi-lamp-fill"></i> 메뉴판</div>
                <!-- 메뉴 리스트 불러와서 v-for문으로 작동 -->
                <div
                  class="card-body"
                  v-for="(data, index) in menu"
                  :key="index"
                >
                  <h5 class="card-title">{{ data.menuName }}</h5>
                  <p class="card-text">
                    {{ data.menuPrice }}
                  </p>
                </div>
                <!--v-for 끝-->
              </div>
            </div>
          </div>

          <!--식당정보 끝-->
          <button
              class="btn btn-warning float-right mb-5 text-white"
            >
              <router-link to="/add/menu">목록 추가</router-link>
            </button>

          <b-button
            type="button"
            v-b-modal.modal-prevent-closing
            >리뷰 쓰기</b-button
          >
          <DinerCommentVue />
          <!-- Comments section-->
          <div
            class="card mb-6 border-info"
            id="card1"
            v-for="(data, index) in review"
            :key="index"
          >
            <div class="row d-flex">
              <div class="">
                <img
                  class="profile-pic"
                  src="https://i.imgur.com/V3ICjlm.jpg"
                />
              </div>
              <div class="d-flex flex-column">
                <h5 class="ms-3 mt-2 mb-0">{{ data.rwriter }}</h5>
                <div>
                  <p class="text-left">
                    <span class="fa fa-star star-active ml-3"></span>
                    <span>{{ data.rating }}점</span>
                  </p>
                </div>
              </div>
              <div class="ml-auto">
                <p class="text-muted pt-5 pt-sm-3">{{ data.insertTime }}</p>
              </div>
            </div>
            <div class="row text-left">
              <p class="content">
                {{ data.rcontent }}
              </p>
            </div>
            <div class="row text-left">
              <img class="pic" src="https://i.imgur.com/kjcZcfv.jpg" />
              <img class="pic" src="https://i.imgur.com/SjBwAgs.jpg" />
              <img class="pic" src="https://i.imgur.com/IgHpsBh.jpg" />
            </div>
          </div>
        </div>

        <!-- Side widgets Map&Chart 시작 -->
        <div class="col-lg-4" v-if="mapNchart">
          <!-- Map widget-->
          <div class="card mb-4">
            <div class="card-header"><i class="bi bi-geo-alt-fill"></i> 지도</div>
            <div class="card-body" style="height: 600px">
              <MakerDetail />
            </div>
          </div>

          <!-- Chart widget-->
          <div class="card mb-4">
            <div class="card-header">Chart</div>
            <div class="card-body">
              <div id="chart" style="height: 450px"></div>
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
    <!-- <div id="chart" class="col-lg-4 bg bg-info">
      <h1>차트 위치 지정해줘야함 - 내부 div로 넣으면 안되는 문제 있음</h1>
      <canvas id="myChart"></canvas>
    </div> -->
  </main>
</template>

<script>
import Chart from "chart.js/auto";

/* eslint-disable */

import DinerDataService from "@/services/DinerDataService";
import ReviewDataService from "@/services/ReviewDataService";
import DinerCommentVue from "./DinerComment.vue";
import AddReservation from "@/components/reservation/AddReservation.vue";
import FavoriteDataService from "@/services/FavoriteDataService";
import MenuDataService from "@/services/MenuDataService"; // 메뉴 리스트를 불러오기 위한 서비스 임포트
import MakerDetail from "@/components/food/detail/MakerDetail.vue";

export default {
  data() {
    return {
      menu: [], // 메뉴 리스트 불러오기 위한 배열
      review: [],
      diner: [],
      currentReview: null,
      currentIndex: -1,
      // dname: "", ->(변경) searchDname: "",
      searchRwriter: "",

      currentDiner: null,
      currentMenu: null,
      message: "",

      mapNchart: true,
      showReservation: false,

      // empty: true,
      // fill: false,

      favorite: {
        fid: null,
        dno: null,
        id: null,
      },

      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 8, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      pageSizes: [3, 6, 9], // select box에 넣을 기본 데이터

      name: "HelloWorld",
      width: 500,
      height: 600,
      info: false,
      marker: null,
      count: 1,
      map: null,
      isCTT: false,
      mapOptions: {
        lat: 35.1525133,
        lng: 129.059547,
        zoom: 15,
        zoomControl: true,
        zoomControlOptions: { position: "TOP_RIGHT" },
        mapTypeControl: true,
      },
      initLayers: [
        "BACKGROUND",
        "BACKGROUND_DETAIL",
        "POI_KOREAN",
        "TRANSIT",
        "ENGLISH",
        "CHINESE",
        "JAPANESE",
      ],

      chartData: {
        labels: ["맛", "친절도", "거리", "청결도"],
        datasets: [
          {
            label: "여성",
            data: [65, 59, 90, 81],
            fill: true,
            backgroundColor: "rgba(255, 99, 132, 0.2)",
            borderColor: "rgb(255, 99, 132)",
            pointBackgroundColor: "rgb(255, 99, 132)",
            pointBorderColor: "#fff",
            pointHoverBackgroundColor: "#fff",
            pointHoverBorderColor: "rgb(255, 99, 132)",
          },
          {
            label: "남성",
            data: [48, 68, 70, 98],
            fill: true,
            backgroundColor: "rgba(54, 162, 235, 0.2)",
            borderColor: "rgb(54, 162, 235)",
            pointBackgroundColor: "rgb(54, 162, 235)",
            pointBorderColor: "#fff",
            pointHoverBackgroundColor: "#fff",
            pointHoverBorderColor: "rgb(54, 162, 235)",
          },
        ],
      },
    };
  },
  components: {
    DinerCommentVue,
    AddReservation,
    MakerDetail,
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
          console.log("현재 리뷰데이터 : ", e);
        });
    },
    // axios , 모든 부서 정보 조회 요청 함수
    retrieveFavorite() {
      // getAll() ->(변경) getAll(dname, page, size)
      FavoriteDataService.get(this.currentUser.id, this.$route.params.dno)
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          this.favorite = response.data; // 스프링부트에서 전송한 데이터
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log("찜한 목록 데이터 : ", e);
        });
    },
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
    // 부서번호(dno)로 메뉴조회 요청하는 함수
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
    // dno로 리뷰 요청하는 함수
    getReview(dno) {
      // axios 공통함수 호출
      ReviewDataService.get(dno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.review = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },
    // select box 값 변경시 실행되는 함수(재조회)
    handlePageSizeChange(event) {
      this.pageSize = event.target.value; // 한페이지당 개수 저장(3, 6, 9)
      this.page = 1;
      // 재조회함수 호출
      this.retrieveDiner();
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
    // 부서정보를 수정 요청하는 함수
    updateDiner() {
      // axios 공통함수 호출
      DinerDataService.update(this.currentDiner.dno, this.currentDiner)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.message = "The Diner was updated successfully!";
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 삭제 요청하는 함수
    deleteDiner() {
      // axios 공통함수 호출
      DinerDataService.delete(this.currentDiner.dno)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /diner
          this.$router.push("/diner");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
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
    // 함수(메소드)
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

    saveFavorite() {
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
          console.log("찜한 데이터 : ", this.favorite);
          // this.$swal({
          //   icon: "success",
          //   title: "찜하기",
          //   showConfirmButton: false,
          //   timer: 1000,
          // });
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((e) => {
          console.log("테스트용");
          console.log(e);
        });
    },
    deleteFavorite() {
      // axios 공통함수 호출
      FavoriteDataService.delete(this.favorite.fid)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // this.$swal({
          //   icon: "error",
          //   title: "찜 해제",
          //   showConfirmButton: false,
          //   timer: 1000,
          // });
          // this.$router.go();
          this.retrieveFavorite();
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
    // alert(this.$route.params.dno);
    // console.log(this.$route.params.dno);

    this.message = "";
    //  this.$route.params.dno : 이전페이지에서 전송한 매개변수는 $route.params 안에 있음
    // $route 객체 : 주로 url 매개변수 정보들이 있음
    // router/index.js 상세페이지 url의 매개변수명 : :dno
    this.getDiner(this.$route.params.dno);
    this.getMenu(this.$route.params.dno); // 화면 로딩시 음식점번호(dno)로 메뉴조회하기
    this.getReview(this.$route.params.dno);
    this.retrieveReview(); // 화면 로딩시 전체 조회함수 실행
    this.retrieveFavorite(); // 화면 로딩시 fid해당하는 조회함수 실행

    const ctx = document.getElementById("myChart");

    new Chart(ctx, {
      type: "radar",
      data: this.chartData,
      options: {
        elements: {
          line: {
            borderWidth: 3,
          },
        },
      },
    });
  },
  computed: {
    // 현재 유저
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },
    // ROLE_ADMIN 만 보이는 메뉴(함수)
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        // if ROLE_ADMIN 있으면 true
        //               없으면 false
        return this.currentUser.roles.includes("ROLE_ADMIN");
      }
      // currentUser 없으면 false (메뉴가 안보임)
      return false;
    },
    existFid() {
      if (this.favorite.fid != null) {
        return true;
      } else {
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
  padding-left: 60px;
  padding-right: 60px;
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
