<template>
  <div>
    <section>
      <div class="untree_co-section">
        <div class="container" data-aos="fade-left" data-aos-delay="200">
          <div class="row">
            <div class="col-lg-10 mx-auto text-center">
              <table class="table">
                <thead>
                  <tr>
                    <th scope="col">번호</th>
                    <th scope="col">식당</th>
                    <th scope="col">위치</th>
                    <th scope="col">이름</th>
                    <th scope="col">인원수</th>
                    <th scope="col">연락처</th>
                    <th scope="col">예약날짜</th>
                    <th scope="col">예약시간</th>
                    <th scope="col">Actions</th>
                  </tr>
                </thead>
                <tbody v-for="(data, index) in reservation" :key="index">
                  <tr>
                    <td>{{ data.rid }}</td>
                    <td>{{ data.dname }}</td>
                    <td>{{ data.loc }}</td>
                    <td>{{ data.rname }}</td>
                    <td>{{ data.rcount }}</td>
                    <td>
                      {{ data.phone }}
                    </td>
                    <td>{{ data.rdate }}</td>
                    <td>{{ data.rtime }}</td>
                    <td>
                      <router-link :to="'/reservation/' + data.rid"
                        ><span class="badge bg-success">Edit</span></router-link
                      >
                    </td>
                  </tr>
                </tbody>
              </table>

              <!--    Todo : page 바 시작 -->
              <div class="col-md-8 offset-4 pt-5">
                <b-pagination
                  v-model="page"
                  :total-rows="count"
                  :per-page="pageSize"
                  prev-text="Prev"
                  next-text="Next"
                  @change="handlePageChange"
                ></b-pagination>
              </div>
              <!--    Todo : page 바 끝 -->

              <!-- search 관련 div 시작 -->
              <div class="col-md-6 offset-3 pt-5">
                <div class="input-group mb-3">
                  <!-- Todo : 수정 시작 -->
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
                  <!-- Todo : 수정 끝 -->
                </div>
              </div>
              <!-- search 관련 div 끝 -->
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import ReservationDataService from "@/services/ReservationDataService";

export default {
  data() {
    return {
      reservation: [],
      searchName: "",
      currentData: null,
      currentIndex: -1,

      page: 1,
      count: 0,
      pageSize: 10,
    };
  },
  methods: {
    // TODO: 전체 예약 조회 함수요청
    retrieveReservation() {
      ReservationDataService.getAll(
        this.searchName,
        this.page - 1,
        this.pageSize
      )
        .then((response) => {
          const { reservation, totalItems } = response.data;
          this.reservation = reservation;
          this.count = totalItems;
          console.log("전체 예약 조회 성공 : ", response.data);
        })
        .catch((e) => {
          console.log("전체 예약 조회 실패 : ", e);
        });
    },

    // TODO: 페이지 관련 함수 시작
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
    // TODO: 페이지 관련 함수 끝
  },
  mounted() {
    this.retrieveReservation();
  },
};
</script>

<style lang="scss" scoped></style>
