<template>
  <div>
    <!-- TODO: announce 시작 -->
    <!-- Contact Start -->
    <div class="container mt-3 mb-3">
      <h1 class="text-center"><i class="bi bi-megaphone-fill"> 공지사항</i></h1>
      <div style="text-align: center">
        <div class="p-3 mb-2 bg-warning text-dark bg-opacity-25 mt-3">
          <strong
            >"공지사항를 통해서 맛있는 토마토의 최신정보를 찾아보세요"
            <br />
            "맛있는 토마토의 최신 정보와 공지를 모아서 한번에 찾아볼 수
            있습니다.
          </strong>
        </div>
      </div>
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
                style="width: 30%"
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
              <!-- 조회수 제목 -->
              <th
                class="table-active text-center"
                style="width: 10%"
                scope="col"
              >
                조회수
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
          <tbody v-for="(data, index) in announce" :key="index">
            <tr>
              <td class="text-center">
                <i class="bi bi-hash"></i>{{ data.aid }}
              </td>
              <td class="text-center">
                <!-- 기존 링크안에 조회수 증가용 함수 a 태그 추가 -->
                <router-link :to="'/announceview/' + data.aid"
                  ><a @click="countViews(data.aid)"
                    ><span>{{ data.title }}</span></a
                  ></router-link
                >
              </td>
              <td class="text-center">{{ data.writer }}</td>
              <td class="text-center">
                <i class="bi bi-calendar-date"></i>
                {{ data.insertTime.split(" ")[0] }}
              </td>
              <!-- 조회수 보여주기 -->
              <td class="text-center">{{ data.views }}</td>
              <td v-if="showAdminBoard">
                <router-link :to="'/announce/' + data.aid"
                  ><span class="badge rounded-pill bg-warning text-dark"
                    >수정</span
                  ></router-link
                >
              </td>
            </tr>
          </tbody>
        </table>
        <!-- TODO: badge를 버튼으로 교체 -->
        <div v-if="showAdminBoard">
          <router-link class="offset-11" to="/add-announce/">
            <button type="button" class="btn btn-warning btn-sm">글쓰기</button>
          </router-link>
        </div>
      </div>
      <div class="overflow-auto offset-5">
        <b-pagination
          v-model="page"
          :total-rows="count"
          pills
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
              <option>작성자</option>
              <option>제목</option>
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
                retrieveAnnounce();
              "
            >
              <i class="bi bi-search"></i>
            </button>
          </div>
          <!-- Todo : 수정 끝 -->
        </div>
      </div>
      <!-- search 관련 div 끝 -->
    </div>
    <!-- Contact End -->
    <!-- TODO: announce 끝 -->
  </div>
</template>

<script>
import AnnounceDataService from "@/services/AnnounceDataService";
export default {
  data() {
    return {
      announce: [],
      searchKeyword: "",
      searchSelect: "제목",

      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 10, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수
    };
  },
  methods: {
    // TODO: 모든 공지사항 정보 조회요청하는 함수
    retrieveAnnounce() {
      AnnounceDataService.getAll(
        this.searchSelect, // select box 선택된 값
        this.searchKeyword, // 검색어
        this.page - 1,
        this.pageSize
      )
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          const { announce, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.announce = announce; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)
          // 디버깅 콘솔에 정보 출력
          console.log("모든 공지사항 정보 조회요청 성공 : ", response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log("모든 공지사항 정보 조회요청 실패 : ", e);
        });
    },
    // select box 값 변경시 실행되는 함수(재조회)
    handlePageSizeChange(event) {
      this.pageSize = event.target.value; // 한페이지당 개수 저장(3, 6, 9)
      this.page = 1;
      // 재조회 함수 호출
      this.retrieveAnnounce();
    },
    // 페이지 번호 변경시 실행되는 함수(재조회)
    handlePageChange(value) {
      this.page = value; // 매개변수값으로 현재페이지 변경
      // 재조회 함수 호출
      this.retrieveAnnounce();
    },

    // TODO: 조회수 증가 함수
    countViews(aid) {
      AnnounceDataService.plusViews(aid)
        .then((response) => {
          // 디버깅 콘솔에 정보 출력
          console.log("조회수 증가 성공 : ", response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log("조회수 증가 실패 : ", e);
        });
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
    this.retrieveAnnounce(); // 화면 로딩시 전체 조회함수 실행
  },
};
</script>

<style>
</style>