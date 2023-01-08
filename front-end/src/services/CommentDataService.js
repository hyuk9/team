// CommentDataService.js
import http from "../http-common";
import authHeader from "@/services/auth/auth-header";

class CommentDataService {
  getAll(id, page, size) {
    return http.get(`/comment?id=${id}&page=${page}&size=${size}`, {
      headers: authHeader(),
    });
  }

  // 음식점번호로 조회 요청 함수
  get(qno) {
    // get 방식 통신 요청 👉 @GetMapping("/api/menu/{dno}")
    return http.get(`/comment/${qno}`);
  }
  // 
  getCommentByQno(qno, page, size) {
    return http.get(`/comment/qno?qno=${qno}&page=${page}&size=${size}`, {
      headers: authHeader(),
    });
  }

  create(data) {
    console.log(data);
    return http.post("/comment", data);
  }

  update(cno, data) {
    return http.put(`/comment/${cno}`, data);
  }

  delete(cno) {
    return http.delete(`/comment/deletion/${cno}`);
  }

  deleteAll() {
    return http.delete("/comment/all");
  }

  // 찜갯수 가져오기용
  getCommentAll() {
    return http.get(`/comment/desc`);
  }

  // 찜갯수 가져오기용(음식점 디테일)
  getComment(dno) {
    return http.get(`/comment/dno/${dno}`);
  }
}

export default new CommentDataService();
