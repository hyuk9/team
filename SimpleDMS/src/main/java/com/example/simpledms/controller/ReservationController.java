package com.example.simpledms.controller;

import com.example.simpledms.dto.FavoriteDto;
import com.example.simpledms.dto.ReservationDto;
import com.example.simpledms.model.Reservation;
import com.example.simpledms.service.ReservationService;
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
// @RestController : return 값이 json 데이터 형태로 출력됨
@Slf4j
// CORS 보안 : 기본적으로 한사이트에서 포트를 달리 사용 못함
// @CrossOrigin(허용할_사이트주소(vue 사이트주소 : 포트)) : CORS 보안을 허용해주는 어노테이션
@CrossOrigin(origins = "http://localhost")
//@CrossOrigin(origins = "http://192.168.0.166")
@RestController
@RequestMapping("/api")
public class ReservationController {

    //    스프링부트 : DI(의존성 주입) ( @Autowired )
    @Autowired
    ReservationService reservationService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

//    ✅ frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ----> backend @RequestParam
//    ✅ frontend url(파라매터방식) : /{} 매개변수 전송방식 사용했으면 ----> backend @PathVariable
//    ✅ @RequestParam(required = false) : false 매개변수에 값이 없어도 애러가 발생하지 않음
//                                         기본값은 required = true
//    ✅ @RequestParam(defaultValue = "값") : 매개변수에 값이 없으면 기본값을 설정함
    @GetMapping("/reservation")
    public ResponseEntity<Object> getReservationAll(@RequestParam(required = false) String rname,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "3") int size
    ) {
        try {
    //            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

    //            Page 객체 정의
            Page<ReservationDto> reservationPage;

//            findAll() 생략 해도 전체 검색이 됨 :
//            why? like 검색시 부서명 매개변수가 ""이더라도 전체 검색이 됨
            reservationPage = reservationService.findAllByRname(rname, pageable);

    //            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("reservation", reservationPage.getContent());
            response.put("currentPage", reservationPage.getNumber());
            response.put("totalItems", reservationPage.getTotalElements());
            response.put("totalPages", reservationPage.getTotalPages());

            if (reservationPage.isEmpty() == false) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/reservation/{rid}")
    public ResponseEntity<Object> getReservationId(@PathVariable int rid) {

        try {
            Optional<ReservationDto> optionalReservation = reservationService.findByRid(rid);

            if (optionalReservation.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalReservation.get(), HttpStatus.OK);
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
    @DeleteMapping("/reservation/all")
    public ResponseEntity<Object> removeAll() {

        try {
            reservationService.removeAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //  *1) 클라이언트 : (form태그) Get 방식(url) -> 2) 서버 : @GetMapping("url") -> 3) DB: select 요청,
    @PostMapping("/reservation")
    public ResponseEntity<Object> createReservation(@RequestBody Reservation reservation) {

        try {
            Reservation reservation2 = reservationService.save(reservation);

            return new ResponseEntity<>(reservation2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/reservation/{rid}")
    public ResponseEntity<Object> updateReservation(@PathVariable int rid, @RequestBody Reservation reservation) {

        try {
            Reservation reservation2 = reservationService.save(reservation);

            return new ResponseEntity<>(reservation2, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/reservation/deletion/{rid}")
    public ResponseEntity<Object> deleteId(@PathVariable int rid) {

        try {
             boolean bSuccess = reservationService.removeById(rid);

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
//    @GetMapping("/reservation/email/{email}")
//    public ResponseEntity<Object> findAllByDnameContaining(@PathVariable String email) {
//
//        try {
//            List<Reservation> list = reservationService.findAllByDnameContaining(email);
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

    //    Todo: 1.5 추가 currentUserId로 예약목록 찾기함수

    @GetMapping("/reservation/id")
    public ResponseEntity<Object> getUserId(@RequestParam Integer id,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "3") int size)
    {
        try {

//            페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

            Page<ReservationDto> reservationPage;

            reservationPage = reservationService.findAllById(id, pageable);

            Map<String, Object> response = new HashMap<>();
            response.put("reservation", reservationPage.getContent());
            response.put("currentPage", reservationPage.getNumber());
            response.put("totalItems", reservationPage.getTotalElements());
            response.put("totalPages", reservationPage.getTotalPages());

            if (reservationPage.isEmpty() == false) {
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
}










