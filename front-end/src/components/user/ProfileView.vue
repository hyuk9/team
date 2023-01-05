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
            <div class="text-center" v-if="profiles">
              <img class="profile" src="assets/img/gallery/empty_profile.png" width="200px" height="200px" alt="" />
            </div>
            <div class="text-center" v-else>
              <img class="profile" :src="currentProfile.fileUrl" width="200px" height="200px" alt="" />
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
                    개인정보 수정하기</span></router-link>
              </p>
              <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas"
                data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
                이미지 수정
              </button>

              <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample"
                aria-labelledby="offcanvasExampleLabel">
                <div class="offcanvas-header container">
                  <h5 class="offcanvas-title" id="offcanvasExampleLabel">이미지 수정</h5>
                  <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"
                    aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                  <div>
                    <img :src="previewImage" class="card-img-top" alt="" />
                  </div>
                  <div>
                    <label class="btn btn-default p-0">
                      <!-- 파일 선택상자 -->
                      <input type="file" class="col-5" accept="image/*" ref="file" @change="selectImage" />
                      <button @click="saveProfile" class="btn btn-primary col-5">수정하기</button>
                    </label>
                  </div>
                </div>
              </div>
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
                <i class="bi bi-suit-heart card-top"></i>
                <p class="fs-1 mt-3">찜한 가게</p>
              </div>
            </a>
          </div>
          <!-- 찜 목록 조회하기 끝 -->

          <!-- 리뷰 관리 시작 -->
          <div class="col-2 pt-5">
            <a href="#myReview">
              <div class="col text-center">
                <i class="bi bi-chat-dots card-top"></i>
                <p class="fs-1 mt-3">내가 쓴 리뷰</p>
              </div>
            </a>
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
    <div class="pt-5 pb-5" id="myReview">
      <div class="mx-auto text-center mb-5">
        <h5 class="fw-bold fs-3 fs-lg-5 lh-sm">내가 쓴 리뷰 목록</h5>
      </div>
      <div class="untree_co-section">
        <div class="container" data-aos="fade-left" data-aos-delay="200">
          <div class="row">
            <div class="col-lg-10 mx-auto text-center">
              <table class="table">
                <thead>
                  <tr>
                    <!-- <th scope="col">Last Name</th> -->
                    <th scope="col">번호</th>
                    <th scope="col">음식점명</th>
                    <th scope="col">리뷰</th>
                    <th scope="col">사진</th>
                    <th scope="col">작성자</th>
                    <th scope="col">변경하기</th>
                  </tr>
                </thead>
                <tbody>
                  <!-- <tr @click="setActive(data, index)"> -->
                  <tr>
                    <th scope="col">1</th>
                    <th scope="col">스미스가 좋아하는 한옥</th>
                    <th scope="col">사장님이 친절하고 요리가 맛있어요</th>
                    <th scope="col">사진</th>
                    <th scope="col">임꺽정</th>
                    <td>
                      <router-link to=""><span class="badge bg-success">수정하기</span></router-link>
                    </td>
                  </tr>
                  <tr>
                    <th scope="col">2</th>
                    <th scope="col">롯데호텔 서울 라센느</th>
                    <th scope="col">여친이랑 와보고 싶어요</th>
                    <th scope="col">사진</th>
                    <th scope="col">홍길동</th>
                    <td>
                      <router-link to=""><span class="badge bg-success">수정하기</span></router-link>
                    </td>
                  </tr>
                </tbody>
              </table>

              <!--    Todo : page 바 시작 -->
              <div class="col-md-8 offset-4 pt-5">
                <b-pagination v-model="page" :total-rows="count" :per-page="pageSize" prev-text="Prev" next-text="Next"
                  @change="handlePageChange"></b-pagination>
              </div>
              <!--    Todo : page 바 끝 -->

              <!-- search 관련 div 시작 -->
              <div class="col-md-6 offset-3 pt-5">
                <div class="input-group mb-3">
                  <!-- Todo : 수정 시작 -->
                  <input type="text" class="form-control" placeholder="Search by Restaurant" v-model="searchName" />
                  <div class="input-group-append">
                    <button class="btn btn-primary" type="button" @click="
  page = 1;
retrieveReview();
                    ">
                      Search
                    </button>
                  </div>
                  <!-- Todo : 수정 끝 -->
                </div>
              </div>
              <!-- search 관련 div 끝 -->
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 내가 쓴 리뷰 목록 끝 -->

    <!-- 최근 본 가게 시작 -->
    <div class="pt-5 pb-5">
      <div class="mx-auto text-center mb-5">
        <h5 class="fw-bold fs-3 fs-lg-5 lh-sm">최근 본 가게</h5>
      </div>
      <div class="container">
        <div class="owl-carousel testimonial-carousel">
          <!-- 1 -->
          <div class="position-relative">
            <div class="card" style="width: 18rem">
              <img src="https://ldb-phinf.pstatic.net/20221113_271/1668319190296wqBDT_JPEG/IMG_6177_2.JPG"
                class="card-img-top" alt="" />
              <div class="card-body">
                <h5 class="card-title">강릉현대장칼국수 부산2호점</h5>
                <div class="card-text">
                  <span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span
                    class="text-primary">서면</span>
                </div>
              </div>
              <ul>
                <li>매일 11:00 - 21:00 <br />20:30 라스트오더</li>
              </ul>
              <div class="card-body btn btn-primary">
                <router-link to="" class="card-link text-white">예약하기</router-link>
              </div>
            </div>
          </div>

          <!-- 2 -->
          <div class="position-relative">
            <div class="card" style="width: 18rem">
              <img src="https://ldb-phinf.pstatic.net/20220330_36/1648623511617Jb1zG_JPEG/1643331771309-0.jpg"
                class="card-img-top" alt="" />
              <div class="card-body">
                <h5 class="card-title">디퀄리타</h5>
                <div class="card-text">
                  <span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span
                    class="text-primary">서면</span>
                </div>
              </div>
              <ul>
                <li>월-토 11:30 - 22:00 일요일 휴무 <br />20:30 라스트오더</li>
              </ul>
              <div class="card-body btn btn-primary">
                <router-link to="" class="card-link text-white">예약하기</router-link>
              </div>
            </div>
          </div>

          <!-- 3 -->
          <div class="position-relative">
            <div class="card" style="width: 18rem">
              <img
                src="https://ldb-phinf.pstatic.net/20221109_49/1667988084702HrJOG_JPEG/KakaoTalk_20221020_113119374.jpg"
                class="card-img-top" alt="" />
              <div class="card-body">
                <h5 class="card-title">후라토식당 서면점</h5>
                <div class="card-text">
                  <span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span
                    class="text-primary">서면</span>
                </div>
              </div>
              <ul>
                <li>매일 11:30 - 22:00 <br />21:00 라스트오더</li>
              </ul>
              <div class="card-body btn btn-primary">
                <router-link to="" class="card-link text-white">예약하기</router-link>
              </div>
            </div>
          </div>

          <!-- 4 -->
          <div class="position-relative">
            <div class="card" style="width: 18rem">
              <img src="https://ldb-phinf.pstatic.net/20221124_186/1669262891000tEB1Q_PNG/%B7%CE%B0%ED7.png"
                class="card-img-top" alt="" />
              <div class="card-body">
                <h5 class="card-title">컵플</h5>
                <div class="card-text">
                  <span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span
                    class="text-primary">서면</span>
                </div>
              </div>
              <ul>
                <li>매일 10:00 - 18:30 <br />18:00 라스트오더</li>
              </ul>
              <div class="card-body btn btn-primary">
                <router-link to="" class="card-link text-white">예약하기</router-link>
              </div>
            </div>
          </div>

          <!-- 5 -->
          <div class="position-relative">
            <div class="card" style="width: 18rem">
              <img
                src="https://ldb-phinf.pstatic.net/20221008_173/1665158490202Aosi6_JPEG/1AC19864-A1DA-47CC-AE0C-F9FDC8BB1909.jpeg"
                class="card-img-top" alt="" />
              <div class="card-body">
                <h5 class="card-title">차선책</h5>
                <div class="card-text">
                  <span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span
                    class="text-primary">서면</span>
                </div>
              </div>
              <ul>
                <li>매일 11:00 - 22:00 <br />21:30 라스트오더</li>
              </ul>
              <div class="card-body btn btn-primary">
                <router-link to="" class="card-link text-white">예약하기</router-link>
              </div>
            </div>
          </div>

          <!-- 6 -->
          <div class="position-relative">
            <div class="card" style="width: 18rem">
              <img
                src="https://ldb-phinf.pstatic.net/20220728_8/1659004494387VT8qo_JPEG/E41FD257-DAE2-419C-8F90-85DB4437DC5F.jpeg"
                class="card-img-top" alt="" />
              <div class="card-body">
                <h5 class="card-title">어어마무시</h5>
                <div class="card-text">
                  <span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span
                    class="text-primary">서면</span>
                </div>
              </div>
              <ul>
                <li>매일 12:00 - 21:00 <br />20:00 라스트오더</li>
              </ul>
              <div class="card-body btn btn-primary">
                <router-link to="" class="card-link text-white">예약하기</router-link>
              </div>
            </div>
          </div>
        </div>
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

export default {
  data() {
    return {
      // currentReservation: null,
      reservation: [],
      searchName: "",
      currentData: null,
      currentProfile: null,
      profiles:true,
      currentIndex: -1,
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

    handlePageChange(value) {
      this.page = value;
      this.retrieveReservation();
    },
    handlePageSizeChange(event) {
      this.pageSize = event.target.value;
      this.page = 1;
      this.retrieveReservation();
    },
    setActive(data, index) {
      console.log(data);
      this.currentData = data;
      this.currentIndex = index;
    },

    saveProfile() {
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(no) 자동생성되므로 빼고 전송함
      this.progress = 0;
      // insert 요청 함수 호출(axios 공통함수 호출)
      ProfileDataService.create(

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
          this.profiles=false;
          // 변수 submitted
          alert("성공했습니다.");
          this.getProfile(1)
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
    ReservationCom
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
