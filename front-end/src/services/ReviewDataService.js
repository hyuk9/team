// DeptDataService.js
// 목적 : Dept 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class ReviewDataService {
    // 모든 부서정보 조회 요청 함수
    // dname : 부서명
    // page : 현재 페이지 번호
    // size : 페이지당 화면에 보여질 개수
    getAll(review_writer, page, size) {
        // get 방식 통신 요청 -> @GetMapping("/api/review")
        // 1) 전체 조회 +
        // 2) 부서명 조회 같이하는 함수
        return http.get(`/diner?review_writer=${review_writer}&page=${page}&size=${size}`); 
    }

    // 부서정보 생성(insert) 요청 함수
    // post 방식 통신 요청 -> @PostMapping("/api/diner"), @RequestBody
    create(data) {
        console.log(data);
        return http.post("/diner", data);
    }

    // 부서정보 수정(update) 요청 함수
    // put 방식 통신 요청 -> @PutMapping("/api/diner/{dno}"), @RequestBody
    update(review_id, data) {
        return http.put(`/diner/${review_id}`, data);
    }

    // 부서정보 삭제(delete) 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/diner/deletion/{dno}")
    //                        , @PathVariable  
    delete(review_id) {
        return http.delete(`/diner/deletion/${review_id}`);
    }

}

export default new ReviewDataService();