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
        <div class="row">
          <!-- 프로필 사진 & 이름 & 개인정보 수정 시작 -->
          <div class="border">
            <div class="col text-center">
              <img
                src="assets/img/gallery/boknim1.jpg"
                width="200px"
                height="200px"
                alt=""
              />
            </div>
          </div>
          <div class="border pt-5">
            <div class="col text-center">
              <h5>{{ currentUser.username }} 님</h5>
              <p class="pt-5">
                <router-link to="" class="btn btn-primary"
                  >개인정보 수정하기</router-link
                >
              </p>
            </div>
          </div>
          <!-- 프로필 사진 & 이름 & 개인정보 수정 끝 -->

          <!-- 예약 확인하기 시작 -->
          <div class="border pt-5">
            <router-link to="">
              <div class="col text-center align-self-center">
                <i class="bi bi-journal-check"></i>
                <p class="fs-1">예약 조회</p>
              </div>
            </router-link>
          </div>
          <!-- 예약 확인하기 끝 -->
          <!-- 찜 목록 조회하기 시작 -->
          <div class="border pt-5">
            <router-link to="">
              <div class="col text-center">
                <i class="bi bi-suit-heart card-top"></i>
                <p class="fs-1">찜한 가게</p>
              </div>
            </router-link>
          </div>
          <!-- 찜 목록 조회하기 끝 -->
          <!-- 리뷰 관리 시작 -->
          <div class="border pt-5">
            <router-link to="">
              <div class="col text-center">
                <i class="bi bi-chat-dots card-top"></i>
                <p class="fs-1">리뷰 관리</p>
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
      <div class="container">
        <div class="row">
          <div>
            <h3>최근 본 가게</h3>
          </div>
          <!-- 1 -->
          <div class="col">
            <div class="card" style="width: 18rem">
              <img
                src="https://ldb-phinf.pstatic.net/20221113_271/1668319190296wqBDT_JPEG/IMG_6177_2.JPG"
                class="card-img-top"
                alt=""
              />
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">
                  Some quick example text to build on the card title and make up
                  the bulk of the card's content.
                </p>
              </div>
              <ul class="list-group list-group-flush">
                <li class="list-group-item">An item</li>
                <li class="list-group-item">A second item</li>
                <li class="list-group-item">A third item</li>
              </ul>
              <div class="card-body">
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
              </div>
            </div>
          </div>

          <!-- 2 -->
          <div class="col">
            <div class="card" style="width: 18rem">
              <img
                src="https://ldb-phinf.pstatic.net/20220330_36/1648623511617Jb1zG_JPEG/1643331771309-0.jpg"
                class="card-img-top"
                alt=""
              />
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">
                  Some quick example text to build on the card title and make up
                  the bulk of the card's content.
                </p>
              </div>
              <ul class="list-group list-group-flush">
                <li class="list-group-item">An item</li>
                <li class="list-group-item">A second item</li>
                <li class="list-group-item">A third item</li>
              </ul>
              <div class="card-body">
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
              </div>
            </div>
          </div>

          <!-- 3 -->
          <div class="col">
            <div class="card" style="width: 18rem">
              <img
                src="https://ldb-phinf.pstatic.net/20221109_49/1667988084702HrJOG_JPEG/KakaoTalk_20221020_113119374.jpg"
                class="card-img-top"
                alt=""
              />
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">
                  Some quick example text to build on the card title and make up
                  the bulk of the card's content.
                </p>
              </div>
              <ul class="list-group list-group-flush">
                <li class="list-group-item">An item</li>
                <li class="list-group-item">A second item</li>
                <li class="list-group-item">A third item</li>
              </ul>
              <div class="card-body">
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
              </div>
            </div>
          </div>

          <!-- 4 -->
          <div class="col">
            <div class="card" style="width: 18rem">
              <img
                src="https://ldb-phinf.pstatic.net/20221124_186/1669262891000tEB1Q_PNG/%B7%CE%B0%ED7.png"
                class="card-img-top"
                alt=""
              />
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">
                  Some quick example text to build on the card title and make up
                  the bulk of the card's content.
                </p>
              </div>
              <ul class="list-group list-group-flush">
                <li class="list-group-item">An item</li>
                <li class="list-group-item">A second item</li>
                <li class="list-group-item">A third item</li>
              </ul>
              <div class="card-body">
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
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
  },
};
</script>

<style>
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
</style>
