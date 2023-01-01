<template>
  <div>
    <div class="container mb-2 mt-2">
      <div class="FreeView-header">
        <h1><strong>자유 게시판</strong></h1>
      </div>
      <div class="FreeView-title">
        <table class="table">
          <colgroup>
            <col style="width: 15%" />
            <col style="width: 85%" />
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
              <td scope="col" v-text="currentFree.title"></td>
            </tr>
            <tr>
              <th scope="row">작성자</th>
              <td scope="row" v-text="currentFree.writer"></td>
            </tr>
            <tr>
              <td colspan="2" scope="row" style="padding: 10px">
                {{ currentFree.content }}
                <!-- 미리보기 이미지 시작 -->
                <div v-if="previewImage">
                  <div>
                    <img class="preview my-3" :src="previewImage" alt="" />
                  </div>
                </div>
                <!-- 미리보기 이미지 끝 -->

                <!-- 서버 에러 메세지가 있을 경우 아래 출력 시작 -->
                <div v-if="message2" class="alert alert-secondary" role="alert">
                  {{ message2 }}
                </div>
                <!-- 서버 에러 메세지가 있을 경우 아래 출력 끝 -->

                <!-- <!— 쇼핑 카트 형태 디자인 시작 —> -->
                <!-- <!— v-for 시작 —> -->
                <div class="row">
                  <div class="col-sm-4" v-for="(data, index) in free" :key="index">
                    <div class="card">
                      <img :src="data.galleryUrl" class="card-img-top" alt="강의" />
                      <div class="card-body">
                        <h5 class="card-title">{{ data.galleryTitle }}</h5>
                        <a style="color: inherit" @click="deleteImage(data.fno)">
                          <!-- <!— <i class="fas fa-trash" /> —> -->
                          <span class="badge bg-danger">Delete</span>
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
              </td>
            </tr>
            <tr>
              <th scope="row">이미지 업로드</th>
              <td scope="row">
                <!-- 이미지명(galleryTitle) 입력박스 시작 -->
                <div class="mb-3 col-md-5">
                  <label for="galleryTitle" class="form-label">이미지명</label>
                  <input type="text" class="form-control" id="galleryTitle" required name="galleryTitle"
                    v-model="galleryTitle" />
                </div>
                <!-- 이미지명 입력박스 끝 -->

                <!-- 이미지 선택상자 시작 -->
                <div class="mb-3 col-md-5">
                  <label class="btn btn-default p-0">
                    <!-- <!— 파일 선택상자 —> -->
                    <input type="file" accept="image/*" ref="file" @change="selectImage" />
                  </label>
                  <button class="btn btn-success btn-sm float-left" :disabled="!currentImage" @click="upload">
                    Upload
                  </button>
                </div>
                <!-- 이미지 선택상자 끝 -->
                <!-- upload 버튼 : insert 문 실행 끝 -->
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <div class="mb-3">
      <router-link :to="'/free/' + currentFree.fno">
        <button class="btn btn-warning offset-5" type="button">
          수정&삭제
        </button>
      </router-link>
    </div>
  </div>
</template>

<script>
import FreeDataService from "../../../services/FreeDataService";
import GalleryDataService from "../../../services/GalleryDataService";
export default {
  data() {
    return {
      currentFree: null,
      message2: "",
      currentImage: undefined, // 현재 이미지 변수
      previewImage: undefined, // 미리보기 이미지 변수
      message: "", // 서버쪽 메세지를 저장할 변수
      free: [], // 이미지 객체 배열
      searchTitle: "", // 이미지명으로 검색하는 변수
      // springboot 요청할 변수 , 이미지명(galleryTitle), 내용(content)
      galleryTitle: "",

            // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 3, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      pageSizes: [3, 6, 9], // select box 에 넣을 기본 데이터
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
          this.message2 = "The Free was updated successfully!";
          location.href = "/free";
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
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /free
          this.$router.push("/free");
          location.href = "/free";
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 전체 조회 함수
    retrieveGallery() {
      GalleryDataService.getFiles(this.searchTitle,this.fno, this.page - 1, this.pageSize)
        // 성공하면 .then() 결과가 전송됨
        .then((response) => {
          const { free, totalItems } = response.data; // springboot 의 전송된 맵 정보
          this.free = free; // 스프링부트에서 전송한 데이터
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
        this.currentImage,
        this.fno
      )
        // insert 성공 then()
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
          const { free, totalItems } = response2.data;
          this.free = free;
          this.count = totalItems;
          console.log(response2.data);
        })
        .catch((e) => {
          console.log(e);
          this.message = "Could not upload the image!" + e;
          this.currentImage = undefined;
        });
    },
    // select box 값 변경시 실행되는 함수(재조회)
    handlePageSizeChange(event) {
      this.pageSize = event.target.value; // 한페이지당 개수 저장(3, 6, 9)
      this.page = 1;
      // 재조회 함수 호출
      this.retrieveGallery();
    },
    // 페이지 번호 변경시 실행되는 함수(재조회)
    handlePageChange(value) {
      this.page = value; // 매개변수값으로 현재페이지 변경
      // 재조회 함수 호출
      this.retrieveGallery();
    },
    deleteImage(fno) {
      GalleryDataService.delete(fno)
        .then(response => {
          console.log(response);
          this.message = "정상적으로 삭제되었습니다.";

          // 삭제 후 재조회
          this.retrieveGallery();
        })
        .catch(e => {
          console.log(e);
          this.message = " 삭제 시 에러가 발생했습니다." + e.message;
        })
    }
  },

  computed: {
    // 현재 유저
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },

    // 관리자 접속인지 아닌지 확인하는 함수
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        // if ROLE_ADMIN 있으면 true
        //               없으면 false
        return this.currentUser.roles.includes("ROLE_ADMIN");
      }
      // currentUser 없으면 false (메뉴가 안보임)
      return false;
    },
  },

  // 화면이 뜨자 마자 실행되는 이벤트
  mounted() {
    this.message2 = "";
    this.getFree(this.$route.params.fno);
    this.retrieveGallery();
  },
};
</script>

<style>

</style>
