package com.example.simpledms.service;

import com.example.simpledms.dto.FavoriteDto;
import com.example.simpledms.dto.ReviewDto;
import com.example.simpledms.model.Comment;
import com.example.simpledms.model.Favorite;
import com.example.simpledms.repository.CommentRepository;
import com.example.simpledms.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class CommentService {

    @Autowired
    CommentRepository commentRepository; // JPA CRUD 함수가 있는 인터페이스

    //    전체 조회 함수( 페이징 처리 )
    public Page<Comment> findAll(Pageable pageable) {
        Page<Comment> page = commentRepository.findAll(pageable);

        return page;
    }

    //    전체 삭제 함수
    public void removeAll() {
        commentRepository.deleteAll(); // 전체 삭제
    }

    //   부서 정보 저장/수정 함수
    public Comment save(Comment comment) {

        Comment comment2 = commentRepository.save(comment);

        return comment2;
    }

    //    부서번호로 조회하는 함수
    public Optional<Comment> findById(int cno) {
//        findById(기본키속성)
        Optional<Comment> optionalComment = commentRepository.findById(cno);

        return optionalComment;
    }

    // 부서번호(no)로 삭제하는 함수
    public boolean removeById(int dno) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(commentRepository.existsById(dno) == true) {


            commentRepository.deleteById(dno);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

    // Todo : 현재 로그인한 유저pk값으로 쓴 댓글 조회하는 함수 (페이징 처리)
    public Page<Comment> findAllByIdEquals(Integer id, Pageable pageable) {
        Page<Comment> page = commentRepository.findAllByIdEquals(id, pageable);

        return page;
    }

    // Todo : 질문게시판 pk값에 해당하는 게시글 댓글 조회하는 함수 (페이징 처리)
    public Page<Comment> findAllByQnoEqualsOrderByInsertTimeAsc(Integer qno, Pageable pageable) {
        Page<Comment> page = commentRepository.findAllByQnoEqualsOrderByInsertTimeAsc(qno, pageable);
        return page;
    }

    // Todo : 자유게시판 pk값에 해당하는 게시글 댓글 조회하는 함수 (페이징 처리)
    public Page<Comment> findAllByFnoEqualsOrderByInsertTimeAsc(Integer fno, Pageable pageable) {
        Page<Comment> page = commentRepository.findAllByFnoEqualsOrderByInsertTimeAsc(fno, pageable);

        return page;
    }

    // Todo : 공지사항 pk값에 해당하는 게시글 댓글 조회하는 함수 (페이징 처리)
    public Page<Comment> findAllByAidEqualsOrderByInsertTimeAsc(Integer aid, Pageable pageable) {
        Page<Comment> page = commentRepository.findAllByAidEqualsOrderByInsertTimeAsc(aid, pageable);

        return page;
    }

    // Todo : 푸드컬럼 pk값에 해당하는 게시글 댓글 조회하는 함수 (페이징 처리)
    public Page<Comment> findAllByCidEqualsOrderByInsertTimeAsc(Integer cid, Pageable pageable) {
        Page<Comment> page = commentRepository.findAllByCidEqualsOrderByInsertTimeAsc(cid, pageable);

        return page;
    }

}









