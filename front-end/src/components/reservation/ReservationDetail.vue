<template>
  <div>
    <section>
      <div class="container">
        <div class="col-lg-6 mx-auto">
          <div v-if="currentReservation">
            <div class="mb-3">
              <label for="restaurant" class="form-label">식당</label>
              <input
                type="text"
                class="form-control"
                id="restaurant"
                required
                name="restaurant"
                v-model="currentReservation.restaurant"
              />
            </div>
            <div class="mb-3">
              <label for="rname" class="form-label">이름</label>
              <input
                type="text"
                class="form-control"
                id="rname"
                required
                name="rname"
                v-model="currentReservation.rname"
              />
            </div>
            <div class="mb-3">
              <label for="rcount" class="form-label">인원수</label>
              <select
                class="form-control"
                required
                v-model="currentReservation.rcount"
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
            <div class="mb-3">
              <label for="phone" class="form-label">연락처</label>
              <input
                type="text"
                class="form-control"
                id="phone"
                required
                name="phone"
                v-model="currentReservation.phone"
              />
            </div>
            <div class="mb-3">
              <label for="reservationDate" class="form-label">예약 날짜</label>
              <input
                type="date"
                class="form-control"
                id="reservationDate"
                required
                name="reservationDate"
                v-model="currentReservation.reservationDate"
              />
            </div>
            <div class="mb-3 pb-5">
              <label for="reservationTime" class="form-label">예약 시간</label>
              <input
                type="time"
                class="form-control"
                id="reservationTime"
                required
                name="reservationTime"
                v-model="currentReservation.reservationTime"
              />
            </div>
            <div class="mb-3">
              <button @click="updateReservation" class="btn btn-primary me-3">
                Update
              </button>
              <button @click="deleteReservation" class="btn btn-danger">
                Delete
              </button>
            </div>
            <div class="alert alert-success" role="alert" v-if="message">
              {{ message }}
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
      currentReservation: null,
      message: "",
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
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /dept
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
    this.message = "";
    this.getReservation(this.$route.params.rid);
  },
};
</script>

<style></style>
