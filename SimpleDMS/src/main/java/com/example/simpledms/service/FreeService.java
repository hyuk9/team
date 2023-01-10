package com.example.simpledms.service;

import com.example.simpledms.model.Free;
import com.example.simpledms.repository.FreeRepository;
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
public class FreeService {

    @Autowired
    FreeRepository freeRepository; // JPA CRUD 함수가 있는 인터페이스

    //    ✅ 전체 조회 함수 findAll() 👉 변경 findAll(Pageable pageable)
    public Page<Free> findAll(Pageable pageable) {
        Page<Free> page = freeRepository.findAll(pageable);

        return page;
    }

//    ✅ id로 조회하는 함수
    public Optional<Free> findById(int fno) {
//        findById(기본키)
        Optional<Free> optionalFree = freeRepository.findById(fno);

        return optionalFree;
    }

    //    ✅ 전체 삭제 함수
    public void removeAll() {
        freeRepository.deleteAll();
    }


    //       ✅ 부서 정보 저장 함수
    public Free save(Free free) {
        Free free2 = freeRepository.save(free);
        return free2;
    }

    //       ✅ 부서 정보 삭제 함수
    public boolean removeById(int fno) {
//        existById(기본키) 있으면 삭제 실행 + true 리턴
        if (freeRepository.existsById(fno) == true) {
            freeRepository.deleteById(fno);
            return true;
        }
//        없으면 그냥 false 리턴
        return false;
    }

    //    ✅ title like 검색 함수 ( 페이징 처리 추가 )
    public Page<Free> findAllByTitleContainingOrderByFnoDesc(String title, Pageable pageable) {
        Page<Free> list = freeRepository.findAllByTitleContainingOrderByFnoDesc(title, pageable);
        return list;
    }

    //    ✅ writer like 검색 함수 ( 페이징 처리 추가 )
    public Page<Free> findAllByWriterContainingOrderByFnoDesc(String writer, Pageable pageable) {
        Page<Free> list = freeRepository.findAllByWriterContainingOrderByFnoDesc(writer, pageable);
        return list;
    }


}








