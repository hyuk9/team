<template>
  <div>
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
              <!--  검색어 입력 -->
              <input
                type="text"
                class="form-control"
                placeholder="이름으로 찾기"
                v-model="searchDname"
              />
              <!--  검색어 버튼 -->
              <div class="input-group-append">
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
              <div class="col-lg-6">
                <!-- Blog post-->
                <div class="card mb-4">
                  <!-- <a href="#!"
                    ><img
                      class="card-img-top"
                      src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                      alt="..."
                  /></a> -->
                  <div
                    id="carouselExampleSlidesOnly"
                    class="carousel slide"
                    data-bs-ride="carousel"
                  >
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                    </div>
                  </div>
                  <div class="card-body">
                    <h2 class="card-title h4">
                      {{ dname }}
                      <a
                        class="badge bg-danger text-decoration-none link-light"
                        href="#!"
                        >{{ score }}</a
                      >
                    </h2>
                    <p class="card-text">
                      {{ review }}
                    </p>
                    <a class="btn btn-primary">
                      <router-link to="/diner">
                    detail →</router-link></a>
                  </div>
                </div>
                <!-- Blog post-->
                <div class="card mb-4">
                  <!-- <a href="#!"
                    ><img
                      class="card-img-top"
                      src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                      alt="..."
                  /></a> -->
                  <div
                    id="carouselExampleSlidesOnly"
                    class="carousel slide"
                    data-bs-ride="carousel"
                  >
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                    </div>
                  </div>
                  <div class="card-body">
                    <h2 class="card-title h4">
                      {{ dname }}
                      <a
                        class="badge bg-danger text-decoration-none link-light"
                        href="#!"
                        >{{ score }}</a
                      >
                    </h2>
                    <p class="card-text">
                      {{ review }}
                    </p>
                    <a class="btn btn-primary" href="#!">detail →</a>
                  </div>
                </div>
              </div>
              <div class="col-lg-6">
                <!-- Blog post-->
                <div class="card mb-4">
                  <!-- <a href="#!"
                    ><img
                      class="card-img-top"
                      src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                      alt="..."
                  /></a> -->
                  <div
                    id="carouselExampleSlidesOnly"
                    class="carousel slide"
                    data-bs-ride="carousel"
                  >
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                    </div>
                  </div>
                  <div class="card-body">
                    <h2 class="card-title h4">
                      {{ dname }}
                      <a
                        class="badge bg-danger text-decoration-none link-light"
                        href="#!"
                        >{{ score }}</a
                      >
                    </h2>
                    <p class="card-text">
                      {{ review }}
                    </p>
                    <a class="btn btn-primary" href="#!">detail →</a>
                  </div>
                </div>
                <!-- Blog post-->
                <div class="card mb-4">
                  <!-- <a href="#!"
                    ><img
                      class="card-img-top"
                      src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                      alt="..."
                  /></a> -->
                  <div
                    id="carouselExampleSlidesOnly"
                    class="carousel slide"
                    data-bs-ride="carousel"
                  >
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                    </div>
                  </div>
                  <div class="card-body">
                    <h2 class="card-title h4">
                      {{ dname }}
                      <a
                        class="badge bg-danger text-decoration-none link-light"
                        href="#!"
                        >{{ score }}</a
                      >
                    </h2>
                    <p class="card-text">
                      {{ review }}
                    </p>
                    <a class="btn btn-primary" href="#!">detail →</a>
                  </div>
                </div>
              </div>
              <div class="col-lg-6">
                <!-- Blog post-->
                <div class="card mb-4">
                  <!-- <a href="#!"
                    ><img
                      class="card-img-top"
                      src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                      alt="..."
                  /></a> -->
                  <div
                    id="carouselExampleSlidesOnly"
                    class="carousel slide"
                    data-bs-ride="carousel"
                  >
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                    </div>
                  </div>
                  <div class="card-body">
                    <h2 class="card-title h4">
                      {{ dname }}
                      <a
                        class="badge bg-danger text-decoration-none link-light"
                        href="#!"
                        >{{ score }}</a
                      >
                    </h2>
                    <p class="card-text">
                      {{ review }}
                    </p>
                    <a class="btn btn-primary" href="#!">detail →</a>
                  </div>
                </div>
                <!-- Blog post-->
                <div class="card mb-4">
                  <!-- <a href="#!"
                    ><img
                      class="card-img-top"
                      src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                      alt="..."
                  /></a> -->
                  <div
                    id="carouselExampleSlidesOnly"
                    class="carousel slide"
                    data-bs-ride="carousel"
                  >
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                    </div>
                  </div>
                  <div class="card-body">
                    <h2 class="card-title h4">
                      {{ dname }}
                      <a
                        class="badge bg-danger text-decoration-none link-light"
                        href="#!"
                        >{{ score }}</a
                      >
                    </h2>
                    <p class="card-text">
                      {{ review }}
                    </p>
                    <a class="btn btn-primary" href="#!">detail →</a>
                  </div>
                </div>
              </div>
              <div class="col-lg-6">
                <!-- Blog post-->
                <div class="card mb-4">
                  <!-- <a href="#!"
                    ><img
                      class="card-img-top"
                      src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                      alt="..."
                  /></a> -->
                  <div
                    id="carouselExampleSlidesOnly"
                    class="carousel slide"
                    data-bs-ride="carousel"
                  >
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                    </div>
                  </div>
                  <div class="card-body">
                    <h2 class="card-title h4">
                      {{ dname }}
                      <a
                        class="badge bg-danger text-decoration-none link-light"
                        href="#!"
                        >{{ score }}</a
                      >
                    </h2>
                    <p class="card-text">
                      {{ review }}
                    </p>
                    <a class="btn btn-primary" href="#!">detail →</a>
                  </div>
                </div>
                <!-- Blog post-->
                <div class="card mb-4">
                  <!-- <a href="#!"
                    ><img
                      class="card-img-top"
                      src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                      alt="..."
                  /></a> -->
                  <div
                    id="carouselExampleSlidesOnly"
                    class="carousel slide"
                    data-bs-ride="carousel"
                  >
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                      <div class="carousel-item">
                        <img
                          src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg"
                          class="d-block w-100"
                          alt="..."
                        />
                      </div>
                    </div>
                  </div>
                  <div class="card-body">
                    <h2 class="card-title h4">
                      {{ dname }}
                      <a
                        class="badge bg-danger text-decoration-none link-light"
                        href="#!"
                        >{{ score }}</a
                      >
                    </h2>
                    <p class="card-text">
                      {{ review }}
                    </p>
                    <a class="btn btn-primary" href="#!">detail →</a>
                  </div>
                </div>
              </div>
            </div>

            <!-- Pagination-->
            <nav aria-label="Pagination mb-5">
              <hr class="my-0" />
              <ul class="pagination justify-content-center my-4">
                <li class="page-item disabled">
                  <a
                    class="page-link"
                    href="#"
                    tabindex="-1"
                    aria-disabled="true"
                    >Newer</a
                  >
                </li>
                <li class="page-item active" aria-current="page">
                  <a class="page-link" href="#!">1</a>
                </li>
                <li class="page-item"><a class="page-link" href="#!">2</a></li>
                <li class="page-item"><a class="page-link" href="#!">3</a></li>
                <li class="page-item disabled">
                  <a class="page-link" href="#!">...</a>
                </li>
                <li class="page-item"><a class="page-link" href="#!">15</a></li>
                <li class="page-item">
                  <a class="page-link" href="#!">Older</a>
                </li>
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
export default {
  data() {
    return {
      dname: "맛있는 식당",
      score: "4.5",
      menu: "한식",
      loc: "서울",
      phone: "010-1234-5678",
      review:
        "맛있긴한데 가격이 비싼편인것같아요. 혼자보단 여럿이와서 여러메뉴 같이 먹어보면 좋을곳...",
    };
  },
};
</script>

<style>
</style>