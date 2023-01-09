
import http from "../http-common";

class ScoreDataService {
  
  // 평점 가져오기용
  getScoreById( dno) {
    return http.get(`/score/dno/${dno}`);
  }
  
  get(rno) {
    return http.get(`/score/${rno}`);
  }

  create(sid, data) {
    console.log(data);
    return http.post(`/score/${sid}`, data);
  }

  update(sid, data) {
    return http.put(`/score/${sid}`, data);
  }

  delete(sid) {
    return http.delete(`/score/deletion/${sid}`);
  }
}

export default new ScoreDataService();
