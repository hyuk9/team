<template>
  <div>
    <!-- Form -->
    <section>
      <div class="mx-auto text-center mb-5">
        <h5 class="fw-bold fs-3 fs-lg-5 lh-sm">예약 수정하기</h5>
      </div>
      <div class="form">
        <div>
          <!-- 가게 명 -->
          <div class="input__block">
            <h5>가게</h5>
            <input
              v-model="currentReservation.restaurant"
              required
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
              v-model="currentReservation.rname"
              required
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
              <select required v-model="currentReservation.rcount">
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
              </select>
            </div>
          </div>

          <!-- 전화번호 -->
          <div class="input__block">
            <h5>전화번호</h5>
            <div class="phoneInput">
              <input
                v-model="currentReservation.phone1"
                type="text"
                class="input"
                id="phone1"
                maxlength="3"
              />
              <span class="minus">-</span>
              <input
                v-model="currentReservation.phone2"
                type="text"
                class="input"
                id="phone2"
                maxlength="4"
              />
              <span class="minus">-</span>
              <input
                v-model="currentReservation.phone3"
                type="text"
                class="input"
                id="phone3"
                maxlength="4"
              />
            </div>
          </div>

          <!-- 예약 날짜 -->
          <!-- <div class="input__block">
            <h5>예약 날짜</h5>
            <input
              v-model="currentReservation.reservationDate"
              required
              type="date"
              class="input"
              id="reservationDate"
              placeholder="날짜 선택"
            />
          </div> -->

          <!-- 예약 날짜 -->
          <div class="input__block">
            <h5>예약 날짜</h5>
            <input
              v-model="currentReservation.reservationDate"
              required
              type="date"
              class="input"
              id="reservationDate"
              placeholder="날짜 선택"
            />
          </div>

          <!-- 예약 시간 -->
          <div class="input__block">
            <h5>예약 시간</h5>
            <input
              v-model="currentReservation.reservationTime"
              required
              type="time"
              class="input"
              id="reservationTime"
              placeholder="시간 선택"
            />
          </div>

          <!-- button -->
          <div class="mt-5 mb-3 text-center">
            <button @click="updateReservation" class="reservation__btn1 me-5">
              수정하기
            </button>
            <button @click="deleteReservation" class="reservation__btn2">
              취소하기
            </button>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
// @ is an alias to /src
/* eslint-disable */
import ReservationDataService from "@/services/ReservationDataService";

export default {
  data() {
    return {
      currentReservation: null,
    };
  },
  methods: {
    // 고객번호(rid)로 조회 요청하는 함수
    getReservation(rid) {
      // axios 공통함수 호출
      ReservationDataService.get(rid)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentReservation = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },
    updateReservation() {
      // axios 공통함수 호출
      ReservationDataService.update(
        this.currentReservation.rid,
        this.currentReservation
      )
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // alert 라이브러리 효과
          this.$swal({
            icon: "success",
            title: "수정완료",
            showConfirmButton: false,
            timer: 1000,
          });
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /reservation
          this.$router.push("/reservation");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    deleteReservation() {
      // axios 공통함수 호출
      ReservationDataService.delete(this.currentReservation.rid)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // alert 라이브러리 효과
          this.$swal({
            icon: "success",
            title: "삭제 성공",
            showConfirmButton: false,
            timer: 1000,
          });
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /reservation
          this.$router.push("/reservation");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
  },
  // 화면 뜨자마자 실행되는 이벤트
  mounted() {
    this.getReservation(this.$route.params.rid);

    $(function () {
      $("#reservationDate").datepicker({
        dateFormat: "yy-mm-dd",
        minDate: 1,
        maxDate: "+1m",
        dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"],
        monthNames: [
          "1월",
          "2월",
          "3월",
          "4월",
          "5월",
          "6월",
          "7월",
          "8월",
          "9월",
          "10월",
          "11월",
          "12월",
        ],
      });
      $("#reservationTime").timepicker({
        timeFormat: "H:mm",
        interval: 30,
        minTime: "11",
        maxTime: "8:00pm",
        startTime: "11:00",
        dynamic: false,
        dropdown: true,
        scrollbar: true,
      });
    });
  },
};
</script>

<style lang="scss" scoped>
h5 {
  display: inline-block;
  color: #ffb30e;
  margin: 30px 0 30px 30px;
}

.form {
  width: 100%;
  max-width: 680px;
  margin: 40px auto 10px;
}
.input__block {
  margin: 20px auto;
  position: relative;
}

.input__block input {
  display: block;
  width: 90%;
  max-width: 680px;
  height: 50px;
  margin: 0 auto;
  border-radius: 8px;
  border: none;
  background: rgba(15, 19, 42, 0.1);
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  padding: 0 10px;
}
/* 셀렉트 박스 둥글게  */
select {
  border-radius: 8px;
}

/* 인원수 입력용 */
.rcountInput {
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
.rcountInput select {
  width: 32%;
  height: 50px;
}
/* 인원수 입력용 */
.rcountInput select:first-of-type {
  margin-right: 2%;
}

/* 전화번호 입력용 */
.phoneInput {
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
.phoneInput .input {
  display: inline-block;
  width: 30%;
}
/* 전화번호 입력용 */
.phoneInput .minus {
  display: inline-block;
  width: 5%;
  text-align: center;
}

.input__block input:focus,
.input__block input:active {
  outline: none;
  border: none;
  color: #0f132a;
}

.reservation__btn1 {
  background: #ffb30e;
  color: white;
  display: inline;
  width: 140px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  font-size: 18px;
  box-shadow: 0 15px 30px #ffb30e5c;
  transition: 0.2s linear;
}
.reservation__btn2 {
  background: tomato;
  color: white;
  display: inline;
  width: 140px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  font-size: 18px;
  box-shadow: 0 15px 30px #ffb30e5c;
  transition: 0.2s linear;
}
.reservation__btn1:hover,
.reservation__btn2:hover {
  box-shadow: 0 0 0 rgba(233, 30, 99, 0);
}

::placeholder {
  color: rgb(128, 128, 128, 0.6) !important;
}

button {
  font-family: ONE-Mobile-POP !important;
}
</style>
