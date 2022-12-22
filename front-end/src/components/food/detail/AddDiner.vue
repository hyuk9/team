<template>
  <div>
    <main class="main" id="top">
      <!-- 최상단 시작 -->
      <section class="py-5 overflow-hidden bg-warning" id="home">
        <div class="container">
          <div class="row flex-center">
            <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
              <a class="img-landing-banner" href="#!"
                ><img
                  class="img-fluid"
                  src="assets/img/gallery/hero-header.png"
                  alt="hero-header"
              /></a>
            </div>
            <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
              <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">
                식당 정보
              </h1>
              <h1 class="text-800 mb-5 fs-4">
                <br />식당정보 추가페이지입니다!<br />
              </h1>
            </div>
          </div>
        </div>
      </section>
      <!-- 최상단 끝 -->

      <div class="card mb-4">
        <!-- AddDiner.vue -->
        <div class="submit-form mt-5 mb-5 card-header">
          <!-- 새 양식 폼 시작 -->
          <div v-if="!submitted" class="card-body" style="width: 500px">
            <!-- 식당이름 -->
            <div class="form-group">
              <label for="dname">식당이름</label>
              <input
                type="text"
                class="form-control"
                id="dname"
                required
                v-model="diner.dname"
                name="dname"
              />
            </div>

            <!-- 평점 -->
            <div class="form-group">
              <label for="score">평점</label>
              <input
              type="text"
                class="form-control"
                id="score"
                required
                v-model="diner.score"
                name="score"
              />
            </div>

            <!-- 지역 -->
            <div class="form-group">
              <label for="loc">지역</label>
              <input
                class="form-control"
                id="loc"
                required
                v-model="diner.loc"
                name="loc"
              />
            </div>

            <!-- 전화번호 -->
            <div class="form-group">
              <label for="phone">전화번호</label>
              <input
              type="text"
                class="form-control"
                id="phone"
                required
                v-model="diner.phone"
                name="phone"
              />
            </div>

            <!-- 메뉴 -->
            <div class="form-group">
              <label for="menu">메뉴</label>
              <input
              type="text"
                class="form-control"
                id="menu"
                required
                v-model="diner.menu"
                name="menu"
              />
            </div>

            <!-- 사진 입력박스 시작 -->
            <div class="form-group">
              <label for="photo" class="form-label">사진</label>
              <input
              type="image"
                class="form-control"
                id="photo"
                required
                v-model="diner.photo"
                name="photo"
              />
            </div>
            <!-- 이미지명 입력박스 끝 -->

            <!-- 이미지 선택상자 시작 -->
            <div class="form-group">
              <label class="btn btn-default p-0">
                <!--  파일 선택상자  -->
                <input
                  type="file"
                  accept="image/*"
                  ref="file"
                  @change="selectImage"
                />
              </label>
            </div>
            <!-- 이미지 선택상자 끝 -->

            <!-- upload 버튼 : insert 문 실행 시작 -->
            <div class="mb-3">
              <!--  서버에 insert 문 호출  -->
              <button
                class="btn btn-success btn-sm float-left"
                :disabled="!currentImage"
                @click="upload"
              >
                Upload
              </button>
            </div>
            <!-- upload 버튼 : insert 문 실행 끝 -->

            <!-- 미리보기 이미지 시작 -->
            <div v-if="previewImage">
              <div>
                <img class="preview my-3" :src="previewImage" alt="" />
              </div>
            </div>
            <!-- 미리보기 이미지 끝 -->

            <!-- 서버 에러 메세지가 있을 경우 아래 출력 시작 -->
            <div v-if="message" class="alert alert-secondary" role="alert">
              {{ message }}
            </div>
            <!-- 서버 에러 메세지가 있을 경우 아래 출력 끝 -->

            <button @click="saveDiner" class="btn btn-success mt-5 mb-3">
              Submit
            </button>
          </div>

          <!-- 새 양식 폼 끝 -->
        </div>
      </div>
    </main>
  </div>
</template>


<script>
// axios 공통함수 import
import DinerDataService from "@/services/DinerDataService";

export default {
  data() {
    return {
      currentImage: undefined, // 현재 이미지 변수
      previewImage: undefined, // 미리보기 이미지 변수
      message: "", // 서버쪽 메세지를 저장할 변수
      galleryDb: [], // 이미지 객체 배열

      diner: {
        dno: null,
        dname: "",
        loc: "",
        score: "",
        review: "",
        menu: "",
        phone: "",
        // springboot 에 요청할 변수, 이미지명(galleryTitle), 내용(content)
        photo: "",
      },
      // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
      submitted: false,
    };
  },
  methods: {
    saveDiner() {
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(dno) 자동생성되므로 빼고 전송함
      let data = {
        dname: this.diner.dname,
        loc: this.diner.loc,
        score: this.diner.score,
        menu: this.diner.menu,
        phone: this.diner.phone,
        photo: this.diner.photo,
      };

      // insert 요청 함수 호출(axios 공통함수 호출)
      DinerDataService.create(data)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          this.diner.dno = response.data.dno;
          // 콘솔 로그 출력(response.data)
          console.log(response.data);
          alert("추가가 완료되었습니다!");
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /diner
          this.$router.push("/diner");
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    newDiner() {
      // 새양식 다시 보여주기 함수, 변수 초기화
      this.submitted = false;
      this.diner = {};
    },
      // 파일 선택상자에서 선택한 이미지를 저장하는 함수
      selectImage() {
      // 첫번째 선택한 이미지를 변수에 저장
      // this.$refs : $refs 속성이 있는 컨트롤이 선택됨
      this.currentImage = this.$refs.file.files.item(0);
      // .createObjectURL() : 이미지 주소만 참조해서 이미지 보여주기 함수
      this.previewImage = URL.createObjectURL(this.currentImage);
      this.message = "";
    }, // upload 함수
    upload() {
      DinerDataService.upload(
        this.galleryTitle,
        this.currentImage
      )
        // insert 성공 then()
        .then((response) => {
          // 서버쪽 성공 메세지를 저장
          this.message = response.data.message;

          // 화면에 재조회 요청( axios 함수로 재조회 요청 )
          return DinerDataService.getFiles(
            this.searchTitle,
            this.page - 1,
            this.pageSize
          );
        })
        // 조회가 성공하면 실행되는 then()
        .then((response2) => {
          const { galleryDb, totalItems } = response2.data;
          this.galleryDb = galleryDb;
          this.count = totalItems;
          console.log(response2.data);
        })
        .catch((e) => {
          console.log(e);
          // 서버쪽에 실패메세지를 받아서 화면에 출력
          this.message = "Could not upload the image!" + e;
          this.currentImage = undefined;
        });
    },
  },
};
</script>

<style>
.submit-form {
  max-width: 700px;
  margin: auto;
}
</style>
