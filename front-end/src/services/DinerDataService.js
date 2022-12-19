import http from "../http-common";

class DinerDataService {
    // 모든 음식점 정보 조회 요청 함수
    getAll(searchSelect, searchKeyword, page, size) {
        // get 방식 통신 요청 -> @GetMapping("/api/")
        return http.get(`/`); 
    }
}

export default new DinerDataService();