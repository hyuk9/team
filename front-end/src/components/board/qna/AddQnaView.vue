<template>
    <div>
        <!-- AddQna Start -->
        <div class="container" v-if="!submitted">
            <div class="mb-3">
                <label for="questioner" class="form-label">작성자</label>
                <input type="questioner" class="form-control" id="questioner" required name="questioner"
                    v-model="qna.questioner" />
            </div>
            <div class="mb-3">
                <label for="title" class="form-label">제목</label>
                <input type="title" class="form-control" id="title" required name="title"
                    v-model="qna.title" />
            </div>
            <div class="mb-3">
                <label for="content" class="form-label">내용</label>
                <textarea class="form-control form-control-lg " id="content" rows="8" required name="content"
                    v-model="qna.content"></textarea>
            </div>
            <div class="mb-3">
                <button @click="saveQna" class="btn btn-primary">Submit</button>
            </div>
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
                questioner: "",
                title: "",
                content:""
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
                
                questioner: this.qna.questioner,
                title: this.qna.title,
                content: this.qna.content
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
                    alert("성공했습니다.")
                    location.href = "/qna";
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