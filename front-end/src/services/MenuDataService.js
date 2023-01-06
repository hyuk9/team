// MenuDataService.js
// 목적 : axios로 CRUD를 하는 공통 함수들 정의

import http from "../http-common";

class MenuDataService {

    // 모든 부서정보 조회 요청 함수
    getAll() {
        // get 방식 통신 요청 👉 @GetMapping("/api/dept")
        return http.get("/menu");
    }

    // 음식점번호로 조회 요청 함수
    get(dno) {
        // get 방식 통신 요청 👉 @GetMapping("/api/menu/{dno}")
        return http.get(`/menu/${dno}`);
    }
     // 부서정보 생성(insert) 요청 함수
    // post 방식 통신 요청 -> @PostMapping("/api/diner"), @RequestBody
    // create(data) {
    //     console.log(data);
    //     return http.post("/menu", data);
    // }
    createMenu(dno,data) {
        console.log(data);
        return http.post(`/menu/${dno}`, data);
    }

    // 부서정보 수정(update) 요청 함수
    // put 방식 통신 요청 -> @PutMapping("/api/diner/{dno}"), @RequestBody
    update(menuId, data) {
        return http.put(`/menu/${menuId}`, data);
    }

    // 부서정보 삭제(delete) 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/diner/deletion/{dno}")
    //                        , @PathVariable  
    delete(menuId) {
        return http.delete(`/menu/deletion/${menuId}`);
    }

    // 부서정보 전체 삭제 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/diner/all")
    deleteAll() {
        return http.delete("/menu/all")
    }

    // 부서명 검색 요청 함수
    // 쿼리스트링 방식 url : ?변수명=값&변수명2=값2....
    // get 방식 통신 요청 -> @GetMapping("/api/diner") , @RequestParam
    // findByDname(dname) {
    //     return http.get(`/diner?dname=${dname}`);
    // }
}

export default new MenuDataService();