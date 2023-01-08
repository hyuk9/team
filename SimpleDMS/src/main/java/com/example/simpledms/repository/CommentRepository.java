package com.example.simpledms.repository;

import com.example.simpledms.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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
    //    like 검색 함수
//    1) 쿼리메소드 방식으로 함수 정의
//    Todo : 질문번호로 댓글 찾는 함수
    Page<Comment> findAllByQnoEqualsOrderByInsertTimeAsc (Integer qno, Pageable pageable);

//    Todo : 위에 코드 안되서 그냥 list 형식으로 만들어봄
//    List<Comment> findAllByQnoEqualsOrderByInsertTimeAsc (Integer qno);
}











