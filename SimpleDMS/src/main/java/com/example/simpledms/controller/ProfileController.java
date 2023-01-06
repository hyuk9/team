package com.example.simpledms.controller;

import com.example.simpledms.dto.gallery.ResponseGalleryDto;
import com.example.simpledms.dto.gallery.ResponseProfileDto;
import com.example.simpledms.model.Profile;
import com.example.simpledms.service.ProfileService;
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
public class ProfileController {

    @Autowired
    ProfileService profileService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

    ModelMapper modelMapper = new ModelMapper();

    //    frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
//    frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable



    @DeleteMapping("/profile/deletion/{pno}")
    public ResponseEntity<Object> deleteProfile(@PathVariable int pno) {

        try {
            boolean bSuccess = profileService.removeById(pno);

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


    //    생성 처리 : image update 포함
    @PostMapping("/profile/create")
    public ResponseEntity<Object> createUploadFile(
            @RequestParam Integer id,
            @RequestParam(required = false) MultipartFile blobFile
    ) {
        String message = "";

        log.info("id : ", id);
        log.info("blobFile {} : ", blobFile);


        try {
            profileService.createUploadImage(id, blobFile);
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
    @PutMapping("/profile/update/{pno}")
    public ResponseEntity<Object> updateUploadFile(
            @PathVariable int pno,
            @RequestParam("blobFile") MultipartFile blobFile
    ) {
        String message = "";

        log.info("pno {} : ", pno);

        try {
            profileService.updateUploadFile(pno, blobFile);

            message = "Uploaded the file successfully: " + blobFile.getOriginalFilename();
            return new ResponseEntity<Object>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            message = "Could not upload the file: " + blobFile.getOriginalFilename() + "!";
            return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    file 자동 다운로드 메뉴 : 내부적으로 이미지 URL 접근 시 다운로드됨
//    다운로드 헤더 형식 : HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
    @GetMapping("/profile/file/{pno}")
    public ResponseEntity<byte[]> findFile(@PathVariable int pno) {
        Profile profile = profileService.findId(pno).get();

        return ResponseEntity.ok()
//           Todo : attachment: => attachment;
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + profile.getImageFileName() + "\"")
                .body(profile.getBlobFile());
    }

    //      Todo:
    @GetMapping("/profile/getlist")
    public ResponseEntity<Object> getListFiles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        try {
            //            페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

//        다운로드 url 을 만들어 DTO 에 저장함
            Page<ResponseProfileDto> profilePage = profileService.findAllDesc(pageable).map(profile -> {
                String fileDownloadUri = ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/api/profile/file/")
                        .path(profile.getPno().toString()) // "/api/profile/1"
                        .toUriString();

//                modelMapper 이용한 model to Dto 변환 ( 사전 라이브러리 설치 필요 )
                ResponseProfileDto profileDto = modelMapper.map(profile, ResponseProfileDto.class);

//                아래 2개 속성은 가공된 데이터 이므로 setter 를 이용해 저장
                if (profile.getBlobFile() != null) {
                    profileDto.setFileSize(profile.getBlobFile().length);
                }
                profileDto.setFileUrl(fileDownloadUri);

                return profileDto;
            });

            Map<String, Object> response = new HashMap<>();
            response.put("profile", profilePage.getContent());
            response.put("currentPage", profilePage.getNumber());
            response.put("totalItems", profilePage.getTotalElements());
            response.put("totalPages", profilePage.getTotalPages());

            if (profilePage.isEmpty() == false) {
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

//    @GetMapping("/profile/{pno}")
//    public ResponseEntity<Object> getProfileId(@PathVariable int pno) {
//
//        try {
//            Optional<Profile> optionalProfile = profileService.findId(pno);
//
//
//            if (optionalProfile.isPresent() == true) {
////                데이터 + 성공 메세지 전송
//                return new ResponseEntity<>(optionalProfile.get(), HttpStatus.OK);
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
    @GetMapping("/profile/{pno}")
    public ResponseEntity<Object> findId(@PathVariable int pno) {
        try {
            //            Vue에서 전송한 매개변수 데이터 확인
            log.info("pno {}", pno);

            Optional<Profile> profileOptional = profileService.findId(pno);

            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/profile/file/")
                    .path(profileOptional.get().getPno().toString())
                    .toUriString();

//                modelMapper 이용한 model to Dto 변환 ( 사전 라이브러리 설치 필요 )
            ResponseProfileDto courseDto = modelMapper.map(profileOptional.get(), ResponseProfileDto.class);

//                아래 2개 속성은 가공된 데이터 이므로 setter 를 이용해 저장
            int fileSize = (profileOptional.get().getBlobFile() != null) ? profileOptional.get().getBlobFile().length : 0;
            courseDto.setFileSize(fileSize);
            courseDto.setFileUrl(fileDownloadUri);


            if (profileOptional.isPresent()) {
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
//    @DeleteMapping("/profile/deletion/{pno}")
//    public ResponseEntity<Object> deleteDept(@PathVariable int pno) {
//
////        프론트엔드 쪽으로 상태정보를 보내줌
//        try {
//            log.debug("pno : {}", pno);
//            boolean bSuccess = profileService.removeById(pno);
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
}










