import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  // TODO: 첫 페이지 (홈 화면)
  {
    path: '/',
    name: 'home',
    component: () => import('../views/HomeView.vue')
  },
  // TODO: 분류별 맛집 리스트 구현
  {
    path: '/local',
    name: 'local',
    component: () => import('@/components/food/local/LocalList.vue')
  },
  {
    path: '/menu',
    name: 'menu',
    component: () => import('@/components/food/menu/MenuList.vue')
  },
  {
    path: '/theme',
    name: 'theme',
    component: () => import('@/components/food/theme/ThemeList.vue')
  },
  {
    path: '/diner', // 음식점 상세페이지 샘플
    name: 'diner',
    component: () => import('@/components/food/detail/DinerDetail.vue')
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
    path: '/announce',
    name: 'announce',
    component: () => import('@/components/board/announce/AnnounceList.vue')
  },
   // AddAnnounce 
   {
    path: '/add-announce',
    name: 'add-announce',
    component: () => import('../components/board/announce/AddAnnounceView.vue')
  },

  // AnnounceDetail 
  {
    path: '/announce/:ano',
    name: 'announce-detail',
    component: () => import('../components/board/announce/AnnounceDetailView.vue')
  },
  // AnnounceView
  {
    path: '/announceview/:ano',
    name: 'announce-view',
    component: () => import('../components/board/announce/AnnounceView.vue')
  },
  {
    path: '/faq',
    name: 'faq',
    component: () => import('@/components/board/FaqList.vue')
  },
  {
    path: '/qna',
    name: 'qna',
    component: () => import('@/components/board/qna/QnaList.vue')
  },
  // TODO: qna 디테일,add 추가
   // AddQna 
   {
    path: '/add-qna',
    name: 'add-qna',
    component: () => import('../components/board/qna/AddQnaView.vue')
  },

  // QnaDetail 
  {
    path: '/qna/:qno',
    name: 'qna-detail',
    component: () => import('../components/board/qna/QnaDetailView.vue')
  },
  // QnaView
  {
    path: '/qnaview/:qno',
    name: 'qna-view',
    component: () => import('../components/board/qna/QnaView.vue')
  },
  // TODO: 로그인 메뉴 달기
  {
    path: '/login',
    name: 'login',
    component: () => import('@/components/user/LoginView.vue')
  },
  {
    path: '/register',
    name: 'register',
    component: () => import('@/components/user/RegisterView.vue')
  },
  {
    path: '/profile',
    name: 'profile',
    component: () => import('@/components/user/ProfileView.vue')
  },
  {
    path: '/user',
    name: 'user',
    component: () => import('../components/admin/UserList.vue')
  },
  {
    path: '/add-user',
    name: 'add-user',
    component: () => import('../components/admin/AddUser.vue')
  },
  {
    path: '/user/:id',
    name: 'user-detail',
    component: () => import('../components/admin/UserDetail.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
