package com.example.simpledms.controller;

import com.example.simpledms.dto.LastviewDto;
import com.example.simpledms.dto.ReviewDto;
import com.example.simpledms.model.Favorite;
import com.example.simpledms.model.Lastview;
import com.example.simpledms.model.Menu;
import com.example.simpledms.service.LastviewService;
import com.example.simpledms.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * packageName : com.example.jpaexam.controller.exam07
 * fileName : Dept07Controller
 * author : ds
 * date : 2022-10-21
 * description : 부서 컨트롤러 @RestController, ResponseEntity, getDeptAll()
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
// @RestController : return 값이 json 데이터 형태로 출력됨
@Slf4j
// CORS 보안 : 기본적으로 한사이트에서 포트를 달리 사용 못함
// @CrossOrigin(허용할_사이트주소(vue 사이트주소 : 포트)) : CORS 보안을 허용해주는 어노테이션
@CrossOrigin(origins = "http://localhost")
//@CrossOrigin(origins = "http://192.168.0.166")
@RestController
@RequestMapping("/api")
public class LastviewController {

    //    스프링부트 : DI(의존성 주입) ( @Autowired )
    @Autowired
    LastviewService lastviewService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기


    //    Todo: 1.6 추가 currentUserId로 최근본 음식점 조회
    @GetMapping("/lastview/id")
    public ResponseEntity<Object> getLastviewById (@RequestParam Integer id,
                                                    @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "3") int size)

    {
        try {

//            페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

            Page<LastviewDto> lastviewPage;

            lastviewPage = lastviewService.findAllByIdOrderByInsertTimeDesc(id, pageable);

            Map<String, Object> response = new HashMap<>();
            response.put("lastview", lastviewPage.getContent());
            response.put("currentPage", lastviewPage.getNumber());
            response.put("totalItems", lastviewPage.getTotalElements());
            response.put("totalPages", lastviewPage.getTotalPages());

            if (lastviewPage.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/lastview/{id}/{dno}")
    public ResponseEntity<Object> getLastviewId(@PathVariable Integer id, @PathVariable Integer dno) {

        try {
            Optional<Lastview> optionalLastview = lastviewService.findByIdAndDno(id, dno);


            if (optionalLastview.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalLastview.get(), HttpStatus.OK);
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

//    Todo: 1.7 추가 최근 본 음식점 데이터 저장하는 함수
    @PostMapping("/lastview")
    public ResponseEntity<Object> createLastview(@RequestBody Lastview lastview) {

        try {
            Lastview lastview2 = lastviewService.save(lastview);
            log.debug("=====================성공=======================");

            return new ResponseEntity<>(lastview2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            log.debug("=====================에러=======================");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/lastview/deletion/{lid}")
    public ResponseEntity<Object> deleteLastview(@PathVariable int lid) {

        try {
            boolean bSuccess = lastviewService.removeById(lid);

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

}










