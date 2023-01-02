// AnswerDataService.js
// 목적 : Answer 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class AnswerDataService {
    // 모든 답변정보 조회 요청 함수
    // getAll(searchSelect, searchKeyword, page, size) {
    //     // get 방식 통신 요청 -> @GetMapping("/api/answer")
    //     return http.get(`/answer?searchSelect=${searchSelect}&searchKeyword=${searchKeyword}&page=${page}&size=${size}`); 
    // }

    // 모든 답변정보 조회 요청 함수
    getAll(searchSelect, searchKeyword, page, size) {
        // get 방식 통신 요청 -> @GetMapping("/api/answer")
        return http.get(`/answer?searchSelect=${searchSelect}&searchKeyword=${searchKeyword}&page=${page}&size=${size}`); 
    }

    // 부서번호로 조회 요청 함수
    // get 방식 통신 요청 -> @GetMapping("/api/answer/{answerNo}"), @PathVariable
    get(questionNo) {
        return http.get(`/answer/${questionNo}`)
    }

    // 부서정보 생성(insert) 요청 함수
    // post 방식 통신 요청 -> @PostMapping("/api/answer"), @RequestBody
    create(data) {
        console.log(data);
        return http.post("/answer", data);
    }

    // 부서정보 수정(update) 요청 함수
    // put 방식 통신 요청 -> @PutMapping("/api/answer/{answerNo}"), @RequestBody
    update(answerNo, data) {
        return http.put(`/answer/${answerNo}`, data);
    }

    // 부서정보 삭제(delete) 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/answer/deletion/{answerNo}")
    //                        , @PathVariable  
    delete(answerNo) {
        return http.delete(`/answer/deletion/${answerNo}`);
    }

    // 부서정보 전체 삭제 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/answer/all")
    deleteAll() {
        return http.delete("/answer/all")
    }

}

export default new AnswerDataService();