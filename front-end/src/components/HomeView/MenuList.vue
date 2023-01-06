<template>
  <div>
    <section class="py-0">
      <div class="container">
        <div class="col-lg-5 mx-auto text-center mt-7">
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
            메뉴별 모아보기
          </h5>
        </div>

        <div class="row h-100 gx-2 mt-7">
          <div class="col-12 d-flex justify-content-end mb-2">
            <!-- 전체보기 눌렀을 때 음식점 리스트로 매개변수 날리면서 페이지 전환 -->
            <a class="btn btn-lg btn-primary" href="/diner"
              >전체보기 <i class="fas fa-chevron-right ms-2"> </i
            ></a>
          </div>
          <!-- 한식 시작 -->
          <div class="col-sm-6 col-lg-3 mb-3 mb-md-0 h-100 pb-4">
            <router-link to="/korean">
              <div class="card card-span h-100">
                <div class="position-relative">
                  <img
                    class="img-fluid rounded-3 w-100"
                    src="assets/img/species/korean.jpg"
                    alt="..."
                  />
                  <div class="card-actions">
                    <div class="badge badge-foodwagon bg-primary p-4">
                      <div class="d-flex flex-between-center">
                        <div class="text-white fs-7" id="menu">한식</div>
                      </div>
                    </div>
                  </div>
                </div>
                <a class="stretched-link" href="#"></a>
              </div>
            </router-link>
          </div>
          <!-- 한식 끝 -->

          <!-- 중식 시작 -->
          <div class="col-sm-6 col-lg-3 mb-3 mb-md-0 h-100 pb-4">
            <router-link to="/chinese">
              <div class="card card-span h-100">
                <div class="position-relative">
                  <img
                    class="img-fluid rounded-3 w-100"
                    src="assets/img/species/chinese.jpg"
                    alt="..."
                  />
                  <div class="card-actions">
                    <div class="badge badge-foodwagon bg-primary p-4">
                      <div class="d-flex flex-between-center">
                        <div class="text-white fs-7" id="menu">중식</div>
                      </div>
                    </div>
                  </div>
                </div>
                <a class="stretched-link" href="#"></a>
              </div>
            </router-link>
          </div>
          <!-- 중식 끝 -->

          <!-- 양식 시작 -->
          <div class="col-sm-6 col-lg-3 mb-3 mb-md-0 h-100 pb-4">
            <router-link to="/western">
              <div class="card card-span h-100">
                <div class="position-relative">
                  <img
                    class="img-fluid rounded-3 w-100"
                    src="assets/img/species/italy.jpg"
                    alt="..."
                  />
                  <div class="card-actions">
                    <div class="badge badge-foodwagon bg-primary p-4">
                      <div class="d-flex flex-between-center">
                        <div class="text-white fs-7" id="menu">양식</div>
                      </div>
                    </div>
                  </div>
                </div>
                <a class="stretched-link" href="#"></a>
              </div>
            </router-link>
          </div>
          <!-- 양식 끝 -->

          <!-- 일식 시작 -->
          <div class="col-sm-6 col-lg-3 mb-3 mb-md-0 h-100 pb-4">
            <router-link to="/japanese">
              <div class="card card-span h-100">
                <div class="position-relative">
                  <img
                    class="img-fluid rounded-3 w-100"
                    src="assets/img/species/japan.jpg"
                    alt="..."
                  />
                  <div class="card-actions">
                    <div class="badge badge-foodwagon bg-primary p-4">
                      <div class="d-flex flex-between-center">
                        <div class="text-white fs-7" id="menu">일식</div>
                      </div>
                    </div>
                  </div>
                </div>
                <a class="stretched-link" href="#"></a>
              </div>
            </router-link>
          </div>
          <!-- 일식 끝 -->

          <!-- 카페 시작 -->
          <!-- <div class="col-sm-6 col-lg-2 mb-3 mb-md-0 h-100 pb-4"> <div class="card
                        card-span h-100"> <div class="position-relative"> <img class="img-fluid
                        rounded-3 w-100" src="assets/img/species/dessert.jpg" alt="..." /> <div
                        class="card-actions"> <div class="badge badge-foodwagon bg-primary p-4"> <div
                        class="d-flex flex-between-center"> <div class="text-white fs-7">디저트</div>
                        </div> </div> </div> </div> <div class="card-body px-0"> <h5 class="fw-bold
                        text-1000 text-truncate">카페에 대한 설명</h5><span class="badge bg-soft-danger py-2
                        px-3"><span class="fs-1 text-danger">지금 바로 알아보기</span></span> </div><a
                        class="stretched-link" href="#"></a> </div> </div> -->
          <!-- 카페 끝 -->
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