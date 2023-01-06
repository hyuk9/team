<template>
  <!-- DinerDetail.vue -->
  <div>
    <!-- 수정 양식 폼 시작 -->
    <div v-if="currentDiner" class="edit-form mt-5 mb-5">
      <h4>식당 정보</h4>
      <form>
        <div class="form-group">
          <label for="dname">식당이름</label>
          <input
            type="text"
            class="form-control"
            id="dname"
            v-model="currentDiner.dname"
          />
        </div>

        <!-- 평점 -->
        <div class="form-group">
          <label for="score">평점</label>
          <select
            class="form-select"
            id="score"
            required
            v-model="currentDiner.score"
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

        <!-- 지역 -->
        <div class="form-group">
          <label for="loc">주소</label>
          <input
            class="form-control"
            id="loc"
            required
            v-model="currentDiner.loc"
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
            v-model="currentDiner.phone"
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
        <div class="form-group">
          <label for="score">테마</label>
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
        <button type="button" class="btn btn-info" @click="findL()">
          주소 -> 좌표 전환 사이트
        </button>

        <!-- 지도 좌표추가 -->
        <div class="form-group">
          <label for="lat">식당 좌표값 -> 위도</label>
          <input
            type="number"
            class="form-control"
            id="lat"
            v-model="currentDiner.lat"
            name="lat"
          />
          <label for="lng">식당 좌표값 -> 경도</label>
          <input
            type="number"
            class="form-control"
            id="lng"
            v-model="currentDiner.lng"
            name="lng"
          />
        </div>

        <!-- 메인 사진넣기 -->
        <div class="form-group">
          <label for="mainphoto">메인 사진</label>
          <input
            type="text"
            class="form-control"
            id="mainphoto"
            v-model="currentDiner.mainphoto"
            name="mainphoto"
          />
        </div>

        <!-- 슬라이드 사진넣기 -->
        <div class="form-group">
          <label for="photo">슬라이드 사진</label>
          <input
            type="text"
            class="form-control"
            id="photo1"
            v-model="currentDiner.photo1"
            name="photo1"
          />
          <input
            type="text"
            class="form-control"
            id="photo2"
            v-model="currentDiner.photo2"
            name="photo2"
          />
          <input
            type="text"
            class="form-control"
            id="photo3"
            v-model="currentDiner.photo3"
            name="photo3"
          />
        </div>
      </form>

      <button class="mt-3 btn btn-danger" @click="deleteDiner">삭제</button>

      <button
        type="submit"
        class="ms-3 mt-3 btn btn-success"
        @click="updateDiner"
      >
        수정
      </button>
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
          alert("수정이 완료되었습니다!");
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
          alert("삭제가 완료되었습니다!");
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

<style>
.edit-form {
  max-width: 500px;
  margin: auto;
}
</style>
