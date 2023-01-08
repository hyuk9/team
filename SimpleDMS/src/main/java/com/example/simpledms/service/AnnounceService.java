package com.example.simpledms.service;

import com.example.simpledms.model.Announce;
import com.example.simpledms.repository.AnnounceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : QnaService
 * author : ds
 * date : 2022-10-20
 * description : 부서 업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class AnnounceService {

    @Autowired
    AnnounceRepository announceRepository; // JPA CRUD 함수가 있는 인터페이스

    //    전체 조회 함수( 페이징 처리 )
    public Page<Announce> findAll(Pageable pageable) {
        Page<Announce> page = announceRepository.findAll(pageable);

        return page;
    }

    //    전체 삭제 함수
    public void removeAll() {
        announceRepository.deleteAll(); // 전체 삭제
    }

    //   부서 정보 저장/수정 함수
    public Announce save(Announce announce) {

        Announce announce2 = announceRepository.save(announce);

        return announce2;
    }

    //    부서번호로 조회하는 함수
    public Optional<Announce> findById(int aid) {
//        findById(기본키속성)
        Optional<Announce> optionalAnnounce = announceRepository.findById(aid);

        return optionalAnnounce;
    }

    // 부서번호(no)로 삭제하는 함수
    public boolean removeById(int aid) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(announceRepository.existsById(aid) == true) {


            announceRepository.deleteById(aid);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

    //    question(질문) like 검색 함수 ( 페이징 처리 )
    public Page<Announce> findAllByWriterContainingOrderByAidDesc(String writer, Pageable pageable) {
        Page<Announce> page = announceRepository.findAllByWriterContainingOrderByAidDesc(writer, pageable);

        return page;
    }

    //    questioner(질문자) like 검색 함수 ( 페이징 처리 )
    public Page<Announce> findAllByTitleContainingOrderByAidDesc(String title, Pageable pageable) {
        Page<Announce> page = announceRepository.findAllByTitleContainingOrderByAidDesc(title, pageable);

        return page;
    }
}









