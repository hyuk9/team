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
    <!-- datepicker 시작 -->
    <div class="container-fluid px-0 px-sm-4 mx-auto">
      <div class="row justify-content-center mx-0">
        <div class="col-lg-10">
          <div class="card border-0">
            <form autocomplete="off">
              <div class="card-header bg-dark">
                <div
                  class="mx-0 mb-0 row justify-content-sm-center justify-content-start px-1"
                >
                  <input
                    type="text"
                    id="dp1"
                    class="datepicker"
                    placeholder="Pick Date"
                    name="date"
                    readonly
                  /><span class="fa fa-calendar"></span>
                </div>
              </div>
              <div class="card-body p-3 p-sm-5">
                <div class="row text-center mx-0">
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">11:00AM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">11:30AM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">12:00PM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">12:30PM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">13:00PM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">13:30PM</div>
                  </div>
                </div>
                <div class="row text-center mx-0">
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">14:00PM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">14:30PM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">15:00PM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">15:30PM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">16:00PM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">16:30PM</div>
                  </div>
                </div>
                <div class="row text-center mx-0">
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">17:00PM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">17:30PM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">18:00PM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">18:30PM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">19:00PM</div>
                  </div>
                  <div class="col-md-2 col-4 my-1 px-2">
                    <div class="cell py-1">19:30PM</div>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- datepicker 끝 -->
  </div>
</template>

<script>
/* eslint-disable */
import ReservationDataService from "../../services/ReservationDataService";

export default {
  data() {
    return {
      reservation: {
        rid: null,
        restaurant: "", // 가게명
        rname: "", // 예약자명
        rcount: "", // 인원수
        phone: "", // 연락처
        reservationDate: "", // 예약날짜
        reservationTime: "", // 예약시간
        reservationYn: "", // 예약가능여부
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
          // alert 라이브러리 효과
          this.$swal({
            icon: "success",
            title: "예약 접수 완료 \n 매장에서 빠르게 확인하겠습니다",
            showConfirmButton: true,
            confirmButtonColor: "#f4b642", // confrim 버튼 색깔 지정
            confirmButtonText: "확인", // confirm 버튼 텍스트 지정
          });
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
  mounted() {
    $(document).ready(function () {
      $(".datepicker").datepicker({
        format: "dd-mm-yyyy",
        autoclose: true,
        startDate: "0d",
      });

      $(".cell").click(function () {
        $(".cell").removeClass("select");
        $(this).addClass("select");
      });
    });
  },
};
</script>

<style>
body {
  color: #000;
  overflow-x: hidden;
  height: 100%;
  background-color: #c5cae9 !important;
  background-repeat: no-repeat;
  padding: 0px !important;
}

.container-fluid {
  padding-top: 120px !important;
  padding-bottom: 120px !important;
}

.card {
  box-shadow: 0px 4px 8px 0px #7986cb;
}

input {
  padding: 10px 20px !important;
  border: 1px solid #000 !important;
  border-radius: 10px;
  box-sizing: border-box;
  background-color: #616161 !important;
  color: #fff !important;
  font-size: 16px;
  letter-spacing: 1px;
  width: 180px;
}

input:focus {
  -moz-box-shadow: none !important;
  -webkit-box-shadow: none !important;
  box-shadow: none !important;
  border: 1px solid #512da8;
  outline-width: 0;
}

::placeholder {
  color: #fff;
  opacity: 1;
}

:-ms-input-placeholder {
  color: #fff;
}

::-ms-input-placeholder {
  color: #fff;
}

button:focus {
  -moz-box-shadow: none !important;
  -webkit-box-shadow: none !important;
  box-shadow: none !important;
  outline-width: 0;
}

.datepicker {
  background-color: #000 !important;
  color: #fff !important;
  border: none;
  padding: 10px !important;
}

.datepicker-dropdown:after {
  border-bottom: 6px solid #000;
}

thead tr:nth-child(3) th {
  color: #fff !important;
  font-weight: bold;
  padding-top: 20px;
  padding-bottom: 10px;
}

.dow,
.old-day,
.day,
.new-day {
  width: 40px !important;
  height: 40px !important;
  border-radius: 0px !important;
}

.old-day:hover,
.day:hover,
.new-day:hover,
.month:hover,
.year:hover,
.decade:hover,
.century:hover {
  border-radius: 6px !important;
  background-color: #eee;
  color: #000;
}

.active {
  border-radius: 6px !important;
  background-image: linear-gradient(#90caf9, #64b5f6) !important;
  color: #000 !important;
}

.disabled {
  color: #616161 !important;
}

.prev,
.next,
.datepicker-switch {
  border-radius: 0 !important;
  padding: 20px 10px !important;
  text-transform: uppercase;
  font-size: 20px;
  color: #fff !important;
  opacity: 0.8;
}

.prev:hover,
.next:hover,
.datepicker-switch:hover {
  background-color: inherit !important;
  opacity: 1;
}

.cell {
  border: 1px solid #bdbdbd;
  margin: 2px;
  cursor: pointer;
}

.cell:hover {
  border: 1px solid #3d5afe;
}

.cell.select {
  background-color: #3d5afe;
  color: #fff;
}

.fa-calendar {
  color: #fff;
  font-size: 30px;
  padding-top: 8px;
  padding-left: 5px;
  cursor: pointer;
}
</style>
