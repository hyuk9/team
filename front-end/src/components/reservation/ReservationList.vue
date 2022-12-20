<template>
  <div>
    <!-- 최상단 시작 -->
    <section class="py-5 overflow-hidden bg-warning" id="home">
      <div class="container">
        <div class="row flex-center">
          <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
            <!-- <a class="img-landing-banner" href="#!"
              ><img
                class="img-fluid"
                src="@/assets/img/species/korean.jpg"
                alt="hero-header"
            /></a> -->
          </div>
          <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
            <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">
              여기는 예약확인 <br />
              페이지 입니다
            </h1>
            <h1 class="text-800 mb-5 fs-4">최상단만 제작</h1>
          </div>
        </div>
      </div>
    </section>
    <!-- 최상단 끝 -->

    <div class="untree_co-section">
      <div class="container" data-aos="fade-left" data-aos-delay="200">
        <div class="row">
          <div class="col-lg-6 mx-auto text-center">
            <!-- search 관련 div 시작 -->
            <div class="col-md-8 offset-2">
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
                    class="btn btn-outline-secondary"
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

            <!--    Todo : page 바 시작 -->
            <div class="col-md-8 offset-4">
              <div class="mb-3">
                Items per Page:
                <select
                  v-model="pageSize"
                  @change="handlePageSizeChange($event)"
                >
                  <option v-for="size in pageSizes" :key="size" :value="size">
                    <!--            size : 3, 6, 9 -->
                    {{ size }}
                  </option>
                </select>
              </div>
            </div>
            <!--    Todo : page 바 끝 -->

            <table class="table">
              <thead>
                <tr>
                  <!-- <th scope="col">Last Name</th> -->
                  <th scope="col">식당</th>
                  <th scope="col">이름</th>
                  <th scope="col">전화번호</th>
                  <th scope="col">예약날짜</th>
                  <th scope="col">예약시간</th>
                  <th scope="col">예약가능여부</th>
                </tr>
              </thead>
              <tbody v-for="(data, index) in reservation" :key="index">
                <tr @click="setActive(data, index)">
                  <td>{{ data.restaurant }}</td>
                  <td>{{ data.name }}</td>
                  <td>{{ data.phone }}</td>
                  <td>{{ data.reservationDate }}</td>
                  <td>{{ data.reservationTime }}</td>
                  <td>{{ data.reservationYn }}</td>
                </tr>
              </tbody>
            </table>

            <!--    Todo : page 바 시작 -->
            <div class="col-md-8 offset-3">
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
          </div>

          <div v-if="currentData" class="col-lg-5 ml-auto">
            <div class="quick-contact-item d-flex align-items-center mb-4">
              <span class="flaticon-house"></span>
              <address class="text">
                {{ this.currentData.address }}
              </address>
            </div>
            <div class="quick-contact-item d-flex align-items-center mb-4">
              <span class="flaticon-phone-call"></span>
              <address class="text">{{ this.currentData.phone }}</address>
            </div>
            <div class="quick-contact-item d-flex align-items-center mb-4">
              <span class="flaticon-mail"></span>
              <address class="text">{{ this.currentData.email }}</address>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ReservationDataService from "../../services/ReservationDataService";

export default {
  data() {
    return {
      reservation: [],
      searchName: "",
      currentData: null,
      currentIndex: -1,

      page: 1,
      count: 0,
      pageSize: 3,

      pageSizes: [3, 6, 9],
    };
  },
  methods: {
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
  mounted() {
    this.retrieveReservation();
  },
};
</script>

<style></style>
