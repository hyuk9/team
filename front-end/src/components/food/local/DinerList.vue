<template>
  <div>
    <main class="main" id="top">
      <!-- 최상단 시작 -->
      <section class="py-5 overflow-hidden bg-warning" id="home">
        <div class="container">
          <div class="row flex-center">
            <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
              <a class="img-landing-banner" href="#!"><img class="img-fluid" src="assets/img/gallery/hero-header.png"
                  alt="hero-header" /></a>
            </div>
            <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
              <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">전국</h1>
              <h1 class="text-800 mb-5 fs-4">
                <br />전국의 <br />
                뜨고있는 맛집들을 알려드립니다!
              </h1>
            </div>
          </div>
        </div>
      </section>
      <!-- 최상단 끝 -->

      <!-- Page content-->
      <div class="container">
        <div class="row">
          <!-- Blog entries-->
          <div class="col-lg-8">
            <div class="input-group mt-5 mb-5">
              <button class="btn btn-success" v-if="showAdminBoard">
                <router-link to="/add/diner">Add</router-link>
              </button>
              <!--  검색어 입력 -->
              <input type="text" class="form-control" placeholder="이름으로 찾기" v-model="searchLoc" />
              <!--  검색어 버튼 -->
              <div class="input-group-append">
                <button class="btn btn-secondary" type="button" @click="
  page = 1;
retrieveDiner();
                ">
                  Search
                </button>
              </div>
            </div>

            <!-- Featured blog post
            <div class="card mb-4">
              <a href="#!"
                ><img
                  class="card-img-top"
                  src="https://dummyimage.com/850x350/dee2e6/6c757d.jpg"
                  alt="..."
              /></a>
              <div class="card-body">
                <div class="small text-muted">January 1, 2022</div>
                <h2 class="card-title">Featured Post Title</h2>
                <p class="card-text">
                  Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                  Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a
                  laboriosam. Dicta expedita corporis animi vero voluptate
                  voluptatibus possimus, veniam magni quis!
                </p>
                <a class="btn btn-primary" href="#!">Read more →</a>
              </div>
            </div> -->
            <!-- Nested row for non-featured blog posts-->
            <div class="row">
              <div class="col-lg-6" :class="{ active: index == currentIndex }" v-for="(data, index) in diner"
                :key="index" @click="setActiveDiner(data, index)">
                <!-- Blog post-->
                <div class="card mb-4">
                  <!-- <a href="#!"
                    ><img
                      class="card-img-top"
                      src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                      alt="..."
                  /></a> -->
                  <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg" class="d-block w-100" alt="..." />
                      </div>
                      <div class="carousel-item">
                        <img src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg" class="d-block w-100" alt="..." />
                      </div>
                      <div class="carousel-item">
                        <img src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg" class="d-block w-100" alt="..." />
                      </div>
                    </div>
                  </div>
                  <div class="card-body">
                    <h2 class="card-title h4">
                      {{ data.dname }}
                      <a class="badge bg-danger text-decoration-none link-light" href="#!">{{ data.score }}</a>
                    </h2>
                    <p class="card-text">
                      {{ data.review }}
                    </p>

                    <!-- 간략 상세 목록 시작 -->
                    <div v-if="currentDiner">
                      <button class="btn btn-warning" type="button">
                        <router-link :to="'/diner/' + currentDiner.dno">detail >
                        </router-link>
                      </button>
                      <button class="btn btn-danger ms-3">
                        <router-link :to="'/diner/' + currentDiner.dno + '/edit'">Edit</router-link>
                      </button>
                    </div>

                    <!-- 간략 상세 목록 끝 -->
                  </div>
                </div>
              </div>
            </div>

            <!-- Pagination-->
            <nav aria-label="Pagination mb-5">
              <hr class="my-0" />
              <ul class="pagination justify-content-center my-4">
                <b-pagination v-model="page" :total-rows="count" :per-page="pageSize" prev-text="Prev" next-text="Next"
                  @change="handlePageChange"></b-pagination>
              </ul>
            </nav>
          </div>
          <!-- Side widgets-->
          <div class="col-lg-4">
            <!-- Map widget-->
            <div class="card mt-5 mb-5">
              <div class="card-header">내 주변 맛집</div>
              <div class="card-body">
                <div id="map" style="height: 600px"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>

<script>
// axios 공통함수 import
import DinerDataService from "@/services/DinerDataService";

export default {
  // 변수 정의하는 곳 : data(), 초기화
  data() {
    return {
      diner: [],
      currentDiner: null,
      currentIndex: -1,
      // dname: "", ->(변경) searchDname: "",
      // TODO: searchDname -> searchLoc
      searchLoc: "",

      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 8, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      pageSizes: [3, 6, 9], // select box에 넣을 기본 데이터
    };
  },
  computed: {
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },
    // ROLE_ADMIN 만 보이는 메뉴(함수)
    showAdminBoard() {
      if(this.currentUser && this.currentUser.roles) {
        // if ROLE_ADMIN 있으면 true
        //               없으면 false
        return this.currentUser.roles.includes("ROLE_ADMIN"); 
      }
      // currentUser 없으면 false (메뉴가 안보임)
      return false;
    }
  },
  // 함수 정의하는 곳 : methods:
  methods: {
    // axios , 모든 부서 정보 조회 요청 함수
    retrieveDiner() {
      // getAll() ->(변경) getAll(dname, page, size)
      DinerDataService.getAll(this.searchLoc, this.page - 1, this.pageSize)
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          // this.diner = response.data -> (변경) const { diner, totalItems } = response.data
          // let(const) { 속성명1, 속성명2 } = 데이터 객체배열 (모던자바문법 구조분해할당)
          const { diner, totalItems } = response.data; // springboot 의 전송한 맵 정보
          this.diner = diner; // 스프링부트에서 전송한 데이터
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
      // 재조회함수 호출
      this.retrieveDiner();
    },
    // 페이지 번호 변경시 실행되는 함수(재조회)
    handlePageChange(value) {
      this.page = value; // 매개변수값으로 현재페이지 변경
      // 재조회함수 호출
      this.retrieveDiner();
    },
    // 목록을 클릭했을때 현재 부서객체, 인덱스번호를 저장하는 함수
    setActiveDiner(data, index) {
      this.currentDiner = data;
      this.currentIndex = index;
    },
    // axios, 모든 부서 정보 삭제 요청 함수
    removeAllDiner() {
      DinerDataService.deleteAll()
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
          // 전체 목록 재조회
          this.retrieveDiner();
          // currentDiner, currentIndex 초기화
          this.currentDiner = null;
          this.currentIndex = -1;
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    
  },
  // 화면이 뜨자마자 실행되는 이벤트(라이프 사이클 함수) : mounted(), created()
  mounted() {
    // 화면 로딩시 전체 조회함수 실행
    this.retrieveDiner(this.searchLoc="서울");
  },
};
</script>

<style>

</style>