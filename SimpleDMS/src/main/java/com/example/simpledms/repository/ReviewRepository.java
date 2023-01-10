package com.example.simpledms.repository;


import com.example.simpledms.dto.ReservationDto;
import com.example.simpledms.dto.ReviewDto;
import com.example.simpledms.dto.ScoreDto;
import com.example.simpledms.model.Comment;
import com.example.simpledms.model.Menu;
import com.example.simpledms.model.Review;
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

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findAllByIdContaining (Integer id);

    List<Review> findAllByDnoEquals (Integer dno);

    Optional<Review> findByRnoEquals (Integer rno);

    Page<Review> findAllByDnoEqualsOrderByInsertTimeDesc(Integer dno, Pageable pageable);

    @Query(value = "select di.dname, rv. content, rv.insert_time as it, sum(rv.taste+rv.service+rv.loc+rv.mood+rv.cost)/5 as sumscore " +
            "from tb_review rv, tb_diner di " +
            "where rv.dno = di.dno " +
            "and rv.id = :id " +
            "and rv.delete_yn = 'N'" +
            "group by di.dname, rv.content, rv.insert_time",
            countQuery = "select di.dname, rv. content, rv.insert_time as it, sum(rv.taste+rv.service+rv.loc+rv.mood+rv.cost)/5 as sumscore " +
                    "from tb_review rv, tb_diner di " +
                    "where rv.dno = di.dno " +
                    "and rv.id = :id " +
                    "and rv.delete_yn = 'N'" +
                    "group by di.dname, rv.content, rv.insert_time"
            , nativeQuery = true)
    Page<ReviewDto> findAllById(Integer id, Pageable pageable);

    //    Todo: 평점 항목별 평균 점수를 성별로 그룹화 해서 찍는 함수
    @Query(value = "select re.gender, avg(re.taste) as avgtaste,avg(re.service) as avgservice ,avg(re.loc) as avgloc,avg(re.mood) as avgmood,avg(re.cost) as avgcost " +
            "from tb_review re " +
            "where re.dno = :dno " +
            "group by re.gender",
            countQuery = "select re.gender, avg(re.taste) as avgtaste,avg(re.service) as avgservice ,avg(re.loc) as avgloc,avg(re.mood) as avgmood,avg(re.cost) as avgcost " +
                    "from tb_review re " +
                    "where re.dno = :dno " +
                    "group by re.gender"
            ,nativeQuery = true)
    List<ScoreDto> findByDnoScoreAvg (@Param("dno") Integer dno);

}










