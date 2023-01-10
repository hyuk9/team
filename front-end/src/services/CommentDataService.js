// CommentDataService.js
import http from "../http-common";
import authHeader from "@/services/auth/auth-header";

class CommentDataService {
  getAll(id, page, size) {
    return http.get(`/comment?id=${id}&page=${page}&size=${size}`, {
      headers: authHeader(),
    });
  }

  // TODO: 질문번호에 해당하는 댓글정보 조회요청하는 함수
  get(qno) {
    // get 방식 통신 요청 👉 @GetMapping("/api/menu/{dno}")
    return http.get(`/comment/${qno}`);
  }

  // TODO: 댓글번호에 해당하는 댓글정보 조회요청하는 함수
  getByCno(cno) {
    // get 방식 통신 요청 👉 @GetMapping("/api/menu/{dno}")
    return http.get(`/comment/cno/${cno}`);
  }

// TODO: 질문번호에 해당하는 댓글 리스트 조회요청하는 함수
  getCommentByQno(qno, page, size) {
    return http.get(`/comment/qno?qno=${qno}&page=${page}&size=${size}`, {
      headers: authHeader(),
    });
  }

// TODO: 자유게시판번호에 해당하는 댓글 리스트 조회요청하는 함수
  getCommentByFno(fno, page, size) {
    return http.get(`/comment/fno?fno=${fno}&page=${page}&size=${size}`, {
      headers: authHeader(),
    });
  }

// TODO: 공지사항번호에 해당하는 댓글 리스트 조회요청하는 함수
  getCommentByAid(aid, page, size) {
    return http.get(`/comment/aid?aid=${aid}&page=${page}&size=${size}`, {
      headers: authHeader(),
    });
  }

// TODO: 푸드컬럼번호에 해당하는 댓글 리스트 조회요청하는 함수
  getCommentByCid(cid, page, size) {
    return http.get(`/comment/cid?cid=${cid}&page=${page}&size=${size}`, {
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
