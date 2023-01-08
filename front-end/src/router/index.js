/* eslint-disable */
import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  // TODO: 첫 페이지 (홈 화면)
  {
    path: "/",
    name: "home",
    component: () => import("../views/HomeView.vue"),
  },
  // TODO: 분류별 맛집 리스트 구현
  {
    path: "/diner",
    name: "diner",
    component: () => import("@/components/food/local/DinerList.vue"),
  },
  {
    path: "/diner/:dno",
    name: "diner-detail",
    component: () => import("@/components/food/detail/DinerDetail.vue"),
  },
  {
    path: "/add/diner",
    name: "diner-add",
    component: () => import("@/components/food/detail/AddDiner.vue"),
  },
  {
    path: "/diner/:dno/edit",
    name: "diner-edit",
    component: () => import("@/components/food/detail/EditDiner.vue"),
  },
  {
    path: "/add/review/:dno",
    name: "review-add",
    component: () => import("@/components/food/detail/DinerComment.vue"),
  },
  {
    path: "/edit/review/:rno",
    name: "review-edit",
    component: () => import("@/components/food/detail/EditComment.vue"),
  },
  // TODO: 분류별 게시판 구현
  {
    path: '/free',
    name: 'free',
    component: () => import('@/components/board/free/FreeList.vue')
  },
  // AddFree 
  {
    path: '/add-free',
    name: 'add-free',
    component: () => import('../components/board/free/AddFreeView.vue')
  },

  // FreeDetail 
  {
    path: '/free/:fno',
    name: 'free-detail',
    component: () => import('../components/board/free/FreeDetailView.vue')
  },
  // FreeView
  {
    path: '/freeview/:fno',
    name: 'free-view',
    component: () => import('../components/board/free/FreeView.vue')
  },
  {
    path: "/announce",
    name: "announce",
    component: () => import("@/components/board/announce/AnnounceList.vue"),
  },
  // AddAnnounce
  {
    path: "/add-announce",
    name: "add-announce",
    component: () => import("../components/board/announce/AddAnnounceView.vue"),
  },

  // AnnounceDetail
  {
    path: "/announce/:ano",
    name: "announce-detail",
    component: () =>
      import("../components/board/announce/AnnounceDetailView.vue"),
  },
  // AnnounceView
  {
    path: "/announceview/:ano",
    name: "announce-view",
    component: () => import("../components/board/announce/AnnounceView.vue"),
  },
  // Faq
  {
    path: "/faq",
    name: "faq",
    component: () => import("@/components/board/faq/FaqList.vue"),
  },
  // AddFaq
  {
    path: "/add-faq",
    name: "add-faq",
    component: () => import("../components/board/faq/AddFaqView.vue"),
  },
  // FaqDetail
  {
    path: "/faq/:no",
    name: "faq-detail",
    component: () => import("../components/board/faq/FaqDetailView.vue"),
  },
  {
    path: "/question",
    name: "question",
    component: () => import("@/components/board/question/QuestionList.vue"),
  },
  // TODO: question 디테일,add 추가
  // Addquestion
  {
    path: "/add-question",
    name: "add-question",
    component: () => import("../components/board/question/AddQuestionView.vue"),
  },
  // QnaDetail
  {
    path: "/question/:qno",
    name: "qna-detail",
    component: () => import("../components/board/question/QuestionDetailView.vue"),
  },
  // QnaView
  {
    path: "/questionview/:qno",
    name: "qna-view",
    component: () => import("../components/board/question/QuestionView.vue"),
  },
  // TODO: 로그인 메뉴 달기
  {
    path: "/login",
    name: "login",
    component: () => import("@/components/user/LoginView.vue"),
  },
  {
    path: "/register",
    name: "register",
    component: () => import("@/components/user/RegisterView.vue"),
  },
  {
    path: "/profile",
    name: "profile",
    component: () => import("@/components/user/ProfileView.vue"),
  },
  {
    path: "/user",
    name: "user",
    component: () => import("../components/admin/UserList.vue"),
  },
  {
    path: "/add-user",
    name: "add-user",
    component: () => import("../components/admin/AddUser.vue"),
  },
  {
    path: "/user/:id",
    name: "user-detail",
    component: () => import("../components/admin/UserDetail.vue"),
  },
  // 예약
  {
    path: "/reservation",
    name: "reservation",
    component: () => import("../components/reservation/ReservationList.vue"),
  },
  {
    path: "/add-reservation",
    name: "add-reservation",
    component: () => import("../components/reservation/AddReservation.vue"),
  },
  {
    path: "/reservation/:rid",
    name: "reservation-detail",
    component: () => import("../components/reservation/ReservationDetail.vue"),
  },
  // 팀원 소개 페이지
  {
    path: "/team",
    name: "team",
    component: () => import("../components/introduce/IntroduceView.vue"),
  },
  {
    path: '/findIdPw',
    name: 'findIdPw',
    component: () => import('../components/user/FindIdPw.vue')
  },
  // 아이디 찾기 버튼 눌렀을 때 아아디 보여주는 화면
  {
    path: '/findId',
    name: 'findId',
    component: () => import('../components/user/FindId.vue')
  },
  // 비번 찾기 버튼 눌렀을 때 비번 재설정 화면
  {
    path: '/findPw',
    name: 'findPw',
    component: () => import('../components/user/FindPw.vue')
  },
  {
    path: '/column',
    name: 'column',
    component: () => import('../components/foodcolumn/ColumnList.vue')
  },
  {
    path: "/column/:cid",
    name: "column-detail",
    component: () => import('../components/foodcolumn/ColumnDetail.vue')
  },
  {
    path: "/add-column",
    name: "add-column",
    component: () => import('../components/foodcolumn/AddColumn.vue')
  },
  // 회원가입 전 약관 동의 페이지
  {
    path: '/termsOfService',
    name: 'termsOfService',
    component: () => import('../components/user/TermsOfService.vue')
  },
  // TODO 3) : 간편 로그인 추가 /auth-redirect
  {
      path: '/auth-redirect',
      name: 'auth-redirect',
      component: () => import('../views/Auth2View.vue')
  },
  // 음식점 조건별(지역,테마 등등) 이동
  {
    path: "/haeundae",
    name: "haeundae",
    component: () => import("@/components/food/local/DinerList.vue"),
  },  
  {
    path: "/namgu",
    name: "namgu",
    component: () => import("@/components/food/local/DinerList.vue"),
  },  {
    path: "/geumjeong",
    name: "geumjeong",
    component: () => import("@/components/food/local/DinerList.vue"),
  },  
  {
    path: "/gijang",
    name: "gijang",
    component: () => import("@/components/food/local/DinerList.vue"),
  },  {
    path: "/dongnae",
    name: "dongnae",
    component: () => import("@/components/food/local/DinerList.vue"),
  },  
  {
    path: "/busanjin",
    name: "busanjin",
    component: () => import("@/components/food/local/DinerList.vue"),
  },  {
    path: "/yeongdo",
    name: "yeongdo",
    component: () => import("@/components/food/local/DinerList.vue"),
  },  
  {
    path: "/gangseo",
    name: "gangseo",
    component: () => import("@/components/food/local/DinerList.vue"),
  },  {
    path: "/korean",
    name: "korean",
    component: () => import("@/components/food/local/DinerList.vue"),
  },  
  {
    path: "/chinese",
    name: "chinese",
    component: () => import("@/components/food/local/DinerList.vue"),
  },  {
    path: "/japanese",
    name: "japanese",
    component: () => import("@/components/food/local/DinerList.vue"),
  },  
  {
    path: "/western",
    name: "western",
    component: () => import("@/components/food/local/DinerList.vue"),
  },  
  {
    path: "/date",
    name: "date",
    component: () => import("@/components/food/local/DinerList.vue"),
  },  
  {
    path: "/meeting",
    name: "meeting",
    component: () => import("@/components/food/local/DinerList.vue"),
  },  
  {
    path: "/getTogether",
    name: "getTogether",
    component: () => import("@/components/food/local/DinerList.vue"),
  },,  
  {
    path: "/daily",
    name: "daily",
    component: () => import("@/components/food/local/DinerList.vue"),
  },
  {
    path: "/add/menu",
    name: "menu-add",
    component: () => import("@/components/food/detail/AddMenu.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  // 다른 컴포넌트 특정 위치로 가기위해 설정 추가
  scrollBehavior(to, from, savedPosition) {
    if (to.hash) {
      return {
        selector: to.hash,
        offset: { y: 200 },
        behavior: "smooth",
      }
    } else {
      return {
        x: 0,
        y: 0,
        behavior: "smooth",
      };
    }

    
  },
  base: process.env.BASE_URL,
  routes,
});

export default router;
