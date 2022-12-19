package com.example.simpledms.controller;

import com.example.simpledms.model.Diner;
import com.example.simpledms.service.DinerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
@Slf4j
@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api")
public class DinerController {

    //    스프링부트 : DI(의존성 주입) ( @Autowired )
    @Autowired
    DinerService dinerService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

//    ✅ frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ----> backend @RequestParam
//    ✅ frontend url(파라매터방식) : /{} 매개변수 전송방식 사용했으면 ----> backend @PathVariable
//    ✅ @RequestParam(required = false) : false 매개변수에 값이 없어도 애러가 발생하지 않음
//                                         기본값은 required = true
//    ✅ @RequestParam(defaultValue = "값") : 매개변수에 값이 없으면 기본값을 설정함
    @GetMapping("/diner")
    public ResponseEntity<Object> getDinerAll(@RequestParam(required = false) String dname,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "3") int size
    ) {
        try {
    //            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

    //            Page 객체 정의
            Page<Diner> dinerPage;

//            findAll() 생략 해도 전체 검색이 됨 :
//            why? like 검색시 부서명 매개변수가 ""이더라도 전체 검색이 됨
            dinerPage = dinerService.findAllByDnameContaining(dname, pageable);

    //            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("diner", dinerPage.getContent());
            response.put("currentPage", dinerPage.getNumber());
            response.put("totalItems", dinerPage.getTotalElements());
            response.put("totalPages", dinerPage.getTotalPages());

            if (dinerPage.isEmpty() == false) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/diner/{dno}")
    public ResponseEntity<Object> getDinerId(@PathVariable int dno) {

        try {
            Optional<Diner> optionalDiner = dinerService.findById(dno);

            if (optionalDiner.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalDiner.get(), HttpStatus.OK);
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

    //  *1) 클라이언트 : (form태그) Get 방식(url) -> 2) 서버 : @GetMapping("url") -> 3) DB: select 요청,
    @DeleteMapping("/diner/all")
    public ResponseEntity<Object> removeAll() {

        try {
            dinerService.removeAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //  *1) 클라이언트 : (form태그) Get 방식(url) -> 2) 서버 : @GetMapping("url") -> 3) DB: select 요청,
    @PostMapping("/diner")
    public ResponseEntity<Object> createDiner(@RequestBody Diner diner) {

        try {
            Diner diner2 = dinerService.save(diner);

            return new ResponseEntity<>(diner2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/diner/{dno}")
    public ResponseEntity<Object> updateDiner(@PathVariable int dno, @RequestBody Diner diner) {

        try {
            Diner diner2 = dinerService.save(diner);

            return new ResponseEntity<>(diner2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/diner/deletion/{dno}")
    public ResponseEntity<Object> deleteId(@PathVariable int dno) {

        try {
             boolean bSuccess = dinerService.removeById(dno);

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

//    like 검색
//    @GetMapping("/diner/email/{email}")
//    public ResponseEntity<Object> findAllByDnameContaining(@PathVariable String email) {
//
//        try {
//            List<Diner> list = dinerService.findAllByDnameContaining(email);
//
//            if (list.isEmpty() == false) {
////                데이터 + 성공 메세지 전송
//                return new ResponseEntity<>(list, HttpStatus.OK);
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


}










