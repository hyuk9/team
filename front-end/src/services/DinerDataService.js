import http from "@/http-common";
import authHeader from "@/services/auth/auth-header";

class DinerDataService {
  getAll(page, size) {
    return http.get(`/diner?&page=${page}&size=${size}`, {
      headers: authHeader(),
    });
  }
}

export default new DinerDataService();
