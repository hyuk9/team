<template>
<!-- 최상단 부분 시작  -->
   <section class="py-5 overflow-hidden bg-warning" id="home">
        <div class="container">
          <div class="row flex-center">
            <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
              <a class="img-landing-banner" href="#!"><img class="img-fluid" src="assets/img/gallery/hero-tomato.png"
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
            this.title = "전국"
            this.contentOne = "전국의" 
            this.contentTwo = "뜨고있는 맛집을 알려드립니다!"
        }
    },
}
</script>

<style>

</style>