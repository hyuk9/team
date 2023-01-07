
import http from "../http-common";

class ScoreDataService {
  
  // 평점 가져오기용
  getScoreById( dno) {
    return http.get(`/score/dno/${dno}`);
  }
}

export default new ScoreDataService();
