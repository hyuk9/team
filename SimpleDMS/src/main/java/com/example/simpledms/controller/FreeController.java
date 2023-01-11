package com.example.simpledms.controller;

import com.example.simpledms.model.Free;
import com.example.simpledms.service.FreeService;
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
@RestController
//@CrossOrigin(origins = "http://localhost")
@CrossOrigin(origins = "http://192.168.0.166")
@RequestMapping("/api")
public class FreeController {
    //    스프링부트 : DI(의존성 주입) ( @Autowired )
    @Autowired
    FreeService freeService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

//    ✅ frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ----> backend @RequestParam
//    ✅ frontend url(파라매터방식) : /{} 매개변수 전송방식 사용했으면 ----> backend @PathVariable
//    ✅ @RequestParam(required = false) : false 매개변수에 값이 없어도 애러가 발생하지 않음
//                                         기본값은 required = true
//    ✅ @RequestParam(defaultValue = "값") : 매개변수에 값이 없으면 기본값을 설정함
    @GetMapping("/free")
    public ResponseEntity<Object> getFreeAll(@RequestParam String searchSelect,
                                              @RequestParam(required = false) String searchKeyword,
                                              @RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "3") int size
    ) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

            Page<Free> freePage;

//            findAll() 생략해도 전체검색해야 됨:
//            why? like 검색시 고객명 매개변수가 ==이더라도 전채 검색 됨.
            if (searchSelect.equals("제목")) {
                freePage = freeService.findAllByTitleContainingOrderByFnoDesc(searchKeyword, pageable);
            } else {
                freePage = freeService.findAllByWriterContainingOrderByFnoDesc(searchKeyword, pageable);
            }
//            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("free", freePage.getContent());
            response.put("currentPage", freePage.getNumber());
            response.put("totalItems", freePage.getTotalElements());
            response.put("totalPages", freePage.getTotalPages());

            if (freePage.isEmpty() == false) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

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


    //  *1) 클라이언트 : (form태그) Get 방식(url) -> 2) 서버 : @GetMapping("url") -> 3) DB: select 요청,
    @DeleteMapping("/free/all")
    public ResponseEntity<Object> removeAll() {

        try {
            freeService.removeAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //  *1) 클라이언트 : (form태그) Get 방식(url) -> 2) 서버 : @GetMapping("url") -> 3) DB: select 요청,
    @PostMapping("/free")
    public ResponseEntity<Object> createFree(@RequestBody Free free) {

        try {
            Free free2 = freeService.save(free);

            return new ResponseEntity<>(free2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/free/{fno}")
    public ResponseEntity<Object> updateFree(@PathVariable int fno, @RequestBody Free free) {

        try {
            Free free2 = freeService.save(free);

            return new ResponseEntity<>(free2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/free/deletion/{fno}")
    public ResponseEntity<Object> deleteId(@PathVariable int fno) {

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

//    like 검색
//    @GetMapping("/free/email/{email}")
//    public ResponseEntity<Object> findAllByDnameContaining(@PathVariable String email) {
//
//        try {
//            List<Free> list = freeService.findAllByDnameContaining(email);
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


    //    조회수 추가 함수0104
    @PutMapping("/free/plusviews/{fno}")
    public ResponseEntity<Object> updateFreeViews(@PathVariable int fno) {

        try {


//       이메일에 맞는 유저 정보 들고와서
            Optional<Free> optionalFree = freeService.findById(fno);

            Free freeData = optionalFree.get();
            Integer plusViews = freeData.getViews() +1;

            freeData.setViews(plusViews);
            
            freeService.save(freeData);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}










