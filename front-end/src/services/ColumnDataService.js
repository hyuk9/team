// ColumnDataService.js
// 목적 : Column 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class ColumnDataService {
    // 모든 부서정보 조회 요청 함수
    getAll(searchSelect, searchKeyword, page, size) {
        // get 방식 통신 요청 -> @GetMapping("/api/Column")
        return http.get(`/column?searchSelect=${searchSelect}&searchKeyword=${searchKeyword}&page=${page}&size=${size}`); 
    }

    // 부서번호로 조회 요청 함수
    // get 방식 통신 요청 -> @GetMapping("/api/Column/{cid}"), @PathVariable
    get(cid) {
        return http.get(`/column/${cid}`)
    }

    // 부서정보 생성(insert) 요청 함수
    // post 방식 통신 요청 -> @PostMapping("/api/Column"), @RequestBody
    create(data) {
        console.log(data);
        return http.post("/column", data);
    }

    // 부서정보 수정(update) 요청 함수
    // put 방식 통신 요청 -> @PutMapping("/api/Column/{cid}"), @RequestBody
    update(cid, data) {
        return http.put(`/column/${cid}`, data);
    }

    // 부서정보 삭제(delete) 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/Column/deletion/{cid}")
    //                        , @PathVariable  
    delete(cid) {
        return http.delete(`/column/deletion/${cid}`);
    }

    // 부서정보 전체 삭제 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/Column/all")
    deleteAll() {
        return http.delete("/column/all")
    }

}

export default new ColumnDataService();