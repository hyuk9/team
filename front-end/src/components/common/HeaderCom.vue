<template>
<!-- 최상단 부분 시작  -->
   <section class="py-5 overflow-hidden bg-warning" id="home">
        <div class="container">
          <div class="row flex-center">
            <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
              <a class="img-landing-banner" href="#!"><img class="img-fluid" src="/assets/img/gallery/hero-tomato.png"
                  alt="hero-header" /></a>
            </div>
            <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
              <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">{{title}}</h1>
              <h1 class="text-800 mb-5 fs-4">
                <br />{{contentOne}} <br />
                {{contentTwo}}
              </h1>
            </div>
          </div>
        </div>
      </section>
<!-- 최상단 부분 끝  -->
</template>

<script>
export default {
    data() {
        return {
            title: "",
            contentOne : "",
            contentTwo : ""
        }
    },
    mounted() {
        // 만약 주소가 /diner 이라면
        if(this.$route.path == "/diner"){
            this.title = "음식점 리스트"
        } else if (this.$route.path == "/announce"){
            this.title = "공지사항"
        } else if (this.$route.path == "/faq"){
            this.title = "자주 묻는 질문"
        } else if (this.$route.path == "/question"){
            this.title = "질문과 답변"
        } else if (this.$route.path == "/free"){
            this.title = "자유게시판"
        } else if (this.$route.path == "/column"){
            this.title = "푸드컬럼"
        } else if (this.$route.path == "/reservation"){
            this.title = "예약 조회 및 수정하기"
        } else if (this.$route.path == "/add-reservation"){
            this.title = "예약하기"
        } else if (this.$route.path == "/profile"){
            this.title = "프로필"
        } else if (this.$route.path == "/user"){
            this.title = "유저목록 조회 및 수정하기"
        } else if (this.$route.path == "/team"){
            this.title = "팀원 소개"
        } else {
          this.title = "음식점 리스트"
        }
    },
}
</script>

<style>

</style>