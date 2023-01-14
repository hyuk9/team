<template>
  <div>
    <div>
      <div class="container col-6 mb-2 mt-2">
        <div class="AnnounceView-header mt-5">
          <h1>
            <strong>자유게시판 등록</strong>
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
              v-model="free.title"
            />
          </div>
          <div class="input-group mb-4">
            <span class="input-group-text">작성자</span>
            <input
              type="writer"
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
              v-model="free.content"
            ></textarea>
          </div>
        </div>

        <div class="mb-3">
          <button @click="saveFree" class="btn btn-primary">글쓰기</button>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import FreeDataService from "@/services/FreeDataService";

export default {
  data() {
    return {
      free: {
        fno: null,
        writer: "",
        title: "",
        content: "",
        id: null,
      },
      // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
      submitted: false,

      currentImage: undefined, // 현재 이미지 변수
      previewImage: undefined, // 미리보기 이미지 변수
      message: "", // 서버쪽 메세지를 저장할 변수
      gallery: [], // 이미지 객체 배열
      searchTitle: "", // 이미지명으로 검색하는 변수

      // springboot 요청할 변수, 이미지명(galleryTitle), 내용(content)
      galleryTitle: "",
      galleryFileName: "",
    };
  },
  methods: {
    // TODO: 자유게시판 정보를 저장요청하는 함수
    saveFree() {
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(no) 자동생성되므로 빼고 전송함
      let data = {
        writer: this.currentUser.username,
        title: this.free.title,
        content: this.free.content,
        id: this.currentUser.id,
      };
      // insert 요청 함수 호출(axios 공통함수 호출)
      FreeDataService.create(data)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          this.free.fno = response.data.ano;
          // 콘솔 로그 출력(response.data)
          console.log("자유게시판 정보 저장 성공 : ", response.data);
          // 변수 submitted
          this.submitted = true;
          // alert("성공했습니다.");
          this.$router.push("/free");
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((e) => {
          console.log("자유게시판 정보 저장 실패 : ", e);
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