// FreeDataService.js
// 목적 : Free 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class FreeDataService {
    // 모든 부서정보 조회 요청 함수
    getAll(searchSelect, searchKeyword, page, size) {
        // get 방식 통신 요청 -> @GetMapping("/api/free")
        return http.get(`/free?searchSelect=${searchSelect}&searchKeyword=${searchKeyword}&page=${page}&size=${size}`); 
    }

    // 부서번호로 조회 요청 함수
    // get 방식 통신 요청 -> @GetMapping("/api/free/{fno}"), @PathVariable
    get(fno) {
        return http.get(`/free/${fno}`)
    }

    // 부서정보 생성(insert) 요청 함수
    // post 방식 통신 요청 -> @PostMapping("/api/free"), @RequestBody
    create(writer,title,content,blobFile) {
        let formData = new FormData(); 

        console.log(writer);
        console.log(title);
        console.log(content);
        console.log(blobFile);

        formData.append("writer", writer);
        formData.append("title", title);
        formData.append("content", content);
        formData.append("blobFile", blobFile);
        
        return http.post("/free/create", formData, {
            headers: {
              "Content-Type": "multipart/form-data"
            },
            // onUploadProgress
          });
    }

    // 부서정보 수정(update) 요청 함수
    // put 방식 통신 요청 -> @PutMapping("/api/free/{fno}"), @RequestBody
    update(fno,writer,title,content,blobFile) {
        let formData = new FormData();

        console.log(fno);
        console.log(writer);
        console.log(title);
        console.log(content);
        console.log(blobFile);

        formData.append("writer", writer);
        formData.append("title", title);
        formData.append("content", content);
        formData.append("blobFile", blobFile);

        return http.put(`/free/update/${fno}`, formData, {
            headers: {
              "Content-Type": "multipart/form-data"
            },
          });
    }

    // 부서정보 삭제(delete) 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/free/deletion/{fno}")
    //                        , @PathVariable  
    delete(fno) {
        return http.delete(`/free/deletion/${fno}`);
    }

    // 부서정보 전체 삭제 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/free/all")
    deleteAll() {
        return http.delete("/free/all")
    }

//     createImage(blobFile, onUploadProgress) {
//     let formData = new FormData(); 
//     console.log(blobFile);
  
//     formData.append("blobFile", blobFile);

//     return http.post("/free/create", formData, {
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

//     return http.put(`/free/update/${fno}`, formData, {
//       headers: {
//         "Content-Type": "multipart/form-data"
//       },
//       onUploadProgress
//     });
//   }

//   deleteImage(fno)  {
//     return http.delete(`/free/deletions/${fno}`);
//   }
    // 조회수 갱신 요청 함수
    plusViews(fno) {
        return http.put(`/free/plusviews/${fno}`);
    }

    // 조회수 확인용 함수
    getById(fno) {
        return http.get(`/free/findById/${fno}`)
    }
}

export default new FreeDataService();