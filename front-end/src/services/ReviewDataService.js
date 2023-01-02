// DeptDataService.js
// 목적 : Dept 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class ReviewDataService {
    getAll(dno, page, size) {
        return http.get(`/review?dno=${dno}&page=${page}&size=${size}`); 
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