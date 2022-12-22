// ReservatioDataService.js
import http from "../http-common";

class ReservationDataService {
  getAll(rname, page, size) {
    return http.get(`/reservation?rname=${rname}&page=${page}&size=${size}`);
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
