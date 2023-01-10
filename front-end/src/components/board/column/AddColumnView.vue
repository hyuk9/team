<template>
  <div>
    <!-- AddColumn Start -->
    <div class="container" v-if="!submitted">
      <div class="mb-3">
        <label for="writer" class="form-label">작성자</label>
        <input type="writer" class="form-control" id="writer"  required name="writer" v-model="column.writer" />
      </div>
      <div class="mb-3">
        <label for="title" class="form-label">제목</label>
        <input type="title" class="form-control" id="title" required name="title" v-model="column.title" />
      </div>
      <div class="mb-3">
        <label for="content" class="form-label">내용</label>
        <textarea class="form-control form-control-lg" id="content" rows="8" required name="content"
          v-model="column.content"></textarea>
      </div>
      <div class="mb-3">
        <!-- <!— v-for 시작 —> -->
        <div class="row">
          <!-- <div class="col-sm-4" v-for="(data, index) in column" :key="index">
            <img :src="data.galleryUrl" class="card-img-top" alt="강의" />
            <a style="color: inherit" @click="deleteImage(data.cid)">
              <span class="badge bg-danger">Delete</span>
            </a>
          </div> -->
          <div class="col-sm-4">
            <img :src="previewImage" class="card-img-top" alt="" />
            <!-- <a style="color: inherit" @click="deleteImage(column.cid)">
              <span class="badge bg-danger">Delete</span>
            </a> -->
          </div>
        </div>
        <div class="mb-3">
          <label class="btn btn-default p-0">
            <!-- 파일 선택상자 -->
            <input type="file" accept="image/*" ref="file" @change="selectImage" />
          </label>
        </div>

        <!-- <div class="mb-3">
          <button class="btn btn-success btn-sm float-left" :disabled="!currentImage" @click="upload">
            Upload
          </button>
        </div> -->

        <!-- 서버 에러 메세지가 있을경우 아래 출력 -->
        <div v-if="message" class="alert alert-secondary" role="alert">
          {{ message }}
        </div>
      </div>
      <div class="mb-3">
        <button @click="saveColumn" class="btn btn-primary">Submit</button>
      </div>
    </div>
    <!-- AddColumn End -->
  </div>
</template>


<script>
import ColumnDataService from "@/services/ColumnDataService";
export default {
  data() {
    return {
      column: {
        cid: null,
        id: null,
        writer: "",
        title: "",
        content: "",
      },
      currentImage: undefined, // 현재 이미지 변수
      previewImage: undefined, // 미리보기 이미지 변수
      message: "", // 서버쪽 메세지를 저장할 변수
      searchTitle: "", // 이미지명으로 검색하는 변수
      // springboot 요청할 변수 , 이미지명(galleryTitle), 내용(content)
      galleryTitle: "",
      // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
      submitted: false,
      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 10, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      pageSizes: [5, 10, 20], // select box 에 넣을 기본 데이터
    };
  },
  methods: {
    saveColumn() {
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(no) 자동생성되므로 빼고 전송함
      this.progress = 0;
      // insert 요청 함수 호출(axios 공통함수 호출)
      ColumnDataService.create(
        this.column.id = this.currentUser.id,
        this.column.writer,
        this.column.title,
        this.column.content,
        this.currentImage,
        // (eve) => {
        //   // 파일이 업로드될때 진척상황이 저장됨(%)
        //   this.progress = Math.round((100 * eve.loaded) / eve.total);
        // }
      )
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.message = response.data;
          // 변수 submitted
          this.submitted = true;
          alert("성공했습니다.");
          location.href = "/column";
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((err) => {
          this.progress = 0;
          this.message = "Could not upload the image! " + err;
          this.currentImage = undefined;
        });
      // 서버에 이미지 업로드 요청(insert 문 실행)
      // ColumnDataService.createImage(
      //   this.currentImage,
      //   (eve) => {
      //     // 파일이 업로드될때 진척상황이 저장됨(%)
      //     this.progress = Math.round((100 * eve.loaded) / eve.total);
      //   }
      // )
      //   // 성공하면 then 으로 들어옴(서버에서 응답한 객체)
      //   .then((response) => {
      //     // 서버쪽 응답 메시지 저장
      //     console.log(response.data);
      //     this.message = response.data;
      //   })
      //   // 실패하면 catch으로 들어옴 : 화면에 실패메세지 출력
      //   .catch((err) => {
      //     this.progress = 0;
      //     this.message = "Could not upload the image! " + err;
      //     this.currentImage = undefined;
      //   });
    },
    newColumn() {
      // 새양식 다시 보여주기 함수, 변수 초기화
      this.submitted = false;
      this.column2 = {};
    },

    returnColumn() {
      location.href = "/column";
    },

    // TODO: 이미지 삽입 시작
    // 이미지를 선택하면 변수에 저장하는 메소드
    selectImage() {
      // 파일선택상자에서 첫번째로 선택한 이미지가 저장됨
      this.currentImage = this.$refs.file.files.item(0);
      // 아래는 미리보기 이미지를 위한 주소가 저장됨
      this.previewImage = URL.createObjectURL(this.currentImage);
      this.progress = 0;
      this.message = "";
    },
    // 파일 업로드를 위한 메소드
    // upload() {

    //   this.progress = 0;
    //   // 서버에 이미지 업로드 요청(insert 문 실행)
    //   ColumnDataService.createImage(
    //     this.currentImage,
    //     (eve) => {
    //       // 파일이 업로드될때 진척상황이 저장됨(%)
    //       this.progress = Math.round((100 * eve.loaded) / eve.total);
    //     }
    //   )
    //     // 성공하면 then 으로 들어옴(서버에서 응답한 객체)
    //     .then((response) => {
    //       // 서버쪽 응답 메시지 저장
    //       console.log(response.data);
    //       this.message = response.data;
    //     })
    //     // 실패하면 catch으로 들어옴 : 화면에 실패메세지 출력
    //     .catch((err) => {
    //       this.progress = 0;
    //       this.message = "Could not upload the image! " + err;
    //       this.currentImage = undefined;
    //     });
    // },
  },

  computed: {
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },
  },

}


</script>

<style>

</style>