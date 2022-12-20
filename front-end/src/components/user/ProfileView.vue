<template>
  <div>
    <!-- 최상단 시작 -->
    <section class="py-5 overflow-hidden bg-warning" id="home">
      <div class="container">
        <div class="row flex-center">
          <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
            <!-- <a class="img-landing-banner" href="#!"
              ><img
                class="img-fluid"
                src="@/assets/img/species/korean.jpg"
                alt="hero-header"
            /></a> -->
          </div>
          <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
            <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">
              여기는 프로필 <br />
              페이지 입니다
            </h1>
            <h1 class="text-800 mb-5 fs-4">최상단만 제작</h1>
          </div>
        </div>
      </div>
    </section>
    <!-- 최상단 끝 -->

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
    <section>
      <div class="container">
        <div class="mx-auto text-center mt-7 mb-5">
          <h5 class="fw-bold fs-3 fs-lg-5 lh-sm">내 정보</h5>
        </div>
        <div class="row">
          <!-- 프로필 사진 시작 -->
          <div class="col-2 pt-3">
            <div class="text-center">
              <img
                class="profile"
                src="assets/img/gallery/gosimperson2.jpg"
                width="200px"
                height="200px"
                alt=""
              />
            </div>
          </div>
          <!-- 프로필 사진 끝 -->

          <!-- 이름, 개인정보 수정 버튼 시작 -->
          <div class="col-2 pt-5 me-auto">
            <div class="text-center">
              <h5>{{ currentUser.username }} 님</h5>
              <p class="pt-5">
                <router-link to="" class="btn btn-primary"
                  >개인정보 수정하기</router-link
                >
              </p>
            </div>
          </div>
          <!-- 이름, 개인정보 수정 버튼 끝 -->

          <!-- 예약 확인하기 시작 -->
          <div class="col-2 border pt-5">
            <router-link to="">
              <div class="col text-center align-self-center">
                <i class="bi bi-journal-check"></i>
                <p class="fs-1">예약 조회</p>
              </div>
            </router-link>
          </div>
          <!-- 예약 확인하기 끝 -->
          <!-- 찜 목록 조회하기 시작 -->
          <div class="col-2 border pt-5">
            <router-link to="">
              <div class="col text-center">
                <i class="bi bi-suit-heart card-top"></i>
                <p class="fs-1">찜한 가게</p>
              </div>
            </router-link>
          </div>
          <!-- 찜 목록 조회하기 끝 -->
          <!-- 리뷰 관리 시작 -->
          <div class="col-2 border pt-5">
            <router-link to="">
              <div class="col text-center">
                <i class="bi bi-chat-dots card-top"></i>
                <p class="fs-1">내가 쓴 리뷰</p>
              </div>
            </router-link>
          </div>
          <!-- 리뷰 관리 끝 -->
        </div>
      </div>
    </section>
    <!-- 프로필, 예약, 찜, 리뷰 끝 -->

    <!-- 최근 본 가게 시작 -->
    <section>
      <div class="mx-auto text-center mb-5">
        <h5 class="fw-bold fs-3 fs-lg-5 lh-sm">최근 본 가게</h5>
      </div>
      <div class="container">
        <div class="owl-carousel testimonial-carousel">
          <!-- 1 -->
          <div class="position-relative">
            <div class="card" style="width: 18rem">
              <img
                src="https://ldb-phinf.pstatic.net/20221113_271/1668319190296wqBDT_JPEG/IMG_6177_2.JPG"
                class="card-img-top"
                alt=""
              />
              <div class="card-body">
                <h5 class="card-title">강릉현대장칼국수 부산2호점</h5>
                <div class="card-text">
                  <span class="text-warning me-2"
                    ><i class="fas fa-map-marker-alt"></i></span
                  ><span class="text-primary">서면</span>
                </div>
              </div>
              <ul>
                <li>매일 11:00 - 21:00 <br />20:30 라스트오더</li>
              </ul>
              <div class="card-body btn btn-primary">
                <router-link to="" class="card-link text-white"
                  >예약하기</router-link
                >
              </div>
            </div>
          </div>

          <!-- 2 -->
          <div class="position-relative">
            <div class="card" style="width: 18rem">
              <img
                src="https://ldb-phinf.pstatic.net/20220330_36/1648623511617Jb1zG_JPEG/1643331771309-0.jpg"
                class="card-img-top"
                alt=""
              />
              <div class="card-body">
                <h5 class="card-title">디퀄리타</h5>
                <div class="card-text">
                  <span class="text-warning me-2"
                    ><i class="fas fa-map-marker-alt"></i></span
                  ><span class="text-primary">서면</span>
                </div>
              </div>
              <ul>
                <li>월-토 11:30 - 22:00 일요일 휴무 <br />20:30 라스트오더</li>
              </ul>
              <div class="card-body btn btn-primary">
                <router-link to="" class="card-link text-white"
                  >예약하기</router-link
                >
              </div>
            </div>
          </div>

          <!-- 3 -->
          <div class="position-relative">
            <div class="card" style="width: 18rem">
              <img
                src="https://ldb-phinf.pstatic.net/20221109_49/1667988084702HrJOG_JPEG/KakaoTalk_20221020_113119374.jpg"
                class="card-img-top"
                alt=""
              />
              <div class="card-body">
                <h5 class="card-title">후라토식당 서면점</h5>
                <div class="card-text">
                  <span class="text-warning me-2"
                    ><i class="fas fa-map-marker-alt"></i></span
                  ><span class="text-primary">서면</span>
                </div>
              </div>
              <ul>
                <li>매일 11:30 - 22:00 <br />21:00 라스트오더</li>
              </ul>
              <div class="card-body btn btn-primary">
                <router-link to="" class="card-link text-white"
                  >예약하기</router-link
                >
              </div>
            </div>
          </div>

          <!-- 4 -->
          <div class="position-relative">
            <div class="card" style="width: 18rem">
              <img
                src="https://ldb-phinf.pstatic.net/20221124_186/1669262891000tEB1Q_PNG/%B7%CE%B0%ED7.png"
                class="card-img-top"
                alt=""
              />
              <div class="card-body">
                <h5 class="card-title">컵플</h5>
                <div class="card-text">
                  <span class="text-warning me-2"
                    ><i class="fas fa-map-marker-alt"></i></span
                  ><span class="text-primary">서면</span>
                </div>
              </div>
              <ul>
                <li>매일 10:00 - 18:30 <br />18:00 라스트오더</li>
              </ul>
              <div class="card-body btn btn-primary">
                <router-link to="" class="card-link text-white"
                  >예약하기</router-link
                >
              </div>
            </div>
          </div>

          <!-- 5 -->
          <div class="position-relative">
            <div class="card" style="width: 18rem">
              <img
                src="https://ldb-phinf.pstatic.net/20221008_173/1665158490202Aosi6_JPEG/1AC19864-A1DA-47CC-AE0C-F9FDC8BB1909.jpeg"
                class="card-img-top"
                alt=""
              />
              <div class="card-body">
                <h5 class="card-title">차선책</h5>
                <div class="card-text">
                  <span class="text-warning me-2"
                    ><i class="fas fa-map-marker-alt"></i></span
                  ><span class="text-primary">서면</span>
                </div>
              </div>
              <ul>
                <li>매일 11:00 - 22:00 <br />21:30 라스트오더</li>
              </ul>
              <div class="card-body btn btn-primary">
                <router-link to="" class="card-link text-white"
                  >예약하기</router-link
                >
              </div>
            </div>
          </div>

          <!-- 6 -->
          <div class="position-relative">
            <div class="card" style="width: 18rem">
              <img
                src="https://ldb-phinf.pstatic.net/20220728_8/1659004494387VT8qo_JPEG/E41FD257-DAE2-419C-8F90-85DB4437DC5F.jpeg"
                class="card-img-top"
                alt=""
              />
              <div class="card-body">
                <h5 class="card-title">어어마무시</h5>
                <div class="card-text">
                  <span class="text-warning me-2"
                    ><i class="fas fa-map-marker-alt"></i></span
                  ><span class="text-primary">서면</span>
                </div>
              </div>
              <ul>
                <li>매일 12:00 - 21:00 <br />20:00 라스트오더</li>
              </ul>
              <div class="card-body btn btn-primary">
                <router-link to="" class="card-link text-white"
                  >예약하기</router-link
                >
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- 최근 본 가게 끝 -->
  </div>
</template>

<script>
/* eslint-disable */
export default {
  computed: {
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },
  },
  // 화면이 뜨자마자 실행되는 이벤트
  mounted() {
    if (!this.currentUser) {
      this.$router.push("/login"); // user 키가 없으면 강제 /login 페이지 이동
    }

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
/* .qqq {
  background-color: aqua;
}
.www {
  background-color: burlywood;
}
.eee {
  background-color: cornflowerblue;
}
.rrr {
  background-color: indianred;
}
.aaa {
  background-color: yellow;
}
.bbb {
  background-color: tomato;
} */
</style>>
