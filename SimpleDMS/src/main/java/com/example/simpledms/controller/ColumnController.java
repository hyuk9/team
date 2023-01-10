package com.example.simpledms.controller;

import com.example.simpledms.dto.gallery.ResponseGalleryDto;
import com.example.simpledms.model.Column;
import com.example.simpledms.service.ColumnService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.controller.exam07
 * fileName : Announce07Controller
 * author : ds
 * date : 2022-10-21
 * description : 부서 컨트롤러 쿼리 메소드
 * 요약 :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
@Slf4j
// CORS 보안 : 기본적으로 한사이트에서 포트를 달리 사용못함
// @CrossOrigin(허용할_사이트주소(Vue 사이트주소:포트)) : CORS 보안을 허용해주는 어노테이션
@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api")
public class ColumnController {

    @Autowired
    ColumnService columnService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

    ModelMapper modelMapper = new ModelMapper();

    //    frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
//    frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable
    @GetMapping("/column")
    public ResponseEntity<Object> getColumnAll(@RequestParam String searchSelect,
                                             @RequestParam(required = false) String searchKeyword,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "3") int size) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

            Page<Column> columnPage;

//            Page 객체 정의
            if (searchSelect.equals("작성자")) {
                columnPage = columnService.findAllByWriterContainingOrderByCidDesc(searchKeyword, pageable);
            } else {
                columnPage = columnService.findAllByTitleContainingOrderByCidDesc(searchKeyword, pageable);
            }

            //            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("column", columnPage.getContent());
            response.put("currentPage", columnPage.getNumber());
            response.put("totalItems", columnPage.getTotalElements());
            response.put("totalPages", columnPage.getTotalPages());

            if (columnPage.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/column/{cid}")
//    public ResponseEntity<Object> getColumnCid(@PathVariable int cid) {
//
//        try {
//            Optional<Column> optionalColumn = columnService.findById(cid);
//
//            if (optionalColumn.isPresent() == true) {
////                데이터 + 성공 메세지 전송
//                return new ResponseEntity<>(optionalColumn.get(), HttpStatus.OK);
//            } else {
////                데이터 없음 메세지 전송(클라이언트)
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//        } catch (Exception e) {
//            log.debug(e.getMessage());
//            // 서버에러 발생 메세지 전송(클라이언트)
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @DeleteMapping("/column/all")
    public ResponseEntity<Object> removeAll() {

        try {
            columnService.removeAll();

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/column/{cid}")
    public ResponseEntity<Object> updateColumn(@PathVariable int cid,
                                             @RequestBody Column column) {

        try {
            Column column2 = columnService.save(column);

            return new ResponseEntity<>(column2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/column/deletion/{cid}")
    public ResponseEntity<Object> deleteColumn(@PathVariable int cid) {

        try {
            boolean bSuccess = columnService.removeById(cid);

            if (bSuccess == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @PostMapping("/column")
//    public ResponseEntity<Object> createColumn(@RequestBody Column column) {
//
//        try {
//            Column column2 = columnService.save(column);
//
//            return new ResponseEntity<>(column2, HttpStatus.OK);
//
//        } catch (Exception e) {
//            log.debug(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    //    생성 처리 : image update 포함
    @PostMapping("/column/create")
    public ResponseEntity<Object> createUploadFile(
            @RequestParam("id") int id,
            @RequestParam("writer") String writer,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam(required = false) MultipartFile blobFile
    ) {
        String message = "";

        log.info("writer {} : ", writer);
        log.info("title {} : ", title);
        log.info("content {} : ", content);
        log.info("blobFile {} : ", blobFile);

        try {
            columnService.createUploadImage(id,writer, title, content, blobFile);
            if (blobFile != null) {
                message = "Uploaded the file successfully: " + blobFile.getOriginalFilename();
            }
            return new ResponseEntity<Object>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            message = "Could not upload the file: " + blobFile.getOriginalFilename() + "!";
            log.debug(e.getMessage());
            return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    //    수정 처리 : image update 포함
    @PutMapping("/column/update/{cid}")
    public ResponseEntity<Object> updateUploadFile(
            @PathVariable int cid,
            @RequestParam("id") int id,
            @RequestParam("writer") String writer,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam(required = false) MultipartFile blobFile
    ) {
        String message = "";

        log.info("cid {} : ", cid);
        log.info("writer {} : ", writer);
        log.info("title {} : ", title);
        log.info("content {} : ", content);

        try {
            Optional<Column> column = columnService.findId(cid);
            Integer views = column.get().getViews();
            columnService.updateUploadFile(cid,id, writer, title, content, blobFile, views);


            if (blobFile != null) {
                message = "Uploaded the file successfully: " + blobFile.getOriginalFilename();
            }
            return new ResponseEntity<Object>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            message = "Could not upload the file: " + blobFile.getOriginalFilename() + "!";
            return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    file 자동 다운로드 메뉴 : 내부적으로 이미지 URL 접근 시 다운로드됨
//    다운로드 헤더 형식 : HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
    @GetMapping("/column/file/{cid}")
    public ResponseEntity<byte[]> findFile(@PathVariable int cid) {
        Column column = columnService.findId(cid).get();

        return ResponseEntity.ok()
//           Todo : attachment: => attachment;
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + column.getGalleryFileName() + "\"")
                .body(column.getBlobFile());
    }

    //      Todo:
    @GetMapping("/column/getlist")
    public ResponseEntity<Object> getListFiles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        try {
            //            페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

//        다운로드 url 을 만들어 DTO 에 저장함
            Page<ResponseGalleryDto> columnPage = columnService.findAllDesc(pageable).map(column -> {
                String fileDownloadUri = ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/api/column/file/")
                        .path(column.getCid().toString()) // "/api/column/1"
                        .toUriString();

//                modelMapper 이용한 model to Dto 변환 ( 사전 라이브러리 설치 필요 )
                ResponseGalleryDto columnDto = modelMapper.map(column, ResponseGalleryDto.class);

//                아래 2개 속성은 가공된 데이터 이므로 setter 를 이용해 저장
                if (column.getBlobFile() != null) {
                    columnDto.setFileSize(column.getBlobFile().length);
                    columnDto.setFileUrl(fileDownloadUri);
                }
//                columnDto.setFileUrl(fileDownloadUri);
                return columnDto;
            });

            Map<String, Object> response = new HashMap<>();
            response.put("column", columnPage.getContent());
            response.put("currentPage", columnPage.getNumber());
            response.put("totalItems", columnPage.getTotalElements());
            response.put("totalPages", columnPage.getTotalPages());

            if (columnPage.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/column/{cid}")
//    public ResponseEntity<Object> getColumnId(@PathVariable int cid) {
//
//        try {
//            Optional<Column> optionalColumn = columnService.findId(cid);
//
//
//            if (optionalColumn.isPresent() == true) {
////                데이터 + 성공 메세지 전송
//                return new ResponseEntity<>(optionalColumn.get(), HttpStatus.OK);
//            } else {
////                데이터 없음 메세지 전송(클라이언트)
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//        } catch (Exception e) {
//            log.debug(e.getMessage());
//            // 서버에러 발생 메세지 전송(클라이언트)
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    //    과목 id로 조회
    @GetMapping("/column/{cid}")
    public ResponseEntity<Object> findId(@PathVariable int cid) {
        try {
            //            Vue에서 전송한 매개변수 데이터 확인
            log.info("cid {}", cid);

            Optional<Column> columnOptional = columnService.findId(cid);

            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/column/file/")
                    .path(columnOptional.get().getCid().toString())
                    .toUriString();

//                modelMapper 이용한 model to Dto 변환 ( 사전 라이브러리 설치 필요 )
            ResponseGalleryDto courseDto = modelMapper.map(columnOptional.get(), ResponseGalleryDto.class);

//                아래 2개 속성은 가공된 데이터 이므로 setter 를 이용해 저장
            int fileSize = (columnOptional.get().getBlobFile() != null) ? columnOptional.get().getBlobFile().length : 0;
            if (columnOptional.get().getBlobFile() != null) {
                courseDto.setFileSize(columnOptional.get().getBlobFile().length);
                courseDto.setFileUrl(fileDownloadUri);
            }


            if (columnOptional.isPresent()) {
                return new ResponseEntity<Object>(courseDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    삭제 처리
//    @DeleteMapping("/column/deletion/{cid}")
//    public ResponseEntity<Object> deleteDept(@PathVariable int cid) {
//
////        프론트엔드 쪽으로 상태정보를 보내줌
//        try {
//            log.debug("cid : {}", cid);
//            boolean bSuccess = columnService.removeById(cid);
//
//            if (bSuccess == true) {
////                delete 문이 성공했을 경우
//                return new ResponseEntity<>(HttpStatus.OK);
//            }
////            delete 실패했을 경우( 0건 삭제가 될경우 )
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
////            DB 에러가 날경우
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    //    조회수 추가 함수0104
    @PutMapping("/column/plusviews/{cid}")
    public ResponseEntity<Object> updateColumnViews(@PathVariable int cid) {

        try {


//       이메일에 맞는 유저 정보 들고와서
            Optional<Column> optionalColumn = columnService.findId(cid);

            Column columnData = optionalColumn.get();
            Integer plusViews = columnData.getViews() +1;

            columnData.setViews(plusViews);

            columnService.save(columnData);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    조회수 위해서 추가
@GetMapping("/column/findById/{cid}")
public ResponseEntity<Object> getColumnId2(@PathVariable int cid) {

    try {
        Optional<Column> optionalColumn = columnService.findId(cid);

        if (optionalColumn.isPresent() == true) {
//                데이터 + 성공 메세지 전송
            return new ResponseEntity<>(optionalColumn.get(), HttpStatus.OK);
        } else {
//                데이터 없음 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    } catch (Exception e) {
        log.debug(e.getMessage());
        // 서버에러 발생 메세지 전송(클라이언트)
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
}










