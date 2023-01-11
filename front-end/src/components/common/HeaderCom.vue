<template>
<!-- 최상단 부분 시작  -->
   <section class="py-5 overflow-hidden bg-warning" id="home">
        <div class="container">
          <div class="row flex-center">
            <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
              <a class="img-landing-banner" href="#!"><img class="img-fluid" :src="heroTitle"
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
/* eslint-disable */
export default {
    data() {
        return {
            title: "",
            contentOne : "",
            contentTwo : "",
            heroTitle : "",
        }
    },
    mounted() {
        // 만약 주소가 /diner 이라면
        if(this.$route.path == "/diner"){
            this.title = "음식점 리스트"
            this.contentOne = "원하는 음식점을 한번에 모아보세요"
            this.heroTitle = "/assets/img/gallery/hero-tomato2.png";
        } else if (this.$route.path == "/announce"){
            this.title = "공지사항"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
        } else if (this.$route.path == "/faq"){
            this.title = "자주 묻는 질문"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
        } else if (this.$route.path == "/question"){
            this.title = "질문과 답변"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
        } else if (this.$route.path == "/questionview"){
            this.title = "질문과 답변"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
        } else if (this.$route.path == "/free"){
            this.title = "자유게시판"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
        } else if (this.$route.path == "/column"){
            this.title = "푸드컬럼"
            this.heroTitle = "/assets/img/gallery/hero-tomato4.png";
        } else if (this.$route.path == "/columnview/"){
            this.title = "푸드컬럼"
            this.heroTitle = "/assets/img/gallery/hero-tomato4.png";
        } else if (this.$route.path == "/reservation"){
            this.title = "예약 조회 및 수정하기"
            this.heroTitle = "/assets/img/gallery/hero-tomato6.png";
        } else if (this.$route.path == "/add-reservation"){
            this.title = "예약하기"
            this.heroTitle = "/assets/img/gallery/hero-tomato6.png";
        } else if (this.$route.path == "/profile"){
            this.title = "프로필"
            this.heroTitle = "/assets/img/gallery/hero-tomato5.png";
        } else if (this.$route.path == "/user"){
            this.title = "유저목록 조회 및 수정하기"
            this.heroTitle = "/assets/img/gallery/hero-tomato6.png";
        } else if (this.$route.path == "/team"){
            this.title = "팀원 소개"
  
        } else if (this.$route.path == "/add-free"){
            this.title = "자유게시판"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
  
        } else if (this.$route.path == "/add-user"){
            this.title = "회원 추가"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
  
        } else if (this.$route.path == "/add-question"){
            this.title = "질문과 답변"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
  
        }else if (this.$route.path == "/add-announce"){
            this.title = "공지사항"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
  
        } else if (this.$route.path == "/add-column"){
            this.title = "푸드컬럼"
            this.heroTitle = "/assets/img/gallery/hero-tomato4.png";
  
        }else if (this.$route.path == "/freeview" && this.$route.params.fno){
          this.title = "자유게시판"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
  
        }else if (this.$route.path == "/free" && this.$route.params.fno){
             this.title = "자유게시판"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
  
        } else if (this.$route.path == "/reservation" && this.$route.params.rid){
               this.title = "예약하기"
            this.heroTitle = "/assets/img/gallery/hero-tomato6.png";
  
        }else if (this.$route.path == "/user" && this.$route.params.id){
               this.title = "회원정보"
            this.heroTitle = "/assets/img/gallery/hero-tomato6.png";
  
        } else if (this.$route.path == "/question" && this.$route.params.qno){
            this.title = "질문과 답변"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
  
        } else if (this.$route.path == "/faq" && this.$route.params.no){
            this.title = "자주 묻는 질문"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
        } else if (this.$route.path == "/faq" && this.$route.params.no){
            this.title = "질문과 답변"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
  
        }else if (this.$route.path == "/announceview" && this.$route.params.aid){
            this.title = "공지사항"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
        }else if (this.$route.path == "/announce" && this.$route.params.aid){
            this.title = "공지사항"
            this.heroTitle = "/assets/img/gallery/hero-tomato3.png";
        }else if (this.$route.path == "/columnview" && this.$route.params.cid){
            this.title = "푸드컬럼"
            this.heroTitle = "/assets/img/gallery/hero-tomato4.png";
        }else if (this.$route.path == "/column" && this.$route.params.cid){
            this.title = "푸드컬럼"
            this.heroTitle = "/assets/img/gallery/hero-tomato4.png";
        } else if (this.$route.path == "/edit/review" && this.$route.params.rno){
            this.title = "리뷰페이지"
            this.heroTitle = "/assets/img/gallery/hero-tomato4.png";
        } else if (this.$route.path == "/add/review/" && this.$route.params.dno){
            this.title = "리뷰페이지"
            this.heroTitle = "/assets/img/gallery/hero-tomato4.png";
        } else if (this.$route.path == "/diner" && this.$route.params.dno){
            this.title = "리뷰페이지"
            this.heroTitle = "/assets/img/gallery/hero-tomato4.png";
        } else if (this.$route.path == "/diner" && this.$route.params.dno){
            this.title = "리뷰페이지"
            this.heroTitle = "/assets/img/gallery/hero-tomato4.png";
        } else {
          this.title = "음식점 리스트"
          this.heroTitle = "/assets/img/gallery/hero-tomato2.png";
        }
    },
}
</script>

<style>

</style>