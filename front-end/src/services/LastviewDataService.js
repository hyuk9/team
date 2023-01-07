// DeptDataService.js
// 목적 : Dept 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";
import authHeader from "@/services/auth/auth-header";

class LastviewDataService {
  // 모든 부서정보 조회 요청 함수
  getAll() {
    // get 방식 통신 요청 👉 @GetMapping("/api/dept")
    return http.get("/lastview");
  }

  // 유저id를 받아서 리뷰 조회하는 함수
  getId(id, page, size) {
    return http.get(`/lastview/id?id=${id}&page=${page}&size=${size}`, {
      headers: authHeader(),
    });
  }

  // id와 dno로 조회하는 함수
  get(id, dno) {
    // get 방식 통신 요청 👉 @GetMapping("/api/menu/{dno}")
    return http.get(`/lastview/${id}/${dno}`);
  }

  // 부서정보 생성(insert) 요청 함수
  // post 방식 통신 요청 -> @PostMapping("/api/diner"), @RequestBody
  create(data) {
    console.log(data);
    return http.post("/lastview", data);
  }

  // 부서정보 수정(update) 요청 함수
  // put 방식 통신 요청 -> @PutMapping("/api/diner/{dno}"), @RequestBody
  update(rno, data) {
    return http.put(`/lastview/${rno}`, data);
  }

  // 부서정보 삭제(delete) 요청 함수
  // delete 방식 통신 요청 -> @DeleteMapping("/api/diner/deletion/{dno}")
  //                        , @PathVariable
  delete(lid) {
    return http.delete(`/lastview/deletion/${lid}`);
  }
}

export default new LastviewDataService();
