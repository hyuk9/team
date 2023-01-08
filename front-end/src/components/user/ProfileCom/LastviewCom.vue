<template>
  <div>
    <div
      v-for="(data, index) in lastview"
      :key="index"
      class="col-lg-6 p-1 d-inline-block"
    >
      <router-link :to="'/diner/' + data.dno">
        <a @click="countViews(data.dno)">
          <div class="">
            <img class="img-fluid rounded-1" :src="data.mainphoto" alt="..." />

            <div class="d-flex align-items-center">
              <div class="flex-1 ms-3 namescore">
                <p class="mb-0 mt-1 dinername" style="font-size: 20px">
                  {{ data.dname }}
                </p>
              </div>
            </div>
            <div class="ms-3">
              <span
                class="badge bg-success text-decoration-none link-light me-2"
                href="#!"
                >{{ data.menu }}</span
              >
              <span
                class="badge bg-warning text-decoration-none link-light me-2"
                href="#!"
                >{{ data.theme }}</span
              >
              <span
                class="badge bg-danger text-decoration-none link-light"
                href="#!"
                >{{ data.score }}</span
              >
            </div>
          </div>
        </a>
      </router-link>
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
      pageSize: 8,
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
