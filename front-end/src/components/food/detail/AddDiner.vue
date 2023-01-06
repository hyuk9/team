<template>
  <div>
    <main class="main" id="top">
      <div class="card mb-4">
        <!-- AddDiner.vue -->
        <div class="submit-form mt-5 mb-5 card-header">
          <!-- 새 양식 폼 시작 -->
          <div v-if="!submitted" class="card-body" style="width: 500px">
            <!-- 식당이름 -->
            <div class="form-group">
              <label for="dname">식당이름</label>
              <input
                type="text"
                class="form-control"
                id="dname"
                required
                v-model="diner.dname"
                name="dname"
              />
            </div>

            <!-- 평점 -->
            <div class="form-group">
              <label for="score">평점</label>
              <select
                class="form-select"
                id="score"
                required
                v-model="diner.score"
                name="score"
                aria-label="Default select example"
              >
                <option selected>평점을 선택해주세요.</option>
                <option value="1">1점</option>
                <option value="2">2점</option>
                <option value="3">3점</option>
                <option value="4">4점</option>
                <option value="5">5점</option>
              </select>
            </div>
            <!-- <div class="form-group">
              <label for="score">평점</label>
              <input
                type="text"
                class="form-control"
                id="score"
                required
                v-model="diner.score"
                name="score"
              />
            </div> -->

            <!-- 지역 -->
            <div class="form-group">
              <label for="loc">주소</label>
              <input
                class="form-control"
                id="loc"
                required
                v-model="diner.loc"
                name="loc"
              />
            </div>

            <!-- 전화번호 -->
            <div class="form-group">
              <label for="phone">전화번호</label>
              <input
                type="text"
                class="form-control"
                id="phone"
                required
                v-model="diner.phone"
                name="phone"
              />
            </div>

            <!-- 메뉴 -->
            <div class="form-group">
              <label for="score">메뉴</label>
              <select
                class="form-select"
                id="menu"
                required
                v-model="diner.menu"
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
            <div class="form-group">
              <label for="score">테마</label>
              <select
                class="form-select"
                id="theme"
                required
                v-model="diner.theme"
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

            <!-- 지도 좌표추가 -->
            <div class="form-group">
              <label for="dname">식당 좌표값</label>
              <input
                type="text"
                class="form-control"
                id="lat"
                required
                v-model="diner.lat"
                name="lat"
              />
              <input
                type="text"
                class="form-control"
                id="lng"
                required
                v-model="diner.lng"
                name="lng"
              />
            </div>

            <!-- 서버 에러 메세지가 있을 경우 아래 출력 시작 -->
            <div v-if="message" class="alert alert-secondary" role="alert">
              {{ message }}
            </div>
            <!-- 서버 에러 메세지가 있을 경우 아래 출력 끝 -->

            <button @click="saveDiner" class="btn btn-success mt-5 mb-3">
              Submit
            </button>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>


<script>
// axios 공통함수 import
import DinerDataService from "@/services/DinerDataService";

export default {
  data() {
    return {
      message: "", // 서버쪽 메세지를 저장할 변수

      diner: {
        dno: null,
        dname: "",
        loc: "",
        score: null,
        review: "",
        menu: "",
        phone: "",
        theme: "",
      },
      // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
      submitted: false,
    };
  },
  methods: {
    saveDiner() {
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(dno) 자동생성되므로 빼고 전송함
      let data = {
        dname: this.diner.dname,
        loc: this.diner.loc,
        score: this.diner.score,
        menu: this.diner.menu,
        phone: this.diner.phone,
        theme: this.diner.theme,
        // photo: this.diner.photo,
      };

      // insert 요청 함수 호출(axios 공통함수 호출)
      DinerDataService.create(data)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          this.diner.dno = response.data.dno;
          // 콘솔 로그 출력(response.data)
          console.log(response.data);
          alert("추가가 완료되었습니다!");
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /diner
          this.$router.push("/diner");
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    newDiner() {
      // 새양식 다시 보여주기 함수, 변수 초기화
      this.submitted = false;
      this.diner = {};
    },
  },
};
</script>

<style>
.submit-form {
  max-width: 700px;
  margin: auto;
}
</style>
