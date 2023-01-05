// ReservatioDataService.js
import http from "../http-common";
import authHeader from "@/services/auth/auth-header";

class ReservationDataService {
  getAll(rname, page, size) {
    return http.get(`/reservation?rname=${rname}&page=${page}&size=${size}`, {
      headers: authHeader(),
    });
  }

  // 유저id를 받아서 예약 조회하는 함수
  getId(id, page, size) {
    return http.get(`/reservation/id?id=${id}&page=${page}&size=${size}`, {
      headers: authHeader(),
    });
  }

  get(rid) {
    return http.get(`/reservation/${rid}`);
  }

  create(data) {
    console.log(data);
    return http.post("/reservation", data);
  }

  update(rid, data) {
    return http.put(`/reservation/${rid}`, data);
  }

  delete(rid) {
    return http.delete(`/reservation/deletion/${rid}`);
  }

  deleteAll() {
    return http.delete("/reservation/all");
  }
}

export default new ReservationDataService();
