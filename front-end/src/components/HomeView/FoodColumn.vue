<template>
  <div>
    <!-- ============================================-->
    <!-- 푸드컬럼1 시작 ============================-->
    <div v-for="(data, index) in column" :key="index">
      <section class="pb-2 pt-2">
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
                        class="img-fluid w-100 fit-cover h-100 rounded-top rounded-md-end rounded-md-top-0"
                        src="assets/img/gallery/crispy-sandwiches.png"
                        alt="..."
                      />
                    </div>
                    <div class="col-md-7 col-xl-5 col-xxl-4 p-4 p-lg-5">
                      <h1 class="card-title mt-xl-5 mb-4">
                        <span> {{ data.title }} </span>
                      </h1>
                      <p class="fs-1">
                        <span class="text-primary">
                          {{ data.writer }}
                        </span>
                        <br />
                        {{ data.content }}
                      </p>
                      <div class="d-grid bottom-0">
                        <!-- <a class="btn btn-lg btn-primary mt-xl-6" href="/"
                        >자세히 알아보기<i
                          class="fas fa-chevron-right ms-2"
                        ></i>
                      </a> -->
                        <router-link
                          :to="'/column/' + data.cid"
                          class="btn btn-lg btn-primary mt-xl-6"
                          >자세히 알아보기</router-link
                        >
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
    </div>
  </div>
</template>

<script>
import ColumnDataService from "@/services/ColumnDataService";

export default {
  data() {
    return {
      column: [],
      searchKeyword: "",
      searchSelect: "제목",

      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 3, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수
    };
  },
  methods: {
    retrieveColumn() {
      ColumnDataService.getAll(
        this.searchSelect, // select box 선택된 값
        this.searchKeyword, // 검색어
        this.page - 1,
        this.pageSize
      )
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          const { column, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.column = column; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    handlePageChange(value) {
      this.page = value;
      this.retrieveColumn();
    },
    handlePageSizeChange(event) {
      this.pageSize = event.target.value;
      this.page = 1;
      this.retrieveColumn();
    },
    setActive(data, index) {
      console.log(data);
      this.currentData = data;
      this.currentIndex = index;
    },
  },
  // 화면이 뜨자마자 실행되는 이벤트(라이프 사이클 함수) : mounted(), created()
  mounted() {
    this.retrieveColumn(); // 화면 로딩시 전체 조회함수 실행
  },
};
</script>

<style></style>
