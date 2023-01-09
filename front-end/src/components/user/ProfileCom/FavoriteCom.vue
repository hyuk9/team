<template>
  <div>
    <div class="pt-5 pb-5" id="favoriteList">
      <div class="mx-auto text-center mb-5">
        <h5 class="fw-bold fs-3 fs-lg-5 lh-sm">찜한 가게</h5>
      </div>
      <div class="untree_co-section">
        <div class="container" data-aos="fade-left" data-aos-delay="200">
          <div class="row">
            <div class="col-lg-10 mx-auto text-center">
              <table class="table">
                <thead>
                  <tr>
                    <!-- <th scope="col">Last Name</th> -->
                    <th scope="col">사진</th>
                    <!-- <th scope="col">fid</th>
                    <th scope="col">user id</th>
                    <th scope="col">dno</th> -->
                    <th scope="col">가게</th>
                    <th scope="col">가게전화번호</th>
                    <th scope="col">위치</th>
                    <th scope="col">더보기</th>
                  </tr>
                </thead>
                <tbody v-for="(data, index) in favorite" :key="index">
                  <!-- <tr @click="setActive(data, index)"> -->
                  <tr>
                    <td>
                      <router-link :to="'/diner/' + data.dno">
                        <img
                          :src="data.mainphoto"
                          alt=""
                          style="height: 100px"
                        />
                      </router-link>
                    </td>
                    <!-- <td>{{ data.fid }}</td>
                    <td>{{ data.id }}</td>
                    <td>{{ data.dno }}</td> -->
                    <td class="align-middle">
                      <router-link :to="'/diner/' + data.dno">{{
                        data.dname
                      }}</router-link>
                    </td>
                    <td class="align-middle">
                      <router-link :to="'/diner/' + data.dno">{{
                        data.phone
                      }}</router-link>
                    </td>
                    <td class="align-middle">
                      <a
                        :href="`https://map.kakao.com/link/search/${data.dname}`"
                        target="_blank"
                        >{{ data.loc }}</a
                      >
                    </td>
                    <td class="align-middle">
                      <router-link :to="'/diner/' + data.dno"
                        ><span class="badge rounded-pill bg-warning"
                          >더보기</span
                        ></router-link
                      >
                    </td>
                  </tr>
                </tbody>
              </table>
              <div v-if="existFavorite()">
                <h4>아직 찜한 기록이 없습니다.</h4>
              </div>

              <!--    Todo : page 바 시작 -->
              <div class="overflow-auto offset-5 mt-5">
                <b-pagination
                  v-model="page"
                  :total-rows="count"
                  :per-page="pageSize"
                  first-text="<<"
                  last-text=">>"
                  prev-text="Prev"
                  next-text="Next"
                  pills
                  @change="handlePageChange"
                ></b-pagination>
              </div>
              <!--    Todo : page 바 끝 -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import ProfileDataService from "@/services/ProfileDataService";
import FavoriteDataService from "@/services/FavoriteDataService";

export default {
  data() {
    return {
      // currentReservation: null,
      favorite: [],
      currentData: null,
      currentIndex: -1,
      message: "", // 서버쪽 메세지를 저장할 변수

      page: 1,
      count: 0,
      pageSize: 5,

      // pageSizes: [3, 6, 9],
    };
  },
  methods: {
    //  찜한목록 조회하는 함수
    retrieveFavorite() {
      FavoriteDataService.getId(
        this.currentUser.id,
        this.page - 1,
        this.pageSize
      )
        .then((response) => {
          const { favorite, totalItems } = response.data;
          this.favorite = favorite;
          this.count = totalItems;

          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    handlePageChange(value) {
      this.page = value;
      this.retrieveFavorite();
    },
    handlePageSizeChange(event) {
      this.pageSize = event.target.value;
      this.page = 1;
      this.retrieveFavorite();
    },
    setActive(data, index) {
      console.log(data);
      this.currentData = data;
      this.currentIndex = index;
    },

    saveProfile() {
      // 임시 객체 변수 -> springboot 전송
      // 부서번호는(no) 자동생성되므로 빼고 전송함
      this.progress = 0;
      // insert 요청 함수 호출(axios 공통함수 호출)
      ProfileDataService.create(
        this.currentImage
        // (eve) => {
        //   // 파일이 업로드될때 진척상황이 저장됨(%)
        //   this.progress = Math.round((100 * eve.loaded) / eve.total);
        // }
      )
        // 성공하면 then() 결과가 전송됨
        .then((response) => {
          console.log(response.data);
          this.message = response.data;
          this.profiles = false;
          // 변수 submitted
          alert("성공했습니다.");
          this.getProfile(1);
        })
        // 실패하면 .catch() 결과가 전송됨
        .catch((err) => {
          this.progress = 0;
          this.message = "Could not upload the image! " + err;
          this.currentImage = undefined;
        });
    },

    getProfile(pno) {
      // axios 공통함수 호출
      ProfileDataService.get(pno)
        // 성공하면 .then() 결과가 리턴됨
        .then((response) => {
          // springboot 결과를 리턴함(부서 객체)
          this.currentProfile = response.data;
          // 콘솔 로그 출력
          console.log(response.data);
        })
        // 실패하면 .catch() 에러메세지가 리턴됨
        .catch((e) => {
          console.log(e);
        });
    },

    selectImage() {
      // 파일선택상자에서 첫번째로 선택한 이미지가 저장됨
      this.currentImage = this.$refs.file.files.item(0);
      // 아래는 미리보기 이미지를 위한 주소가 저장됨
      this.previewImage = URL.createObjectURL(this.currentImage);
      this.progress = 0;
      this.message = "";
    },
    // 찜한 거 없을때 글자띄우기
    existFavorite() {
      if (this.favorite != null) {
        return false;
      } else {
        return true;
      }
    },
  },
  computed: {
    currentUser() {
      // 모듈 저장소 : this.$store.state.모듈명.state값
      // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
      return this.$store.state.auth.user;
    },
  },
  // 화면이 뜨자마자 실행되는 이벤트
  mounted() {
    this.retrieveFavorite();
  },
};
</script>

<style></style>
