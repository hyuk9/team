<template>
  <div>
    <div class="container col-8 mb-2 mt-2">
      <div class="AnnounceView-header mt-5">
        <h1><strong>공지사항 게시판</strong>
          <!-- <router-link :to="'/announce'">
            <button class="btn btn-warning offset-8" type="button">
              돌아가기
            </button>
          </router-link> -->
        </h1>
      </div>
      <div class="AnnounceView-title">
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
              <td scope="col" v-text="currentAnnounce.title"></td>
            </tr>
            <tr>
              <th scope="row">작성자</th>
              <td scope="row" v-text="currentAnnounce.writer"></td>
            </tr>
            <tr>
              <th scope="col">조회수</th>
              <td scope="col" v-text="currentAnnounce.views"></td>
            </tr>
            <tr>
              <!-- <td
                colspan="2"
                scope="row"
                style="padding: 10px"
              >{{ currentAnnounce.content }}</td> -->
              <td colspan="2" scope="row">
                <div class="contentarea">
                  {{ currentAnnounce.content }}
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>

      <!-- 댓글 창 만들어야 함
          <div v-for="(data, index) in comment" :key="index">
            <div>{{ data.writer }} 댓글:</div>
            <div>{{ data.content }}</div>
          </div> -->
      <div class="card">
        <div class="card-header pb-4">댓글
          <ul class="list-group" v-if="showSpan">
            <li class="list-group-item d-flex justify-content-between p-2" >
              <h4 class="col-1"><span class="badge rounded-pill bg-primary  text-dark">{{}}</span></h4>
              <p class="col-6">{{}}</p>
              <div class="d-flex">
                <div class="front-italic col-">작성일:{{}}&nbsp;</div>
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

    <div class="mb-3">
      <router-link :to="'/announce/' + currentAnnounce.aid">
        <button class="btn btn-warning offset-5" type="button" v-if="showAdminBoard">
          수정&삭제
        </button>
      </router-link>
    </div>
  </div>
</template>

<script>
import AnnounceDataService from "@/services/AnnounceDataService";
import CommentDataService from "@/services/CommentDataService";
export default {
  data() {
    return {
      currentColumn:null,
      currentAnnounce: null,
      message: "",
    };
  },
  methods: {
    // 부서번호(aid)로 조회 요청하는 함수
    getAnnounce(aid) {
      // axios 공통함수 호출
      AnnounceDataService.get(aid)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentAnnounce = response.data;
          // 콘솔 로그 출력
          console.log("공지사항 조회 성공 : ", response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          // /////////////////////////////////////////////////////
          console.log("공지사항 조회 실패 : ", e);
          //////////////////////////////////
        });
    },

    // 부서정보를 수정 요청하는 함수
    updateAnnounce() {
      // axios 공통함수 호출
      AnnounceDataService.update(this.currentAnnounce.aid, this.currentAnnounce)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.message = "The Announce was updated successfully!";
          this.$router.push("/announce");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    // 부서정보를 삭제 요청하는 함수
    deleteAnnounce() {
      // axios 공통함수 호출
      AnnounceDataService.delete(this.currentAnnounce.aid)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /announce
          this.$router.push("/announce");
        })
        // 실패하면 .catch() 에러메세지가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },

    // FIXME: 성공은 하는데 response.data에 아무것도 안들어감;
    // Todo : 댓글 정보를 조회요청하는 함수
    getComment() {
      CommentDataService.getCommentByQno(
        this.currentColumn.cid,
        this.page - 1,
        this.pageSize
      )
        .then((response) => {
          // springboot 결과를 리턴함(질문 객체)
          const { comment, totalItems } = response.data; // springboot 의 전송한 맵 정보
          this.comment = comment; // 스프링부트에서 전송한 데이터
          this.count = totalItems;
          // 콘솔 로그 출력
          console.log("댓글 정보 조회 성공 : ", response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log("댓글 정보 조회 실패 : ", e);
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
    this.message = "";
    this.getAnnounce(this.$route.params.aid);
  },
};
</script>

<style>
.contentarea {
  width: 1240px;
  height: 500px;
  padding: 30px;
}
</style>
