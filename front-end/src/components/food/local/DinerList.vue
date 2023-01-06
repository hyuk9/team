<template>
  <div>
    <main class="main" id="top">
      <!-- Page content-->
      <div class="container">
        <div class="row">
          <!-- Blog entries-->
          <div class="col-lg-8">
            <div class="input-group mt-5 mb-5">
              <div class="col-3">
                <select class="form-select" v-model="notTruesearchSelect">
                  <option>메뉴</option>
                  <option>지역</option>
                  <option>테마</option>
                </select>
              </div>

              <!-- searchDname -> searchKeyword 변경 -->
              <div class="col-7">
                <input
                  type="text"
                  class="form-control"
                  placeholder="검색하기"
                  v-model="notTruesearchKeyword"
                />
              </div>
              <!--  검색어 버튼 -->
              <div class="input-group-append col-1">
                <button
                  class="btn btn-secondary"
                  type="button"
                  @click="
                    page = 1;
                    retrieveDiner();
                  "
                >
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
              <div class="col-lg-6" v-for="(data, index) in diner" :key="index">
                <!-- Blog post-->
                <div class="card mb-5">
                  <a @click="countViews(data.dno)">
                    <router-link :to="'/diner/' + data.dno">
                      <img
                        class="img-fluid rounded-3 h-100 pt-2"
                        :src="data.photo"
                        alt="..."
                      />
                      <div class="card-body">
                        <a
                          class="
                            badge
                            bg-success
                            text-decoration-none
                            link-light
                          "
                          href="#!"
                        >
                          {{ data.menu }}
                        </a>
                        <a
                          class="
                            badge
                            bg-warning
                            text-decoration-none
                            link-light
                            ms-1
                          "
                          href="#!"
                          >{{ data.theme }}</a
                        >

                        <h2 class="card-title h4 mt-1">
                          <span>
                            {{ data.dname }}
                          </span>
                          <a
                            class="
                              badge
                              bg-danger
                              text-decoration-none
                              link-light
                            "
                            href="#!"
                            >{{ data.score }}</a
                          >
                        </h2>
                        <p class="card-text fw-bolder">
                          {{ data.loc }}
                        </p>
                        <p class="card-text text-800 fw-bolder">
                          <i
                            class="fas fa-eye text-dark text-800 me-2 fs-0"
                          ></i>
                          {{ data.views }}
                          <i
                            class="
                              fas
                              fa-heart
                              text-dark text-800
                              ms-3
                              me-2
                              fs-0
                            "
                          ></i>
                          {{}}
                        </p>
                      </div>
                    </router-link>
                  </a>
                </div>
              </div>
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

            <button
              class="btn btn-warning float-right mb-5 text-white"
              v-if="showAdminBoard"
            >
              <router-link to="/add/diner">목록 추가</router-link>
            </button>
          </div>
          <!-- Side widgets-->
          <div class="col-lg-4">
            <!-- Map widget-->
            <div class="card mb-4 mt-5">
              <div class="card-header">
                <i class="bi bi-geo-alt-fill"></i> 내 근처 맛집
              </div>
              <div class="card-body" style="height: 550px; width: 100%;">
                <CurrentMap />
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
/* eslint-disable */

import DinerDataService from "@/services/DinerDataService";
import CurrentMap from "@/components/food/detail/CurrentMap.vue";

export default {
  // 변수 정의하는 곳 : data(), 초기화
  data() {
    return {
      diner: [],
      // TODO: searchLoc -> searchSelect
      searchSelect: "지역",
      searchKeyword: "",

      currentDiner: null,
      currentIndex: -1,

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
      // 처음 페이지 열렸을때 입력값 숨기기용 변수
      notTruesearchSelect: "",
      notTruesearchKeyword: "",
    };
  },
  // 함수 정의하는 곳 : methods:
  methods: {
    retrieveDiner() {
      // 입력값 숨기기용 변수 값을 원래 변수로 옮기기
      if (this.notTruesearchSelect != "" && this.notTruesearchKeyword != "") {
        this.searchSelect = this.notTruesearchSelect;
        this.searchKeyword = this.notTruesearchKeyword;
      }
      DinerDataService.getAll(
        this.searchSelect, // select box 선택된 값
        this.searchKeyword, // 검색어
        this.page - 1,
        this.pageSize
      )
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          // let(const) { 속성명1, 속성명2 } = 데이터 객체배열 (모던자바문법 구조 분해 할당)
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
      // 재조회 함수 호출
      this.retrieveDiner();
    },
    // 페이지 번호 변경시 실행되는 함수(재조회)
    handlePageChange(value) {
      this.page = value; // 매개변수값으로 현재페이지 변경
      // 재조회 함수 호출
      this.retrieveDiner();
    },
    // 목록을 클릭했을때 현재 부서객체, 인덱스번호를 저장하는 함수
    setActiveDiner(data, index) {
      this.currentDiner = data;
      this.currentIndex = index;
    },
    // 조회수 증가 함수
    countViews(dno) {
      DinerDataService.plusViews(dno)
        .then((response) => {
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
  },
  components: {
    CurrentMap,
  },
  computed: {
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
    // 나브바에서 무엇을 선택했냐에 따라서 보여주는 음식점을 바꾸는 함수
    whatSelectDinerList() {
      if (this.$route.path == "/haeundae") {
        this.searchSelect = "지역";
        this.searchKeyword = "해운대구";
      } else if (this.$route.path == "/namgu") {
        this.searchSelect = "지역";
        this.searchKeyword = "남구";
      } else if (this.$route.path == "/geumjeong") {
        this.searchSelect = "지역";
        this.searchKeyword = "금정구";
      } else if (this.$route.path == "/gijang") {
        this.searchSelect = "지역";
        this.searchKeyword = "기장군";
      } else if (this.$route.path == "/dongnae") {
        this.searchSelect = "지역";
        this.searchKeyword = "동래구";
      } else if (this.$route.path == "/busanjin") {
        this.searchSelect = "지역";
        this.searchKeyword = "부산진구";
      } else if (this.$route.path == "/yeongdo") {
        this.searchSelect = "지역";
        this.searchKeyword = "영도구";
      } else if (this.$route.path == "/gangseo") {
        this.searchSelect = "지역";
        this.searchKeyword = "강서구";
      } else if (this.$route.path == "/korean") {
        this.searchSelect = "메뉴";
        this.searchKeyword = "한식";
      } else if (this.$route.path == "/chinese") {
        this.searchSelect = "메뉴";
        this.searchKeyword = "중식";
      } else if (this.$route.path == "/japanese") {
        this.searchSelect = "메뉴";
        this.searchKeyword = "일식";
      } else if (this.$route.path == "/western") {
        this.searchSelect = "메뉴";
        this.searchKeyword = "양식";
      } else if (this.$route.path == "/date") {
        this.searchSelect = "테마";
        this.searchKeyword = "데이트";
      } else if (this.$route.path == "/meeting") {
        this.searchSelect = "테마";
        this.searchKeyword = "모임";
      } else if (this.$route.path == "/getTogether") {
        this.searchSelect = "테마";
        this.searchKeyword = "회식";
      }
      this.retrieveDiner();
    },
  },
  // 화면이 뜨자마자 실행되는 이벤트(라이프 사이클 함수) : mounted(), created()
  mounted() {
    // 화면 로딩시 전체 조회함수 실행
    this.whatSelectDinerList();
    // this.searchKeyword = "";
  },
};
</script>

<style></style>
