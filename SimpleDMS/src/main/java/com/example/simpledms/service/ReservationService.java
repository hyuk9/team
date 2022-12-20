package com.example.simpledms.service;

import com.example.simpledms.model.Reservation;
import com.example.simpledms.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : ReservationService
 * author : ds
 * date : 2022-10-20
 * description : 부서 업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository; // JPA CRUD 함수가 있는 인터페이스

    //    전체 조회 함수 findAll() ->(변경) findAll(Pageable pageable)
    public Page<Reservation> findAll(Pageable pageable) {
        Page<Reservation> page = reservationRepository.findAll(pageable);

        return page;
    }

    //    전체 삭제 함수
    public void removeAll() {
        reservationRepository.deleteAll(); // 전체 삭제
    }

    //   부서 정보 저장/수정 함수
    public Reservation save(Reservation reservation) {

        Reservation reservation2 = reservationRepository.save(reservation);

        return reservation2;
    }

    //    부서번호로 조회하는 함수
    public Optional<Reservation> findById(int rid) {
//        findById(기본키속성)
        Optional<Reservation> optionalReservation = reservationRepository.findById(rid);

        return optionalReservation;
    }

    // 부서번호(rid)로 삭제하는 함수
    public boolean removeById(int rid) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(reservationRepository.existsById(rid) == true) {
            reservationRepository.deleteById(rid);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

    //    name like 검색 함수( 페이징 처리 추가 )
    public Page<Reservation> findAllByNameContaining(String name, Pageable pageable) {
        Page<Reservation> page = reservationRepository.findAllByNameContaining(name, pageable);

        return page;
    }
}









