package com.example.simpledms.service;

import com.example.simpledms.dto.FavoriteDto;
import com.example.simpledms.dto.ScoreDto;
import com.example.simpledms.model.Favorite;

import com.example.simpledms.model.Score;
import com.example.simpledms.repository.FavoriteRepository;
import com.example.simpledms.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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
public class ScoreService {

    @Autowired
    ScoreRepository scoreRepository; // JPA CRUD 함수가 있는 인터페이스


    // dno 로 검색함수
    public List<ScoreDto> findByDnoScoreAvg(Integer dno) {
        List<ScoreDto> list = scoreRepository.findByDnoScoreAvg(dno);

        return list;
    }
}









