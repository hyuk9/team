package com.example.simpledms.repository;

import com.example.simpledms.dto.FavoriteDto;
import com.example.simpledms.dto.ScoreDto;
import com.example.simpledms.model.Favorite;
import com.example.simpledms.model.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.repository
 * fileName : DeptRepository
 * author : ds
 * date : 2022-10-20
 * description : JPA CRUD를 위한 인터페이스(==DAO)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */

public interface ScoreRepository extends JpaRepository<Score, Integer> {


    //    평점 항목별 평균 점수를 성별로 그룹화 해서 찍는 함수
    @Query(value = "select sc.gender, avg(sc.taste) as avgtaste,avg(sc.service) as avgservice ,avg(sc.loc) as avgloc,avg(sc.mood) as avgmood,avg(sc.cost) as avgcost " +
            "from tb_score sc " +
            "where sc.dno = :dno " +
            "group by sc.gender",
            countQuery = "select sc.gender, avg(sc.taste)as avgtaste,avg(sc.service) as avgservice ,avg(sc.loc) as avgloc,avg(sc.mood) as avgmood,avg(sc.cost) as avgcost " +
                    "from tb_score sc " +
                    "where sc.dno = :dno " +
                    "group by sc.gender"
            ,nativeQuery = true)
    List<ScoreDto> findByDnoScoreAvg (@Param("dno") Integer dno);

}









