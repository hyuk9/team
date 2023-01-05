package com.example.simpledms.service;

import com.example.simpledms.dto.FavoriteDto;
import com.example.simpledms.dto.ReservationDto;
import com.example.simpledms.model.Reservation;
import com.example.simpledms.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : DeptService
 * author : ds
 * date : 2022-10-20
 * description : 부서 업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
@Slf4j
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository; // JPA CRUD 함수가 있는 인터페이스

    //    ✅ 전체 조회 함수 findAll() 👉 변경 findAll(Pageable pageable)
    public Page<Reservation> findAll(Pageable pageable) {
        Page<Reservation> page = reservationRepository.findAll(pageable);

        return page;
    }

//    ✅ id로 조회하는 함수

    public Optional<Reservation> findById(int rid) {
//        findById(기본키)
        Optional<Reservation> optionalReserve = reservationRepository.findById(rid);

        return optionalReserve;
    }


    //    ✅ 전체 삭제 함수
    public void removeAll() {
        reservationRepository.deleteAll();
    }


    //       ✅ 부서 정보 저장 함수
    public Reservation save(Reservation reservation) {
        Reservation reservation2 = reservationRepository.save(reservation);
        return reservation2;
    }

    //       ✅ 부서 정보 삭제 함수
    public boolean removeById(int rid) {
//        existById(기본키) 있으면 삭제 실행 + true 리턴
        if (reservationRepository.existsById(rid) == true) {
            reservationRepository.deleteById(rid);
            return true;
        }
//        없으면 그냥 false 리턴
        return false;
    }

    //    ✅ dname like 검색 함수 ( 페이징 처리 추가 )
    public Page<ReservationDto> findAllByRname(String rname, Pageable pageable) {
        Page<ReservationDto> list = reservationRepository.findAllByRname(rname, pageable);

        return list;
    }


    //    ✅ username like 검색 함수 ( 페이징 처리 추가 )
    public Page<ReservationDto> findAllById(Integer id, Pageable pageable) {
        Page<ReservationDto> list = reservationRepository.findAllById(id, pageable);

        return list;
    }
}








