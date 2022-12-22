// DeptDataService.js
// 목적 : Dept 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class DinerDataService {
    // 모든 부서정보 조회 요청 함수
    // dname : 부서명
    // page : 현재 페이지 번호
    // size : 페이지당 화면에 보여질 개수
    getAll(dname, page, size) {
        // get 방식 통신 요청 -> @GetMapping("/api/diner")
        // 1) 전체 조회 +
        // 2) 부서명 조회 같이하는 함수
        return http.get(`/diner?dname=${dname}&page=${page}&size=${size}`); 
    }

    // 부서번호로 조회 요청 함수
    // get 방식 통신 요청 -> @GetMapping("/api/diner/{dno}"), @PathVariable
    get(dno) {
        return http.get(`/diner/${dno}`)
    }

    // 부서정보 생성(insert) 요청 함수
    // post 방식 통신 요청 -> @PostMapping("/api/diner"), @RequestBody
    create(data) {
        console.log(data);
        return http.post("/diner", data);
    }

    // 부서정보 수정(update) 요청 함수
    // put 방식 통신 요청 -> @PutMapping("/api/diner/{dno}"), @RequestBody
    update(dno, data) {
        return http.put(`/diner/${dno}`, data);
    }

    // 부서정보 삭제(delete) 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/diner/deletion/{dno}")
    //                        , @PathVariable  
    delete(dno) {
        return http.delete(`/diner/deletion/${dno}`);
    }

    // 부서정보 전체 삭제 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/diner/all")
    deleteAll() {
        return http.delete("/diner/all")
    }

    // 부서명 검색 요청 함수
    // 쿼리스트링 방식 url : ?변수명=값&변수명2=값2....
    // get 방식 통신 요청 -> @GetMapping("/api/diner") , @RequestParam
    // findByDname(dname) {
    //     return http.get(`/diner?dname=${dname}`);
    // }

}

export default new DinerDataService();