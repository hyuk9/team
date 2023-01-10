// DeptDataService.js
// 목적 : Dept 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";
import authHeader from "@/services/auth/auth-header";

class ReviewDataService {
  // 모든 부서정보 조회 요청 함수
  getAll() {
    // get 방식 통신 요청 👉 @GetMapping("/api/dept")
    return http.get("/review");
  }

  // 유저id를 받아서 리뷰 조회하는 함수
  getId(id, page, size) {
    return http.get(`/review/id?id=${id}&page=${page}&size=${size}`, {
      headers: authHeader(),
    });
  }

  // 음식점번호로 조회 요청 함수
  get(dno) {
    // get 방식 통신 요청 👉 @GetMapping("/api/menu/{dno}")
    return http.get(`/review/${dno}`);
  }

  // 리뷰번호로 조회 요청 함수
  getRno(rno) {
    // get 방식 통신 요청 👉 @GetMapping("/api/menu/{dno}")
    return http.get(`/review/rno/${rno}`);
  }

  //
  getReviewByDno(dno, page, size) {
    return http.get(`/review/dno?dno=${dno}&page=${page}&size=${size}`, {
      headers: authHeader(),
    });
  }

  // 부서정보 생성(insert) 요청 함수
  // post 방식 통신 요청 -> @PostMapping("/api/diner"), @RequestBody
  create(data) {
    console.log(data);
    return http.post("/review", data);
  }

  // 부서정보 수정(update) 요청 함수
  // put 방식 통신 요청 -> @PutMapping("/api/diner/{dno}"), @RequestBody
  update(rno, data) {
    return http.put(`/review/${rno}`, data);
  }

  // 부서정보 삭제(delete) 요청 함수
  // delete 방식 통신 요청 -> @DeleteMapping("/api/diner/deletion/{dno}")
  //                        , @PathVariable
  delete(rno) {
    return http.delete(`/review/deletion/${rno}`);
  }

  // 스코어 조회 함수
  findByDnoScoreAvg(dno) {
    return http.get(`/review/dno/${dno}`);
  }
}

export default new ReviewDataService();
