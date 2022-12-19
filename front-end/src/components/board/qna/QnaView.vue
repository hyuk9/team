<template>
    <div>
        <!-- 최상단 시작 -->
        <section class="py-5 overflow-hidden bg-warning" id="home">
            <div class="container">
                <div class="row flex-center">
                    <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
                        <!-- TODO: 이미지가 안나와서 이미지 경로 수정 -->
                        <a class="img-landing-banner" href="#!"><img class="img-fluid"
                                src="../../../../public/assets/img/gallery/hero-header.png" alt="hero-header" /></a>
                    </div>
                    <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
                        <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">
                            여기는 질문과답변 <br />
                            페이지 입니다
                        </h1>
                        <h1 class="text-800 mb-5 fs-4">최상단만 제작</h1>
                    </div>
                </div>
            </div>
        </section>
        <!-- 최상단 끝 -->
        <div class="container">
            <div class="QnaView-header">
                <h1><strong>1:1 문의 게시판</strong></h1>
            </div>
            <div class="QnaView-title">
                <table class="table">
                    <colgroup>
                        <col style="width:15%">
                        <col style="width:85%">
                    </colgroup>
                    <thead>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>

                        <tr>
                            <th scope="col">제목</th>
                            <td scope="col" v-text="currentQna.title"></td>
                        </tr>
                        <tr>
                            <th scope="row">작성자</th>
                            <td scope="row" v-text="currentQna.questioner"></td>
                        </tr>
                        <tr>
                            <td colspan="2" scope="row"  v-text="currentQna.content"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
import QnaDataService from "../../../services/QnaDataService";
export default {
  data() {
    return {
      currentQna: null,
      message: "",
    };
  },
  methods: {
    // 부서번호(qno)로 조회 요청하는 함수
    getQna(qno) {
      // axios 공통함수 호출
      QnaDataService.get(qno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentQna = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 수정 요청하는 함수
    updateQna() {
      // axios 공통함수 호출
      QnaDataService.update(this.currentQna.qno, this.currentQna)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.message = "The Qna was updated successfully!";
          location.href = "/qna";
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });

    },
    // 부서정보를 삭제 요청하는 함수
    deleteQna() {
      // axios 공통함수 호출
      QnaDataService.delete(this.currentQna.qno)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /qna
          this.$router.push("/qna");
          location.href = "/qna";
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
  },
  // 화면이 뜨자 마자 실행되는 이벤트
  mounted() {
    this.message = "";
    this.getQna(this.$route.params.qno);
  },
}
</script>

<style>

</style>
