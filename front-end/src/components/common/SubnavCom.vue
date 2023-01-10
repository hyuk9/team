<template>
    <div>
        <!-- 네비게이션 바 시작 -->
        <nav class="navbar navbar-expand-lg navbar-light dropmenu bg-light fixed-top"
            data-navbar-on-scroll="data-navbar-on-scroll">
            <div class="container">
                <!-- 로고명과 이미지 시작 -->
                <router-link to="/" class="navbar-brand">
                    <!-- <img
              class="h-25 d-inline-block"
              src="assets/img/gallery/tomato.png"
              alt="logo"/> -->
                    <span class="text-1000 fs-3 fw-bold ms-2 text-gradient">맛있는 토마토</span>
                </router-link>
                <!-- 로고명과 이미지 끝 -->
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="dropdown">
                            <router-link to="" class="nav-link dropdown-toggle text-gradient" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                음식점 리스트
                            </router-link>
                            <ul class="dropdown-menu">
                                <!-- <li class="has-children subdropmenu">
                                    <router-link to="/diner" class="dropdown-item">서울</router-link>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">강남구</a></li>
                                        <li><a href="#">서초구</a></li>
                                        <li><a href="#">송파구</a></li>
                                        <li><a href="#">서대문구</a></li>
                                        <li><a href="#">영등포구</a></li>
                                        <li><a href="#">마포구</a></li>
                                        <li><a href="#">종로구</a></li>
                                    </ul>
                                </li>
                                <li class="has-children subdropmenu">
                                    <router-link to="/diner" class="dropdown-item">경기</router-link>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">인천</a></li>
                                        <li><a href="#">세종시</a></li>
                                        <li><a href="#">평택</a></li>
                                        <li><a href="#">용인</a></li>
                                        <li><a href="#">이천</a></li>
                                        <li><a href="#">화성</a></li>
                                        <li><a href="#">김포</a></li>
                                    </ul>
                                </li> -->
                                <li class="has-children subdropmenu">
                                    <a href="/diner" class="dropdown-item">부산광역시</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/haeundae">해운대구</a></li>
                                        <li><a href="/namgu">남구</a></li>
                                        <li><a href="/geumjeong">금정구</a></li>
                                        <li><a href="/gijang">기장구</a></li>
                                        <li><a href="/dongnae">동래구</a></li>
                                        <li><a href="/busanjin">부산진구</a></li>
                                        <li><a href="/yeongdo">영도구</a></li>
                                        <li><a href="/gangseo">강서구</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <hr class="dropdown-divider" />
                                </li>
                                <li class="has-children subdropmenu">
                                    <a href="/diner" class="dropdown-item">메뉴별</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/korean">한식</a></li>
                                        <li><a href="/chinese">중식</a></li>
                                        <li><a href="/japanese">일식</a></li>
                                        <li><a href="/western">양식</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <hr class="dropdown-divider" />
                                </li>
                                <li class="has-children subdropmenu">
                                    <a href="/diner" class="dropdown-item">테마별</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/date">데이트</a></li>
                                        <li><a href="/meeting">모임</a></li>
                                        <li><a href="/getTogether">회식</a></li>
                                        <li><a href="/daily">식사</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <router-link to="" class="nav-link dropdown-toggle text-gradient" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                게시판
                            </router-link>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="/announce" class="dropdown-item">공지사항</a>
                                </li>
                                <li>
                                    <a href="/faq" class="dropdown-item">자주묻는질문</a>
                                </li>
                                <li>
                                    <a href="/question" class="dropdown-item">질문과답변</a>
                                </li>
                                <li>
                                    <a href="/column" class="dropdown-item">푸드컬럼</a>
                                </li>
                                <li>
                                    <a href="/free" class="dropdown-item">자유게시판</a>
                                </li>
                            </ul>
                        </li>

                        <!-- 임시로 만든 예약 네비게이션 시작 -->
                        <li class="nav-item dropdown">
                            <router-link to="" class="nav-link dropdown-toggle text-gradient" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                예약(임시)
                            </router-link>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="/reservation" class="dropdown-item">예약 조회하기</a>
                                </li>
                                <li>
                                    <a href="/add-reservation" class="dropdown-item">예약하기</a>
                                </li>
                            </ul>
                        </li>
                        <!-- 임시로 만든 예약 네비게이션 끝 -->

                        <!-- 관리자 전용 페이지 시작 -->
                        <!-- showAdminBoard가 동작하면 보이게 작동 -->
                        <li v-if="showAdminBoard" class="nav-item dropdown">
                            <router-link to="" class="nav-link dropdown-toggle text-gradient" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                관리자 전용(관리자만 보이게 설정)
                            </router-link>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="/user" class="dropdown-item">유저 목록 조회하기</a>
                                </li>
                                <li>
                                    <a href="/reservation" class="dropdown-item">예약현황 조회하기</a>
                                </li>
                            </ul>
                        </li>
                        <!-- 관리자 전용 페이지 끝 -->

                    </ul>
                </div>

                <div class="collapse navbar-collapse border-lg-0 my-2 mt-lg-0" id="navbarSupportedContent">
                    <div class="mx-auto pt-5 pt-lg-0 d-block d-lg-none d-xl-block">
                        <!-- 공간을 위한 안보이는 div -->
                    </div>
                    <form class="d-flex mt-4 mt-lg-0 ms-lg-auto ms-xl-0">
                        <!-- 검색창 시작 일단 안보이게 주석처리함 -->
                        <div class="input-group-icon pe-2">
                            <!-- <i class="fas fa-search input-box-icon text-primary"></i>
                            <input class="form-control border-0 input-box bg-100" type="search" placeholder="여기는 검색창"
                                aria-label="Search" /> -->
                        </div>
                        <!-- 검색창 끝 -->

                        <div v-if="!currentUser">
                            <!-- 회원가입 시작 -->
                            <router-link to="/termsOfService" class="btn btn-white text-yellow register">
                                <i class="bi bi-person-plus-fill fs-2 mr-2" />
                                <span class="text-1000 fs-2 fw-bold text-yellow">회원가입</span>
                            </router-link>
                            <!-- 회원가입 끝 -->

                            <!-- 로그인 시작 -->
                            <!-- 부트스트랩 뷰 의 모달 기능 사용하기 -->
                            <b-button v-b-modal.modal-1 class="btn btn-white text-yellow login" id="loginButton">
                                <!-- <i class="fas fa-user me-2"></i>로그인 -->
                                <i class="bi bi-door-closed-fill fs-2 mr-2" /> 
                                <span class="text-1000 fs-2 fw-bold text-yellow">로그인</span>
                            </b-button>
                            <!-- 로그인 끝 -->
                        </div>
                        <div v-if="currentUser">
                            <!-- 프로필 시작 -->
                            <a href="/profile" class="btn btn-white text-yellow login">
                                <i class="bi bi-person-circle fs-2 mr-2" /> 
                                <span class="text-1000 fs-2 fw-bold text-yellow"> {{ this.currentUser.username }}</span>
                            </a>
                            <!-- 프로필 끝 -->

                            <!-- 로그아웃 시작 -->
                            <a @click.prevent="logout" class="btn btn-white text-yellow login">
                                <i class="bi bi-door-open-fill fs-2 mr-2" /> 
                                <span class="text-1000 fs-2 fw-bold text-yellow">로그아웃</span>
                            </a>
                            <!-- 로그아웃 끝 -->
                        </div>
                    </form>
                </div>
            </div>
        </nav>
        <!-- 네비게이션 바 끝 -->

        <!-- 로그인 모달 내용 시작 -->
        <b-modal id="modal-1" title="로그인" hide-footer="true">
            <!-- 로그인 모달 컴포넌트를 내용으로 가져오기 -->
            <LoginView />
        </b-modal>
        <!-- 로그인 모달 내용 끝 -->
    </div>
</template>
  
<script>
/* eslint-disable */
// 부트스트랩 뷰 의 모달 기능 사용하기
import { BModal } from "bootstrap-vue";
// 로그인 뷰 페이지를 컴포넌트로 가져오기
import LoginView from "@/components/user/LoginView.vue";

export default {
    // 부트스트랩 뷰 의 모달 기능 사용하기, 로그인 뷰 페이지를 컴포넌트로 가져오기
    components: {
        BModal,
        LoginView,
    },

    computed: {
        // 현재 유저
        currentUser() {
            // 모듈 저장소 : this.$store.state.모듈명.state값
            // user 객체 의 속성 : username, password, email, accesToken, roles(배열)
            return this.$store.state.auth.user;
        },

        // 관리자 접속인지 아닌지 확인하는 함수
        showAdminBoard() {
            if (this.currentUser && this.currentUser.roles) {
                // if ROLE_ADMIN 있으면 true
                //               없으면 false
                return this.currentUser.roles.includes("ROLE_ADMIN");
            }
            // currentUser 없으면 false (메뉴가 안보임)
            return false;
        },
    },
    methods: {
        // 로그아웃 함수 -> 공통함수 호출
        logout() {
            // this.$store.dispatch("모듈명/함수명")
            this.$store.dispatch("auth/logout"); // 공통함수 logout 호출
            // alert 라이브러리 효과
            this.$swal({
                icon: "success",
                title: "로그아웃 성공",
                showConfirmButton: false,
                timer: 1000,
            });
            // 홈으로 보내기 함수(프로필에 있거나 유저관련 페이지일 경우)
            if(this.$route.path == "/profile" || this.$route.path == "/user") {
                this.$router.push("/")
            } else {
                this.$router.go();
            }
        },
        busanNav(){
            alert("클릭성공");
        }
    },

    // 모달 적용시 로그인 버튼에 강제적으로 추가되어 css를 바꾸는 클래스 삭제하기
    mounted() {
        var ele = document.getElementById("loginButton");
        ele.classList.remove("btn-secondary");

    },
    // 모달 적용시 로그인 버튼에 강제적으로 추가되어 css를 바꾸는 클래스 삭제하기
    updated() {
        var ele = document.getElementById("loginButton");
        ele.classList.remove("btn-secondary");
    },
    // 모달 끄라는 명령 받아서 실행하는 함수
    watch : {
        '$store.state.modalclose' : function() {
            this.$bvModal.hide('modal-1');
            this.$store.commit("modalcloseReady");
        }
    }
};
</script>
  
<style>
/* .dropdown:hover .dropdown-menu {
    display: block;
    margin-top: 0;
  } */

/* 로그인 모달의 x 버튼 커마 */
.close {
    background: none;
    border: none;
    font-size: 2rem;
}

/* 모달안에 안보여야 할 버튼 숨기기 */
.b-button {
    display: none;
}

.modal-dialog {
    display: table;
}

/* 나브바 오른쪽 버튼들 색 조정 */
.text-yellow {
    color: #FFB30E !important;
}
/* 나브바 오른쪽 버튼들 마우스 올렸을 때 색 조정 */
.text-yellow:hover {
    color: #FFB30E !important;
}

/* 나브바 오른쪽 버튼들 마우스 눌렸을 때 테두리 제거 */
.text-yellow:focus {
    box-shadow: none !important;
}

@import "../../../public/assets/css/navstyle.css"
</style>
  