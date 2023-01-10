<template>
  <div>
    <main class="main" id="top">
      <div class="card mb-4">
        <!-- AddDiner.vue -->
        <div class="form mt-5 mb-5 card-header">
          <!-- 새 양식 폼 시작 -->
          <div v-if="!submitted" class="card-body">
            <h1 class="mt-6"><i class="bi bi-journal-plus"></i> 음식점 추가하기</h1>
            <!-- 식당이름 -->
            <div class="input__block">
              <h5>식당이름</h5>
              <input
                type="text"
                class="form-control"
                id="dname"
                required
                v-model="diner.dname"
                name="dname"
              />
            </div>


            <!-- 지역 -->
            <div class="input__block">
              <h5>주소</h5>
              <input
                class="form-control"
                id="loc"
                required
                v-model="diner.loc"
                name="loc"
              />
            </div>

            <!-- 전화번호 -->
            <div class="input__block">
              <h5>전화번호</h5>
              <input
                type="text"
                class="form-control"
                id="phone"
                required
                v-model="diner.phone"
                name="phone"
              />
            </div>

            <!-- 메뉴 -->
            <div class="input__block">
              <h5>메뉴</h5>
              <select
                class="form-select"
                id="menu"
                required
                v-model="diner.menu"
                name="menu"
                aria-label="Default select example"
              >
                <option selected>메뉴을 선택해주세요.</option>
                <option value="한식">한식</option>
                <option value="중식">중식</option>
                <option value="일식">일식</option>
                <option value="양식">양식</option>
              </select>
            </div>

            <!-- 테마 -->
            <div class="input__block">
              <h5>테마</h5>
              <select
                class="form-select"
                id="theme"
                required
                v-model="diner.theme"
                name="theme"
                aria-label="Default select example"
              >
                <option selected>테마를 선택해주세요.</option>
                <option value="데이트">데이트</option>
                <option value="모임">모임</option>
                <option value="회식">회식</option>
                <option value="식사">식사</option>
              </select>
            </div>

            <!-- 주소로 지도 좌표찾는 사이트 링크 추가 -->
            <div class="text-center">
              <button type="button" class="reservation__btn22 mt-4" @click="findL()">
                주소 <i class="bi bi-arrow-right-circle"></i> 좌표 전환 사이트
              </button>
            </div>

            <!-- 지도 좌표 추가 -->
            <div class="wd">
              <div class="row">
                <div class="col">
                  <h5>식당 좌표값 <i class="bi bi-arrow-right-circle"></i> 위도</h5>
                  <input
                    type="number"
                    class="form-control"
                    id="lat"
                    v-model="diner.lat"
                    name="lat"
                  />
                </div>
                <div class="col">
                  <h5>식당 좌표값 <i class="bi bi-arrow-right-circle"></i> 경도</h5>
                  <input
                    type="number"
                    class="form-control"
                    id="lng"
                    v-model="diner.lng"
                    name="lng"
                  />
                </div>
              </div>
            </div>

            <!-- 메인 사진넣기 -->
            <div class="input__block">
              <h5>메인 사진</h5>
              <input
                type="text"
                class="form-control"
                id="mainphoto"
                v-model="diner.mainphoto"
                name="mainphoto"
              />
            </div>

            <!-- 슬라이드 사진넣기 -->
            <div class="input__block">
              <h5>슬라이드 사진</h5>
              <input
                type="text"
                class="form-control mb-1"
                id="photo1"
                v-model="diner.photo1"
                name="photo1"
              />
              <input
                type="text"
                class="form-control mb-1"
                id="photo2"
                v-model="diner.photo2"
                name="photo2"
              />
              <input
                type="text"
                class="form-control mb-1"
                id="photo3"
                v-model="diner.photo3"
                name="photo3"
              />
            </div>
            <br />

            <!-- 대표 메뉴 추가하기 -->
            <div class="wd">
              <h4 class="text-center mt-2 text-900">
                <i class="bi bi-clipboard-plus"></i>
                대표메뉴 5가지를 추가해주세요!</h4>
              <div class="row">
                <div class="col">
                  <h5>메뉴1</h5>
                  <input
                    type="text"
                    class="form-control"
                    id="menu1"
                    v-model="diner.menu1"
                    name="menu1"
                    required
                  />
                </div>
                <div class="col">
                  <h5>메뉴1 가격</h5>
                  <input
                    type="number"
                    class="form-control"
                    id="price1"
                    v-model="diner.price1"
                    name="price1"
                    required
                  />
                </div>
              </div>
              <div class="row">
                <div class="col">
                  <h5>메뉴2</h5>
                  <input
                    type="text"
                    class="form-control"
                    id="menu2"
                    v-model="diner.menu2"
                    name="menu2"
                    required
                  />
                </div>
                <div class="col">
                  <h5>메뉴2 가격</h5>
                  <input
                    type="number"
                    class="form-control"
                    id="price2"
                    v-model="diner.price2"
                    name="price2"
                    required
                  />
                </div>
              </div>
              <div class="row">
                <div class="col">
                  <h5>메뉴3</h5>
                  <input
                    type="text"
                    class="form-control"
                    id="menu3"
                    v-model="diner.menu3"
                    name="menu3"
                    required
                  />
                </div>
                <div class="col">
                  <h5>메뉴3 가격</h5>
                  <input
                    type="number"
                    class="form-control"
                    id="price3"
                    v-model="diner.price3"
                    name="price3"
                    required
                  />
                </div>
              </div>
              <div class="row">
                <div class="col">
                  <h5>메뉴4</h5>
                  <input
                    type="text"
                    class="form-control"
                    id="menu4"
                    v-model="diner.menu4"
                    name="menu4"
                    required
                  />
                </div>
                <div class="col">
                  <h5>메뉴4 가격</h5>
                  <input
                    type="number"
                    class="form-control"
                    id="price4"
                    v-model="diner.price4"
                    name="price4"
                    required
                  />
                </div>
              </div>
              <div class="row">
                <div class="col">
                  <h5>메뉴5</h5>
                  <input
                    type="text"
                    class="form-control"
                    id="menu5"
                    v-model="diner.menu5"
                    name="menu5"
                    required
                  />
                </div>
                <div class="col">
                  <h5>메뉴5 가격</h5>
                  <input
                    type="number"
                    class="form-control"
                    id="price5"
                    v-model="diner.price5"
                    name="price5"
                    required
                  />
                </div>
              </div>
            </div>

            <!-- 서버 에러 메세지가 있을 경우 아래 출력 시작 -->
            <div v-if="message" class="alert alert-secondary" role="alert">
              {{ message }}
            </div>
            <!-- 서버 에러 메세지가 있을 경우 아래 출력 끝 -->

            <div class="mt-5 mb-3 text-center">
              <button @click="saveDiner" class="reservation__btn2">
                추가하기
              </button>
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>


<script>
// axios 공통함수 import
import DinerDataService from "@/services/DinerDataService";

export default {
  data() {
    return {
      message: "", // 서버쪽 메세지를 저장할 변수

      diner: {
        dno: null,
        dname: "",
        loc: "",
        score: null,
        review: "",
        menu: "",
        phone: "",
        theme: "",
        lat: null,
        lng: null,

        mainphoto: "",
        photo1: "",
        photo2: "",
        photo3: "",

        // 메뉴추가
        menu1: "",
        price1: null,
        menu2: "",
        price2: null,
        menu3: "",
        price3: null,
        menu4: "",
        price4: null,
        menu5: "",
        price5: null,
      },
      // submit 버튼을 클릭하면 true 가 되고, You submitted successfully! 화면에 출력됨
      submitted: false,
    };
  },
  methods: {
    saveDiner() {
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(dno) 자동생성되므로 빼고 전송함
      let data = {
        dname: this.diner.dname,
        loc: this.diner.loc,
        score: this.diner.score,
        menu: this.diner.menu,
        phone: this.diner.phone,
        theme: this.diner.theme,
        lat: this.diner.lat,
        lng: this.diner.lng,
        mainphoto: this.diner.mainphoto,
        photo1: this.diner.photo1,
        photo2: this.diner.photo2,
        photo3: this.diner.photo3,

        // 메뉴추가
        menu1: this.diner.menu1,
        price1: this.diner.price1,
        menu2: this.diner.menu2,
        price2: this.diner.price2,
        menu3: this.diner.menu3,
        price3: this.diner.price3,
        menu4: this.diner.menu4,
        price4: this.diner.price4,
        menu5: this.diner.menu5,
        price5: this.diner.price5,
      };

      // insert 요청 함수 호출(axios 공통함수 호출)
      DinerDataService.create(data)
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          this.diner.dno = response.data.dno;
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
    newDiner() {
      // 새양식 다시 보여주기 함수, 변수 초기화
      this.submitted = false;
      this.diner = {};
    },
    findL() {
      window.open("https://deveapp.com/map.php");
    },
  },
};
</script>

<style lang="scss" scoped>
h1 {
  color: #ffb30e;
  font-size: 48px;
  letter-spacing: -3px;
  text-align: center;
  margin-bottom: 80px;
  transition: 0.2s linear;
}

h5 {
  display: inline-block;
  color: #ffb30e;
  margin: 30px 0 30px 30px;
  transition: 0.2s linear;
}

.form {
  width: 100%;
  max-width: 680px;
  margin: 40px auto 10px;
}

.form-select {
  width: 90%;
  margin: 0 auto;
}

.input__block {
  margin: 20px auto;
  display: block;
  position: relative;
}
.wd {
  margin: 0 auto;
  width: 90%;
  padding: 0 10px;
}
.input__block input {
  display: block;
  width: 90%;
  max-width: 680px;
  height: 50px;
  margin: 0 auto;
  border-radius: 8px;
  border: none;
  background: rgba(15, 19, 42, 0.1);
  font-size: 14px;
  font-family: "Montserrat", sans-serif;
  padding: 0 10px;
}

.gender {
  margin: 0 0 0 30px;
}

.gender h5 {
  margin: 30px 0 30px 0px;
}

.gender input {
  width: 50%;
  max-width: 680px;
  height: 30px;
  margin: 0 auto;
  padding: 0 0 0 15px;
  vertical-align: middle;
}
.reservation__btn1 {
  background: tomato;
  color: white;
  display: inline;
  width: 140px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  font-size: 18px;
  box-shadow: 0 10px 20px rgba(170, 71, 54, 0.377);
  transition: 0.2s linear;
}
.reservation__btn2 {
  background: rgba(76, 184, 43, 0.993);
  color: white;
  display: inline;
  width: 140px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  font-size: 18px;
  box-shadow: 0 10px 20px rgba(59, 138, 35, 0.493);
  transition: 0.2s linear;
}
.reservation__btn22 {
  background: rgba(76, 184, 43, 0.993);
  color: white;
  display: inline;
  width: 250px;
  height: 50px;
  border-radius: 8px;
  margin: 0 auto;
  border: none;
  font-size: 18px;
  box-shadow: 0 10px 20px rgba(59, 138, 35, 0.493);
  transition: 0.2s linear;
}
.reservation__btn1:hover,
.reservation__btn2:hover {
  box-shadow: 0 0 0 rgba(233, 30, 99, 0);
}
button {
  font-family: ONE-Mobile-POP !important;
}
</style>

