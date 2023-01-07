package com.example.simpledms.service;

import com.example.simpledms.dto.LastviewDto;
import com.example.simpledms.model.Favorite;
import com.example.simpledms.model.Lastview;
import com.example.simpledms.model.Menu;
import com.example.simpledms.repository.LastviewRepository;
import com.example.simpledms.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class LastviewService {

    @Autowired
    LastviewRepository lastviewRepository; // JPA CRUD 함수가 있는 인터페이스

    //    ✅ 전체 조회 함수
    public List<Lastview> findAll() {
        List<Lastview> list = lastviewRepository.findAll();

        return list;
    }

//    Todo: 최근본 음식점 테이블에 저장하는 함수
    public Lastview save(Lastview lastview) {

        Lastview lastview2 = lastviewRepository.save(lastview);

        return lastview2;
    }

    //    Todo: user id로 최근 본 가게 조회하는 함수
    public Page<LastviewDto> findAllByIdOrderByInsertTimeDesc(Pageable pageable) {
        Page<LastviewDto> lastviews = lastviewRepository.findAllByIdOrderByInsertTimeDesc(pageable);

        return lastviews;
    }

}








