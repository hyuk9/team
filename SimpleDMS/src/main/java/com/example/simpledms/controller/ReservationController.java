package com.example.simpledms.controller;

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
 * fileName : Reservation07Controller
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
@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    ReservationService reservationService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

    @GetMapping("/reservation")
    public ResponseEntity<Object> getReservationAll(@RequestParam(required = false) String name,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "3") int size
    ) {
        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

//            Page 객체 정의
            Page<Reservation> reservationPage;

            reservationPage = reservationService.findAllByNameContaining(name, pageable);

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


    @DeleteMapping("/reservation/all")
    public ResponseEntity<Object> removeAll() {

        try {
            reservationService.removeAll();

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/reservation")
    public ResponseEntity<Object> createReservation(@RequestBody Reservation reservation) {

        try {
            Reservation reservation2 = reservationService.save(reservation);

            return new ResponseEntity<>(reservation2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/reservation/{rid}")
    public ResponseEntity<Object> getReservationId(@PathVariable int rid) {

        try {
            Optional<Reservation> optionalReservation = reservationService.findById(rid);

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

    @PutMapping("/reservation/{rid}")
    public ResponseEntity<Object> updateReservation(@PathVariable int rid,
                                            @RequestBody Reservation reservation) {

        try {
            Reservation reservation2 = reservationService.save(reservation);

            return new ResponseEntity<>(reservation2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping ("/reservation/deletion/{rid}")
    public ResponseEntity<Object> deleteReservation(@PathVariable int rid) {

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

}










