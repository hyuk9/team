<template>
    <div>
        <div class="container mb-2 mt-2">
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
                            <td colspan="2" scope="row" style="padding:10px" v-text="currentQna.content"></td>
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
