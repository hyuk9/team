<template>
  <!-- DinerDetail.vue -->
  <div class="form">
    <!-- 수정 양식 폼 시작 -->
    <div v-if="currentDiner" class="mt-5 mb-5">
      <h1 class="mt-6"><i class="bi bi-journal-plus"></i> 음식점 수정하기</h1>
      <!-- 식당이름 -->
      <div class="input__block">
        <h5>식당이름</h5>
        <input
          type="text"
          class="form-control"
          id="dname"
          required
          v-model="currentDiner.dname"
          name="dname"
        />
      </div>

      <!-- 지역 -->
      <div class="input__block">
        <h5>주소</h5>
        <input
          class="form-control"
          id="loc"
          required
          v-model="currentDiner.loc"
          name="loc"
        />
      </div>

      <!-- 전화번호 -->
      <div class="input__block">
        <h5>전화번호</h5>
        <input
          type="text"
          class="form-control"
          id="phone"
          required
          v-model="currentDiner.phone"
          name="phone"
        />
      </div>

      <!-- 메뉴 -->
      <div class="input__block">
        <h5>메뉴</h5>
        <select
          class="form-select"
          id="menu"
          required
          v-model="currentDiner.menu"
          name="menu"
          aria-label="Default select example"
        >
          <option selected>메뉴을 선택해주세요.</option>
          <option value="한식">한식</option>
          <option value="중식">중식</option>
          <option value="일식">일식</option>
          <option value="양식">양식</option>
        </select>
      </div>

      <!-- 테마 -->
      <div class="input__block">
        <h5>테마</h5>
        <select
          class="form-select"
          id="theme"
          required
          v-model="currentDiner.theme"
          name="theme"
          aria-label="Default select example"
        >
          <option selected>테마를 선택해주세요.</option>
          <option value="데이트">데이트</option>
          <option value="모임">모임</option>
          <option value="회식">회식</option>
          <option value="식사">식사</option>
        </select>
      </div>

      <!-- 주소로 지도 좌표찾는 사이트 링크 추가 -->
      <div class="text-center">
        <button type="button" class="reservation__btn22 mt-4" @click="findL()">
          주소 <i class="bi bi-arrow-right-circle"></i> 좌표 전환 사이트
        </button>
      </div>

      <!-- 지도 좌표 추가 -->
      <div class="wd">
        <div class="row">
          <div class="col">
            <h5>식당 좌표값 <i class="bi bi-arrow-right-circle"></i> 위도</h5>
            <input
              type="number"
              class="form-control"
              id="lat"
              v-model="currentDiner.lat"
              name="lat"
            />
          </div>
          <div class="col">
            <h5>식당 좌표값 <i class="bi bi-arrow-right-circle"></i> 경도</h5>
            <input
              type="number"
              class="form-control"
              id="lng"
              v-model="currentDiner.lng"
              name="lng"
            />
          </div>
        </div>
      </div>

      <!-- 메인 사진넣기 -->
      <div class="input__block">
        <h5>메인 사진</h5>
        <input
          type="text"
          class="form-control"
          id="mainphoto"
          v-model="currentDiner.mainphoto"
          name="mainphoto"
        />
      </div>

      <!-- 슬라이드 사진넣기 -->
      <div class="input__block">
        <h5>슬라이드 사진</h5>
        <input
          type="text"
          class="form-control mb-1"
          id="photo1"
          v-model="currentDiner.photo1"
          name="photo1"
        />
        <input
          type="text"
          class="form-control mb-1"
          id="photo2"
          v-model="currentDiner.photo2"
          name="photo2"
        />
        <input
          type="text"
          class="form-control mb-1"
          id="photo3"
          v-model="currentDiner.photo3"
          name="photo3"
        />
      </div>
      <br />

      <!-- 대표 메뉴 추가하기 -->
      <div class="wd">
        <h4 class="text-center mt-2 text-900">
          <i class="bi bi-clipboard-plus"></i>
          대표메뉴 5가지를 추가해주세요!
        </h4>
        <div class="row">
          <div class="col">
            <h5>메뉴1</h5>
            <input
              type="text"
              class="form-control"
              id="menu1"
              v-model="currentDiner.menu1"
              name="menu1"
              required
            />
          </div>
          <div class="col">
            <h5>메뉴1 가격</h5>
            <input
              type="number"
              class="form-control"
              id="price1"
              v-model="currentDiner.price1"
              name="price1"
              required
            />
          </div>
        </div>
        <div class="row">
          <div class="col">
            <h5>메뉴2</h5>
            <input
              type="text"
              class="form-control"
              id="menu2"
              v-model="currentDiner.menu2"
              name="menu2"
              required
            />
          </div>
          <div class="col">
            <h5>메뉴2 가격</h5>
            <input
              type="number"
              class="form-control"
              id="price2"
              v-model="currentDiner.price2"
              name="price2"
              required
            />
          </div>
        </div>
        <div class="row">
          <div class="col">
            <h5>메뉴3</h5>
            <input
              type="text"
              class="form-control"
              id="menu3"
              v-model="currentDiner.menu3"
              name="menu3"
              required
            />
          </div>
          <div class="col">
            <h5>메뉴3 가격</h5>
            <input
              type="number"
              class="form-control"
              id="price3"
              v-model="currentDiner.price3"
              name="price3"
              required
            />
          </div>
        </div>
        <div class="row">
          <div class="col">
            <h5>메뉴4</h5>
            <input
              type="text"
              class="form-control"
              id="menu4"
              v-model="currentDiner.menu4"
              name="menu4"
              required
            />
          </div>
          <div class="col">
            <h5>메뉴4 가격</h5>
            <input
              type="number"
              class="form-control"
              id="price4"
              v-model="currentDiner.price4"
              name="price4"
              required
            />
          </div>
        </div>
        <div class="row">
          <div class="col">
            <h5>메뉴5</h5>
            <input
              type="text"
              class="form-control"
              id="menu5"
              v-model="currentDiner.menu5"
              name="menu5"
              required
            />
          </div>
          <div class="col">
            <h5>메뉴5 가격</h5>
            <input
              type="number"
              class="form-control"
              id="price5"
              v-model="currentDiner.price5"
              name="price5"
              required
            />
          </div>
        </div>
      </div>
      <!-- 서버 에러 메세지가 있을 경우 아래 출력 시작 -->
      <div v-if="message" class="alert alert-secondary" role="alert">
        {{ message }}
      </div>
      <!-- 서버 에러 메세지가 있을 경우 아래 출력 끝 -->

      <div class="mt-5 mb-5 text-center">
        <button class="reservation__btn1 me-5" @click="deleteDiner">
          삭제
        </button>

        <button type="submit" class="reservation__btn2" @click="updateDiner">
          수정
        </button>
      </div>
    </div>
    <!-- 수정 양식 폼 끝 -->

    <div v-else>
      <br />
      <p>Please click on a Diner…</p>
    </div>
  </div>
</template>

<script>
import DinerDataService from "@/services/DinerDataService";
export default {
  data() {
    return {
      currentDiner: null,
      message: "",
    };
  },
  methods: {
    // 부서번호(dno)로 조회 요청하는 함수
    getDiner(dno) {
      // axios 공통함수 호출
      DinerDataService.get(dno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentDiner = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 수정 요청하는 함수
    updateDiner() {
      // axios 공통함수 호출
      DinerDataService.update(this.currentDiner.dno, this.currentDiner)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
            this.$swal({
            icon: "success",
            title: "수정이 완료되었습니다",
            showConfirmButton: false,
            timer: 1000,
          });
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /diner
          this.$router.push("/diner");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 삭제 요청하는 함수
    deleteDiner() {
      // axios 공통함수 호출
      DinerDataService.delete(this.currentDiner.dno)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
            this.$swal({
            icon: "success",
            title: "삭제가 완료되었습니다",
            showConfirmButton: false,
            timer: 1000,
          });
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /diner
          this.$router.push("/diner");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
  },
  // 화면이 뜨자 마자 실행되는 이벤트
  mounted() {
    // 클라이언트쪽 디버깅
    // alert(this.$route.params.dno);
    // console.log(this.$route.params.dno);

    this.message = "";
    //  this.$route.params.dno : 이전페이지에서 전송한 매개변수는 $route.params 안에 있음
    // $route 객체 : 주로 url 매개변수 정보들이 있음
    // router/index.js 상세페이지 url의 매개변수명 : :dno
    this.getDiner(this.$route.params.dno);
  },
};
</script>

<style lang="scss" scoped>
h1 {
  color: #ffb30e;
  font-size: 48px;
  letter-spacing: -3px;
  text-align: center;
  margin-bottom: 80px;
  transition: 0.2s linear;
}

h5 {
  display: inline-block;
  color: #ffb30e;
  margin: 30px 0 30px 30px;
  transition: 0.2s linear;
}

.form {
  width: 100%;
  max-width: 680px;
  margin: 40px auto 10px;
}

.form-select {
  width: 90%;
  margin: 0 auto;
}

.input__block {
  margin: 20px auto;
  display: block;
  position: relative;
}
.wd {
  margin: 0 auto;
  width: 90%;
  padding: 0 10px;
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

.gender {
  margin: 0 0 0 30px;
}

.gender h5 {
  margin: 30px 0 30px 0px;
}

.gender input {
  width: 50%;
  max-width: 680px;
  height: 30px;
  margin: 0 auto;
  padding: 0 0 0 15px;
  vertical-align: middle;
}
.reservation__btn1 {
  background: tomato;
  color: white;
  display: inline;
  width: 140px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  font-size: 18px;
  box-shadow: 0 10px 20px rgba(170, 71, 54, 0.377);
  transition: 0.2s linear;
}
.reservation__btn2 {
  background: rgba(76, 184, 43, 0.993);
  color: white;
  display: inline;
  width: 140px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  font-size: 18px;
  box-shadow: 0 10px 20px rgba(59, 138, 35, 0.493);
  transition: 0.2s linear;
}
.reservation__btn22 {
  background: rgba(76, 184, 43, 0.993);
  color: white;
  display: inline;
  width: 250px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  font-size: 18px;
  box-shadow: 0 10px 20px rgba(59, 138, 35, 0.493);
  transition: 0.2s linear;
}
.reservation__btn1:hover,
.reservation__btn2:hover {
  box-shadow: 0 0 0 rgba(233, 30, 99, 0);
}
button {
  font-family: ONE-Mobile-POP !important;
}
</style>
