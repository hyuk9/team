// AnnounceDataService.js
// 목적 : Announce 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class AnnounceDataService {
    // 모든 부서정보 조회 요청 함수
    getAll(searchSelect, searchKeyword, page, size) {
        // get 방식 통신 요청 -> @GetMapping("/api/announce")
        return http.get(`/announce?searchSelect=${searchSelect}&searchKeyword=${searchKeyword}&page=${page}&size=${size}`); 
    }

    // 부서번호로 조회 요청 함수
    // get 방식 통신 요청 -> @GetMapping("/api/announce/{aid}"), @PathVariable
    get(aid) {
        return http.get(`/announce/${aid}`)
    }

    // 부서정보 생성(insert) 요청 함수
    // post 방식 통신 요청 -> @PostMapping("/api/announce"), @RequestBody
    create(data) {
        console.log(data);
        return http.post("/announce", data);
    }

    // 부서정보 수정(update) 요청 함수
    // put 방식 통신 요청 -> @PutMapping("/api/announce/{aid}"), @RequestBody
    update(aid, data) {
        return http.put(`/announce/${aid}`, data);
    }

    // 부서정보 삭제(delete) 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/announce/deletion/{aid}")
    //                        , @PathVariable  
    delete(aid) {
        return http.delete(`/announce/deletion/${aid}`);
    }

    // 부서정보 전체 삭제 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/announce/all")
    deleteAll() {
        return http.delete("/announce/all")
    }

    // 조회수 갱신 요청 함수
    plusViews(aid) {
        return http.put(`/announce/plusviews/${aid}`);
    }

}

export default new AnnounceDataService();