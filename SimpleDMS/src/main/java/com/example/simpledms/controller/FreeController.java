package com.example.simpledms.controller;

import com.example.simpledms.dto.ResponseMessageDto;
import com.example.simpledms.dto.gallery.ResponseGalleryDto;
import com.example.simpledms.model.Announce;
import com.example.simpledms.model.Column;
import com.example.simpledms.model.Free;
import com.example.simpledms.service.FreeService;
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
public class FreeController {

    @Autowired
    FreeService freeService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

    ModelMapper modelMapper = new ModelMapper();

    //    frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
//    frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable
    @GetMapping("/free")
    public ResponseEntity<Object> getFreeAll(@RequestParam String searchSelect,
                                             @RequestParam(required = false) String searchKeyword,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "3") int size) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

            Page<Free> freePage;

//            Page 객체 정의
            if (searchSelect.equals("작성자")) {
                freePage = freeService.findAllByWriterContainingOrderByFnoDesc(searchKeyword, pageable);
            } else {
                freePage = freeService.findAllByTitleContainingOrderByFnoDesc(searchKeyword, pageable);
            }

            //            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("free", freePage.getContent());
            response.put("currentPage", freePage.getNumber());
            response.put("totalItems", freePage.getTotalElements());
            response.put("totalPages", freePage.getTotalPages());

            if (freePage.isEmpty() == false) {
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

//    @GetMapping("/free/{fno}")
//    public ResponseEntity<Object> getFreeFno(@PathVariable int fno) {
//
//        try {
//            Optional<Free> optionalFree = freeService.findById(fno);
//
//            if (optionalFree.isPresent() == true) {
////                데이터 + 성공 메세지 전송
//                return new ResponseEntity<>(optionalFree.get(), HttpStatus.OK);
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

    @DeleteMapping("/free/all")
    public ResponseEntity<Object> removeAll() {

        try {
            freeService.removeAll();

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/free/{fno}")
    public ResponseEntity<Object> updateFree(@PathVariable int fno,
                                             @RequestBody Free free) {

        try {
            Free free2 = freeService.save(free);

            return new ResponseEntity<>(free2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/free/deletion/{fno}")
    public ResponseEntity<Object> deleteFree(@PathVariable int fno) {

        try {
            boolean bSuccess = freeService.removeById(fno);

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


//    @PostMapping("/free")
//    public ResponseEntity<Object> createFree(@RequestBody Free free) {
//
//        try {
//            Free free2 = freeService.save(free);
//
//            return new ResponseEntity<>(free2, HttpStatus.OK);
//
//        } catch (Exception e) {
//            log.debug(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    //    생성 처리 : image update 포함
    @PostMapping("/free/create")
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
            freeService.createUploadImage(id,writer, title, content, blobFile);
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
    @PutMapping("/free/update/{fno}")
    public ResponseEntity<Object> updateUploadFile(
            @PathVariable int fno,
            @RequestParam("id") int id,
            @RequestParam("writer") String writer,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam(required = false) MultipartFile blobFile
    ) {
        String message = "";

        log.info("fno {} : ", fno);
        log.info("writer {} : ", writer);
        log.info("title {} : ", title);
        log.info("content {} : ", content);

        try {
            Optional<Free> free = freeService.findId(fno);
            Integer views = free.get().getViews();
            freeService.updateUploadFile(fno,id, writer, title, content, blobFile, views);


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
    @GetMapping("/free/file/{fno}")
    public ResponseEntity<byte[]> findFile(@PathVariable int fno) {
        Free free = freeService.findId(fno).get();

        return ResponseEntity.ok()
//           Todo : attachment: => attachment;
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + free.getGalleryFileName() + "\"")
                .body(free.getBlobFile());
    }

    //      Todo:
    @GetMapping("/free/getlist")
    public ResponseEntity<Object> getListFiles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        try {
            //            페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

//        다운로드 url 을 만들어 DTO 에 저장함
            Page<ResponseGalleryDto> freePage = freeService.findAllDesc(pageable).map(free -> {
                String fileDownloadUri = ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/api/free/file/")
                        .path(free.getFno().toString()) // "/api/free/1"
                        .toUriString();

//                modelMapper 이용한 model to Dto 변환 ( 사전 라이브러리 설치 필요 )
                ResponseGalleryDto freeDto = modelMapper.map(free, ResponseGalleryDto.class);

//                아래 2개 속성은 가공된 데이터 이므로 setter 를 이용해 저장
                if (free.getBlobFile() != null) {
                    freeDto.setFileSize(free.getBlobFile().length);
                }
                freeDto.setFileUrl(fileDownloadUri);

                return freeDto;
            });

            Map<String, Object> response = new HashMap<>();
            response.put("free", freePage.getContent());
            response.put("currentPage", freePage.getNumber());
            response.put("totalItems", freePage.getTotalElements());
            response.put("totalPages", freePage.getTotalPages());

            if (freePage.isEmpty() == false) {
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

//    @GetMapping("/free/{fno}")
//    public ResponseEntity<Object> getFreeId(@PathVariable int fno) {
//
//        try {
//            Optional<Free> optionalFree = freeService.findId(fno);
//
//
//            if (optionalFree.isPresent() == true) {
////                데이터 + 성공 메세지 전송
//                return new ResponseEntity<>(optionalFree.get(), HttpStatus.OK);
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
    @GetMapping("/free/{fno}")
    public ResponseEntity<Object> findId(@PathVariable int fno) {
        try {
            //            Vue에서 전송한 매개변수 데이터 확인
            log.info("fno {}", fno);

            Optional<Free> freeOptional = freeService.findId(fno);

            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/free/file/")
                    .path(freeOptional.get().getFno().toString())
                    .toUriString();

//                modelMapper 이용한 model to Dto 변환 ( 사전 라이브러리 설치 필요 )
            ResponseGalleryDto courseDto = modelMapper.map(freeOptional.get(), ResponseGalleryDto.class);

//                아래 2개 속성은 가공된 데이터 이므로 setter 를 이용해 저장
            int fileSize = (freeOptional.get().getBlobFile() != null) ? freeOptional.get().getBlobFile().length : 0;
            courseDto.setFileSize(fileSize);
            courseDto.setFileUrl(fileDownloadUri);


            if (freeOptional.isPresent()) {
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
//    @DeleteMapping("/free/deletion/{fno}")
//    public ResponseEntity<Object> deleteDept(@PathVariable int fno) {
//
////        프론트엔드 쪽으로 상태정보를 보내줌
//        try {
//            log.debug("fno : {}", fno);
//            boolean bSuccess = freeService.removeById(fno);
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
    @PutMapping("/free/plusviews/{fno}")
    public ResponseEntity<Object> updateFreeViews(@PathVariable int fno) {

        try {


//       이메일에 맞는 유저 정보 들고와서
            Optional<Free> optionalFree = freeService.findId(fno);

            Free freeData = optionalFree.get();
            Integer plusViews = freeData.getViews() +1;

            freeData.setViews(plusViews);

            freeService.save(freeData);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    조회수 위해서 추가
@GetMapping("/free/findById/{fno}")
public ResponseEntity<Object> getFreeId2(@PathVariable int fno) {

    try {
        Optional<Free> optionalFree = freeService.findId(fno);

        if (optionalFree.isPresent() == true) {
//                데이터 + 성공 메세지 전송
            return new ResponseEntity<>(optionalFree.get(), HttpStatus.OK);
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










