<template>
  <div>
    <!-- AddFaq Start -->
    <!-- <div class="container" v-if="!submitted">
      <div class="mb-3">
        <label for="title" class="form-label">제목</label>
        <input
          type="title"
          class="form-control"
          id="title"
          required
          name="title"
          v-model="faq.title"
        />
      </div>
      <div class="mb-3">
        <label for="content" class="form-label">내용</label>
        <textarea
          class="form-control form-control-lg"
          id="content"
          rows="8"
          required
          name="content"
          v-model="faq.content"
        ></textarea>
      </div>
      <div class="mb-3">
        <button @click="saveFaq" class="btn btn-primary">Submit</button>
      </div>
    </div> -->
    <!-- AddFaq End -->


    <div>
      <div class="container col-6 mb-2 mt-2">
        <div class="AnnounceView-header mt-5">
          <h1>
            <strong>자주 묻는 질문 등록</strong>
          </h1>
        </div>
        <div class="AnnounceView-title">


          <div class="input-group mt-3 mb-4">
            <span class="input-group-text">제목</span>
            <input type="text" class="form-control" style="height:50px" id="title" required name="title"
              v-model="faq.title" />
          </div>
          <div class="mb-5">
            <textarea class="form-control form-control-lg" id="content" rows="8" required name="content"
              v-model="faq.content"></textarea>
          </div>

        </div>


        <div class="mb-3">
          <button @click="saveFaq" class="btn btn-primary">글쓰기</button>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import FaqDataService from "@/services/FaqDataService";
export default {
  data() {
    return {
      faq: {
        no: null,
        title: "",
        content: "",
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
        content: this.faq.content,
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
            this.$swal({
            icon: "success",
            title: "성공했습니다",
            showConfirmButton: false,
            timer: 1000,
          });
          this.$router.push("/faq");
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
      this.$router.push("/faq");
    },
  },
};
</script>

<style>

</style>