// QuestionDataService.js
// 목적 : Question 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class QuestionDataService {
    // 모든 부서정보 조회 요청 함수
    getAll(searchSelect, searchKeyword, page, size) {
        // get 방식 통신 요청 -> @GetMapping("/api/question")
        return http.get(`/question?searchSelect=${searchSelect}&searchKeyword=${searchKeyword}&page=${page}&size=${size}`); 
    }

    // 부서번호로 조회 요청 함수
    // get 방식 통신 요청 -> @GetMapping("/api/question/{questionNo}"), @PathVariable
    get(questionNo) {
        return http.get(`/question/${questionNo}`)
    }

    // 부서정보 생성(insert) 요청 함수
    // post 방식 통신 요청 -> @PostMapping("/api/question"), @RequestBody
    create(data) {
        console.log(data);
        return http.post("/question", data);
    }

    // 부서정보 수정(update) 요청 함수
    // put 방식 통신 요청 -> @PutMapping("/api/question/{questionNo}"), @RequestBody
    update(questionNo, data) {
        return http.put(`/question/${questionNo}`, data);
    }

    // 부서정보 삭제(delete) 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/question/deletion/{questionNo}")
    //                        , @PathVariable  
    delete(questionNo) {
        return http.delete(`/question/deletion/${questionNo}`);
    }

    // 부서정보 전체 삭제 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/question/all")
    deleteAll() {
        return http.delete("/question/all")
    }

}

export default new QuestionDataService();