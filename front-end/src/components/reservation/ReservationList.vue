<template>
  <div>
    <section>
      <div class="untree_co-section">
        <div class="container" data-aos="fade-left" data-aos-delay="200">
          <div class="row">
            <div class="col-lg-10 mx-auto text-center">
              <!--    Todo : page 바 시작 -->
              <!-- <div class="col-md-8 offset-4">
              <div class="mb-3">
                Items per Page:
                <select
                  v-model="pageSize"
                  @change="handlePageSizeChange($event)"
                >
                  <option v-for="size in pageSizes" :key="size" :value="size"> -->
              <!--            size : 3, 6, 9 -->
              <!-- {{ size }}
                  </option>
                </select>
              </div>
             </div> -->
              <!--    Todo : page 바 끝 -->

              <table class="table">
                <thead>
                  <tr>
                    <!-- <th scope="col">Last Name</th> -->
                    <th scope="col">번호</th>
                    <th scope="col">식당</th>
                    <th scope="col">이름</th>
                    <th scope="col">인원수</th>
                    <th scope="col">연락처</th>
                    <th scope="col">예약날짜</th>
                    <th scope="col">예약시간</th>
                    <th scope="col">Actions</th>
                  </tr>
                </thead>
                <tbody v-for="(data, index) in reservation" :key="index">
                  <!-- <tr @click="setActive(data, index)"> -->
                  <tr>
                    <td>{{ data.rid }}</td>
                    <td>{{ data.restaurant }}</td>
                    <td>{{ data.rname }}</td>
                    <td>{{ data.rcount }}</td>
                    <td>
                      {{ data.phone }}
                    </td>
                    <td>{{ data.reservationDate }}</td>
                    <td>{{ data.reservationTime }}</td>
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

            <!-- <div v-if="currentData" class="col-lg-5 ml-auto">
              <div class="quick-contact-item d-flex align-items-center mb-4">
                <span class="flaticon-house"></span>
                <address class="text">
                  {{ this.currentData.restaurant }}
                </address>
              </div>
              <div class="quick-contact-item d-flex align-items-center mb-4">
                <span class="flaticon-phone-call"></span>
                <address class="text">{{ this.currentData.phone }}</address>
              </div>
              <div class="quick-contact-item d-flex align-items-center mb-4">
                <span class="flaticon-mail"></span>
                <address class="text">{{ this.currentData.rname }}</address>
              </div>
            </div> -->
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

      // pageSizes: [3, 6, 9],
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

<style lang="scss" scoped></style>
