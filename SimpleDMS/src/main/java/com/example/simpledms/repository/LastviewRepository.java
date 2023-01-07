package com.example.simpledms.repository;


import com.example.simpledms.dto.LastviewDto;
import com.example.simpledms.model.Diner;
import com.example.simpledms.model.Favorite;
import com.example.simpledms.model.Lastview;
import com.example.simpledms.model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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

@Repository
public interface LastviewRepository extends JpaRepository<Lastview, Integer> {
//    부서명으로(dname) 조회하는 like 검색 함수
//    1) 쿼리메소드 방식으로 사용자 정의 함수 정의
//    List<Menu> findAllByMenuNameContaining (String menuName);
//
//    List<Menu> findAllByDnoEquals (Integer dno);

//    @Query(value = "select di.* " +
//                   "from tb_diner di, tb_lastview la " +
//                   "where di.dno = la.dno " +
//                   "and id = :id",
//    countQuery = "select di.* " +
//            "from tb_diner di, tb_lastview la " +
//            "where di.dno = la.dno " +
//            "and id = :id",
//    nativeQuery = true)
@Query(value = "select di.*, la.insert_time as it " +
        "from tb_diner di, tb_lastview la " +
        "where di.dno = la.dno " +
        "and id = :id " +
        "order by la.insert_time desc",
        countQuery = "select di.*, la.insert_time as it " +
                "from tb_diner di, tb_lastview la " +
                "where di.dno = la.dno " +
                "and id = :id " +
                "order by la.insert_time desc",
        nativeQuery = true)
    Page<LastviewDto> findAllByIdOrderByInsertTimeDesc (Integer id, Pageable pageable);

    Optional<Lastview> findByIdAndDno (Integer id, Integer dno);
}









