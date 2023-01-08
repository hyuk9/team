<template>
  <div>
    <div class="pt-5 pb-5">
      <div class="mx-auto text-center mb-5">
        <h5 class="fw-bold fs-3 fs-lg-5 lh-sm">최근 본 가게</h5>
      </div>
      <!-- todo -->
      <div>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">가게</th>
              <th scope="col">가게전화번호</th>
              <th scope="col">위치</th>
              <th scope="col">사진</th>
              <th scope="col">가게dno</th>
              <th scope="col">조회시간</th>
              <th scope="col">더보기</th>
            </tr>
          </thead>
          <tbody v-for="(data, index) in lastview" :key="index">
            <tr>
              <td class="align-middle">{{ data.dname }}</td>
              <td class="align-middle">{{ data.phone }}</td>
              <td class="align-middle">{{ data.loc }}</td>
              <td>
                <img :src="data.mainphoto" alt="" style="height: 100px" />
              </td>
              <td class="align-middle">{{ data.dno }}</td>
              <td class="align-middle">{{ data.it }}</td>
              <td class="align-middle">
                <router-link :to="'/diner/' + data.dno"
                  ><span class="badge rounded-pill bg-warning"
                    >더보기</span
                  ></router-link
                >
              </td>
            </tr>
          </tbody>
        </table>

        <!--    Todo : page 바 시작 -->
        <!-- <div class="overflow-auto offset-5 mt-5">
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
        </div> -->
        <!--    Todo : page 바 끝 -->
      </div>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import LastviewDataService from "@/services/LastviewDataService";

export default {
  data() {
    return {
      lastview: [],
      currentData: null,
      currentIndex: -1,

      page: 1,
      count: 0,
      pageSize: 5,
    };
  },
  methods: {
    retrieveLastview() {
      LastviewDataService.getId(
        this.currentUser.id,
        this.page - 1,
        this.pageSize
      )
        .then((response) => {
          const { lastview, totalItems } = response.data;
          this.lastview = lastview;
          this.count = totalItems;

          console.log("성공시 최근 본 가게 데이터 : ", response.data);
        })
        .catch((e) => {
          console.log("실패시", e);
        });
    },

    handlePageChange(value) {
      this.page = value;
      this.retrieveLastview();
    },
    handlePageSizeChange(event) {
      this.pageSize = event.target.value;
      this.page = 1;
      this.retrieveLastview();
    },
    setActive(data, index) {
      console.log(data);
      this.currentData = data;
      this.currentIndex = index;
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
    this.retrieveLastview();
  },
};
</script>

<style></style>
