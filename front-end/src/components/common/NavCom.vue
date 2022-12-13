<template>
  <div>
    <!-- 네비게이션 바 시작 -->
    <nav
      class="navbar navbar-expand-lg navbar-light bg-light fixed-top"
      data-navbar-on-scroll="data-navbar-on-scroll"
    >
      <div class="container">
        <!-- 로고명과 이미지 시작 -->
        <router-link to="/" class="navbar-brand d-inline-flex">
          <!-- <img
            class="d-inline-block"
            src="assets/img/gallery/logo.svg"
            alt="logo"/> -->
            <span class="text-1000 fs-3 fw-bold ms-2 text-gradient"
            >맛있는 토마토</span
          >
        </router-link>
        <!-- 로고명과 이미지 끝 -->

        <!-- 밑에 버튼 뭔지 모르겠어서 일단 주석처리 해놨음 -->
        <!-- <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"> </span>
        </button> -->
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
          <ul class="navbar-nav ">
            <li class="nav-item dropdown">
              <router-link to = ""
                class="nav-link dropdown-toggle"
                
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                음식점 리스트
              </router-link>
              <ul class="dropdown-menu">
                <li><router-link to="/local" class="dropdown-item">지역별</router-link></li>
                <li><router-link to="/menu" class="dropdown-item">메뉴별</router-link></li>
                <li>
                  <router-link to = "/score" class="dropdown-item" >평점별</router-link>
                </li>
                <li>
                  <router-link to = "/review" class="dropdown-item" >리뷰많은순</router-link>
                </li>
              </ul>
            </li>
            <li class="nav-item dropdown">
              <router-link to = ""
                class="nav-link dropdown-toggle"
                
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                게시판
              </router-link>
              <ul class="dropdown-menu">
                <li><router-link to = "/announce" class="dropdown-item" >공지사항</router-link></li>
                <li><router-link to = "/faq" class="dropdown-item" >자주묻는질문</router-link></li>
                <li>
                  <router-link to = "/qna" class="dropdown-item" >질문과답변</router-link>
                </li>
                <li>
                  <router-link to = "/free" class="dropdown-item" >자유게시판</router-link>
                </li>
              </ul>
            </li>
          </ul>
        </div>
        <div
          class="collapse navbar-collapse  border-lg-0 my-2 mt-lg-0"
          id="navbarSupportedContent"
        >
          <div class="mx-auto pt-5 pt-lg-0 d-block d-lg-none d-xl-block">
            <!-- 여기부분은 필요 없는거 같아서 일단 주석처리 해놨음 -->
            <!-- <p class="mb-0 fw-bold text-lg-center">
              Deliver to: <i class="fas fa-map-marker-alt text-warning mx-2"></i
              ><span class="fw-normal">Current Location </span
              ><span>Mirpur 1 Bus Stand, Dhaka</span>
            </p> -->
          </div>
          <form class="d-flex mt-4 mt-lg-0 ms-lg-auto ms-xl-0">
            <!-- 검색창 시작 -->
            <div class="input-group-icon pe-2">
              <i class="fas fa-search input-box-icon text-primary"></i>
              <input
                class="form-control border-0 input-box bg-100"
                type="search"
                placeholder="여기는 검색창"
                aria-label="Search"
              />
            </div>
            <!-- 검색창 끝 -->

            <!-- 회원가입 시작 -->
            <button
              class="btn btn-white shadow-warning text-warning"
            >
              <i class="fas fa-user me-2"></i><router-link to="/register">회원가입</router-link> 
            </button>
            <!-- 회원가입 끝 -->

            <!-- 로그인 시작 -->
            <button
              class="btn btn-white shadow-warning text-warning"
            >
              <i class="fas fa-user me-2"></i><router-link to="/login">로그인</router-link> 
            </button>
            <!-- 로그인 끝 -->
          </form>
        </div>
      </div>
    </nav>
    <!-- 네비게이션 바 끝 -->
  </div>
</template>

<script>
export default {};
</script>

<style>
</style>

