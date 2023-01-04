// ProfileDataService.jsprofile
// 목적 : Profile 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class ProfileDataService {
    // 모든 부서정보 조회 요청 함수
    getAll(searchSelect, searchKeyword, page, size) {
        // get 방식 통신 요청 -> @GetMapping("/api/profile")
        return http.get(`/profile?searchSelect=${searchSelect}&searchKeyword=${searchKeyword}&page=${page}&size=${size}`); 
    }

    // 부서번호로 조회 요청 함수
    // get 방식 통신 요청 -> @GetMapping("/api/profile/{fno}"), @PathVariable
    get(pno) {
        return http.get(`/profile/${pno}`)
    }

    // 부서정보 생성(insert) 요청 함수
    // post 방식 통신 요청 -> @PostMapping("/api/profile"), @RequestBody
    create(blobFile) {
        let formData = new FormData(); 


        console.log(blobFile);

        formData.append("blobFile", blobFile);
        
        return http.post("/profile/create", formData, {
            headers: {
              "Content-Type": "multipart/form-data"
            },
            // onUploadProgress
          });
    }

    // 부서정보 수정(update) 요청 함수
    // put 방식 통신 요청 -> @PutMapping("/api/profile/{fno}"), @RequestBody
    update(pno,blobFile) {
        let formData = new FormData();

        console.log(pno);
        console.log(blobFile);


        formData.append("blobFile", blobFile);

        return http.put(`/profile/update/${pno}`, formData, {
            headers: {
              "Content-Type": "multipart/form-data"
            },
          });
    }

    // 부서정보 삭제(delete) 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/profile/deletion/{fno}")
    //                        , @PathVariable  
    delete(pno) {
        return http.delete(`/profile/deletion/${pno}`);
    }

    // 부서정보 전체 삭제 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/profile/all")
    deleteAll() {
        return http.delete("/profile/all")
    }

//     createImage(blobFile, onUploadProgress) {
//     let formData = new FormData(); 
//     console.log(blobFile);
  
//     formData.append("blobFile", blobFile);

//     return http.post("/profile/create", formData, {
//       headers: {
//         "Content-Type": "multipart/form-data"
//       },
//       onUploadProgress
//     });
//   }
  
//   updateImage(fno, blobFile, onUploadProgress) {
//     let formData = new FormData();

//     console.log(fno);
    
//     console.log(blobFile);

//     formData.append("blobFile", blobFile);

//     return http.put(`/profile/update/${fno}`, formData, {
//       headers: {
//         "Content-Type": "multipart/form-data"
//       },
//       onUploadProgress
//     });
//   }

//   deleteImage(fno)  {
//     return http.delete(`/profile/deletions/${fno}`);
//   }

}

export default new ProfileDataService();