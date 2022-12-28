package com.example.simpledms.controller;

import com.example.simpledms.dto.ResponseMessageDto;
import com.example.simpledms.dto.gallery.ResponseGalleryDto;
import com.example.simpledms.model.Announce;
import com.example.simpledms.model.Free;
import com.example.simpledms.service.AnnounceService;
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
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class FreeController {

    @Autowired
    FreeService freeService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

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
                freePage = freeService.findAllByWriterContainingOrderByInsertTimeDescFnoDesc(searchKeyword, pageable);
            } else {
                freePage = freeService.findAllByTitleContainingOrderByInsertTimeDescFnoDesc(searchKeyword, pageable);
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

    @PostMapping("/free")
    public ResponseEntity<Object> createFree(@RequestBody Free free) {

        try {
            Free free2 = freeService.save(free);

            return new ResponseEntity<>(free2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/free/{fno}")
    public ResponseEntity<Object> getFreeId(@PathVariable int fno) {

        try {
            Optional<Free> optionalFree = freeService.findById(fno);


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


    //  Model to Dto 자동변환, Dto to Model 자동변환 외부 라이브러리
    ModelMapper modelMapper = new ModelMapper();

    //    이미지 업로드 컨트롤러 함수
    @PostMapping("/freeview")
    public ResponseEntity<Object> galleryUploadFile(@RequestParam("galleryTitle") String galleryTitle,
                                                    @RequestParam("free") MultipartFile free


    ) {

        String message = ""; // front-end 전송할 메세지

//            디버깅 출력
        log.debug("galleryTitle :" + galleryTitle);
        log.debug("free :" + free);

        try {
//            db 저장 함수 호출
            freeService.store(galleryTitle, free);

            message = "Upload the file successfully: " + free.getOriginalFilename();

            return new ResponseEntity<>(new ResponseMessageDto(message), HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            message = "Could not upload the file : " + free.getOriginalFilename();
            return new ResponseEntity<>(new ResponseMessageDto(message),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    모든 이미지 정보 가져오기 함수
    @GetMapping("/freeview")
    public ResponseEntity<Object> getListFiles(
                                               @RequestParam(required = false) String galleryTitle,
                                               @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "3") int size


    ) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

//          Upload 이미지 정보를 가져오는 함수
            Page<ResponseGalleryDto> filePage = freeService
                    .findAllByGalleryTitleContaining(galleryTitle, pageable)
                    .map(dbFile -> {
//                      자동적으로 반복문이 실행됨 : .map()
//                      1) 다운로드 URL 만들기
//          ServletUriComponentsBuilder : URL 만들어 주는 클래스
                        String fileDownloadUri = ServletUriComponentsBuilder
//                                (변경)
//                               .fromCurrentRequest() -> .fromCurrentContextPath()
                                .fromCurrentContextPath() // 이미지 파일 경로
                                .path("/api/freeview/")
                                .path(dbFile.getFno().toString()) // "/api/gallery/1"
                                .toUriString(); // 마지막에 호출( URL 완성됨 )

//                      modelMapper 로 dbFile == fileDB -> ResponseGalleryDto 변환
//                        modelMapper.map(소스모델, 타겟DTO.class)
                        ResponseGalleryDto fileDto = modelMapper.map(dbFile, ResponseGalleryDto.class);

//                      DTO 에 2개 남은 속성 처리 : setter 이용 가공된 데이터 저장
                        fileDto.setGallerySize(dbFile.getGalleryData().length);
                        fileDto.setGalleryUrl(fileDownloadUri);

                        return fileDto;
                    });

//            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("free", filePage.getContent());
            response.put("currentPage", filePage.getNumber());
            response.put("totalItems", filePage.getTotalElements());
            response.put("totalPages", filePage.getTotalPages());

            if (filePage.isEmpty() == false) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    파일 다운로드 함수 : url /api/gallery/1
    @GetMapping("/freeview/{fno}")
    public ResponseEntity<byte[]> getFile(@PathVariable int fno) {

//        id 로 조회 함수
        Free free = freeService.getFile(fno).get();

//        첨부파일 다운로드 : url Content-Type 규칙
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + free.getGalleryFileName() + "\"")
                .body(free.getGalleryData());
    }

    //    id 삭제 함수
    @DeleteMapping("/freeview/{fno}/deletion/")
    public ResponseEntity<Object> deleteGallery(@PathVariable int fno) {

        try {
            boolean bSuccess = freeService.removeById(fno);

            if (bSuccess == true) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}










