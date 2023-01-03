// FavoriteDataService.js
import http from "../http-common";

class FavoriteDataService {
  getAll(searchSelect, searchKeyword, page, size) {
    // get 방식 통신 요청 -> @GetMapping("/api/faq")
    return http.get(
      `/favorite?searchSelect=${searchSelect}&searchKeyword=${searchKeyword}&page=${page}&size=${size}`
    );
  }

  get(fid) {
    return http.get(`/favorite/${fid}`);
  }

  create(data) {
    console.log(data);
    return http.post("/favorite", data);
  }

  update(fid, data) {
    return http.put(`/favorite/${fid}`, data);
  }

  delete(dno) {
    return http.delete(`/favorite/deletion/${dno}`);
  }

  deleteAll() {
    return http.delete("/favorite/all");
  }
}

export default new FavoriteDataService();
