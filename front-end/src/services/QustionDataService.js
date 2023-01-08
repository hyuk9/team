// QuestionDataService.js
// 목적 : Question 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class QuestionDataService {
    // Todo : 모든 질문정보 조회 요청 함수
    getAll(searchSelect, searchKeyword, page, size) {
        // get 방식 통신 요청 -> @GetMapping("/api/question")
        return http.get(`/question?searchSelect=${searchSelect}&searchKeyword=${searchKeyword}&page=${page}&size=${size}`);
    }

    // Todo : 질문번호로 조회 요청 함수
    // get 방식 통신 요청 -> @GetMapping("/api/question/{qno}"), @PathVariable
    get(qno) {
        return http.get(`/question/${qno}`)
    }

    // Todo : 질문정보 생성(insert) 요청 함수
    // post 방식 통신 요청 -> @PostMapping("/api/question"), @RequestBody
    create(data) {
        console.log(data);
        return http.post("/question", data);
    }

    // Todo : 질문정보 수정(update) 요청 함수
    // put 방식 통신 요청 -> @PutMapping("/api/question/{qno}"), @RequestBody
    update(qno, data) {
        return http.put(`/question/${qno}`, data);
    }

    // Todo : 질문정보 삭제(delete) 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/question/deletion/{qno}")
    //                        , @PathVariable  
    delete(qno) {
        return http.delete(`/question/deletion/${qno}`);
    }

    // Todo : 질문정보 전체 삭제 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/question/all")
    deleteAll() {
        return http.delete("/question/all")
    }

    // Todo : 조회수 갱신 요청 함수
    plusViews(qno) {
        return http.put(`/question/plusviews/${qno}`);
    }

    // Todo : 조회수 확인용 함수
    getById(fno) {
        return http.get(`/question/findById/${fno}`)
    }

}

export default new QuestionDataService();