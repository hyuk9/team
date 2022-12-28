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
                            <router-link to="" class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                음식점 리스트
                            </router-link>
                            <ul class="dropdown-menu">
                                <li class="dropdown-item disabled">지역별</li>
                                <li class="has-children subdropmenu">
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
                                    <router-link to="/local" class="dropdown-item">경기</router-link>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">인천</a></li>
                                        <li><a href="#">세종시</a></li>
                                        <li><a href="#">평택</a></li>
                                        <li><a href="#">용인</a></li>
                                        <li><a href="#">이천</a></li>
                                        <li><a href="#">화성</a></li>
                                        <li><a href="#">김포</a></li>
                                    </ul>
                                </li>
                                <li class="has-children subdropmenu">
                                    <router-link to="/local" class="dropdown-item">부산</router-link>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">해운대구</a></li>
                                        <li><a href="#">남구</a></li>
                                        <li><a href="#">금정구</a></li>
                                        <li><a href="#">기장구</a></li>
                                        <li><a href="#">동래구</a></li>
                                        <li><a href="#">부산진구</a></li>
                                        <li><a href="#">영도구</a></li>
                                        <li><a href="#">강서구</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <hr class="dropdown-divider" />
                                </li>
                                <li class="dropdown-item disabled">메뉴별</li>
                                <li>
                                    <router-link to="/" class="dropdown-item">한식</router-link>
                                </li>
                                <li>
                                    <router-link to="/" class="dropdown-item">중식</router-link>
                                </li>
                                <li>
                                    <router-link to="/" class="dropdown-item">일식</router-link>
                                </li>
                                <li>
                                    <router-link to="/" class="dropdown-item">양식</router-link>
                                </li>
                                <li>
                                    <hr class="dropdown-divider" />
                                </li>
                                <li class="dropdown-item disabled">테마별</li>
                                <li>
                                    <router-link to="/" class="dropdown-item">데이트</router-link>
                                </li>
                                <li>
                                    <router-link to="/" class="dropdown-item">모임</router-link>
                                </li>
                                <li>
                                    <router-link to="/" class="dropdown-item">회식</router-link>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <router-link to="" class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                게시판
                            </router-link>
                            <ul class="dropdown-menu">
                                <li>
                                    <router-link to="/announce" class="dropdown-item">공지사항</router-link>
                                </li>
                                <li>
                                    <router-link to="/faq" class="dropdown-item">자주묻는질문</router-link>
                                </li>
                                <li>
                                    <router-link to="/qna" class="dropdown-item">질문과답변</router-link>
                                </li>
                                <li>
                                    <router-link to="/free" class="dropdown-item">자유게시판</router-link>
                                </li>
                            </ul>
                        </li>
                        <!-- 푸드컬럼 페이지 시작 -->
                        <li class="nav-item dropdown">
                            <router-link to="" class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                푸드컬럼
                            </router-link>
                            <ul class="dropdown-menu">
                                <li>
                                    <router-link to="/column" class="dropdown-item">푸드컬럼 보기</router-link>
                                </li>
                                <li>
                                    <router-link to="#" class="dropdown-item">차라리 게시판 쪽에 통합을 할지?</router-link>
                                </li>
                            </ul>
                        </li>
                        <!-- 푸드컬럼 페이지 끝 -->

                        <!-- 임시로 만든 예약 네비게이션 시작 -->
                        <li class="nav-item dropdown">
                            <router-link to="" class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                예약(임시)
                            </router-link>
                            <ul class="dropdown-menu">
                                <li>
                                    <router-link to="/reservation" class="dropdown-item">예약 조회하기</router-link>
                                </li>
                                <li>
                                    <router-link to="/add-reservation" class="dropdown-item">예약하기</router-link>
                                </li>
                            </ul>
                        </li>
                        <!-- 임시로 만든 예약 네비게이션 끝 -->

                        <!-- 관리자 전용 페이지 시작 -->
                        <!-- showAdminBoard가 동작하면 보이게 작동 -->
                        <li v-if="showAdminBoard" class="nav-item dropdown">
                            <router-link to="" class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                관리자 전용(관리자만 보이게 설정)
                            </router-link>
                            <ul class="dropdown-menu">
                                <li>
                                    <router-link to="/user" class="dropdown-item">유저 목록 조회하기</router-link>
                                </li>
                                <li>
                                    <router-link to="/reservation" class="dropdown-item">예약현황 조회하기</router-link>
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
                        <!-- 검색창 시작 -->
                        <div class="input-group-icon pe-2">
                            <i class="fas fa-search input-box-icon text-primary"></i>
                            <input class="form-control border-0 input-box bg-100" type="search" placeholder="여기는 검색창"
                                aria-label="Search" />
                        </div>
                        <!-- 검색창 끝 -->

                        <div v-if="!currentUser">
                            <!-- 회원가입 시작 -->
                            <router-link to="/register" class="btn btn-white text-yellow register">
                                <i class="fas fa-user me-2"></i>회원가입
                            </router-link>
                            <!-- 회원가입 끝 -->

                            <!-- 로그인 시작 -->
                            <!-- 부트스트랩 뷰 의 모달 기능 사용하기 -->
                            <b-button v-b-modal.modal-1 class="btn btn-white text-yellow ms-1 login" id="loginButton">
                                <i class="fas fa-user me-2"></i>로그인
                            </b-button>
                            <!-- 로그인 끝 -->
                        </div>
                        <div v-if="currentUser">
                            <!-- 프로필 시작 -->
                            <router-link to="/profile" class="btn btn-white text-yellow login">
                                <i class="fas fa-user me-2"></i>프로필
                            </router-link>
                            <!-- 프로필 끝 -->

                            <!-- 로그아웃 시작 -->
                            <a @click.prevent="logout" class="btn btn-white text-yellow ms-1 login">
                                <i class="fas fa-user me-2"></i>
                                로그아웃
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
            <!-- 모달창 끄기용 가짜버튼(화면에 안보임) -->
            <b-button @click="$bvModal.hide('modal-1')" ref="button" class="b-button"></b-button>
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
        },
    },

    // 모달 적용시 로그인 버튼에 강제적으로 추가되어 css를 바꾸는 클래스 삭제하기
    mounted() {
        var ele = document.getElementById("loginButton");
        ele.classList.remove("btn-secondary");

        this.$store.subscribeAction((action, state) => {
            if (action.type === "clickButton") {
                // Trigger the click event on the button element
                this.$refs.button.click();
            }
        });
    },
    // 모달 적용시 로그인 버튼에 강제적으로 추가되어 css를 바꾸는 클래스 삭제하기
    updated() {
        var ele = document.getElementById("loginButton");
        ele.classList.remove("btn-secondary");
    },
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
    color: #FFB30E;
}
/* 나브바 오른쪽 버튼들 마우스 올렸을 때 색 조정 */
.text-yellow:hover {
    color: #FFB30E !important;
}
.text-yellow:active {
    border: none !important;
}

@import "../../../public/assets/css/navstyle.css"
</style>
  