<template>
  <div>
    <div class="container col-8 mb-2 mt-2">
      <div class="FreeView-header mt-5">
        <h1><strong>자유 게시판</strong></h1>
        <!-- <router-link :to="'/free'">
            <button class="btn btn-warning offset-8" type="button">
              돌아가기
            </button>
          </router-link> -->
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
              <th scope="row">조회수</th>
              <td scope="row" v-text="currentfreeForViews.views"></td>
            </tr>
            <tr>
              <td colspan="2" scope="row" style="padding: 10px">
                <div class="contentarea">
                  {{ currentFree.content }}
                  <div>
                    <img id="imageSize" class="preview my-3 " :src="currentFree.fileUrl" alt="" />
                  </div>
                </div>
                <!-- 미리보기 이미지 시작 -->
                <!-- 미리보기 이미지 끝 -->
              </td>
            </tr>
          </tbody>
        </table>
        <!-- 댓글 창 만들어야 함
          <div v-for="(data, index) in comment" :key="index">
            <div>{{ data.writer }} 댓글:</div>
            <div>{{ data.content }}</div>
          </div> -->
        <div class="card">
          <div class="card-header pb-4">댓글
            <ul class="list-group" v-if="showSpan">
              <li class="list-group-item d-flex justify-content-between p-2" 
                :key="index">
                <h4 class="col-1"><span class="badge rounded-pill bg-primary  text-dark">{{  }}</span></h4>
                <p class="col-6">{{  }}</p>
                <div class="d-flex">
                  <div class="front-italic col-">작성일:{{  }}&nbsp;</div>
                  <span class="badge bg-primary p-2 mt-1 ms-3"><span class="fs-0">수정</span></span>
                  <span class="badge bg-danger p-2 mt-1 ms-3"><span class="fs-0">삭제</span></span>
                  <!-- <span class="badge rounded-pill bg-danger text-dark col-2">삭제</span> -->
                </div>
                <!-- <h1>여기</h1> -->
              </li>
            </ul>
          </div>
        </div>

        <br />

        <div class="card">
          <div class="card-body input-group"><span class="input-group-text">댓글창</span><textarea class="form-control"
              row="1"></textarea><button type="button" class="btn btn-danger">등록</button></div>
        </div>
      </div>
    </div>

    <div class="mb-3">
      <router-link :to="'/free/' + currentFree.fno" v-if="showDetailBoard">
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
      currentIndex: -1,
      name: "",

      // 페이징을 위한 변수 정의
      page: 1, // 현재 페이지
      count: 0, // 전체 데이터 건수
      pageSize: 3, // 한페이지당 몇개를 화면에 보여줄지 결정하는 변수

      pageSizes: [3, 6, 9], // select box 에 넣을 기본 데이터

      // 조회수용 변수 추가
      currentfreeForViews: null,
    };
  },
  methods: {
    // 부서번호(fno)로 조회 요청하는 함수
    getFree(fno) {
      // axios 공통함수 호출
      FreeDataService.getById(fno)
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
      // axios 공통함수 호출
      FreeDataService.get(fno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentfreeForViews = response.data;
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

  },

  computed: {
    // 현재 유저
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },

    // // 관리자 접속인지 아닌지 확인하는 함수
    // showAdminBoard() {
    //   if (this.currentUser && this.currentUser.roles) {
    //     // if ROLE_ADMIN 있으면 true
    //     //               없으면 false
    //     return this.currentUser.roles.includes("ROLE_ADMIN");
    //   }
    //   // currentUser 없으면 false (메뉴가 안보임)
    //   return false;
    // },

    showDetailBoard() {
      if (this.currentUser && this.currentUser.roles) {
        // if ROLE_ADMIN 있으면 true 없으면 false 이거나 현재로그인한id == 글쓴사람id
        return this.currentUser.roles.includes("ROLE_ADMIN") || this.currentUser.id == this.currentFree.id;
      }
      // currentUser 없으면 false (메뉴가 안보임)
      return false;
    },
    // showImage() {
    //   if(this.currentFree.fileUrl) {
    //     return true;
    //   }
    //   return false;
    // }

    showSpan() {
      if (this.currentColumn != null) {
        return true;
      } else {
        return false;
      }
    }
  },

  // 화면이 뜨자 마자 실행되는 이벤트
  mounted() {
    this.message2 = "";
    this.getFree(this.$route.params.fno);
  },
};
</script>

<style>
.contentarea {
  width: 1240px;
  height: 600px;
  padding: 30px;
}

#imageSize {
  width: 550px;
  height: 500px;
}
</style>
