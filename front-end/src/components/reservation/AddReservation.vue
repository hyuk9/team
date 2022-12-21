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
              여기는 예약 추가 <br />
              페이지 입니다
            </h1>
            <h1 class="text-800 mb-5 fs-4">최상단만 제작</h1>
          </div>
        </div>
      </div>
    </section>
    <!-- 최상단 끝 -->
    <section>
      <div class="untree_co-section">
        <div class="container" data-aos="fade-left" data-aos-delay="200">
          <div class="row">
            <div class="col-lg-6 mx-auto">
              <!-- TODO:  -->
              <div class="submit-form">
                <div v-if="!submitted">
                  <!-- <form> -->
                  <div class="form-group">
                    <label for="restaurant">가게 이름</label>
                    <input
                      type="text"
                      class="form-control"
                      id="restaurant"
                      required
                      v-model="reservation.restaurant"
                      name="restaurant"
                    />
                  </div>

                  <div class="form-group">
                    <label for="rname">예약자 성함</label>
                    <input
                      type="text"
                      class="form-control"
                      id="rname"
                      required
                      v-model="reservation.rname"
                      name="rname"
                    />
                  </div>

                  <div class="form-group">
                    <label for="rcount">인원수</label>
                    <select
                      class="form-control"
                      required
                      v-model="reservation.rcount"
                    >
                      <option>2</option>
                      <option>3</option>
                      <option>4</option>
                      <option>5</option>
                      <option>6</option>
                      <option>7</option>
                      <option>8</option>
                      <option>9</option>
                      <option>10</option>
                    </select>
                  </div>

                  <div class="form-group">
                    <label for="phone">연락처</label>
                    <input
                      type="text"
                      class="form-control"
                      id="phone"
                      required
                      v-model="reservation.phone"
                      name="phone"
                    />
                  </div>

                  <div class="form-group">
                    <label for="reservationDate">예약 날짜</label>
                    <input
                      type="date"
                      class="form-control"
                      id="reservationDate"
                      required
                      v-model="reservation.reservationDate"
                      name="reservationDate"
                    />
                  </div>

                  <div class="form-group">
                    <label for="reservationTime">예약 시간</label>
                    <input
                      type="time"
                      class="form-control"
                      id="reservationTime"
                      required
                      v-model="reservation.reservationTime"
                      name="reservationTime"
                    />
                  </div>

                  <div class="text-center mt-5">
                    <button @click="saveReservation" class="btn btn-primary">
                      확인
                    </button>
                  </div>
                  <!-- </form> -->
                </div>

                <!-- <div v-else>
                <h4>You submitted successfully!</h4>
                <button class="btn btn-success" @click.prevent="newReservation">
                  Add
                </button>
              </div> -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import ReservationDataService from "../../services/ReservationDataService";

export default {
  data() {
    return {
      reservation: {
        rid: null,
        restaurant: "",
        rname: "",
        rcount: "",
        phone: "",
        reservationDate: "",
        reservationTime: "",
        reservationYn: "",
      },
      daterange: "",
      submitted: false,
    };
  },
  methods: {
    saveReservation() {
      let data = {
        restaurant: this.reservation.restaurant,
        rname: this.reservation.rname,
        rcount: this.reservation.rcount,
        phone: this.reservation.phone,
        reservationDate: this.reservation.reservationDate,
        reservationTime: this.reservation.reservationTime,
      };

      ReservationDataService.create(data)
        .then((response) => {
          this.reservation.rid = response.data.rid;
          console.log(response.data);
          alert("추가 성공!");
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /reservation
          this.$router.push("/reservation");
          // this.submitted = true;
        })
        .catch((e) => {
          console.log(e);
        });
    },

    newReservation() {
      this.submitted = false;
      this.reservation = {};
    },
  },
  mounted() {},
};
</script>

<style></style>
