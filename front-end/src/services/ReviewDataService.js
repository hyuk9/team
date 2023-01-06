// DeptDataService.js
// 목적 : Dept 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";
import authHeader from "@/services/auth/auth-header";

class ReviewDataService {
  // upload(review) {
  //     // json 객체 사용하지 않음 (x)
  //     // form 태그로 전송하는 방식을 이용함
  //     // html <form></form> == js FormData 객체로 사용가능
  //     //                       .append("속성명", 값) 함수 : 데이터를 저장
  //     // axios 함수 : .post()
  //     // 헤더 : "Content-Type" : "multipart/form-data"
  //     let formData = new FormData(); // 폼(form) 객체 생성

  //     formData.append("review", review);

  //     return http.post("/review/upload", formData, {
  //         headers: {
  //             "Content-Type" : "multipart/form-data"
  //         }
  //     })
  // }

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
}

export default new ReviewDataService();
