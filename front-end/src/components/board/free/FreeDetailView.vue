<template>
  <div>
    <!-- detali Start -->
    <div class="container" v-if="currentFree">
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
      <div class="mb-3">
        <label for="content" class="form-label">이미지</label><br />
        <img :src="currentFree.fileUrl" class="preview my-3" alt="" />
        <!-- <a style="color: inherit" @click="updateFree(currentFree.fno)">
           <span class="badge bg-danger">수정</span>
         </a> -->
      </div>
      <div class="mb-3">
        <label class="btn btn-default p-0">
          <!-- 파일 선택상자 -->
          <input
            type="file"
            accept="image/*"
            ref="file"
            @change="selectImage"
          />
        </label>
      </div>
      <div class="mb-3">
        <button @click="updateFree" class="btn btn-primary me-3">Update</button>
        <button @click="deleteFree" class="btn btn-danger">Delete</button>
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
      FreeDataService.update(
        this.currentFree.fno,
        this.currentUser.id,
        this.currentFree.writer,
        this.currentFree.title,
        this.currentFree.content,
        this.currentImage
      )
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.message = "The Free was updated successfully!";
          this.$router.push("/free");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    selectImage() {
      // 파일선택상자에서 첫번째로 선택한 이미지가 저장됨
      this.currentImage = this.$refs.file.files.item(0);
      // 아래는 미리보기 이미지를 위한 주소가 저장됨
      this.previewImage = URL.createObjectURL(this.currentImage);
      this.progress = 0;
      this.message = "";
    },
    // 부서정보를 삭제 요청하는 함수
    deleteFree() {
      // axios 공통함수 호출
      FreeDataService.delete(this.currentFree.fno)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /free
          this.$router.push("/free");
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
    this.getFree(this.$route.params.fno);
  },

  computed: {
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