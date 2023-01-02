<template>
  <div>
    <!-- Form -->
    <section>
      <div class="mx-auto text-center mb-5">
        <h5 class="fw-bold fs-3 fs-lg-5 lh-sm">예약자 정보</h5>
      </div>
      <div class="form">
        <div>
          <!-- 가게 명 -->
          <div class="input__block">
            <h5>가게</h5>
            <input
              v-model="reservation.restaurant"
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
              v-model="reservation.rname"
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
              <select required v-model="reservation.rcount">
                <option class="text-center">2</option>
                <option class="text-center">3</option>
                <option class="text-center">4</option>
                <option class="text-center">5</option>
                <option class="text-center">6</option>
                <option class="text-center">7</option>
                <option class="text-center">8</option>
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
              ref="reservationDate"
              required
              type="text"
              class="input"
              id="reservationDate"
              placeholder="날짜 선택"
            />
          </div>

          <!-- 예약 시간 -->
          <div class="input__block">
            <h5>예약 시간</h5>
            <input
              ref="reservationTime"
              required
              type="text"
              class="input"
              id="reservationTime"
              placeholder="시간 선택"
            />
          </div>

          <!-- 예약시간 -->
          <!-- <div class="input__block">
            <h5>예약 시간</h5>
            <div class="accordion" id="accordionExample">
              <div class="accordion-item">
                <h2 class="accordion-header" id="headingOne">
                  <button
                    class="accordion-button collapsed"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#collapseOne"
                    aria-expanded="false"
                    aria-controls="collapseOne"
                    id="selTime"
                  ></button>
                </h2>
                <div
                  id="collapseOne"
                  class="accordion-collapse collapse"
                  aria-labelledby="headingOne"
                  data-bs-parent="#accordionExample"
                >
                  <div class="accordion-body">
                    <div class="p-3 p-sm-5">
                      <div class="row text-center mx-0">
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">11:00</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">11:30</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">12:00</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">12:30</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">13:00</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">13:30</div>
                        </div>
                      </div>
                      <div class="row text-center mx-0">
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">14:00</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">14:30</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">15:00</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">15:30</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">16:00</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">16:30</div>
                        </div>
                      </div>
                      <div class="row text-center mx-0">
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">17:00</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">17:30</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">18:00</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">18:30</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">19:00</div>
                        </div>
                        <div class="col-md-2 col-4 my-1 px-2">
                          <div class="cell py-1">19:30</div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div> -->

          <!-- sign in button -->
          <button @click="saveReservation" class="reservation__btn mt-5">
            예약하기
          </button>
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
      reservation: {
        rid: null,
        restaurant: "", // 가게명
        rname: "", // 예약자명
        rcount: "", // 인원수
        phone1: "", // 전화번호의 앞자리
        phone2: "", // 전화번호의 중간자리
        phone3: "", // 전화번호의 뒷자리
        reservationDate: "", // 예약날짜
        reservationTime: "", // 예약시간
        reservationYn: "", // 예약가능여부
      },
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
        reservationDate: this.$refs.reservationDate.value,
        reservationTime: this.$refs.reservationTime.value,
        // reservationTime: document.querySelector("#selTime").innerHTML,
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
      // $(function () {
      //   $(".cell").click(function () {
      //     $(".cell").removeClass("select");
      //     $(this).addClass("select");
      //     $(this).text();
      //     // TODO: document.querySelector("#selTime").innerHTML = $(this).text(); 변경
      //     document.querySelector("#selTime").innerHTML = $(this).text();
      //   });
      // });
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
  font-size: 18px;
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

.reservation__btn {
  background: #ffb30e;
  color: white;
  display: block;
  width: 92.5%;
  max-width: 680px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  font-size: 18px;
  box-shadow: 0 15px 30px #ffb30e5c;
  transition: 0.2s linear;
}
.reservation__btn:hover {
  box-shadow: 0 0 0 rgba(233, 30, 99, 0);
}

::placeholder {
  color: rgb(128, 128, 128, 0.6) !important;
}

button {
  font-family: ONE-Mobile-POP !important;
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
</style>
