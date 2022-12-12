package com.example.simpledms.controller;

import com.example.simpledms.model.Faq;
import com.example.simpledms.service.FaqService;
import com.example.simpledms.service.FaqService;
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
 * fileName : Faq07Controller
 * author : ds
 * date : 2022-10-21
 * description : 부서 컨트롤러 @RestController, ResponseEntity, getFaqAll()
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
// @RestController : return 값이 json 데이터 형태로 출력됨
@Slf4j
// CORS 보안 : 기본적으로 한사이트에서 포트를 달리 사용 못함
// @CrossOrigin(허용할_사이트주소(vue 사이트주소 : 포트)) : CORS 보안을 허용해주는 어노테이션
//@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api")
public class FaqController {

    //    스프링부트 : DI(의존성 주입) ( @Autowired )
    @Autowired
    FaqService faqService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

//    ✅ frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ----> backend @RequestParam
//    ✅ frontend url(파라매터방식) : /{} 매개변수 전송방식 사용했으면 ----> backend @PathVariable

    @GetMapping("/faq")
    public ResponseEntity<Object> getFaqAll(@RequestParam(required = false) String title,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "3") int size
    ) {

        try {

            Pageable pageable = PageRequest.of(page, size);

            Page<Faq> faqPage;

            faqPage = faqService.findAllByTitleContaining(title, pageable);

            Map<String, Object> response = new HashMap<>();
            response.put("faq", faqPage.getContent());
            response.put("currentPage", faqPage.getNumber());
            response.put("totalItems", faqPage.getTotalElements());
            response.put("totalPages", faqPage.getTotalPages());


            if (faqPage.isEmpty() == false) {
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


    @GetMapping("/faq/{no}")
    public ResponseEntity<Object> getFaqId(@PathVariable int no) {

        try {
            Optional<Faq> optionalFaq = faqService.findById(no);

            if (optionalFaq.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalFaq.get(), HttpStatus.OK);
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
    @DeleteMapping("/faq/all")
    public ResponseEntity<Object> removeAll() {

        try {
            faqService.removeAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //  *1) 클라이언트 : (form태그) Get 방식(url) -> 2) 서버 : @GetMapping("url") -> 3) DB: select 요청,
    @PostMapping("/faq")
    public ResponseEntity<Object> createFaq(@RequestBody Faq faq) {

        try {
            Faq faq2 = faqService.save(faq);

            return new ResponseEntity<>(faq2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/faq/{no}")
    public ResponseEntity<Object> updateFaq(@PathVariable int no, @RequestBody Faq faq) {

        try {
            Faq faq2 = faqService.save(faq);

            return new ResponseEntity<>(faq2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/faq/deletion/{no}")
    public ResponseEntity<Object> deleteId(@PathVariable int no) {

        try {
             boolean bSuccess = faqService.removeById(no);

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
//    @GetMapping("/Faq/dname/{dname}")
//    public ResponseEntity<Object> findAllByDnameContaining(@PathVariable String dname) {
//
//        try {
//            List<Faq> list = FaqService.findAllByDnameContaining(dname);
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










