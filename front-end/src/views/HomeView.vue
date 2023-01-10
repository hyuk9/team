<template>
  <div>
    <main class="main" id="top">
      <!-- 홈뷰 최상단 시작 -->
      <section class="py-5 overflow-hidden bg-danger" id="home">
        <div class="container">
          <div class="row flex-center">
            <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
              <a class="img-landing-banner" href="#!"><img class="img-fluid" src="assets/img/gallery/hero-tomato.png"
                  alt="hero-header" /></a>
            </div>
            <div class="col-md-7 col-lg-6 py-8 text-md-start text-center" id="typed">
              <span class="
                  typed-words
                  fs-md-5 fs-lg-6 fs-xl-8
                  text-light
                  font-italic
                  fw-900
                "></span>
              <br />
              <span class="fs-md-5 fs-lg-6 fs-xl-8 text-light font-italic fw-900">쉽고 빠르게😋</span>
            </div>
          </div>
        </div>
      </section>
      <!-- 최상단 끝 -->


      <!-- ============================================-->
      <!-- 음식점 리스트 표시 시작 -->
      <MenuList />
      <!-- 음식점 리스트 표시 끝 -->
      <!-- ============================================-->


      <!-- ============================================-->
      <!-- 지역별 맛집 정렬 시작 ============================-->
      <LocalList />
      <!-- 지역별 맛집 정렬 끝 ============================-->
      <!-- ============================================-->


      <!-- ============================================-->
      <!-- 테마별 맛집 정렬 시작 ============================-->
      <ThemeList />
      <!-- 테마별 맛집 정렬 끝 ============================-->
      <!-- ============================================-->


      <!-- ============================================-->
      <!-- 인기 순 정렬 시작 ============================-->
      <PopularList />
      <!-- 인기 순 정렬 끝 ============================-->
      <!-- ============================================-->


      <!-- ============================================-->
      <!-- 찜한가게 많은 순서대로 모아보기 시작 ============================-->
      <ChooseList />
      <!-- 찜한가게 많은 순서대로 음식별로 모아보기 끝 ============================-->
      <!-- ============================================-->


      <!-- ============================================-->
      <!-- 푸드컬럼 시작 ============================-->
      <FoodColumn />
      <!-- 푸드컬럼  끝 ============================-->
      <!-- ============================================-->


      <!-- ============================================-->
      <!-- 광고배너? 시작 ============================-->
      <section class="py-0">
        <div class="bg-holder" style="
            background-image: url(assets/img/gallery/cta-two-bg.png);
            background-position: center;
            background-size: cover;
          "></div>
        <!--/.bg-holder-->

        <div class="container">
          <div class="row flex-center">
            <div class="col-xxl-9 py-7 text-center">
              <h1 class="fw-bold mb-4 text-white fs-6">
                맞춤형 서비스를 이용하기 위해
                <br />
                로그인하러 가기
              </h1>
              <a class="btn btn-danger" href="#">
                처음으로 돌아가기
                <i class="fas fa-chevron-right ms-2"></i>
              </a>
            </div>
          </div>
        </div>
      </section>
      <!-- 광고배너 끝 ============================-->
      <!-- ============================================-->
    </main>
  </div>
</template>

<script>
/* eslint-disable */

// '지역별 맛집' component 화
import LocalList from "../components/HomeView/LocalList.vue";
// '테마별 맛집' component 화
import ThemeList from "../components/HomeView/ThemeList.vue";
// '메뉴별 맛집' component 화
import MenuList from "../components/HomeView/MenuList.vue";
// '푸드컬럼' component 화
import FoodColumn from "../components/HomeView/FoodColumn.vue";
// '인기순 정렬' component 화
import PopularList from "../components/HomeView/PopularList.vue";
// '많이 찜한 맛집' component 화
import ChooseList from "../components/HomeView/ChooseList.vue";


export default {
  // '지역별 맛집' component 화
  components: {
    LocalList,
    ThemeList,
    MenuList,
    PopularList,
    ChooseList,
    FoodColumn
  },
  data() {
    return {
      diner: [],
      // dname: "", ->(변경) searchUsername: "", 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 9, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      pageSizes: [3, 6, 9], // select box 에 넣을 기본 데이터
    };
  },
  methods: {

  },
  mounted() {
    $(function () {
      let typed2 = new Typed(".typed-words", {
        strings: [
          "지금 찾고있는 맛집을",
          "생각나는 가게 없을 때",
          "가까운 맛집을",
          "데이트코스로 딱인 맛집을",
          "가성비 좋은 가게를",
        ],
        typeSpeed: 80,
        backSpeed: 80,
        backDelay: 4000,
        startDelay: 1000,
        loop: true,
        showCursor: true,
      });
    });

  },
};
</script>

<style>
.typed-cursor {
  opacity: 0;
  font-size: 70px;
  color: rgb(255, 215, 53);
}
</style>