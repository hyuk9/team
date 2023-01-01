// DeptDataService.js
// 목적 : Dept 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class ReviewDataService {
  getAll(reviewWriter, page, size) {
    return http.get(
      `/review?reviewWriter=${reviewWriter}&page=${page}&size=${size}`
    );
  }
  // 부서번호로 조회 요청 함수
  // get 방식 통신 요청 -> @GetMapping("/api/diner/{dno}"), @PathVariable
  get(reviewId) {
    return http.get(`/review/${reviewId}`);
  }

  // 부서정보 생성(insert) 요청 함수
  // post 방식 통신 요청 -> @PostMapping("/api/diner"), @RequestBody
  create(data) {
    console.log(data);
    return http.post("/review", data);
  }

  // 부서정보 수정(update) 요청 함수
  // put 방식 통신 요청 -> @PutMapping("/api/diner/{dno}"), @RequestBody
  update(reviewId, data) {
    return http.put(`/review/${reviewId}`, data);
  }

  // 부서정보 삭제(delete) 요청 함수
  // delete 방식 통신 요청 -> @DeleteMapping("/api/diner/deletion/{dno}")
  //                        , @PathVariable
  delete(reviewId) {
    return http.delete(`/review/deletion/${reviewId}`);
  }
}

export default new ReviewDataService();
