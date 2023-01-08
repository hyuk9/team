<template>
  <div>
    <!-- <div class="container">
      <header class="jumbotron">
        <h3>
          <strong>{{ currentUser.username }}</strong> Profile
        </h3>
      </header>
      <p>
        <strong>Token:</strong>
        {{ currentUser.accessToken.substring(0, 20) }} …
        {{
          currentUser.accessToken.substr(currentUser.accessToken.length - 20)
        }}
      </p>
      <p>
        <strong>Id:</strong>
        {{ currentUser.id }}
      </p>
      <p>
        <strong>Email:</strong>
        {{ currentUser.email }}
      </p>
      <strong>Authorities:</strong>
      <ul>
        <li v-for="(role, index) in currentUser.roles" :key="index">
          {{ role }}
        </li>
      </ul>
    </div> -->

    <!-- 프로필, 예약, 찜, 리뷰 시작 -->
    <div class="pt-5 pb-5">
      <div class="container">
        <div class="row">
          <!-- 프로필 사진 시작 -->
          <div class="col-2 pt-3">
            <div>
              <div class="text-center" v-if="profileImage">
                <img
                  class="profile"
                  src="assets/img/gallery/empty_profile.png"
                  width="200px"
                  height="200px"
                  alt=""
                />
              </div>
              <div class="text-center" v-else>
                <img
                  class="profile"
                  :src="currentProfile.fileUrl"
                  width="200px"
                  height="200px"
                  alt=""
                />
              </div>
              <!-- 이미지 수정 버튼 -->
              <span
                id="imageBtn"
                class="btn btn-primary"
                type="button"
                data-bs-toggle="offcanvas"
                data-bs-target="#offcanvasExample"
                aria-controls="offcanvasExample"
              >
                <i class="bi bi-camera-fill fs-3" id="camera"></i>
              </span>
            </div>
            <div
              class="offcanvas offcanvas-start"
              tabindex="-1"
              id="offcanvasExample"
              aria-labelledby="offcanvasExampleLabel"
            >
              <div class="offcanvas-header container">
                <h5 class="offcanvas-title" id="offcanvasExampleLabel">
                  이미지 수정
                </h5>
                <button
                  type="button"
                  class="btn-close text-reset"
                  data-bs-dismiss="offcanvas"
                  aria-label="Close"
                ></button>
              </div>
              <div class="offcanvas-body">
                <div>
                  <img :src="previewImage" class="card-img-top" alt="" />
                </div>
                <div>
                  <label class="btn btn-default p-0">
                    <!-- 파일 선택상자 -->
                    <input
                      type="file"
                      class="col-5"
                      accept="image/*"
                      ref="file"
                      @change="selectImage"
                    />
                    <button @click="saveProfile" class="btn btn-primary col-5">
                      수정하기
                    </button>
                  </label>
                </div>
              </div>
            </div>
          </div>
          <!-- 프로필 사진 끝 -->

          <!-- 이름, 개인정보 수정 버튼 시작 -->
          <div class="col-2 pt-5 me-auto">
            <div class="text-center">
              <h5>{{ currentUser.username }} 님</h5>
              <p class="pt-5">
                <router-link :to="'/user/' + currentUser.id">
                  <span class="btn btn-primary">
                    개인정보 수정하기</span
                  ></router-link
                >
              </p>
            </div>
          </div>
          <!-- 이름, 개인정보 수정 버튼 끝 -->

          <!-- 예약 확인하기 시작 -->
          <div class="col-2 pt-5">
            <a href="#reservationCheck">
              <div class="col text-center align-self-center">
                <i class="bi bi-journal-check"></i>
                <p class="fs-1 mt-3">예약 조회</p>
              </div>
            </a>
          </div>
          <!-- 예약 확인하기 끝 -->

          <!-- 찜 목록 조회하기 시작 -->
          <div class="col-2 pt-5">
            <a href="#favoriteList">
              <div class="col text-center">
                <i class="bi bi-heart"></i>
                <p class="fs-1 mt-3">찜한 가게</p>
              </div>
            </a>
          </div>
          <!-- 찜 목록 조회하기 끝 -->

          <!-- 리뷰 관리 시작 -->
          <div class="col-2 pt-5">
            <a href="#myReview">
              <div class="col text-center">
                <i class="bi bi-chat-dots"></i>
                <p class="fs-1 mt-3">내가 쓴 리뷰</p>
              </div>
            </a>
          </div>
          <!-- 리뷰 관리 끝 -->

          <!-- 리뷰 관리 시작 -->
          <div class="col-2 pt-5">
            <a
              data-bs-toggle="offcanvas"
              data-bs-target="#offcanvasRight"
              aria-controls="offcanvasRight"
            >
              <div class="col text-center">
                <i class="bi bi-file-earmark-richtext"></i>
                <p class="fs-1 mt-3">최근 본 페이지</p>
              </div>
            </a>
            <!-- <a href="#latelyPage">
              <div class="col text-center">
                <i class="bi bi-file-earmark-richtext"></i>
                <p class="fs-1 mt-3">최근 본 페이지</p>
              </div>
            </a> -->
          </div>
          <!-- 리뷰 관리 끝 -->
        </div>
      </div>
    </div>
    <!-- 프로필, 예약, 찜, 리뷰 끝 -->

    <!-- 예약조회 섹션 시작 -->
    <ReservationCom />
    <!-- 예약조회 섹션 끝 -->

    <!-- 찜한 가게 시작 -->
    <FavoriteCom />
    <!-- 찜한 가게 끝 -->

    <!-- 내가 쓴 리뷰 목록 시작 -->
    <ReviewCom />
    <!-- 내가 쓴 리뷰 목록 끝 -->

    <!-- 최근 본 가게 시작 -->
    <div
      class="offcanvas offcanvas-end"
      tabindex="-1"
      id="offcanvasRight"
      aria-labelledby="offcanvasRightLabel"
    >
      <div class="offcanvas-header">
        <h3 id="offcanvasRightLabel">최근 본 가게</h3>
        <button
          type="button"
          class="btn-close text-reset"
          data-bs-dismiss="offcanvas"
          aria-label="Close"
        ></button>
      </div>
      <div class="offcanvas-body">
        <LastviewCom />
      </div>
    </div>

    <!-- 최근 본 가게 끝 -->
  </div>
</template>

<script>
/* eslint-disable */
import ProfileDataService from "@/services/ProfileDataService";
import FavoriteCom from "@/components/user/ProfileCom/FavoriteCom.vue";
import ReservationCom from "@/components/user/ProfileCom/ReservationCom.vue";
import ReviewCom from "@/components/user/ProfileCom/ReviewCom.vue";
import LastviewCom from "@/components/user/ProfileCom/LastviewCom.vue";

export default {
  data() {
    return {
      // currentReservation: null,
      reservation: [],
      searchName: "",
      currentProfile: null,
      profileImage: true,
      currentImage: undefined, // 현재 이미지 변수
      previewImage: undefined, // 미리보기 이미지 변수
      message: "", // 서버쪽 메세지를 저장할 변수

      page: 1,
      count: 0,
      pageSize: 10,

      // pageSizes: [3, 6, 9],
    };
  },
  methods: {
    saveProfile() {
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(no) 자동생성되므로 빼고 전송함
      this.progress = 0;
      // insert 요청 함수 호출(axios 공통함수 호출)
      ProfileDataService.create(
        this.currentUser.id,
        this.currentImage
        // (eve) => {
        //   // 파일이 업로드될때 진척상황이 저장됨(%)
        //   this.progress = Math.round((100 * eve.loaded) / eve.total);
        // }
      )
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          this.message = response.data;
          this.profiles = false;
          // 변수 submitted
          alert("성공했습니다.");
          this.getProfile(this.currentUser.id);
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((err) => {
          this.progress = 0;
          this.message = "Could not upload the image! " + err;
          this.currentImage = undefined;
        });
    },

    getProfile(pno) {
      // axios 공통함수 호출
      ProfileDataService.get(pno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentProfile = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
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
  },
  computed: {
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },
  },

  components: {
    FavoriteCom,
    ReservationCom,
    ReviewCom,
    LastviewCom,
  },
  // 화면이 뜨자마자 실행되는 이벤트
  mounted() {
    if (!this.currentUser) {
      this.$router.push("/login"); // user 키가 없으면 강제 /login 페이지 이동
    }

    // this.saveProfile();

    // 캐러셀 초기화 실행
    $(".testimonial-carousel").owlCarousel({
      autoplay: true, // 자동으로 이미지가 돌아가게 할 것인지?
      smartSpeed: 1000, // 이미지가 변경될때 변경 속도
      nav: true,
      items: 4, // 초기 화면에 표시할 이미지 개수
      loop: true, // 마지막 사진이 오면 처음사진으로 돌아가게 할 것인지?
    });
  },
};
</script>

<style lang="scss" scoped>
li {
  list-style-type: none;
}

#imageBtn {
  position: absolute;
  width: 65px;
  height: 65px;
  top: 60%;
  left: 60%;
  background-color: rgba(0, 0, 0, 0.5);
  border: none;
  border-radius: 50%;
}

#camera {
  position: absolute;
  top: 20%;
  left: 32.5%;
}

.bi {
  font-size: 70px;
}

.border {
  width: 250px;
  height: 250px;
}

.profile {
  border-radius: 70%;
}
</style>
