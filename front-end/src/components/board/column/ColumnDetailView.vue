<template>
  <div>
    <div>
      <div class="container col-6 mb-2 mt-2">
        <div class="AnnounceView-header mt-5">
          <h1>
            <strong>푸드컬럼 수정</strong>
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
              v-model="currentColumn.title"
            />
          </div>
          <div class="input-group mt-3 mb-4">
            <span class="input-group-text">부제목</span>
            <input
              type="text"
              class="form-control"
              style="height: 50px"
              id="subtitle"
              required
              name="subtitle"
              v-model="currentColumn.subtitle"
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
              v-model="currentColumn.writer"
            />
          </div>

          <div class="mb-5">
            <textarea
              class="form-control form-control-lg"
              id="content"
              rows="8"
              required
              name="content"
              v-model="currentColumn.content"
            ></textarea>
          </div>
        </div>

        <div class="mb-3">
          <div class="row">
            <div class="col-sm-4">
              <img :src="currentColumn.fileUrl" class="card-img-top" alt="" />
            </div>
          </div>
          <div class="mb-3">
            <label class="btn btn-default p-0">
              <input
                type="file"
                accept="image/*"
                ref="file"
                @change="selectImage"
              />
            </label>
          </div>

          <div v-if="message" class="alert alert-secondary" role="alert">
            {{ message }}
          </div>
        </div>

        <div class="mb-3">
          <div v-if="checkImage2">
            <svg xmlns="http://www.w3.org/2000/svg" style="display: none">
              <symbol
                id="exclamation-triangle-fill"
                fill="currentColor"
                viewBox="0 0 16 16"
              >
                <path
                  d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"
                />
              </symbol>
            </svg>
            <div
              class="alert alert-danger d-flex align-items-center"
              role="alert"
            >
              <svg
                class="bi flex-shrink-0 me-2"
                width="24"
                height="24"
                role="img"
                aria-label="Danger:"
              >
                <use xlink:href="#exclamation-triangle-fill" />
              </svg>
              <div>이미지를 넣어주세요!</div>
            </div>
          </div>
          <button
            v-if="checkImage"
            @click="updateColumn"
            class="btn btn-primary me-3"
          >
            수정
          </button>
          <button
            v-else
            @click="updateColumn"
            class="btn btn-primary me-3"
            disabled
          >
            수정
          </button>
          <button @click="deleteColumn" class="btn btn-danger">삭제</button>
        </div>
        <div class="alert alert-success" role="alert" v-if="message">
          {{ message }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ColumnDataService from "@/services/ColumnDataService";
export default {
  data() {
    return {
      currentColumn: null,
      previewImage: null,
      message: "",
    };
  },
  methods: {
    // TODO: 푸드컬럼 pk로 조회 요청하는 함수
    getColumn(cid) {
      // axios 공통함수 호출
      ColumnDataService.get(cid)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentColumn = response.data;
          // 콘솔 로그 출력
          console.log("푸드컬럼 정보 조회 성공 : ", response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log("푸드컬럼 정보 조회 실패 : ", e);
        });
    },
    // TODO: 푸드컬럼 정보를 수정 요청하는 함수
    updateColumn() {
      // axios 공통함수 호출
      ColumnDataService.update(
        this.currentColumn.cid,
        this.currentUser.id,
        this.currentColumn.writer,
        this.currentColumn.title,
        this.currentColumn.content,
        this.currentImage
      )
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log("푸드컬럼 정보 수정 성공 : ", response.data);
          this.message = "The Column was updated successfully!";
          this.$router.push("/column");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log("푸드컬럼 정보 수정 실패 : ", e);
        });
    },
    // TODO: 이미지 정보 저장 함수
    selectImage() {
      // 파일선택상자에서 첫번째로 선택한 이미지가 저장됨
      this.currentImage = this.$refs.file.files.item(0);
      // 아래는 미리보기 이미지를 위한 주소가 저장됨
      this.previewImage = URL.createObjectURL(this.currentImage);
      this.progress = 0;
      this.message = "";
    },
    // TODO: 푸드컬럼 정보를 삭제요청하는 함수
    deleteColumn() {
      // axios 공통함수 호출
      ColumnDataService.delete(this.currentColumn.cid)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log("푸드컬럼 정보 삭제 성공 : ", response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /column
          this.$router.push("/column");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log("푸드컬럼 정보 삭제 실패 : ", e);
        });
    },
  },
  // 화면이 뜨자 마자 실행되는 이벤트
  mounted() {
    this.message = "";
    this.getColumn(this.$route.params.cid);
  },

  computed: {
    // TODO: 로컬 스토리지에 저장된 현재 유저 정보 가져오는 함수
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },

    existImage() {
      if (this.currentColumn.fileUrl != null) {
        console.log("로그는:", this.currentColumn);
        return true;
      } else {
        console.log("else:", this.currentColumn);
        return false;
      }
    },

    checkImage() {
      if (this.previewImage != null) {
        return true;
      } else {
        return false;
      }
    },

    checkImage2() {
      if (this.previewImage != null) {
        return false;
      } else {
        return true;
      }
    },
  },
};
</script>

<style>
#imageSize {
  width: 550px;
  height: 500px;
}
</style>