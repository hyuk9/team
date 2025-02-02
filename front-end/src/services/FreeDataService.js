// freeDataService.js
// 목적 : free 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class freeDataService {
    // 모든 부서정보 조회 요청 함수
    getAll(searchSelect, searchKeyword, page, size) {
        // get 방식 통신 요청 -> @GetMapping("/api/free")
        return http.get(`/free?searchSelect=${searchSelect}&searchKeyword=${searchKeyword}&page=${page}&size=${size}`); 
    }

    // 부서번호로 조회 요청 함수
    // get 방식 통신 요청 -> @GetMapping("/api/free/{fno}"), @PathVariable
    get(fno) {
        return http.get(`/free/${fno}`)
    }

    // 부서정보 생성(insert) 요청 함수
    // post 방식 통신 요청 -> @PostMapping("/api/free"), @RequestBody
    create(data) {
        console.log(data);
        return http.post("/free", data);
    }

    // 부서정보 수정(update) 요청 함수
    // put 방식 통신 요청 -> @PutMapping("/api/free/{fno}"), @RequestBody
    update(fno, data) {
        return http.put(`/free/${fno}`, data);
    }

    // 부서정보 삭제(delete) 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/free/deletion/{fno}")
    //                        , @PathVariable  
    delete(fno) {
        return http.delete(`/free/deletion/${fno}`);
    }

    // 부서정보 전체 삭제 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/free/all")
    deleteAll() {
        return http.delete("/free/all")
    }

    // 조회수 갱신 요청 함수
    plusViews(fno) {
        return http.put(`/free/plusviews/${fno}`);
    }
    

}

export default new freeDataService();