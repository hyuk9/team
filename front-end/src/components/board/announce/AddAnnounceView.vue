<template>
  <div>
    <div>
      <div class="container col-6 mb-2 mt-2">
        <div class="AnnounceView-header mt-5">
          <h1>
            <strong>공지사항 등록</strong>
          </h1>
        </div>
        <div class="AnnounceView-title">
          <div class="input-group mt-3 mb-4">
            <span class="input-group-text">제목</span>
            <input
              type="text"
              class="form-control"
              style="height: 50px"
              id="title"
              required
              name="title"
              v-model="announce.title"
            />
          </div>
          <div class="input-group mb-4">
            <span class="input-group-text">작성자</span>
            <input
              type="text"
              class="form-control"
              style="height: 50px"
              id="writer"
              required
              name="writer"
              v-bind:disabled="true"
              v-model="currentUser.username"
            />
          </div>

          <div class="mb-5">
            <textarea
              class="form-control form-control-lg"
              id="content"
              rows="8"
              required
              name="content"
              v-model="announce.content"
            ></textarea>
          </div>
        </div>
        <div class="mb-3">
          <button @click="saveAnnounce" class="btn btn-primary">등록</button>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import AnnounceDataService from "@/services/AnnounceDataService";
export default {
  data() {
    return {
      announce: {
        aid: null,
        writer: "",
        title: "",
        content: "",
      },
      // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
      submitted: false,
    };
  },
  methods: {
    // TODO: 공지사항 정보를 저장요청하는 함수
    saveAnnounce() {
      // 임시 객체 변수 -> springboot 전송
      // 공지사항pk는(aid) 자동생성되므로 빼고 전송함
      let data = {
        writer: this.currentUser.username,
        title: this.announce.title,
        content: this.announce.content,
      };
      AnnounceDataService.create(data)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          this.announce.aid = response.data.aid;
          // 콘솔 로그 출력(response.data)
          console.log("공지사항 정보 저장요청 성공 : ", response.data);
          // 변수 submitted
          this.submitted = true;
          this.$router.push("/announce");
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((e) => {
          console.log("공지사항 정보 저장요청 실패 : ", e);
        });
    },
  },
  computed: {
    // TODO: 로컬 스토리지에 저장된 현재 유저 정보 가져오는 함수
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },
  },
};
</script>

<style>
</style>