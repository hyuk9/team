<template>
  <!-- DinerDetail.vue -->
  <div>
    <!-- 최상단 시작 -->
    <section class="py-5 overflow-hidden bg-warning" id="home">
      <div class="container">
        <div class="row flex-center">
          <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
            <a class="img-landing-banner" href="#!"
              ><img
                class="img-fluid"
                src="assets/img/gallery/hero-header.png"
                alt="hero-header"
            /></a>
          </div>
          <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
            <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">
              식당정보
            </h1>
            <h1 class="text-800 mb-5 fs-4">
              <br />식당정보 수정페이지입니다! <br />
            </h1>
          </div>
        </div>
      </div>
    </section>
    <!-- 최상단 끝 -->

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
        <div class="mt-3 form-group">
          <label for="loc">평점</label>
          <input
            type="text"
            class="form-control"
            id="loc"
            v-model="currentDiner.score"
          />
        </div>
        <div class="mt-3 form-group">
          <label for="loc">지역</label>
          <input
            type="text"
            class="form-control"
            id="loc"
            v-model="currentDiner.loc"
          />
        </div>
        <div class="mt-3 form-group">
          <label for="loc">전화번호</label>
          <input
            type="text"
            class="form-control"
            id="loc"
            v-model="currentDiner.phone"
          />
        </div>
        <div class="mt-3 form-group">
          <label for="loc">메뉴</label>
          <input
            type="text"
            class="form-control"
            id="loc"
            v-model="currentDiner.menu"
          />
        </div>
      </form>

      <button class="mt-3 btn btn-danger" @click="deleteDiner">Delete</button>

      <button
        type="submit"
        class="ms-3 mt-3 btn btn-success"
        @click="updateDiner"
      >
        Update
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
