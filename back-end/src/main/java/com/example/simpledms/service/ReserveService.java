package com.example.simpledms.service;

import com.example.simpledms.model.Dept;
import com.example.simpledms.model.Reserve;
import com.example.simpledms.repository.DeptRepository;
import com.example.simpledms.repository.ReserveRepository;
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
public class ReserveService {

    @Autowired
    ReserveRepository reserveRepository; // JPA CRUD 함수가 있는 인터페이스

    //    ✅ 전체 조회 함수 findAll() 👉 변경 findAll(Pageable pageable)
    public Page<Reserve> findAll(Pageable pageable) {
        Page<Reserve> page = reserveRepository.findAll(pageable);

        return page;
    }

//    ✅ id로 조회하는 함수

    public Optional<Reserve> findById(int rid) {
//        findById(기본키)
        Optional<Reserve> optionalReserve = reserveRepository.findById(rid);

        return optionalReserve;
    }


    //    ✅ 전체 삭제 함수
    public void removeAll() {
        reserveRepository.deleteAll();
    }


    //       ✅ 부서 정보 저장 함수
    public Reserve save(Reserve reserve) {
        Reserve reserve2 = reserveRepository.save(reserve);
        return reserve2;
    }

    //       ✅ 부서 정보 삭제 함수
    public boolean removeById(int rid) {
//        existById(기본키) 있으면 삭제 실행 + true 리턴
        if (reserveRepository.existsById(rid) == true) {
            reserveRepository.deleteById(rid);
            return true;
        }
//        없으면 그냥 false 리턴
        return false;
    }

    //    ✅ dname like 검색 함수 ( 페이징 처리 추가 )
    public Page<Reserve> findAllByEmailContaining(String email, Pageable pageable) {
        Page<Reserve> list = reserveRepository.findAllByEmailContaining(email, pageable);

        return list;
    }

}








