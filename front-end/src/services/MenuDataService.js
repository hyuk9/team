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
}

export default new MenuDataService();