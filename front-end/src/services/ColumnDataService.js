// ColumnDataService.js
// 목적 : Column 정보를 axios 로 CRUD 를 하는 공통 함수들 정의
import http from "../http-common";

class ColumnDataService {
    // Todo : 모든 자유게시판 정보 조회 요청 함수
    getAll(searchSelect, searchKeyword, page, size) {
        // get 방식 통신 요청 -> @GetMapping("/api/column")
        return http.get(`/column?searchSelect=${searchSelect}&searchKeyword=${searchKeyword}&page=${page}&size=${size}`); 
    }

    // Todo : 자유게시판번호로 조회 요청 함수
    // get 방식 통신 요청 -> @GetMapping("/api/column/{cid}"), @PathVariable
    get(cid) {
        return http.get(`/column/findId/${cid}`)
    }

    getImage(cid) {
        return http.get(`/column/${cid}`)
    }

    // Todo : 자유게시판정보 생성(insert) 요청 함수
    // post 방식 통신 요청 -> @PostMapping("/api/column"), @RequestBody
    create(id,writer,title,content,blobFile) {
        let formData = new FormData(); 

        console.log(id);
        console.log(writer);
        console.log(title);
        console.log(content);
        console.log(blobFile);

        formData.append("id", id);
        formData.append("writer", writer);
        formData.append("title", title);
        formData.append("content", content);
        formData.append("blobFile", blobFile);
        
        return http.post("/column/create", formData, {
            headers: {
              "Content-Type": "multipart/form-data"
            },
            // onUploadProgress
          });
    }

    // Todo : 자유게시판정보 수정(update) 요청 함수
    // put 방식 통신 요청 -> @PutMapping("/api/column/{cid}"), @RequestBody
    update(cid,id,writer,title,content,blobFile) {
        let formData = new FormData();

        console.log(cid);
        console.log(id);
        console.log(writer);
        console.log(title);
        console.log(content);
        console.log(blobFile);
    

        formData.append("id", id);
        formData.append("writer", writer);
        formData.append("title", title);
        formData.append("content", content);
        formData.append("blobFile", blobFile);


        return http.put(`/column/update/${cid}`, formData, {
            headers: {
              "Content-Type": "multipart/form-data"
            },
          });
    }

    // Todo : 자유게시판정보 삭제(delete) 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/column/deletion/{cid}")
    //                        , @PathVariable  
    delete(cid) {
        return http.delete(`/column/deletion/${cid}`);
    }

    // Todo : 자유게시판정보 전체 삭제 요청 함수
    // delete 방식 통신 요청 -> @DeleteMapping("/api/column/all")
    deleteAll() {
        return http.delete("/column/all")
    }

//     createImage(blobFile, onUploadProgress) {
//     let formData = new FormData(); 
//     console.log(blobFile);
  
//     formData.append("blobFile", blobFile);

//     return http.post("/column/create", formData, {
//       headers: {
//         "Content-Type": "multipart/form-data"
//       },
//       onUploadProgress
//     });
//   }
  
//   updateImage(cid, blobFile, onUploadProgress) {
//     let formData = new FormData();

//     console.log(cid);
    
//     console.log(blobFile);

//     formData.append("blobFile", blobFile);

//     return http.put(`/column/update/${cid}`, formData, {
//       headers: {
//         "Content-Type": "multipart/form-data"
//       },
//       onUploadProgress
//     });
//   }

//   deleteImage(cid)  {
//     return http.delete(`/column/deletions/${cid}`);
//   }
    // 조회수 갱신 요청 함수
    plusViews(cid) {
        return http.put(`/column/plusviews/${cid}`);
    }

    // 조회수 확인용 함수
    getById(cid) {
        return http.get(`/column/findById/${cid}`)
    }
}

export default new ColumnDataService();