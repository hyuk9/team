<template>
  <!-- 메인 화면의 지역별 맛집 부분 시작 -->
  <section id="testimonial">
    <div class="container">
      <div class="row h-100">
        <div class="col-lg-5 mx-auto text-center mb-6">
          <h5
            class="
              fw-light
              fs-5 fs-lg-7
              lh-sm
              rounded-3
              bg-primary
              text-white
              pt-2
              pb-2
            "
          >
            테마별 맛집
          </h5>
        </div>
      </div>
      <div class="col-12 mb-2">
        <!-- 전체보기 눌렀을 때 음식점 리스트로 매개변수 날리면서 페이지 전환 -->
        <!-- 지역별 맛집 선택 -->
        <select class="form-select" v-model="searchKeyword">
          <option value="데이트">데이트</option>
          <option value="모임">모임</option>
          <option value="회식">회식</option>
        </select>
        <a class="btn btn-lg btn-primary float-right" href="/diner"
          >전체보기 <i class="fas fa-chevron-right ms-2"> </i
        ></a>
      </div>
      <div class="row gx-2">
        <div class="row gx-2">
          <div
            class="carousel slide"
            id="carouselLocationItemsInThemeList"
            data-bs-touch="false"
            data-bs-interval="false"
          >
            <div class="carousel-inner">
              <!-- 첫번째 캐러셀 -->
              <!--  db와 연결될 때만 볼 수 있음 -->
              <div class="carousel-item active">
                <div
                  v-for="(data, index) in diner.slice(0, 4)"
                  :key="index"
                  class="
                    col-sm-6 col-md-4 col-lg-3
                    h-100
                    mb-5
                    p-1
                    d-inline-block
                  "
                >
                  <router-link :to="'/diner/' + data.dno">
                    <a @click="countViews(data.dno)">
                      <div class="card card-span h-100 text-white rounded-3">
                        <img
                          class="img-fluid rounded-3 h-100"
                          :src="data.mainphoto"
                          alt="..."
                        />
                        <div class="card-img-overlay ps-0">
                          <div>
                            <span class="badge bg-danger p-2 mt-1 ms-3"
                              ><i class="fas fa-map-marker-alt me-2 fs-0"></i
                              ><span class="fs-0">{{ data.loc.split(" ")[1] }}</span></span
                            >
                            <span class="badge bg-primary p-2 mt-1 ms-3"
                              ><i class="fas fa-tag me-2 fs-0"></i
                              ><span class="fs-0">{{ data.menu }}</span></span
                            >
                          </div>
                        </div>
                        <div class="card-body ps-0">
                          <div class="d-flex align-items-center mb-3">
                            <div class="flex-1 ms-3 namescore">
                              <h4 class="mb-0 fw-bold text-900 dinername">
                                {{ data.dname }}
                              </h4>
                            </div>
                            <span class="text-primary fs-2 me-1"
                              ><i class="fas fa-star"></i
                            ></span>
                            <span class="mb-0 fs-2 text-primary">{{
                              data.score
                            }}</span>
                          </div>
                          <div class="ms-3">
                            <i
                              class="fas fa-eye text-dark text-500 me-2 fs-0"
                            ></i>
                            <span class="mb-0 text-dark text-600 fs-0 me-3">
                              {{ data.views }}
                            </span>
                            <i
                              class="fas fa-heart text-dark text-600 me-2 fs-0"
                            ></i>
                            <span class="mb-0 text-dark text-600 fs-0 me-3">
                              {{ data.dno_count }}
                            </span>
                          </div>
                        </div>
                      </div>
                    </a>
                  </router-link>
                </div>
              </div>
              <!-- 첫 캐러셀 종료 -->

              <!-- 첫번째를 제외한 나머지 캐러셀 -->
              <!-- db와 연결될 때만 볼 수 있음 -->
              <div
                class="carousel-item"
                v-for="index in Math.ceil(diner.length / 4) - 1"
                :key="index"
              >
                <div
                  v-for="(data, index) in diner.slice(
                    countCarouselNum,
                    countCarouselNum + 4
                  )"
                  :key="index"
                  class="
                    col-sm-6 col-md-4 col-lg-3
                    h-100
                    mb-5
                    p-1
                    d-inline-block
                  "
                >
                  <router-link :to="'/diner/' + data.dno">
                    <a @click="countViews(data.dno)">
                      <div class="card card-span h-100 text-white rounded-3">
                        <img
                          class="img-fluid rounded-3 h-100"
                          :src="data.mainphoto"
                          alt="..."
                        />
                        <div class="card-img-overlay ps-0">
                          <div>
                            <span class="badge bg-danger p-2 mt-1 ms-3"
                              ><i class="fas fa-map-marker-alt me-2 fs-0"></i
                              ><span class="fs-0">{{ data.loc.split(" ")[1]  }}</span></span
                            >
                            <span class="badge bg-primary p-2 mt-1 ms-3"
                              ><i class="fas fa-tag me-2 fs-0"></i
                              ><span class="fs-0">{{ data.menu }}</span></span
                            >
                          </div>
                        </div>
                        <div class="card-body ps-0">
                          <div class="d-flex align-items-center mb-3">
                            <div class="flex-1 ms-3 namescore">
                              <h4 class="mb-0 fw-bold text-1000 dinername">
                                {{ data.dname }}
                              </h4>
                            </div>
                            <span class="text-primary fs-2 me-1"
                              ><i class="fas fa-star"></i
                            ></span>
                            <span class="mb-0 fs-2 text-primary">{{
                              data.score
                            }}</span>
                          </div>
                          <div class="ms-3">
                            <i
                              class="fas fa-eye text-dark text-800 me-2 fs-0"
                            ></i>
                            <span class="mb-0 text-dark text-800 fs-0 me-3">
                              {{ data.views }}
                            </span>
                            <i
                              class="fas fa-heart text-dark text-800 me-2 fs-0"
                            ></i>
                            <span class="mb-0 text-dark text-800 fs-0 me-3">
                              {{ data.dno_count }}
                            </span>
                          </div>
                        </div>
                      </div>
                    </a>
                  </router-link>
                </div>
              </div>
              <!-- 첫번째를 제외한 나머지 캐러셀 종료 -->
            </div>
            <!-- 캐러셀 버튼 시작 -->
            <button
              class="carousel-control-prev carousel-icon"
              type="button"
              data-bs-target="#carouselLocationItemsInThemeList"
              data-bs-slide="prev"
              v-on:click="countDown()"
            >
              <span
                class="carousel-control-prev-icon hover-top-shadow"
                aria-hidden="true"
              ></span
              ><span class="visually-hidden">Previous</span>
            </button>
            <button
              class="carousel-control-next carousel-icon"
              type="button"
              data-bs-target="#carouselLocationItemsInThemeList"
              data-bs-slide="next"
              v-on:click="countUp()"
            >
              <span
                class="carousel-control-next-icon hover-top-shadow"
                aria-hidden="true"
              ></span
              ><span class="visually-hidden">Next </span>
            </button>
          </div>
          <!-- 캐러셀 버튼 종료 -->
        </div>
      </div>
    </div>
  </section>
  <!-- 메인 화면의 지역별 맛집 부분 끝 -->
</template>

<script>
/* eslint-disable */
import DinerDataService from "@/services/DinerDataService";
import FavoriteDataService from "@/services/FavoriteDataService";

export default {
  data() {
    return {
      diner: [],
      // dname: "", ->(변경) searchUsername: "",
      searchSelect: "테마",
      searchKeyword: "데이트",

      currentDiner: null,
      currentIndex: -1,
      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 20, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      pageSizes: [3, 6, 9], // select box 에 넣을 기본 데이터
      countCarouselNum: 0, //'지역별 맛집'의 캐러셀 작동을 위한 변수

         // favorite 정보 저장용
      favorite : [],
    };
  },
  methods: {
    retrieveDiner() {
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
          
          // favorite 정보 받기
          FavoriteDataService.getFavoriteAll()
          // 성공하면 .then() 결과가 전송됨
          .then((response) => {
            this.favorite = response.data; // 스프링부트에서 전송한 데이터 받고 조회수 내림차순으로 가공
            // 디버깅 콘솔에 정보 출력
            console.log(response.data);   
                  // favorite dno_count 를 diner dno_count에 복사
            for(let i= 0; i<this.diner.length; i++) {
              for(let j=0; j<this.favorite.length; j++) {
                if(this.diner[i].dname ==this.favorite[j].dname) {
                  this.diner[i].dno_count = this.favorite[j].dno_count        
                }
              }              
            }  
          })
          // 실패하면 .catch() 에 에러가 전송됨
          .catch((e) => {
            console.log(e);
          });
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    // '지역별 맛집'의 캐러셀 버튼의 오른쪽을 눌렀을때 작동하는 함수
    countUp() {
      setTimeout(function() {
       if (this.countCarouselNum + 4 < this.diner.length) {
        this.countCarouselNum = this.countCarouselNum + 4;
      } else {
        this.countCarouselNum = 0;
      }
}.bind(this), 600);
      // if (this.countCarouselNum + 4 < this.diner.length) {
      //   this.countCarouselNum = this.countCarouselNum + 4;
      // } else {
      //   this.countCarouselNum = 0;
      // }
    },

    // '지역별 맛집'의 캐러셀 버튼의 왼쪽을 눌렀을때 작동하는 함수
    countDown() {
         setTimeout(function() {
   if (this.countCarouselNum >= 4) {
        this.countCarouselNum = this.countCarouselNum - 4;
      } else {
        if (this.diner.length % 4 == 0) {
          this.countCarouselNum = this.diner.length - 4;
        } else {
          this.countCarouselNum = this.diner.length - (this.diner.length % 4);
        }
      }
}.bind(this), 600);
   
    },

      // 조회수 증가 함수
    countViews (dno) {
      DinerDataService.plusViews(dno)
     .then((response) => {
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    }
  },

  // handlePageSizeChange(event) {
  //   this.pageSize = event.target.value;
  //   this.page = 1;
  //   this.retrieveDiner();
  // },

  // handlePageChange(value) {
  //   this.page = value;
  //   this.retrieveDiner();
  // },

  mounted() {
    // $(function () {
    //   let typed2 = new Typed(".typed-words", {
    //     strings: [
    //       "지금 찾고있는 맛집을",
    //       "송년회 하기 좋은 맛집을",
    //       "크리스마스 파티 맛집을",
    //       "데이트코스로 딱인 맛집을",
    //       "가성비 좋은 맛집을",
    //     ],
    //     typeSpeed: 80,
    //     backSpeed: 80,
    //     backDelay: 4000,
    //     startDelay: 1000,
    //     loop: true,
    //     showCursor: true,
    //   });
    // });

    this.retrieveDiner();
  },
  watch : {
    searchKeyword() {
      this.countCarouselNum = 0;
      $('#carouselLocationItemsInThemeList').carousel(0).removeData();
      this.retrieveDiner();
    },
  },
};
</script>

<style>
.form-select {
  display: inline-block;
  width: 15%;
}
/* 음식점 이름 길면 말줄임 처리 */
.namescore {
  width: 40%;
}
.dinername {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
