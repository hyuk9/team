<template>
    <div>
        <!-- AddAnnounce Start -->
        <!-- <div class="container" v-if="!submitted">
            <div class="mb-3">
                <label for="writer" class="form-label">작성자</label>
                <input type="writer" class="form-control" id="writer" required name="writer"
                    v-model="announce.writer" />
            </div>
            <div class="mb-3">
                <label for="title" class="form-label">제목</label>
                <input type="title" class="form-control" id="title" required name="title"
                    v-model="announce.title" />
            </div>
            <div class="mb-3">
                <label for="content" class="form-label">내용</label>
                <textarea class="form-control form-control-lg " id="content" rows="8" required name="content"
                    v-model="announce.content"></textarea>
            </div>
            <div class="mb-3">
                <button @click="saveAnnounce" class="btn btn-primary">Submit</button>
            </div>
        </div> -->
        <!-- AddAnnounce End -->

        <div>
            <div class="container col-6 mb-2 mt-2">
                <div class="AnnounceView-header mt-5">
                    <h1>
                        <strong>공지사항 등록</strong>
                    </h1>
                </div>
                <div class="AnnounceView-title">


                    <div class="input-group mt-3 mb-4">
                        <span class="input-group-text">제목</span>
                        <input type="text" class="form-control" style="height:50px" id="title" required name="title"
                            v-model="announce.title" />
                    </div>
                    <div class="input-group mb-4">
                        <span class="input-group-text">작성자</span>
                        <input type="text" class="form-control" style="height:50px" id="writer" required name="writer"
                        v-bind:disabled="true"
              v-model="currentUser.username" />
                    </div>

                    <div class="mb-5">
                        <textarea class="form-control form-control-lg" id="content" rows="8" required name="content"
                            v-model="announce.content"></textarea>
                    </div>

                </div>


                <div class="mb-3">
                    <button @click="saveAnnounce" class="btn btn-primary">등록</button>
                </div>
            </div>
        </div>
    </div>
</template>


<script>
import AnnounceDataService from "@/services/AnnounceDataService";
export default {
    data() {
        return {
            announce: {
                aid: null,
                writer: "",
                title: "",
                content: ""
            },
            // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
            submitted: false,
        };
    },
    methods: {
        saveAnnounce() {
            // 임시 객체 변수 -> springboot 전송
            // 부서번호는(no) 자동생성되므로 빼고 전송함
            let data = {

                // writer: this.announce.writer,
                writer: this.currentUser.username,
                title: this.announce.title,
                content: this.announce.content
            };

            // insert 요청 함수 호출(axios 공통함수 호출)
            AnnounceDataService.create(data)
                // 성공하면 then() 결과가 전송됨
                .then((response) => {
                    this.announce.aid = response.data.aid;
                    // 콘솔 로그 출력(response.data)
                    console.log(response.data);
                    // 변수 submitted
                    this.submitted = true;
                    this.$router.push("/announce");
                })
                // 실패하면 .catch() 결과가 전송됨
                .catch((e) => {
                    console.log(e);
                });
        },
        // newAnnounce() {
        //     // 새양식 다시 보여주기 함수, 변수 초기화
        //     this.submitted = false;
        //     this.announce = {};
        // },

        // returnAnnounce() {
        //     this.$router.push("/announce");
        // }

    },
    computed: {
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },
  },

};
</script>

<style>

</style>