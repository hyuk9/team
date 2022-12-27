<template>
  <div>
      <div class="container mb-2 mt-2">
          <div class="AnnounceView-header">
              <h1><strong>공지사항 게시판</strong></h1>
          </div>
          <div class="AnnounceView-title">
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
                          <td scope="col" v-text="currentAnnounce.title"></td>
                      </tr>
                      <tr>
                          <th scope="row">작성자</th>
                          <td scope="row" v-text="currentAnnounce.writer"></td>
                      </tr>
                      <tr>
                          <td colspan="2" scope="row" style="padding:10px" v-text="currentAnnounce.content"></td>
                      </tr>
                  </tbody>
              </table>
          </div>
      </div>

      <div>
        <button class="btn btn-warning offset-4" type="button">수정</button>
        <button class="btn btn-danger offset-1" type="button">삭제</button>
      </div>

  </div>
</template>

<script>
import AnnounceDataService from "../../../services/AnnounceDataService";
export default {
data() {
  return {
    currentAnnounce: null,
    message: "",
  };
},
methods: {
  // 부서번호(ano)로 조회 요청하는 함수
  getAnnounce(ano) {
    // axios 공통함수 호출
    AnnounceDataService.get(ano)
      // 성공하면 .then() 결과가 리턴됨
      .then((response) => {
        // springboot 결과를 리턴함(부서 객체)
        this.currentAnnounce = response.data;
        // 콘솔 로그 출력
        console.log(response.data);
      })
      // 실패하면 .catch() 에러메세지가 리턴됨
      .catch((e) => {
        console.log(e);
      });
  },
  // 부서정보를 수정 요청하는 함수
  updateAnnounce() {
    // axios 공통함수 호출
    AnnounceDataService.update(this.currentAnnounce.ano, this.currentAnnounce)
      // 성공하면 then() 결과가 전송됨
      .then((response) => {
        console.log(response.data);
        this.message = "The Announce was updated successfully!";
        location.href = "/announce";
      })
      // 실패하면 .catch() 에러메세지가 전송됨
      .catch((e) => {
        console.log(e);
      });

  },
  // 부서정보를 삭제 요청하는 함수
  deleteAnnounce() {
    // axios 공통함수 호출
    AnnounceDataService.delete(this.currentAnnounce.ano)
      // 성공하면 then() 결과가 전송됨
      .then((response) => {
        console.log(response.data);
        // 첫페이지(전체목록_조회_페이지) 강제 이동 : /announce
        this.$router.push("/announce");
        location.href = "/announce";
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
  this.getAnnounce(this.$route.params.ano);
},
}
</script>

<style>

</style>
