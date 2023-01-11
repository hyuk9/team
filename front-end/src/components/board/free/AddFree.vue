<template>
  <div>
    <!-- AddFree Start -->
    <!-- <div class="container" v-if="!submitted">
      <div class="mb-3">
        <label for="writer" class="form-label">작성자</label>
        <input
          type="writer"
          class="form-control"
          id="writer"
          required
          name="writer"
          v-bind:disabled="true"
          v-model="currentUser.username"
        />
      </div>
      <div class="mb-3">
        <label for="title" class="form-label">제목</label>
        <input
          type="title"
          class="form-control"
          id="title"
          required
          name="title"
          v-model="free.title"
        />
      </div>
      <div class="mb-3 col-md-5">
        <label class="btn btn-default p-0">
          <input
            type="file"
            accept="image/*"
            ref="file"
            @change="selectImage"
          />
        </label>
      </div>
      <div class="mb-3">
        <button
          class="btn btn-success btn-sm float-left"
          :disabled="!currentImage"
          @click="upload"
        >
          Upload
        </button>
      </div>
      <div v-if="previewImage">
        <div>
          <img class="preview my-3" :src="previewImage" alt="" />
        </div>
      </div>
      <div class="mb-3">
        <label for="content" class="form-label">내용</label>
        <textarea
          class="form-control form-control-lg"
          id="content"
          rows="8"
          required
          name="content"
          v-model="free.content"
        ></textarea>
      </div>

      <div class="mb-3">
        <button @click="saveFree" class="btn btn-primary">작성완료</button>
      </div>
    </div> -->
    <!-- AddFree End -->

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
            <input type="text" class="form-control" style="height:50px" id="title" required name="title"
              v-model="free.title" />
          </div>
          <div class="input-group mb-4">
            <span class="input-group-text">작성자</span>
            <input type="writer" class="form-control" style="height:50px" id="writer" required name="writer" v-bind:disabled="true"
              v-model="currentUser.username" />
          </div>

          <div class="mb-5">
            <textarea class="form-control form-control-lg" id="content" rows="8" required name="content"
              v-model="free.content"></textarea>
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
import GalleryDataService from "@/services/GalleryDataService";

export default {
  data() {
    return {
      free: {
        fno: null,
        writer: "",
        title: "",
        content: "",
        photo: "",
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
    saveFree() {
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(no) 자동생성되므로 빼고 전송함
      let data = {
        writer: this.currentUser.username,
        title: this.free.title,
        content: this.free.content,
        photo: this.selectImage.currentImage,
        id: this.currentUser.id,
      };

      // insert 요청 함수 호출(axios 공통함수 호출)
      FreeDataService.create(data)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          this.free.fno = response.data.ano;
          // 콘솔 로그 출력(response.data)
          console.log(response.data);
          // 변수 submitted
          this.submitted = true;
          // alert("성공했습니다.");
          this.$router.push("/free");
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    newFree() {
      // 새양식 다시 보여주기 함수, 변수 초기화
      this.submitted = false;
      this.free = {};
    },

    returnFree() {
      this.$router.push("/free");
    },

    // 조회 함수
    retrieveGallery() {
      GalleryDataService.getFiles(this.searchTitle, this.page - 1, this.pageSize)
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          const { gallery, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.gallery = gallery; // 스프링부트에서 전송한 데이터
          this.count = totalItems; // 스프링부트에서 전송한 페이지정보(총 건수)
          // 디버깅 콘솔에 정보 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에 에러가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 파일 선택상자에서 선택한 이미지를 저장하는 함수
    selectImage() {
      // 첫번째 선택한 이미지를 변수에 저장
      // this.$refs : $refs 속성이 있는 컨트롤이 선택됨
      this.currentImage = this.$refs.file.files.item(0);
      // .createObjectURL() : 이미지 주소만 참조해서 이미지 보여주기 함수
      this.previewImage = URL.createObjectURL(this.currentImage);
      this.message = "";
    },
    // upload 함수
    upload() {
      GalleryDataService.upload(
        this.galleryTitle,
        this.galleryFileName,
        this.currentImage
      )
        .then((response) => {
          // 서버쪽 성공 메세지를 저장
          this.message = response.data.message;

          // 화면에 재조회 요청(axios 함수로 재조회 요청)
          return GalleryDataService.getFiles(
            this.searchTitle,
            this.page - 1,
            this.pageSize
          );
        })
        // 조회가 성공하면 실행되는 then()
        .then((response2) => {
          const { gallery, totalItems } = response2.data;
          this.gallery = gallery;
          this.count = totalItems;
          console.log(response2.data);
        })
        .catch((e) => {
          console.log(e);
          this.message = "Could not upload the image!" + e;
          this.currentImage = undefined;
        });
    },
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