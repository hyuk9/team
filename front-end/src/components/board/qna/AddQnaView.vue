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

        <!-- AddQna Start -->
        <div class="container" v-if="!submitted">
            <div class="mb-3">
                <label for="question" class="form-label">question</label>
                <textarea class="form-control form-control-lg " id="question" rows="3" required name="question"
                    v-model="qna.question"></textarea>
            </div>
            <div class="mb-3">
                <label for="questioner" class="form-label">questioner</label>
                <input type="questioner" class="form-control" id="questioner" required name="questioner"
                    v-model="qna.questioner" />
            </div>
            <div class="mb-3">
                <label for="answer" class="form-label">answer</label>
                <textarea class="form-control form-control-lg" id="answer" rows="3" required name="answer"
                    v-model="qna.answer"></textarea>
            </div>
            <div class="mb-3">
                <label for="answerer" class="form-label">answerer</label>
                <input type="text" class="form-control" id="answerer" name="answerer" v-model="qna.answerer" />
            </div>
            <div class="mb-3">
                <button @click="saveQna" class="btn btn-primary">Submit</button>
            </div>
        </div>
        <div v-else>
            <div class="alert alert-success" role="alert">Save qna successfully!</div>
            <button @click="newQna" class="btn btn-primary">Add New Qna</button>
            <button @click="returnQna" class="btn btn-primary ms-3">Return QnaList</button>
        </div>
        <!-- AddQna End -->
    </div>
</template>

<script>
import QnaDataService from "../../../services/QnaDataService";
export default {
    data() {
        return {
            qna: {
                qno: null,
                question: "",
                questioner: "",
                answer: "",
                answerer: "",
            },
            // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
            submitted: false,
        };
    },
    methods: {
        saveQna() {
            // 임시 객체 변수 -> springboot 전송
            // 부서번호는(no) 자동생성되므로 빼고 전송함
            let data = {
                question: this.qna.question,
                questioner: this.qna.questioner,
                answer: this.qna.answer,
                answerer: this.qna.answerer,
            };

            // insert 요청 함수 호출(axios 공통함수 호출)
            QnaDataService.create(data)
                // 성공하면 then() 결과가 전송됨
                .then((response) => {
                    this.qna.qno = response.data.qno;
                    // 콘솔 로그 출력(response.data)
                    console.log(response.data);
                    // 변수 submitted
                    this.submitted = true;
                })
                // 실패하면 .catch() 결과가 전송됨
                .catch((e) => {
                    console.log(e);
                });
        },
        newQna() {
            // 새양식 다시 보여주기 함수, 변수 초기화
            this.submitted = false;
            this.qna = {};
        },

        returnQna() {
            location.href = "/qna";
        }
    },

};
</script>

<style>

</style>