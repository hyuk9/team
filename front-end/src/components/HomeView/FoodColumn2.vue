<template>
  <div>
    <!-- ============================================-->
    <!-- 푸드컬럼1 시작 ============================-->
    <div v-for="(data, index) in free" :key="index">
      <section class="pb-2 pt-2">
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="card card-span mb-3 shadow-lg">
                <div class="card-body py-0">
                  <div class="row justify-content-center">
                    <div class="col-md-5 col-xl-7 col-xxl-8 g-0 order-0 order-md-1">
                      <img class="img-fluid fit-cover rounded-top rounded-md-end rounded-md-top-0"
                        :src="'http://localhost:8000/api/free/file/' + data.fno "  alt="..." />

                      <!-- <img class="img-fluid w-100 fit-cover h-100 rounded-top rounded-md-end rounded-md-top-0"
                        src="assets/img/gallery/crispy-sandwiches.png" alt="..." /> -->

                      <!-- <img class="preview my-3"
                        :src="currentFree.fileUrl" alt="..." /> -->

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
                        <router-link :to="'/free/' + data.fno" class="btn btn-lg btn-primary mt-xl-6">자세히
                          알아보기</router-link>
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
import FreeDataService from "@/services/FreeDataService";

export default {
  data() {
    return {
      free: [],
      currentFree: null,
      searchKeyword: "",
      searchSelect: "작성자",

      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 10, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      pageSizes: [3, 6, 9], // select box 에 넣을 기본 데이터
    };
  },
  methods: {
  
    // axios , 모든 정보 조회 요청 함수
    retrieveFree() {
      FreeDataService.getAll(
        this.searchSelect, // select box 선택된 값
        this.searchKeyword, // 검색어
        this.page - 1,
        this.pageSize
      )
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          const { free, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.free = free; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // select box 값 변경시 실행되는 함수(재조회)
    handlePageSizeChange(event) {
      this.pageSize = event.target.value; // 한페이지당 개수 저장(3, 6, 9)
      this.page = 1;
      // 재조회 함수 호출
      this.retrieveFree();
    },
    // 페이지 번호 변경시 실행되는 함수(재조회)
    handlePageChange(value) {
      this.page = value; // 매개변수값으로 현재페이지 변경
      // 재조회 함수 호출
      this.retrieveFree();
    },
    // 조회수 증가 함수
    countViews(fno) {
      FreeDataService.plusViews(fno)
        .then((response) => {
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    }
  },

  computed: {
    // 현재 유저
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },

    // 관리자 접속인지 아닌지 확인하는 함수
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        // if ROLE_ADMIN 있으면 true
        //               없으면 false
        return this.currentUser.roles.includes("ROLE_ADMIN");
      }
      // currentUser 없으면 false (메뉴가 안보임)
      return false;
    },
    showAddBoard() {
      if (this.currentUser && this.currentUser.roles) {
        // if (ROLE_ADMIN || ROLE_USER) 로그인이 되어있다면 관리자거나 일반유저이므로 푸드컬럼 페이지로 바로 이동
        return (
          (this.currentUser.roles.includes("ROLE_ADMIN") ||
            this.currentUser.roles.includes("ROLE_USER"))
        );
      }
      // 로그인이 되어있지 않다면 로그인이 필요한 항목이라고 표시
      return false;
    },

  },

  // 화면이 뜨자마자 실행되는 이벤트(라이프 사이클 함수) : mounted(), created()
  mounted() {
    this.retrieveFree(); // 화면 로딩시 전체 조회함수 실행
  },
};
</script>

<style>

</style>
