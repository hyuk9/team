<template>
  <main class="main" id="top">
    <!-- 최상단 시작 -->
    <section class="py-5 overflow-hidden bg-warning" id="home">
      <div class="container">
        <div class="row flex-center">
          <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
            <a class="img-landing-banner" href="#!"
              ><img
                class="img-fluid"
                src="assets/img/gallery/hero-header.png"
                alt="hero-header"
            /></a>
          </div>
          <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
            <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">맛집</h1>
            <h1 class="text-800 mb-5 fs-4">
              <br />맛집을 찾으시나요? <br />
              뜨고있는 맛집들을 알려드립니다!
            </h1>
          </div>
        </div>
      </div>
    </section>
    <!-- 최상단 끝 -->

    <!-- Page content-->
    <!-- <div v-if="currentDiner" class="edit-form"> -->
    <div v-if="currentDiner" class="container mt-5">
      <div class="row">
        <div class="col-lg-8">
          <!-- Post content-->
          <article>
            <!-- Post header-->
            <header class="mb-4">
              <!-- Post categories-->
              <h4>
                <a
                  class="badge bg-success text-decoration-none link-light"
                  href="#!"
                  >{{ currentDiner.menu }}</a
                >
              </h4>
              <!-- Post title-->
              <h1 class="fw-bolder mb-1">
                {{ currentDiner.dname }}
                <a
                  class="badge bg-danger text-decoration-none link-light"
                  href="#!"
                  >{{ currentDiner.score }}</a
                >
              </h1>

              <!-- Post meta content-->
              <div class="text mb-2">
                <p class="fs-1">
                  {{ currentDiner.loc }}<br />

                  {{ currentDiner.phone }}
                </p>
              </div>
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
            <!-- Post content
            <section class="mb-5">
              <p class="fs-5 mb-4">
                Science is an enterprise that should be cherished as an activity
                of the free human mind. Because it transforms who we are, how we
                live, and it gives us an understanding of our place in the
                universe.
              </p>
              <p class="fs-5 mb-4">
                The universe is large and old, and the ingredients for life as
                we know it are everywhere, so there's no reason to think that
                Earth would be unique in that regard. Whether of not the life
                became intelligent is a different question, and we'll see if we
                find that.
              </p>
              <p class="fs-5 mb-4">
                If you get asteroids about a kilometer in size, those are large
                enough and carry enough energy into our system to disrupt
                transportation, communication, the food chains, and that can be
                a really bad day on Earth.
              </p>
              <h2 class="fw-bolder mb-4 mt-5">
                I have odd cosmic thoughts every day
              </h2>
              <p class="fs-5 mb-4">
                For me, the most fascinating interface is Twitter. I have odd
                cosmic thoughts every day and I realized I could hold them to
                myself or share them with people who might be interested.
              </p>
              <p class="fs-5 mb-4">
                Venus has a runaway greenhouse effect. I kind of want to know
                what happened there because we're twirling knobs here on Earth
                without knowing the consequences of it. Mars once had running
                water. It's bone dry today. Something bad happened there as
                well.
              </p> -->
            <!-- </section> -->
            <div class="btn-group btn-group-lg" role="group" aria-label="Basic example" style="width: 950px">
              <button type="button" class="btn btn-primary">찜</button>
              <button type="button" class="btn btn-primary">리뷰보기</button>
              <button type="button" class="btn btn-primary">예약</button>
            </div>
          </article>
          <!-- Comments section-->
          <section class="mb-5">
            <div class="card bg-light">
              <div class="card-body">
                <!-- Comment form-->
                <form class="mb-4">
                  <h3>review<br /></h3>
                  <textarea
                    class="form-control"
                    rows="3"
                    placeholder="리뷰를 남겨주세요!"
                  ></textarea>
                </form>
                <!-- Comment with nested comments-->
                <div class="d-flex mb-4">
                  <!-- Parent comment-->
                  <div class="flex-shrink-0">
                    <img
                      class="rounded-circle"
                      src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
                      alt="..."
                    />
                  </div>
                  <div class="ms-3">
                    <div class="fw-bold">Commenter Name</div>
                    If you're going to lead a space frontier, it has to be
                    government; it'll never be private enterprise. Because the
                    space frontier is dangerous, and it's expensive, and it has
                    unquantified risks.
                    <!-- Child comment 1-->
                    <div class="d-flex mt-4">
                      <div class="flex-shrink-0">
                        <img
                          class="rounded-circle"
                          src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
                          alt="..."
                        />
                      </div>
                      <div class="ms-3">
                        <div class="fw-bold">Commenter Name</div>
                        And under those conditions, you cannot establish a
                        capital-market evaluation of that enterprise. You can't
                        get investors.
                      </div>
                    </div>
                    <!-- Child comment 2-->
                    <div class="d-flex mt-4">
                      <div class="flex-shrink-0">
                        <img
                          class="rounded-circle"
                          src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
                          alt="..."
                        />
                      </div>
                      <div class="ms-3">
                        <div class="fw-bold">Commenter Name</div>
                        When you put money directly to a problem, it makes a
                        good headline.
                      </div>
                    </div>
                  </div>
                </div>
                <!-- Single comment-->
                <div class="d-flex">
                  <div class="flex-shrink-0">
                    <img
                      class="rounded-circle"
                      src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
                      alt="..."
                    />
                  </div>
                  <div class="ms-3">
                    <div class="fw-bold">Commenter Name</div>
                    When I look at the universe and all the ways the universe
                    wants to kill us, I find it hard to reconcile that with
                    statements of beneficence.
                  </div>
                </div>
              </div>
            </div>
          </section>
        </div>
        <!-- Side widgets-->
        <div class="col-lg-4">
          <!-- Map widget-->
          <div class="card mb-4">
            <div class="card-header">Map</div>
            <div class="card-body">
              <div id="map" style="height: 600px"></div>
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
      </div>
    </div>
  </main>
</template>

<script>
import DinerDataService from "@/services/DinerDataService";
export default {
  data() {
    return {
      currentDiner: null,
      message: "",
    };
  },
  methods: {
    // 부서번호(dno)로 조회 요청하는 함수
    getDiner(dno) {
      // axios 공통함수 호출
      DinerDataService.get(dno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentDiner = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
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
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /local
          this.$router.push("/diner");
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
  },
};
</script>
<style>
</style>