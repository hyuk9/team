<template>
  <div>
    <div class="container mt-2 mb-2">
      <table class="table">
        <thead>
          <tr>
            <th scope="col">번호</th>
            <th scope="col">아이디</th>
            <th scope="col">이름</th>
            <th scope="col">이메일</th>
            <th scope="col">권한</th>
            <th scope="col" v-if="confirmAdmin">편집</th>
          </tr>
        </thead>
        <tbody v-for="(data, index) in user" :key="index">
          <tr>
            <td>{{ data.id }}</td>
            <td>{{ data.username }}</td>
            <td>{{ data.name }}</td>
            <td>{{ data.email }}</td>
            <td>{{ data.rname }}</td>
            <td v-if="confirmAdmin">
              <router-link :to="'/user/' + data.id"
                ><span class="badge bg-success">수정하기</span></router-link
              >
            </td>
          </tr>
        </tbody>
      </table>

      <b-pagination
        class="offset-5"
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
      <div class="input-group mb-3 offset-1">
        <!--            Todo : 수정 시작 -->
        <!--    Todo : page 바 시작 -->
        <div class="col-2">
          <select
            class="form-select"
            v-model="pageSize"
            @change="handlePageSizeChange($event)"
          >
            <option v-for="size in pageSizes" :key="size" :value="size">
              {{ size }}
            </option>
          </select>
        </div>
        <!-- Todo : page 바 끝 -->
        <div class="col-6">
          <input
            type="text"
            class="form-control"
            placeholder="검색어를 입력해주세요"
            v-model="searchUsername"
          />
        </div>
        <div class="input-group-append">
          <button
            class="btn btn-warning"
            type="button"
            @click="
              page = 1;
              retrieveUser();
            "
          >
            Search
          </button>
        </div>
        <!--            Todo : 수정 끝 -->
      </div>
    </div>
    <!-- search 관련 div 끝 -->
  </div>
</template>

<script>
import UserDataService from "@/services/UserDataService";

export default {
  data() {
    return {
      user: [],
      searchUsername: "", // 부서명

      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 9, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      pageSizes: [3, 6, 9], // select box 에 넣을 기본 데이터
    };
  },
  methods: {
    // TODO: 전체 유저정보 조회요청하는 함수
    retrieveUser() {
      UserDataService.getAll(this.searchUsername, this.page - 1, this.pageSize)
        .then((response) => {
          const { user, totalItems } = response.data;
          this.user = user;
          this.count = totalItems;
          console.log("전체 유저정보 조회 성공 : ", response.data);
        })
        .catch((e) => {
          console.log("전체 유저정보 조회 실패 : ", e);
        });
    },

    handlePageSizeChange(event) {
      this.pageSize = event.target.value;
      this.page = 1;
      this.retrieveUser();
    },

    handlePageChange(value) {
      this.page = value;
      this.retrieveUser();
    },
  },

  computed: {
    // TODO: 현재 유저
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },

    // TODO: 관리자 접속인지 아닌지 확인하는 함수
    confirmAdmin() {
      if (this.currentUser && this.currentUser.roles) {
        // if ROLE_ADMIN 있으면 true
        //               없으면 false
        return this.currentUser.roles.includes("ROLE_ADMIN");
      }
      // currentUser 없으면 false (메뉴가 안보임)
      return false;
    },
  },

  mounted() {
    this.retrieveUser();
  },
};
</script>