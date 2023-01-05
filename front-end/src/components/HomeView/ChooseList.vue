<template>
  <div>
    <section class="py-8 overflow-hidden">
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
              원하는 음식대로
            </h5>
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
    </section>
  </div>
</template>

<script>
export default {};
</script>

<style>
</style>