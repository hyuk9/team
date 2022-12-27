<template>
    <div>
        <!-- 최상단 시작 -->
        <section class="py-5 overflow-hidden bg-warning" id="home">
            <div class="container">
                <div class="row flex-center">
                    <div class="col-md-5 col-lg-6 order-0 order-md-1 mt-8 mt-md-0">
                        <!-- TODO: 이미지가 안나와서 이미지 경로 수정 -->
                        <a class="img-landing-banner" href="#!"><img class="img-fluid"
                                src="../../../../public/assets/img/gallery/hero-header.png" alt="hero-header" /></a>
                    </div>
                    <div class="col-md-7 col-lg-6 py-8 text-md-start text-center">
                        <h1 class="display-1 fs-md-5 fs-lg-6 fs-xl-8 text-light">
                            여기는 질문과답변 <br />
                            페이지 입니다
                        </h1>
                        <h1 class="text-800 mb-5 fs-4">최상단만 제작</h1>
                    </div>
                </div>
            </div>
        </section>
        <!-- 최상단 끝 -->

        <!-- AddFaq Start -->
        <div class="container" v-if="!submitted">
            <div class="mb-3">
                <label for="title" class="form-label">제목</label>
                <input type="title" class="form-control" id="title" required name="title"
                    v-model="faq.title" />
            </div>
            <div class="mb-3">
                <label for="content" class="form-label">내용</label>
                <textarea class="form-control form-control-lg " id="content" rows="8" required name="content"
                    v-model="faq.content"></textarea>
            </div>
            <div class="mb-3">
                <button @click="saveFaq" class="btn btn-primary">Submit</button>
            </div>
        </div>
        <!-- AddFaq End -->
    </div>
</template>


<script>
import FaqDataService from "../../../services/FaqDataService";
export default {
    data() {
        return {
            faq: {
                no: null,
                title: "",
                content:""
            },
            // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
            submitted: false,
        };
    },
    methods: {
        saveFaq() {
            // 임시 객체 변수 -> springboot 전송
            // 부서번호는(no) 자동생성되므로 빼고 전송함
            let data = {
                
                title: this.faq.title,
                content: this.faq.content
            };

            // insert 요청 함수 호출(axios 공통함수 호출)
            FaqDataService.create(data)
                // 성공하면 then() 결과가 전송됨
                .then((response) => {
                    this.faq.no = response.data.no;
                    // 콘솔 로그 출력(response.data)
                    console.log(response.data);
                    // 변수 submitted
                    this.submitted = true;
                    alert("성공했습니다.")
                    location.href = "/faq";
                })
                // 실패하면 .catch() 결과가 전송됨
                .catch((e) => {
                    console.log(e);
                });
        },
        newFaq() {
            // 새양식 다시 보여주기 함수, 변수 초기화
            this.submitted = false;
            this.faq = {};
        },

        returnFaq() {
            location.href = "/faq";
        }
     
    },

};
</script>

<style>

</style>