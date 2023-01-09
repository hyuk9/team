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
    // Todo : 모든 댓글 조회하는 함수 (페이징 처리)
    Page<Comment> findAllByIdEquals (Integer id, Pageable pageable);

    // Todo : 질문게시판 pk값에 해당하는 게시글 댓글 조회하는 함수 (페이징 처리)
    Page<Comment> findAllByQnoEqualsOrderByInsertTimeAsc(Integer qno, Pageable pageable);

    // Todo : 자유게시판 pk값에 해당하는 게시글 댓글 조회하는 함수 (페이징 처리)
    Page<Comment> findAllByFnoEqualsOrderByInsertTimeAsc(Integer fno, Pageable pageable);

    // Todo : 공지사항 pk값에 해당하는 게시글 댓글 조회하는 함수 (페이징 처리)
    Page<Comment> findAllByAidEqualsOrderByInsertTimeAsc(Integer aid, Pageable pageable);

    // Todo : 푸드컬럼 pk값에 해당하는 게시글 댓글 조회하는 함수 (페이징 처리)
    Page<Comment> findAllByCidEqualsOrderByInsertTimeAsc(Integer cid, Pageable pageable);


}








