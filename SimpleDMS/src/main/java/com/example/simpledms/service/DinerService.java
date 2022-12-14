package com.example.simpledms.service;

import com.example.simpledms.model.Diner;
import com.example.simpledms.repository.DinerRepository;
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
public class DinerService {

    @Autowired
    DinerRepository dinerRepository; // JPA CRUD 함수가 있는 인터페이스

    //    ✅ 전체 조회 함수 findAll() 👉 변경 findAll(Pageable pageable)
    public Page<Diner> findAll(Pageable pageable) {
        Page<Diner> page = dinerRepository.findAll(pageable);

        return page;
    }

//    ✅ id로 조회하는 함수
    public Optional<Diner> findById(int dno) {
//        findById(기본키)
        Optional<Diner> optionalDinner = dinerRepository.findById(dno);

        return optionalDinner;
    }


    //    ✅ 전체 삭제 함수
    public void removeAll() {
        dinerRepository.deleteAll();
    }


    //       ✅ 부서 정보 저장 함수
    public Diner save(Diner diner) {
        Diner diner2 = dinerRepository.save(diner);
        return diner2;
    }

    //       ✅ 부서 정보 삭제 함수
    public boolean removeById(int dno) {
//        existById(기본키) 있으면 삭제 실행 + true 리턴
        if (dinerRepository.existsById(dno) == true) {
            dinerRepository.deleteById(dno);
            return true;
        }
//        없으면 그냥 false 리턴
        return false;
    }

    //    ✅ dname like 검색 함수 ( 페이징 처리 추가 )
    public Page<Diner> findAllByDnameContaining(String sname, Pageable pageable) {
        Page<Diner> list = dinerRepository.findAllByDnameContaining(sname, pageable);

        return list;
    }

}








