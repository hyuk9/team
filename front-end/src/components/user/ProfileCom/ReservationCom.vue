<template>
  <div>
    <div class="pt-5 pb-5" id="reservationCheck">
      <div class="mx-auto text-center mb-5">
        <h5 class="fw-bold fs-3 fs-lg-5 lh-sm">내 예약</h5>
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
                    <th scope="col">위치</th>
                    <th scope="col">예약자명</th>
                    <th scope="col">인원수</th>
                    <th scope="col">연락처</th>
                    <th scope="col">예약날짜</th>
                    <th scope="col">예약시간</th>
                    <th scope="col">변경하기</th>
                  </tr>
                </thead>
                <tbody v-for="(data, index) in reservation" :key="index">
                  <!-- <tr @click="setActive(data, index)"> -->
                  <tr>
                    <td>{{ data.dname }}</td>
                    <td>{{ data.loc }}</td>
                    <td>{{ data.rname }}</td>
                    <td>{{ data.rcount }}</td>
                    <td>{{ data.phone }}</td>
                    <td>{{ data.rdate }}</td>
                    <td>{{ data.rtime }}</td>
                    <td>
                      <router-link :to="'/reservation/' + data.rid"
                        ><span class="badge rounded-pill bg-success"
                          >변경하기</span
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
                  pills
                  @change="handlePageChange"
                ></b-pagination>
              </div>
              <!--    Todo : page 바 끝 -->

              <!-- search 관련 div 시작 -->
              <!-- <div class="col-md-6 offset-3 pt-5">
                <div class="input-group mb-3">
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Search by Name"
                    v-model="searchName"
                  />
                  <div class="input-group-append">
                    <button
                      class="btn btn-primary"
                      type="button"
                      @click="
                        page = 1;
                        retrieveReservation();
                      "
                    >
                      Search
                    </button>
                  </div>
                </div>
              </div> -->
              <!-- search 관련 div 끝 -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import ReservationDataService from "@/services/ReservationDataService";

export default {
  data() {
    return {
      reservation: [],
      currentData: null,
      currentIndex: -1,
      message: "", // 서버쪽 메세지를 저장할 변수

      page: 1,
      count: 0,
      pageSize: 10,

      // pageSizes: [3, 6, 9],
    };
  },
  methods: {
    // 예약목록 조회하는 함수
    retrieveReservation() {
      ReservationDataService.getId(
        this.currentUser.id,
        this.page - 1,
        this.pageSize
      )
        .then((response) => {
          const { reservation, totalItems } = response.data;
          this.reservation = reservation;
          this.count = totalItems;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    handlePageChange(value) {
      this.page = value;
      this.retrieveReservation();
    },
    handlePageSizeChange(event) {
      this.pageSize = event.target.value;
      this.page = 1;
      this.retrieveReservation();
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
  // 화면이 뜨자마자 실행되는 이벤트
  mounted() {
    this.retrieveReservation();
  },
};
</script>

<style></style>
