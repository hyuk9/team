<template>
  <div>
    <section class="py-4 overflow-hidden">
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
              요즘핫한 가게
            </h5>
          </div>
          <div class="col-12">
                  <div class="col-12 d-flex justify-content-end mb-2">
        <!-- 전체보기 눌렀을 때 음식점 리스트로 매개변수 날리면서 페이지 전환 -->
        <a class="btn btn-lg btn-primary" href="/diner"
          >전체보기 <i class="fas fa-chevron-right ms-2"> </i
        ></a>
      </div>
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
                        <a class="btn btn-lg btn-danger" href="#!" role="button"
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
  </div>
</template>

<script>
export default {};
</script>

<style>
</style>