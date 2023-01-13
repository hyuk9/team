package com.example.simpledms.controller;

import com.example.simpledms.model.Menu;
import com.example.simpledms.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
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
// @RestController : return 값이 json 데이터 형태로 출력됨
@Slf4j
// CORS 보안 : 기본적으로 한사이트에서 포트를 달리 사용 못함
// @CrossOrigin(허용할_사이트주소(vue 사이트주소 : 포트)) : CORS 보안을 허용해주는 어노테이션
@CrossOrigin(origins = "http://localhost")
//@CrossOrigin(origins = "http://192.168.0.166")
@RestController
@RequestMapping("/api")
public class MenuController {

    //    스프링부트 : DI(의존성 주입) ( @Autowired )
    @Autowired
    MenuService menuService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

//    ✅ frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ----> backend @RequestParam
//    ✅ frontend url(파라매터방식) : /{} 매개변수 전송방식 사용했으면 ----> backend @PathVariable

    @GetMapping("/menu")
    public ResponseEntity<Object> getMenuAll(@RequestParam(required = false) String menuName) {

        try {
//            1) menuName == null : 전체 검색
//            2) menuName != null : 부서명 like 검색
            List<Menu> list = Collections.emptyList(); // null 대신 초기화

//            1) menuName == null : 전체 검색
            if (menuName == null){
                list = menuService.findAll();
            } else {
//            2) menuName != null : 부서명 like 검색
                list = menuService.findAllByMenuNameContaining(menuName);
            }

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
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


    @GetMapping("/menu/{dno}")
    public ResponseEntity<Object> getMenuId(@PathVariable Integer dno) {

        try {
            List<Menu> list = menuService.findAllByDnoEquals(dno);

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
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
    @DeleteMapping("/menu/all")
    public ResponseEntity<Object> removeAll() {

        try {
            menuService.removeAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //  *1) 클라이언트 : (form태그) Get 방식(url) -> 2) 서버 : @GetMapping("url") -> 3) DB: select 요청,
    @PostMapping("/menu")
    public ResponseEntity<Object> createMenu(@RequestBody Menu menu) {

        try {
            Menu menu2 = menuService.save(menu);

            return new ResponseEntity<>(menu2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/menu/{dno}")
    public ResponseEntity<Object> updateMenu(@PathVariable int dno, @RequestBody Menu menu) {

        try {
            Menu menu2 = menuService.save(menu);

            return new ResponseEntity<>(menu2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/menu/deletion/{dno}")
    public ResponseEntity<Object> deleteId(@PathVariable int dno) {

        try {
             boolean bSuccess = menuService.removeById(dno);

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

////    like 검색
//    @GetMapping("/menu/menuName/{menuName}")
//    public ResponseEntity<Object> findAllByDnoEquals(@PathVariable Integer dno) {
//
//        try {
//            List<Menu> list = menuService.findAllByDnoEquals(dno);
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










