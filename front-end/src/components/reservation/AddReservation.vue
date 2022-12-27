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

    <!-- Form -->
    <form action="" name="form">
      <div>
        <!-- 가게 명 -->
        <div class="input__block">
          <h5>가게</h5>
          <input
            v-model="reservation.restaurant"
            v-validate="'required'"
            type="text"
            class="input"
            id="restaurant"
            name="restaurant"
          />
        </div>

        <!-- 예약자 이름 -->
        <div class="input__block">
          <h5>예약자</h5>
          <input
            v-model="reservation.rname"
            v-validate="'required'"
            type="text"
            class="input"
            id="rname"
            name="rname"
          />
        </div>

        <!-- 인원수 -->
        <div class="input__block">
          <h5>인원수</h5>
          <div class="rcountInput">
            <select required v-model="reservation.rcount">
              <option :value="index" v-for="index in 8" :key="index">
                {{ index }}
              </option>
            </select>
          </div>
        </div>

        <!-- 전화번호 -->
        <div class="input__block">
          <h5>전화번호</h5>
          <div class="phoneInput">
            <input
              v-model="reservation.phone1"
              type="text"
              class="input"
              id="phone1"
              maxlength="3"
            />
            <span class="minus">-</span>
            <input
              v-model="reservation.phone2"
              type="text"
              class="input"
              id="phone2"
              maxlength="4"
            />
            <span class="minus">-</span>
            <input
              v-model="reservation.phone3"
              type="text"
              class="input"
              id="phone3"
              maxlength="4"
            />
          </div>
        </div>

        <!-- 예약 날짜 -->
        <div class="input__block">
          <h5>예약 날짜</h5>
          <input
            v-model="reservation.reservationDate"
            v-validate="'required'"
            type="date"
            class="input"
            id="reservationDate"
            name="reservationDate"
          />
        </div>

        <!-- 예약 시간 -->
        <div class="input__block">
          <h5>예약 시간</h5>
          <input
            v-model="reservation.reservationTime"
            v-validate="'required'"
            type="time"
            class="input"
            id="reservationTime"
            name="reservationTime"
          />
        </div>

        <!-- sign in button -->
        <button @click="saveReservation" class="signin__btn mt-5">
          예약하기
        </button>
      </div>
    </form>
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
        phoneFirstPart: "", // 전화번호의 앞자리
        phoneMiddlePart: "", // 전화번호의 중간자리
        phoneLastPart: "", // 전화번호의 뒷자리
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
        phone1: this.reservation.phone1,
        phone2: this.reservation.phone2,
        phone3: this.reservation.phone3,
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

  mounted() {},
};
</script>

<style scoped>
body {
  font-family: "Montserrat", sans-serif;
  background: white;
}

/* .container {
  display: block;
  max-width: 680px;
  width: 80%;
  margin: 120px auto;
} */

/* h1 {
  color: #ffb30e;
  font-size: 48px;
  letter-spacing: -3px;
  text-align: center;
  margin-bottom: 80px;
  transition: 0.2s linear;
} */

h5 {
  display: inline-block;
  color: #ffb30e;
  margin: 30px 0 30px 30px;
  transition: 0.2s linear;
}

form {
  width: 100%;
  max-width: 680px;
  margin: 40px auto 10px;
}
form .input__block {
  margin: 20px auto;
  display: block;
  position: relative;
}
form .input__block.first-input__block::before {
  content: "";
  position: absolute;
  top: -15px;
  left: 50px;
  display: block;
  width: 0;
  height: 0;
  background: transparent;
  border-left: 15px solid transparent;
  border-right: 15px solid transparent;
  border-bottom: 15px solid rgba(15, 19, 42, 0.1);
  transition: 0.2s linear;
}
form .input__block.signup-input__block::before {
  content: "";
  position: absolute;
  top: -15px;
  left: 150px;
  display: block;
  width: 0;
  height: 0;
  background: transparent;
  border-left: 15px solid transparent;
  border-right: 15px solid transparent;
  border-bottom: 15px solid rgba(15, 19, 42, 0.1);
  transition: 0.2s linear;
}
form .input__block input {
  display: block;
  width: 90%;
  max-width: 680px;
  height: 50px;
  margin: 0 auto;
  border-radius: 8px;
  border: none;
  background: rgba(15, 19, 42, 0.1);
  /* color: #23004d; */
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  padding: 0 10px;
}
/* 셀렉트 박스 둥글게  */
form select {
  border-radius: 8px;
}

/* 인원수 입력용 */
form .rcountInput {
  display: block;
  width: 90%;
  max-width: 680px;
  height: 50px;
  margin: 0 auto;
  border-radius: 8px;
  border: none;
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  padding: 0;
}
/* 인원수 입력용 */
form .rcountInput .input {
  display: inline-block;
  width: 32%;
  margin-right: 2%;
}
/* 인원수 입력용 */
form .rcountInput select {
  width: 32%;
  height: 50px;
}
/* 인원수 입력용 */
form .rcountInput select:first-of-type {
  margin-right: 2%;
}

/* 전화번호 입력용 */
form .phoneInput {
  display: block;
  width: 90%;
  max-width: 680px;
  height: 50px;
  margin: 0 auto;
  border-radius: 8px;
  border: none;
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  padding: 0;
}

/* 전화번호 입력용 */
form .phoneInput .input {
  display: inline-block;
  width: 30%;
}
/* 전화번호 입력용 */
form .phoneInput .minus {
  display: inline-block;
  width: 5%;
  text-align: center;
}

form .input__block input:focus,
form .input__block input:active {
  outline: none;
  border: none;
  color: #0f132a;
}
form .input__block input.repeat__password {
  opacity: 0;
  display: none;
  transition: 0.2s linear;
}

form .signin__btn {
  background: #ffb30e;
  color: white;
  display: block;
  width: 92.5%;
  max-width: 680px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  cursor: pointer;
  font-size: 18px;
  font-family: "Montserrat", sans-serif;
  box-shadow: 0 15px 30px #ffb30e5c;
  transition: 0.2s linear;
}
form .signin__btn:hover {
  box-shadow: 0 0 0 rgba(233, 30, 99, 0);
}

::placeholder {
  color: rgb(128, 128, 128, 0.6) !important;
}

.register-alert {
  display: block;
  width: 90%;
  max-width: 680px;
  height: 30px;
  margin: 10px auto 0 auto;
  border-radius: 8px;
  border: none;
  background: #ffb30e5c;
  padding: 0 0 0 15px;
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
}

.register-alert p {
  line-height: 30px;
}

button {
  font-family: ONE-Mobile-POP !important;
}
</style>
