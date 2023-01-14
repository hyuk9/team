<template>
  <div>
    <!-- TODO FAQ리스트 시작 -->
    <div class="container mt-3 mb-2">
      <h1 class="text-center"><i class="bi bi-chat-square-text-fill"> 자주 묻는 질문</i></h1>
      <div style="text-align: center">
        <div class="p-3 mb-2 bg-warning text-dark bg-opacity-25 mt-3">
          <strong
            >"FAQ를 통해서 원하는 답변을 쉽고 빠르게 찾아보세요"
            <br />
            "맛있는 토마토 관련 질문 중 가장 빈도 수가 높은 질문들을 모아,
            친절한 답변과 함께 제공해드리고 있습니다."
          </strong>
        </div>
      </div>

      <!-- TODO: 아코디언으로 FAQ 구현 -->
      <div class="accordion accordion-flush" id="accordionFlushExample">
        <div class="accordion-item" v-for="(data, index) in faq" :key="index">
          <h2 class="accordion-header" id="flush-headingOne">
            <button
              class="accordion-button collapsed"
              type="button"
              data-bs-toggle="collapse"
              :data-bs-target="'#flush-' + index"
              aria-expanded="false"
              aria-controls="flush-0"
            >
              <i class="bi bi-pin-fill"></i>
              {{ data.title }}
            </button>
          </h2>
          <div
            :id="'flush-' + index"
            class="accordion-collapse collapse"
            aria-labelledby="flush-headingOne"
            data-bs-parent="#accordionFlushExample"
          >
            <div class="accordion-body">
              {{ data.content }}
              <div class="offset-11" v-if="showAdminBoard">
                <router-link :to="'/faq/' + data.no"
                  ><span class="badge rounded-pill bg-danger text-dark"
                    >수정</span
                  ></router-link
                >
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- TODO: 어드민 한테만 보이는 추가 버튼 -->
      <router-link class="offset-11 mt-3" to="/add-faq/">
        <button type="button" class="btn btn-danger" v-if="showAdminBoard">
          추가
        </button>
      </router-link>
      <div class="overflow-auto offset-5">
        <b-pagination
          v-model="page"
          :total-rows="count"
          :per-page="pageSize"
          pills
          first-text="<<"
          last-text=">>"
          prev-text="Prev"
          next-text="Next"
          @change="handlePageChange"
        ></b-pagination>
      </div>
      <!-- search 관련 div 시작 -->
      <div class="col-md-8 offset-2">
        <div class="input-group">
          <!-- select box 추가 : v-model="searchSelect" -->
          <div class="col-3">
            <select class="form-select" v-model="searchSelect">
              <option>제목</option>
              <option>내용</option>
            </select>
          </div>

          <!-- searchDname -> searchKeyword 변경 -->
          <div class="col-7">
            <input
              type="text"
              class="form-control"
              placeholder="검색어를 입력해주세요"
              v-model="searchKeyword"
            />
          </div>

          <div class="input-group-append col-2">
            <button
              type="button"
              class="btn btn-warning"
              @click="
                page = 1;
                retrieveFaq();
              "
            >
              <i class="bi bi-search"></i>
            </button>
          </div>
          <!--            Todo : 수정 끝 -->
        </div>
      </div>
      <!-- search 관련 div 끝 -->
    </div>
    <!-- TODO FAQ리스트 끝 -->
  </div>
</template>

<script>
import FaqDataService from "@/services/FaqDataService";
export default {
  data() {
    return {
      faq: [],
      searchKeyword: "",
      searchSelect: "제목",

      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 10, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      pageSizes: [3, 6, 9], // select box 에 넣을 기본 데이터전송됨
    };
  },
  methods: {
    // TODO: 모든 FAQ 정보 조회요청하는 함수
    retrieveFaq() {
      FaqDataService.getAll(
        this.searchSelect, // select box 선택된 값
        this.searchKeyword, // 검색어
        this.page - 1,
        this.pageSize
      )
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          const { faq, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.faq = faq; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)
          // 디버깅 콘솔에 정보 출력
          console.log("모든 FAQ 정보 조회요청 성공 : ", response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log("모든 FAQ 정보 조회요청 실패 : ", e);
        });
    },
    // select box 값 변경시 실행되는 함수(재조회)
    handlePageSizeChange(event) {
      this.pageSize = event.target.value; // 한페이지당 개수 저장(3, 6, 9)
      this.page = 1;
      // 재조회 함수 호출
      this.retrieveFaq();
    },
    // 페이지 번호 변경시 실행되는 함수(재조회)
    handlePageChange(value) {
      this.page = value; // 매개변수값으로 현재페이지 변경
      // 재조회 함수 호출
      this.retrieveFaq();
    },
  },

  computed: {
    // TODO: 현재 유저정보 조회
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },

    // TODO: 관리자 접속인지 아닌지 확인하는 함수
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        // if ROLE_ADMIN 있으면 true
        //               없으면 false
        return this.currentUser.roles.includes("ROLE_ADMIN");
      }
      // currentUser 없으면 false (메뉴가 안보임)
      return false;
    },
  },

  // 화면이 뜨자마자 실행되는 이벤트(라이프 사이클 함수) : mounted(), created()
  mounted() {
    this.retrieveFaq(); // 화면 로딩시 전체 조회함수 실행
  },
};
</script>

<style></style>
