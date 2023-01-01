// GalleryDataService.js
import http from "../http-common";

class GalleryDataService {

    upload(title,free,fno) {

        let formData = new FormData(); // 폼(form) 객체 생성

        formData.append("galleryTitle", title);
        formData.append("free", free);

        return http.post(`/freeview/${fno}`, formData, {
            headers: {
                "Content-Type" : "multipart/form-data"
            }
        })
    }

    // 이미지 제목 검색 요청 함수
    getFiles(fno, galleryTitle, page, size) {
        console.log(fno);
        console.log(galleryTitle);
        console.log(page);
        console.log(size);
        return http.get(`/freeview/${fno}?galleryTitle=${galleryTitle}&page=${page}&size=${size}`)
    }

    // 이미지 삭제 요청 함수
    delete(fno) {
        return http.delete(`/freeview/${fno}/deletion`);
    }

}

export default new GalleryDataService();