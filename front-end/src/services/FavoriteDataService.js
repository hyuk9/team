// FavoriteDataService.js
import http from "../http-common";
import authHeader from "@/services/auth/auth-header";

class FavoriteDataService {
  getAll(id, page, size) {
    return http.get(`/favorite?id=${id}&page=${page}&size=${size}`, {
      headers: authHeader(),
    });
  }

  getId(id, page, size) {
    return http.get(`/favorite?id=${id}&page=${page}&size=${size}`, {
      headers: authHeader(),
    });
  }

  get(id, dno) {
    return http.get(`/favorite/${id}/${dno}`);
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

  // 찜하기 추가
  getFavorite(page, size) {
    return http.get(`/favorite/desc?page=${page}&size=${size}`);
  }
}

export default new FavoriteDataService();
