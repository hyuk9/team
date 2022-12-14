<template>
  <div>
    <!-- 최상단 시작 -->
    <section class="py-5 overflow-hidden bg-warning" id="home">
      <div class="container">
        <div class="row flex-center">
          <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
            <a class="img-landing-banner" href="#!"><img class="img-fluid" src="assets/img/gallery/hero-header.png"
                alt="hero-header" /></a>
          </div>
          <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
            <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">
              여기는 자주묻는질문 <br />
              페이지 입니다
            </h1>
            <h1 class="text-800 mb-5 fs-4">최상단만 제작</h1>
          </div>
        </div>
      </div>
    </section>
    <!-- 최상단 끝 -->
    <!-- TODO FAQ리스트 시작 -->
    <div class="container offset-2">
      <!-- search 관련 div 시작 -->
      <div class="col-md-8">
        <div class="input-group mb-3">
          <!-- select box 추가 : v-model="searchSelect" -->
          <div class="col-2">
            <select class="form-select" v-model="searchSelect">
              <option>question</option>
              <option>questioner</option>
            </select>
          </div>

          <!-- searchDname -> searchKeyword 변경 -->
          <div class="col-9">
            <input type="text" class="form-control" placeholder="Search by Question" v-model="searchKeyword" />
          </div>

          <div class="input-group-append col-1">
            <button class="btn btn-warning" type="button" @click="
  page = 1;
retrieveQna();
            ">
              Search
            </button>
          </div>
          <!--            Todo : 수정 끝 -->
        </div>
      </div>
      <!-- search 관련 div 끝 -->

      <!--    Todo : page 바 시작 -->
      <div class="col-md-12">
        <div class="mb-3">
          Items per Page:
          <select v-model="pageSize" @change="handlePageSizeChange($event)">
            <option v-for="size in pageSizes" :key="size" :value="size">
              <!-- <!—            size : 3, 6, 9 —> -->
              {{ size }}
            </option>
          </select>
        </div>

        <b-pagination v-model="page" :total-rows="count" :per-page="pageSize" prev-text="Prev" next-text="Next"
          @change="handlePageChange"></b-pagination>
      </div>
      <!-- <!—    Todo : page 바 끝 —> -->

      <table class="table table-bordered border-dark">
        <colgroup>
          <col style="width: 24%">
          <col style="width: 76%">
        </colgroup>
        <thead>
          <tr>
            <th class="table-active" scope="col">구분</th>
            <th class="table-active" scope="col">질문</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td rowspan="4" class="align-middle" style="text-align: center;">일반문의 사항</td>
            <td>일반문의1</td>
          </tr>
          <tr>
            <td>일반문의2</td>
          </tr>
          <tr>
            <td>일반문의3</td>
          </tr>
          <tr>
            <td>일반문의4</td>
          </tr>
          <tr>
            <td rowspan="3" class="align-middle" style="text-align: center;">자주묻는 질문 사항</td>
            <td>자주묻는 질문1</td>
          </tr>
          <tr>
            <td>자주묻는 질문2</td>
          </tr>
          <tr>
            <td>자주묻는 질문3</td>
          </tr>
        </tbody>
      </table>
    </div>
    <!-- TODO FAQ리스트 끝 -->
  </div>
</template>

<script>
export default {};
</script>

<style>

</style>