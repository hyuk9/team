package com.example.simpledms.repository;

import com.example.simpledms.dto.FavoriteDto;
import com.example.simpledms.model.Comment;
import com.example.simpledms.model.Favorite;
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

public interface CommentRepository extends JpaRepository<Comment, Integer> {
//    question 조회하는 like 검색 함수
//    1) 쿼리메소드 방식으로 함수 정의

    //    프로필페이지에서 사용할 함수
    Page<Comment> findAllByQnoEqualsOrderByInsertTimeAsc(Integer qno, Pageable pageable);

    //    id랑 dno로 Fid찾는 함수
    Page<Comment> findAllByFnoEqualsOrderByInsertTimeAsc(Integer fno, Pageable pageable);

}








