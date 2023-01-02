<template>
  <div>
    <!-- TODO: column 시작 -->
    <!-- Contact Start -->
    <div class="container mt-2 mb-2">
      <h1 class="offset-5">
        <i class="bi bi-star-fill"></i>푸드컬럼<i class="bi bi-star-fill"></i>
      </h1>
      <div style="text-align: center">
        <div class="p-3 mb-2 bg-warning text-dark bg-opacity-25">
          <strong
            >푸드컬럼 리스트
            <br />
            대충 푸드컬럼 있다는 내용
          </strong>
        </div>
      </div>

      <!--    Todo : page 바 시작 주석 처리 -->
      <!-- <div class="col-md-12 offset-2">
                <div class="mb-3">
                    Items per Page:
                    <select v-model="pageSize" @change="handlePageSizeChange($event)">
                        <option v-for="size in pageSizes" :key="size" :value="size">
                               size : 3, 6, 9 
                            {{ size }}
                        </option>
                    </select>
                </div>

                <b-pagination v-model="page" :total-rows="count" :per-page="pageSize" prev-text="Prev" next-text="Next"
                    @change="handlePageChange"></b-pagination>
            </div> -->

      <!--    Todo : page 바 끝 주석처리 -->
      <div>
        <table class="table table-hover">
          <thead>
            <tr>
              <th
                class="table-active text-center"
                style="width: 10%"
                scope="col"
              >
                번호
              </th>
              <th
                class="table-active text-center"
                style="width: 40%"
                scope="col"
              >
                제목
              </th>
              <th
                class="table-active text-center"
                style="width: 20%"
                scope="col"
              >
                작성자
              </th>
              <th
                class="table-active text-center"
                style="width: 20%"
                scope="col"
              >
                작성일
              </th>
              <th
                v-if="showAdminBoard"
                class="table-active"
                style="width: 10%"
                scope="col"
              >
                수정/삭제
              </th>
            </tr>
          </thead>
          <tbody v-for="(data, index) in column" :key="index">
            <tr>
              <td class="text-center">
                <i class="bi bi-hash"></i>{{ data.cid }}
              </td>
              <td class="text-center">
                <router-link :to="'/column/' + data.cid"
                  ><span>{{ data.columnTitle }}</span></router-link
                >
              </td>
              <td class="text-center">{{ data.columnWriter }}</td>
              <td class="text-center">
                <i class="bi bi-calendar-date"></i> {{ data.insertTime }}
              </td>
              <td v-if="showAdminBoard">
                <router-link :to="'/column/' + data.cid"
                  ><span class="badge rounded-pill bg-warning text-dark"
                    >수정</span
                  ></router-link
                >
              </td>
            </tr>
          </tbody>
        </table>

        <!-- <router-link to="/add-column/">
          <span class="badge bg-warning text-dark">추가</span>
        </router-link> -->
        <!-- TODO: badge를 버튼으로 교체 -->
        <div v-if="showLoginUser">
          <router-link class="offset-11" to="/add-column/">
            <button type="button" class="btn btn-warning btn-sm">글쓰기</button>
          </router-link>
        </div>
      </div>
      <div class="overflow-auto offset-5">
        <b-pagination
          v-model="page"
          :total-rows="count"
          :per-page="pageSize"
          first-text="<<"
          last-text=">>"
          prev-text="Prev"
          next-text="Next"
          @change="handlePageChange"
        ></b-pagination>
      </div>
      <!-- search 관련 div 시작 -->
      <div class="col-md-8 offset-2">
        <div class="input-group mb-3">
          <!-- select box 추가 : v-model="searchSelect" -->
          <div class="col-3">
            <select class="form-select" v-model="searchSelect">
              <option>제목</option>
              <option>작성자</option>
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
              class="btn btn-warning"
              type="button"
              @click="
                page = 1;
                retrieveColumn();
              "
            >
              <i class="bi bi-search"></i>
              Search
            </button>
          </div>
          <!--            Todo : 수정 끝 -->
        </div>
      </div>
      <!-- search 관련 div 끝 -->
    </div>
    <!-- Contact End -->
    <!-- TODO: column 끝 -->
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
      pageSize: 10, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      pageSizes: [3, 6, 9], // select box 에 넣을 기본 데이터
    };
  },
  methods: {
    // axios , 모든 정보 조회 요청 함수
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
    // select box 값 변경시 실행되는 함수(재조회)
    handlePageSizeChange(event) {
      this.pageSize = event.target.value; // 한페이지당 개수 저장(3, 6, 9)
      this.page = 1;
      // 재조회 함수 호출
      this.retrieveColumn();
    },
    // 페이지 번호 변경시 실행되는 함수(재조회)
    handlePageChange(value) {
      this.page = value; // 매개변수값으로 현재페이지 변경
      // 재조회 함수 호출
      this.retrieveColumn();
    },
  },

  computed: {
    // 현재 유저
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },

    // 일반유저 접속인지 아닌지 확인하는 함수
    showLoginUser() {
      if (this.currentUser && this.currentUser.roles) {
        // if ROLE_ADMIN 있으면 true
        //               없으면 false
        return this.currentUser.roles.includes("ROLE_USER");
      }
      // currentUser 없으면 false (메뉴가 안보임)
      return false;
    },
  },

  // 화면이 뜨자마자 실행되는 이벤트(라이프 사이클 함수) : mounted(), created()
  mounted() {
    this.retrieveColumn(); // 화면 로딩시 전체 조회함수 실행
  },
};
</script>

<style>
</style>