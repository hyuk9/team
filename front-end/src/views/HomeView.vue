<template>
  <div>
    <main class="main" id="top">
      <!-- 최상단 시작 -->
      <section class="py-5 overflow-hidden bg-danger" id="home">
        <div class="container">
          <div class="row flex-center">
            <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
              <a class="img-landing-banner" href="#!"
                ><img
                  class="img-fluid"
                  src="assets/img/gallery/hero-tomato.png"
                  alt="hero-header"
              /></a>
            </div>
            <div
              class="col-md-7 col-lg-6 py-8 text-md-start text-center"
              id="typed"
            >
              <span
                class="
                  typed-words
                  fs-md-5 fs-lg-6 fs-xl-8
                  text-light
                  font-italic
                  fw-900
                "
              ></span>
              <br />
              <span
                class="fs-md-5 fs-lg-6 fs-xl-8 text-light font-italic fw-900"
                >쉽고 빠르게😋</span
              >
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


      <!-- ============================================-->
      <!-- 인기 순 정렬 시작 ============================-->
      <!-- 조회수 기준으로 정렬하는게 좋을 거 같은데 방법을 아직 모르니 일단 하드코딩으로 데이터 집어넣어야할듯 -->
      <section class="py-4 overflow-hidden">
        <div class="container">
          <div class="row h-100">
            <div class="col-lg-7 mx-auto text-center mt-7 mb-5">
              <h5 class="fw-bold fs-3 fs-lg-5 lh-sm">요즘 핫한 가게</h5>
            </div>
            <div class="col-12">
              <div
                class="carousel slide"
                id="carouselPopularItems"
                data-bs-touch="false"
                data-bs-interval="false"
              >
                <div class="carousel-inner">
                  <!-- 초기 캐러셀 -->
                  <div class="carousel-item active" data-bs-interval="10000">
                    <div class="row gx-3 h-100 align-items-center">
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/cheese-burger.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Cheese Burger
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Burger Arena</span>
                            </div>
                            <span class="text-1000 fw-bold">$3.88</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/toffes-cake.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Toffe's Cake
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Top Sticks</span>
                            </div>
                            <span class="text-1000 fw-bold">$4.00</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/dancake.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Dancake
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Cake World</span>
                            </div>
                            <span class="text-1000 fw-bold">$1.99</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/crispy-sandwitch.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Crispy Sandwitch
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Fastfood Dine</span>
                            </div>
                            <span class="text-1000 fw-bold">$3.00</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/thai-soup.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Thai Soup
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Foody Man</span>
                            </div>
                            <span class="text-1000 fw-bold">$2.79</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                    </div>
                  </div>
                  <!-- 두번째 -->
                  <div class="carousel-item" data-bs-interval="5000">
                    <div class="row gx-3 h-100 align-items-center">
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/cheese-burger.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Cheese Burger
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Burger Arena</span>
                            </div>
                            <span class="text-1000 fw-bold">$3.88</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/toffes-cake.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Toffe's Cake
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Top Sticks</span>
                            </div>
                            <span class="text-1000 fw-bold">$4.00</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/dancake.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Dancake
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Cake World</span>
                            </div>
                            <span class="text-1000 fw-bold">$1.99</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/crispy-sandwitch.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Crispy Sandwitch
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Fastfood Dine</span>
                            </div>
                            <span class="text-1000 fw-bold">$3.00</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/thai-soup.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Thai Soup
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Foody Man</span>
                            </div>
                            <span class="text-1000 fw-bold">$2.79</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                    </div>
                  </div>
                  <!-- 세번째 -->
                  <div class="carousel-item" data-bs-interval="3000">
                    <div class="row gx-3 h-100 align-items-center">
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/cheese-burger.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Cheese Burger
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Burger Arena</span>
                            </div>
                            <span class="text-1000 fw-bold">$3.88</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/toffes-cake.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Toffe's Cake
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Top Sticks</span>
                            </div>
                            <span class="text-1000 fw-bold">$4.00</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/dancake.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Dancake
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Cake World</span>
                            </div>
                            <span class="text-1000 fw-bold">$1.99</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/crispy-sandwitch.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Crispy Sandwitch
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Fastfood Dine</span>
                            </div>
                            <span class="text-1000 fw-bold">$3.00</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/thai-soup.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Thai Soup
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Foody Man</span>
                            </div>
                            <span class="text-1000 fw-bold">$2.79</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                    </div>
                  </div>
                  <!-- 네번째 -->
                  <div class="carousel-item">
                    <div class="row gx-3 h-100 align-items-center">
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/cheese-burger.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Cheese Burger
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Burger Arena</span>
                            </div>
                            <span class="text-1000 fw-bold">$3.88</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/toffes-cake.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Toffe's Cake
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Top Sticks</span>
                            </div>
                            <span class="text-1000 fw-bold">$4.00</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/dancake.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Dancake
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Cake World</span>
                            </div>
                            <span class="text-1000 fw-bold">$1.99</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/crispy-sandwitch.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Crispy Sandwitch
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Fastfood Dine</span>
                            </div>
                            <span class="text-1000 fw-bold">$3.00</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-3">
                          <img
                            class="img-fluid rounded-3 h-100"
                            src="assets/img/gallery/thai-soup.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5 class="fw-bold text-1000 text-truncate mb-1">
                              Thai Soup
                            </h5>
                            <div>
                              <span class="text-warning me-2">
                                <i class="fas fa-map-marker-alt"></i>
                              </span>
                              <span class="text-primary">Foody Man</span>
                            </div>
                            <span class="text-1000 fw-bold">$2.79</span>
                          </div>
                        </div>
                        <div class="d-grid gap-2">
                          <a
                            class="btn btn-lg btn-danger"
                            href="#!"
                            role="button"
                            >Order now</a
                          >
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- 캐러셀 버튼 -->
                <button
                  class="carousel-control-prev carousel-icon"
                  type="button"
                  data-bs-target="#carouselPopularItems"
                  data-bs-slide="prev"
                >
                  <span
                    class="carousel-control-prev-icon hover-top-shadow"
                    aria-hidden="true"
                  ></span>
                  <span class="visually-hidden">Previous</span>
                </button>
                <button
                  class="carousel-control-next carousel-icon"
                  type="button"
                  data-bs-target="#carouselPopularItems"
                  data-bs-slide="next"
                >
                  <span
                    class="carousel-control-next-icon hover-top-shadow"
                    aria-hidden="true"
                  ></span>
                  <span class="visually-hidden">Next </span>
                </button>
                <!-- 캐러셀 버튼 -->
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- 인기 순 정렬 끝 ============================-->
      <!-- ============================================-->

      <!-- ============================================-->
      <!-- 음식별로 모아보기 시작 ============================-->
      <section class="py-8 overflow-hidden">
        <div class="container">
          <div class="row flex-center mb-6">
            <div class="col-lg-7">
              <h5 class="fw-bold fs-3 fs-lg-5 lh-sm text-center text-lg-start">
                원하는 음식을 찾아보세요
              </h5>
            </div>
            <div class="col-lg-4 text-lg-end text-center">
              <a class="btn btn-lg text-800 me-2" href="#" role="button"
                >VIEW ALL
                <i class="fas fa-chevron-right ms-2"></i>
              </a>
            </div>
            <div class="col-lg-auto position-relative">
              <button
                class="carousel-control-prev s-icon-prev carousel-icon"
                type="button"
                data-bs-target="#carouselSearchByFood"
                data-bs-slide="prev"
              >
                <span
                  class="carousel-control-prev-icon hover-top-shadow"
                  aria-hidden="true"
                ></span>
                <span class="visually-hidden">Previous</span>
              </button>
              <button
                class="carousel-control-next s-icon-next carousel-icon"
                type="button"
                data-bs-target="#carouselSearchByFood"
                data-bs-slide="next"
              >
                <span
                  class="carousel-control-next-icon hover-top-shadow"
                  aria-hidden="true"
                ></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div>
          </div>
          <div class="row flex-center">
            <div class="col-12">
              <div
                class="carousel slide"
                id="carouselSearchByFood"
                data-bs-touch="false"
                data-bs-interval="false"
              >
                <div class="carousel-inner">
                  <div class="carousel-item active" data-bs-interval="10000">
                    <div class="row h-100 align-items-center">
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/search-pizza.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              pizza
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/burger.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Burger
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/noodles.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Noodles
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/sub-sandwich.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Sub-sandwiches
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/chowmein.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Chowmein
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/steak.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Steak
                            </h5>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="carousel-item" data-bs-interval="5000">
                    <div class="row h-100 align-items-center">
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/search-pizza.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              pizza
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/burger.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Burger
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/noodles.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Noodles
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/sub-sandwich.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Sub-sandwiches
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/chowmein.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Chowmein
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/steak.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Steak
                            </h5>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="carousel-item" data-bs-interval="3000">
                    <div class="row h-100 align-items-center">
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/search-pizza.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              pizza
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/burger.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Burger
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/noodles.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Noodles
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/sub-sandwich.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Sub-sandwiches
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/chowmein.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Chowmein
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/steak.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Steak
                            </h5>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="carousel-item">
                    <div class="row h-100 align-items-center">
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/search-pizza.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              pizza
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/burger.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Burger
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/noodles.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Noodles
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/sub-sandwich.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Sub-sandwiches
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/chowmein.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Chowmein
                            </h5>
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                        <div class="card card-span h-100 rounded-circle">
                          <img
                            class="img-fluid rounded-circle h-100"
                            src="assets/img/gallery/steak.png"
                            alt="..."
                          />
                          <div class="card-body ps-0">
                            <h5
                              class="
                                text-center
                                fw-bold
                                text-1000 text-truncate
                                mb-2
                              "
                            >
                              Steak
                            </h5>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- end of .container-->
      </section>
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

      <!-- ============================================-->
      <!-- 푸드컬럼1 시작 ============================-->
      <section class="pb-5 pt-8">
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="card card-span mb-3 shadow-lg">
                <div class="card-body py-0">
                  <div class="row justify-content-center">
                    <div
                      class="col-md-5 col-xl-7 col-xxl-8 g-0 order-0 order-md-1"
                    >
                      <img
                        class="
                          img-fluid
                          w-100
                          fit-cover
                          h-100
                          rounded-top rounded-md-end rounded-md-top-0
                        "
                        src="assets/img/gallery/crispy-sandwiches.png"
                        alt="..."
                      />
                    </div>
                    <div class="col-md-7 col-xl-5 col-xxl-4 p-4 p-lg-5">
                      <h1 class="card-title mt-xl-5 mb-4">
                        여기는
                        <span class="text-primary"> 푸드컬럼 공간</span>
                      </h1>
                      <p class="fs-1">
                        이쪽은 작업 끝나고 여유되면 공간채우는 식으로 하는게
                        좋을듯
                      </p>
                      <div class="d-grid bottom-0">
                        <a class="btn btn-lg btn-primary mt-xl-6" href="#!"
                          >자세히 알아보기<i
                            class="fas fa-chevron-right ms-2"
                          ></i>
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- end of .container-->
      </section>
      <!-- 푸드컬럼 끝 ============================-->
      <!-- ============================================-->

      <!-- ============================================-->
      <!-- 푸드컬럼2 시작 ============================-->
      <section class="py-0">
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="card card-span mb-3 shadow-lg">
                <div class="card-body py-0">
                  <div class="row justify-content-center">
                    <div class="col-md-5 col-xl-7 col-xxl-8 g-0 order-md-0">
                      <img
                        class="
                          img-fluid
                          w-100
                          fit-cover
                          h-100
                          rounded-top rounded-md-start rounded-md-top-0
                        "
                        src="assets/img/gallery/fried-chicken.png"
                        alt="..."
                      />
                    </div>
                    <div class="col-md-7 col-xl-5 col-xxl-4 p-4 p-lg-5">
                      <h1 class="card-title mt-xl-5 mb-4">
                        무슨 내용을
                        <br />
                        <span class="text-primary">넣을지는 나중에</span>
                      </h1>
                      <p class="fs-1">
                        푸드컬럼용 페이지를 추가로 생성해야되는 귀찮음이 있어서
                        일단 보류
                      </p>
                      <div class="d-grid bottom-0">
                        <a class="btn btn-lg btn-primary mt-xl-6" href="#!"
                          >자세히 알아보기<i
                            class="fas fa-chevron-right ms-2"
                          ></i>
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- end of .container-->
      </section>
      <!-- 푸드컬럼 끝 ============================-->
      <!-- ============================================-->

      <!-- ============================================-->
      <!-- 푸드컬럼3 시작 ============================-->
      <section class="pt-5">
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="card card-span mb-3 shadow-lg">
                <div class="card-body py-0">
                  <div class="row justify-content-center">
                    <div
                      class="col-md-5 col-xl-7 col-xxl-8 g-0 order-0 order-md-1"
                    >
                      <img
                        class="
                          img-fluid
                          w-100
                          fit-cover
                          h-100
                          rounded-top rounded-md-end rounded-md-top-0
                        "
                        src="assets/img/gallery/pizza.png"
                        alt="..."
                      />
                    </div>
                    <div class="col-md-7 col-xl-5 col-xxl-4 p-4 p-lg-5">
                      <h1 class="card-title mt-xl-5 mb-4">
                        필요없다고 생각하면
                        <br />
                        <span class="text-primary">과감하게 포기</span>
                      </h1>
                      <p class="fs-1">
                        사용자가 직접 칼럼을 작성하는 식으로 만들어도 괜찮을거
                        같음
                      </p>
                      <div class="d-grid bottom-0">
                        <a class="btn btn-lg btn-primary mt-xl-6" href="#!"
                          >자세히 알아보기<i
                            class="fas fa-chevron-right ms-2"
                          ></i>
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- end of .container-->
      </section>
      <!-- 푸드컬럼 끝 ============================-->
      <!-- ============================================-->

      <!-- ============================================-->
      <!-- 광고배너? 시작 ============================-->
      <section class="py-0">
        <div
          class="bg-holder"
          style="
            background-image: url(assets/img/gallery/cta-two-bg.png);
            background-position: center;
            background-size: cover;
          "
        ></div>
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


export default {
  // '지역별 맛집' component 화
  components: {
    LocalList,
    ThemeList,
    MenuList
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
    retrieveDiner() {
      DinerDataService.getAll(this.page - 1, this.pageSize)
        .then((response) => {
          const { diner, totalItems } = response.data;
          this.diner = diner;
          this.count = totalItems;

          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },

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

    this.retrieveDiner();
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