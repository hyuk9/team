<template>
  <div>
    <div class="container mt-2 mb-2">
      <h1> {{ currentUser.username }} </h1>
      <h1> {{ currentUser.id }} </h1>
      <h1> {{ currentUser.email }} </h1>
      <h1> {{ currentUser.roles }} </h1>
      <h1> {{ currentUser.accessToken.substring(0, 20) }} </h1>
      <h1> {{ currentUser.accessToken.substr(currentUser.accessToken.length - 20) }}</h1>
      <!-- 여기까진 출력가능한데 다음부턴 출력이 안됨. 이유가 뭐지? -->
      <!-- 웹토큰에 저장되어있는게 토큰 / email / id / roles / username 뿐이라서 -->
      <h1> {{ currentUser.birthday }} </h1>
      <h1> {{ currentUser.name }} </h1>
      <h1> {{ currentUser.gender }} </h1>
      <h1> {{ currentUser.phone }} </h1>
      
      <table class="table">
        <thead>
          <tr>
            <th scope="col">번호</th>
            <th scope="col">아이디</th>
            <th scope="col">이름</th>
            <th scope="col">이메일</th>
            <th scope="col">권한</th>
            <th scope="col">편집</th>
          </tr>
        </thead>
        <tbody v-for="(data, index) in user" :key="index">
          <tr>
            <td>{{ data.id }}</td>
            <td>{{ data.username }}</td>
            <td>{{ data.name }}</td>
            <td>{{ data.email }}</td>
            <td>{{ data.rname }}</td>
            <td>
              <router-link :to="'/user/' + data.id"><span class="badge bg-success">수정하기</span></router-link>
            </td>
          </tr>
        </tbody>
      </table>

      <b-pagination class="offset-5" v-model="page" :total-rows="count" :per-page="pageSize" pills first-text="<<"
        last-text=">>" prev-text="Prev" next-text="Next" @change="handlePageChange"></b-pagination>
    </div>

    <!-- search 관련 div 시작 -->
    <div class="col-md-8 offset-2">
      <div class="input-group mb-3 offset-1">
        <!--            Todo : 수정 시작 -->
        <!--    Todo : page 바 시작 -->
        <div class="col-2">
          <select class="form-select" v-model="pageSize" @change="handlePageSizeChange($event)">
            <option v-for="size in pageSizes" :key="size" :value="size">
              {{ size }}
            </option>
          </select>
        </div>
        <!-- Todo : page 바 끝 -->
        <div class="col-6">
          <input type="text" class="form-control" placeholder="Search by Username" v-model="searchUsername" />
        </div>
        <div class="input-group-append">
          <button class="btn btn-warning" type="button" @click="
  page = 1;
retrieveUser();
          ">
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
import UserDataService from "../../services/UserDataService";

export default {
  data() {
    return {
      user: [],
      // dname: "", ->(변경) searchUsername: "",
      searchUsername: "", // 부서명

      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 9, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      pageSizes: [3, 6, 9], // select box 에 넣을 기본 데이터
    };
  },
  methods: {
    retrieveUser() {
      UserDataService.getAll(this.searchUsername, this.page - 1, this.pageSize)
        .then((response) => {
          const { user, totalItems } = response.data;
          this.user = user;
          this.count = totalItems;

          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
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
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },
  },

  mounted() {
    this.retrieveUser();
  },
};
</script>