package com.example.simpledms.service;

import com.example.simpledms.dto.FavoriteDto;
import com.example.simpledms.dto.ScoreDto;
import com.example.simpledms.model.Favorite;

import com.example.simpledms.model.Menu;
import com.example.simpledms.model.Review;
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

    //    ✅ id로 조회하는 함수

    public List<Score> findAllByRnoEquals(int rno) {
//        findById(기본키)
        List<Score> list = scoreRepository.findAllByRnoEquals(rno);

        return list;
    }

    //       ✅ 부서 정보 저장 함수
    public Score save(Score score) {
        Score score2 = scoreRepository.save(score);
        return score2;
    }

    //       ✅ 부서 정보 삭제 함수
    public boolean removeById(int sid) {
//        existById(기본키) 있으면 삭제 실행 + true 리턴
        if (scoreRepository.existsById(sid) == true) {
            scoreRepository.deleteById(sid);
            return true;
        }
//        없으면 그냥 false 리턴
        return false;
    }
}









