<template>
  <div>
    <!-- detali Start -->
    <div class="container ">
      <div class="mt-3 mb-3">
        <label for="title" class="form-label">제목</label>
        <input
          type="text"
          class="form-control"
          id="title"
          required
          name="title"
          v-model="currentFree.title"
        />
      </div>
      <div class="mb-3">
        <label for="writer" class="form-label">작성자</label>
        <input
          type="writer"
          class="form-control"
          id="writer"
          required
          name="writer"
          v-model="currentFree.writer"
        />
      </div>
      <div class="mb-3">
        <label for="content" class="form-label">내용</label>
        <textarea
          class="form-control form-control-lg"
          id="content"
          rows="8"
          required
          name="content"
          v-model="currentFree.content"
        ></textarea>
      </div>
      <!-- 게시글 작성자 id == 현재 로그인한 유저 id 이면 보이거나 관리자 계정이면 보이게 설정해야함 -->
      <div class="mb-3" v-if="showAdminBoard">
        <button @click="updateFree" class="btn btn-primary me-3">수정</button>
        <button @click="deleteFree" class="btn btn-danger me-3">삭제</button>
      </div>
      <div>
        <button @click="goFreeList" class="btn btn-danger me-3">목록보기</button>
      </div>
      <div class="alert alert-success" role="alert" v-if="message">
        {{ message }}
      </div>
    </div>
    <!-- detail End -->
  </div>
</template>

<script>
import FreeDataService from "@/services/FreeDataService";
export default {
  data() {
    return {
      currentFree: null,
      message: "",
    };
  },
  methods: {
    // 부서번호(fno)로 조회 요청하는 함수
    getFree(fno) {
      // axios 공통함수 호출
      FreeDataService.get(fno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentFree = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 수정 요청하는 함수
    updateFree() {
      // axios 공통함수 호출
      FreeDataService.update(this.currentFree.fno, this.currentFree)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.message = "The Announce was updated successfully!";
          this.$router.push("/free");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 삭제 요청하는 함수
    deleteFree() {
      // axios 공통함수 호출
      FreeDataService.delete(this.currentFree.fno)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /announce
          this.$router.push("/free");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 푸드컬럼리스트로 페이지 이동하는 함수
    goFreeList(){
      this.$router.push("/free");
    }
  },
  computed: {
    // 현재 유저
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },
    // 관리자 접속이거나 글쓴사람(id)가 동일하면 보이는 함수
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        // if ROLE_ADMIN 있으면 true 없으면 false 이거나 현재로그인한id == 글쓴사람id
        return this.currentUser.roles.includes("ROLE_ADMIN") || this.currentUser.id == this.currentFree.id;
      }
      // currentUser 없으면 false (메뉴가 안보임)
      return false;
    },
  },
  // 화면이 뜨자 마자 실행되는 이벤트
  mounted() {
    this.message = "";
    this.getFree(this.$route.params.fno);
  },
};
</script>

<style>
</style>