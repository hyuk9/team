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
                      <img :src="data.fileUrl" class="card-img-top" alt="강의" />
                      <div class="card-body">
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
                <!-- <div class="mb-3 col-md-5">
                  <label for="galleryTitle" class="form-label">이미지명</label>
                  <input type="text" class="form-control" id="galleryTitle" required name="galleryTitle"
                    v-model="galleryTitle" />
                </div> -->
                <!-- 이미지명 입력박스 끝 -->

                <!-- 이미지 선택상자 시작 -->
                <!-- <div class="mb-3 col-md-5">
                  <label class="btn btn-default p-0">
                    <input type="file" accept="image/*" ref="file" @change="selectImage" />
                  </label>
                  <button class="btn btn-success btn-sm float-left" :disabled="!currentImage" @click="upload">
                    Upload
                  </button>
                </div> -->
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
import FreeDataService from "@/services/FreeDataService";
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
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /free
          this.$router.push("/free");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    retrieveFree() {
      FreeDataService.getAll(
        this.searchSelect,
        this.searchKeyword,
        this.page - 1,
        this.pageSize)
        .then((response) => {
          const { free, totalItems } = response.data;
          this.free = free;
          this.count = totalItems;

          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);

          this.message = "조회 시 에러가 발생했습니다. " + e.message;
          // toast 알림창 호출
          // 2. 알램창 호출
          this.$toastr.e("에러", this.message, { timeOut: 1000 });
        });
    },

    // Todo : handlePageChange, handlePageSizeChange
    handlePageChange(value) {
      this.page = value;
      this.retrieveFree();
    },

    handlePageSizeChange(event) {
      this.pageSize = event.target.value;
      this.page = 1;
      this.retrieveFree();
    },
    deleteCourse(id) {
      // alert(id);
      FreeDataService.delete(id)
        .then((response) => {
          console.log(response);

          this.message = "정상적으로 삭제되었습니다. ";
          // toast 알림창 호출
          this.$toastr.s("성공", this.message, { timeOut: 1000 });

          //  삭제 후 재조회
          this.retrieveFree();
        })
        .catch((e) => {
          console.log(e);

          this.message = "삭제 시 에러가 발생했습니다. " + e.message;
          // toast 알림창 호출
          // toast 알림창 호출
          // 1. 알림창 위치
          this.$toastr.options.positionClass = "toast-top-center";
          // 2. 알램창 호출
          this.$toastr.e("에러", this.message, { timeOut: 1000 });
        });
    },
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
    this.retrieveFree();
  },
};
</script>

<style>

</style>
