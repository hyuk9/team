<template>
  <div>
    <div class="pt-5 pb-5" id="myReview">
      <div class="mx-auto text-center mb-5">
        <h5 class="fw-bold fs-3 fs-lg-5 lh-sm">내가 쓴 리뷰 목록</h5>
      </div>
      <div class="untree_co-section">
        <div class="container" data-aos="fade-left" data-aos-delay="200">
          <div class="row">
            <div class="col-lg-10 mx-auto text-center">
              <table class="table">
                <thead>
                  <tr>
                    <!-- <th scope="col">Last Name</th> -->
                    <th scope="col">가게</th>
                    <th scope="col">리뷰</th>
                    <th scope="col">평점</th>
                    <th scope="col">사진</th>
                    <th scope="col">수정하기</th>
                  </tr>
                </thead>
                <tbody v-for="(data, index) in review" :key="index">
                  <tr>
                    <td class="align-middle">{{ data.dname }}</td>
                    <td class="align-middle">{{ data.rcontent }}</td>
                    <td class="align-middle">{{ data.rating }}</td>
                    <td>
                      <img :src="data.photo" alt="" style="height: 100px" />
                    </td>
                    <td class="align-middle">
                      <router-link to=""
                        ><span class="badge rounded-pill bg-success"
                          >수정하기</span
                        ></router-link
                      >
                    </td>
                  </tr>
                </tbody>
              </table>

              <!--    Todo : page 바 시작 -->
              <div class="overflow-auto offset-5 mt-5">
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
              <!--    Todo : page 바 끝 -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import ReviewDataService from "@/services/ReviewDataService";

export default {
  data() {
    return {
      review: [],
      currentData: null,
      currentIndex: -1,

      page: 1,
      count: 0,
      pageSize: 10,
    };
  },

  methods: {
    //  리뷰목록 조회하는 함수
    retrieveReview() {
      ReviewDataService.getId(this.currentUser.id, this.page - 1, this.pageSize)
        .then((response) => {
          const { review, totalItems } = response.data;
          this.review = review;
          this.count = totalItems;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    handlePageChange(value) {
      this.page = value;
      this.retrieveReview();
    },
    handlePageSizeChange(event) {
      this.pageSize = event.target.value;
      this.page = 1;
      this.retrieveReview();
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
    this.retrieveReview();
  },
};
</script>

<style></style>
