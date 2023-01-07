package com.example.simpledms.controller;

import com.example.simpledms.dto.FavoriteDto;
import com.example.simpledms.dto.ScoreDto;
import com.example.simpledms.model.Favorite;
import com.example.simpledms.service.FavoriteService;
import com.example.simpledms.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.controller.exam07
 * fileName : Announce07Controller
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
// CORS 보안 : 기본적으로 한사이트에서 포트를 달리 사용못함
// @CrossOrigin(허용할_사이트주소(Vue 사이트주소:포트)) : CORS 보안을 허용해주는 어노테이션
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ScoreController {

    @Autowired
    ScoreService scoreService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

//    dno로 검색함수
    @GetMapping("/score/dno/{dno}")
    public ResponseEntity<Object> findByDnoScoreAvg(@PathVariable Integer dno) {

        try {
            List<ScoreDto> scoreDtoList = scoreService.findByDnoScoreAvg(dno);

            if (scoreDtoList.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(scoreDtoList, HttpStatus.OK);
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










