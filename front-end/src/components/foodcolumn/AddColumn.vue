<template>
  <div>
    <!-- AddColumn Start -->
    <div class="container" v-if="!submitted">
      <div class="mb-3">
        <label for="writer" class="form-label">작성자</label>
        <input
          type="writer"
          class="form-control"
          id="writer"
          required
          name="writer"
          v-model="column.columnWriter"
        />
      </div>
      <div class="mb-3">
        <label for="title" class="form-label">제목</label>
        <input
          type="title"
          class="form-control"
          id="title"
          required
          name="title"
          v-model="column.columnTitle"
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
          v-model="column.columnContent"
        ></textarea>
      </div>
      <div class="mb-3">
        <button @click="saveColumn" class="btn btn-primary">Submit</button>
      </div>
    </div>
    <!-- AddColumn End -->
  </div>
</template>


<script>
import ColumnDataService from "@/services/ColumnDataService";
export default {
  data() {
    return {
      column: {
        cid: null,
        columnWriter: "",
        columnTitle: "",
        columnContent: "",
      },
      // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
      submitted: false,
    };
  },
  methods: {
    saveColumn() {
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(no) 자동생성되므로 빼고 전송함
      let data = {
        columnWriter: this.column.columnWriter,
        columnTitle: this.column.columnTitle,
        columnContent: this.column.columnContent,
      };

      // insert 요청 함수 호출(axios 공통함수 호출)
      ColumnDataService.create(data)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          this.column.cid = response.data.ano;
          // 콘솔 로그 출력(response.data)
          console.log(response.data);
          // 변수 submitted
          this.submitted = true;
          alert("성공했습니다.");
          this.$router.push("/column");
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    newColumn() {
      // 새양식 다시 보여주기 함수, 변수 초기화
      this.submitted = false;
      this.column = {};
    },

    returnColumn() {
      this.$router.push("/column");
    },
  },
};
</script>

<style>
</style>