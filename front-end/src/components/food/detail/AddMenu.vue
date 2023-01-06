<template>
  <div>
    <main class="main" id="top">
      <div class="card mb-4">
        <!-- AddDiner.vue -->
        <div class="submit-form mt-5 mb-5 card-header">
          <!-- 새 양식 폼 시작 -->
          <div v-if="!submitted" class="card-body" style="width: 500px">
            <!-- 식당이름 -->
            <div class="form-group">
              <label for="menuName">메뉴</label>
              <input
                type="text"
                class="form-control"
                id="menuName"
                required
                v-model="menu.menuName"
                name="menuName"
              />
            </div>

            <!-- 식당이름 -->
            <div class="form-group">
              <label for="menuPrice">가격</label>
              <input
                type="text"
                class="form-control"
                id="menuPrice"
                required
                v-model="menu.menuPrice"
                name="menuPrice"
              />
            </div>

            <button @click="saveMenu" class="btn btn-success mt-5 mb-3">
              Submit
            </button>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>


<script>
// axios 공통함수 import
import MenuDataService from "@/services/MenuDataService";

export default {
  data() {
    return {
      message: "", // 서버쪽 메세지를 저장할 변수

      menu: {
        menuName: "",
        menuPrice: "",
      },
      // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
      submitted: false,
    };
  },
  methods: {
    saveMenu() {
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(dno) 자동생성되므로 빼고 전송함
      let data = {
        menuName: this.menu.menuName,
        menuPrice: this.menu.menuPrice,
      };

      // insert 요청 함수 호출(axios 공통함수 호출)
      MenuDataService.create(data)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          this.menu.menuId = response.data.menuId;
          // 콘솔 로그 출력(response.data)
          console.log(response.data);
          alert("추가가 완료되었습니다!");
          // 첫페이지(전체목록_조회_페이지) 강제 이동 : /diner
          this.$router.push("/diner");
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((e) => {
          console.log(e);
        });
    },
    newMenu() {
      // 새양식 다시 보여주기 함수, 변수 초기화
      this.submitted = false;
      this.Menu = {};
    },
  },
};
</script>

<style>
.submit-form {
  max-width: 700px;
  margin: auto;
}
</style>
