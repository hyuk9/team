<template>
  <div>
    <main class="main" id="top">
      <!-- 최상단 시작 -->
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
      <!-- 어떻게 작동하느냐인데 이건 굳이 없어도 될듯? -->
      <!-- <section class="py-0 bg-primary-gradient"> <div class="container"> <div
            class="row justify-content-center g-0"> <div class="col-xl-9"> <div
            class="col-lg-6 text-center mx-auto mb-3 mb-md-5 mt-4"> <h5 class="fw-bold
            text-danger fs-3 fs-lg-5 lh-sm my-6">어떻게 작동하는지?</h5> </div> <div class="row">
            <div class="col-sm-6 col-md-3 mb-6"> <div class="text-center"><img
            class="shadow-icon" src="assets/img/gallery/location.png" height="112" alt="..."
            /> <h5 class="mt-4 fw-bold">Select location</h5> <p class="mb-md-0">Choose the
            location where your food will be delivered.</p> </div> </div> <div
            class="col-sm-6 col-md-3 mb-6"> <div class="text-center"><img
            class="shadow-icon" src="assets/img/gallery/order.png" height="112" alt="..." />
            <h5 class="mt-4 fw-bold">Choose order</h5> <p class="mb-md-0">Check over
            hundreds of menus to pick your favorite food</p> </div> </div> <div
            class="col-sm-6 col-md-3 mb-6"> <div class="text-center"><img
            class="shadow-icon" src="assets/img/gallery/pay.png" height="112" alt="..." />
            <h5 class="mt-4 fw-bold">Pay advanced</h5> <p class="mb-md-0">It's quick, safe,
            and simple. Select several methods of payment</p> </div> </div> <div
            class="col-sm-6 col-md-3 mb-6"> <div class="text-center"><img
            class="shadow-icon" src="assets/img/gallery/meals.png" height="112" alt="..." />
            <h5 class="mt-4 fw-bold">Enjoy meals</h5> <p class="mb-md-0">Food is made and
            delivered directly to your home.</p> </div> </div> </div> </div> </div> </div>
            </section> -->
      <!-- close ============================-->
      <!-- ============================================-->

      <!-- ============================================-->
      <!-- 테마별 맛집 정렬 시작 ============================-->
      <ThemeList />
      <!-- 테마별 맛집 정렬 끝 ============================-->
      <!-- ============================================-->
      <PopularList />
      <!-- ============================================-->
      <!-- 인기 순 정렬 시작 ============================-->
      <!-- 조회수 기준으로 정렬하는게 좋을 거 같은데 방법을 아직 모르니 일단 하드코딩으로 데이터 집어넣어야할듯 -->

      <!-- 인기 순 정렬 끝 ============================-->
      <!-- ============================================-->

      <!-- ============================================-->
      <!-- 음식별로 모아보기 시작 ============================-->
      <ChooseList />
      <!-- 음식별로 모아보기 끝 ============================-->
      <!-- ============================================-->

      <!-- ============================================-->
      <!-- 어플 안내창 시작 ============================-->
      <!-- <section> <div class="bg-holder"
            style="background-image:url(assets/img/gallery/cta-one-bg.png);background-position:center;background-size:cover;">
            </div> <div class="container"> <div class="row justify-content-center"> <div
            class="col-xxl-10"> <div class="card card-span shadow-warning"
            style="border-radius: 35px;"> <div class="card-body py-5"> <div class="row
            justify-content-evenly"> <div class="col-md-3"> <div class="d-flex d-md-block
            d-xl-flex justify-content-evenly justify-content-lg-between"><img
            src="assets/img/icons/discounts.png" width="100" alt="..." /> <div class="d-flex
            d-lg-block d-xl-flex flex-center"> <h2 class="fw-bolder text-1000 mb-0
            text-gradient">Daily<br class="d-none d-md-block" />Discounts </h2> </div>
            </div> </div> <div class="col-md-3 hr-vertical"> <div class="d-flex d-md-block
            d-xl-flex justify-content-evenly justify-content-lg-between"><img
            src="assets/img/icons/live-tracking.png" width="100" alt="..." /> <div
            class="d-flex d-lg-block d-xl-flex flex-center"> <h2 class="fw-bolder text-1000
            mb-0 text-gradient">Live Tracking</h2> </div> </div> </div> <div class="col-md-3
            hr-vertical"> <div class="d-flex d-md-block d-xl-flex justify-content-evenly
            justify-content-lg-between"><img src="assets/img/icons/quick-delivery.png"
            width="100" alt="..." /> <div class="d-flex d-lg-block d-xl-flex flex-center">
            <h2 class="fw-bolder text-1000 mb-0 text-gradient">Quick Delivery </h2> </div>
            </div> </div> </div> </div> </div> </div> </div> <div class="row flex-center
            mt-md-8"> <div class="col-lg-5 d-none d-lg-block" style="margin-bottom:
            -122px;"> <img class="w-100" src="assets/img/gallery/phone-cta-one.png"
            alt="..." /></div> <div class="col-lg-5 mt-7 mt-md-0"> <h1
            class="text-primary">Install the app</h1> <p>It's never been easier to order
            food. Look for the finest <br class="d-none d-xl-block" />discounts and you'll
            be lost in a world of delectable food.</p><a class="pe-2"
            href="https://www.apple.com/app-store/" target="_blank"><img
            src="assets/img/gallery/app-store.svg" width="160" alt="" /></a><a
            href="https://play.google.com/store/apps" target="_blank"><img
            src="assets/img/gallery/google-play.svg" width="160" alt="" /></a> </div> </div>
            </div> </section> -->
      <!-- 어플 안내창 끝 ============================-->
      <!-- ============================================-->

      <FoodColumn2 />

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
                혹시나 기능추가를 위한 공간
                <br />
                어떤기능을 넣을까
              </h1>
              <a class="btn btn-danger" href="#">
                버튼도 만들어놨음
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
import FoodColumn2 from "../components/HomeView/FoodColumn2.vue";
// '인기순 정렬' component 화
import PopularList from "../components/HomeView/PopularList.vue";
// '원하는 음식' component 화
import ChooseList from "../components/HomeView/ChooseList.vue";


export default {
  // '지역별 맛집' component 화
  components: {
    LocalList,
    ThemeList,
    MenuList,
    PopularList,
    ChooseList,
    FoodColumn2
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
    // handlePageSizeChange(event) {   this.pageSize = event.target.value;
    // this.page = 1;   this.retrieveDiner(); }, handlePageChange(value) {
    // this.page = value;   this.retrieveDiner(); },
  },
  mounted() {
    $(function () {
      let typed2 = new Typed(".typed-words", {
        strings: [
          "지금 찾고있는 맛집을",
          "송년회 하기 좋은 맛집을",
          "크리스마스 파티 맛집을",
          "데이트코스로 딱인 맛집을",
          "가성비 좋은 맛집을",
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