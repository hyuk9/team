package com.example.simpledms.service;

import com.example.simpledms.model.Comment;
import com.example.simpledms.repository.CommentRepository;
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

    //    질문번호로 조회하는 함수
    public Optional<Comment> findById(int qno) {
//        findById(기본키속성)
        Optional<Comment> optionalAnswer = commentRepository.findById(qno);

        return optionalAnswer;
    }

    // 부서번호(no)로 삭제하는 함수
    public boolean removeById(int cno) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(commentRepository.existsById(cno) == true) {
            commentRepository.deleteById(cno);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }
//
////    Todo : 질문번호에 해당하는 댓글 조회하는 함수
//    public Page<Comment> findAllByQnoEqualsOrderByInsertTimeAsc(Integer qno, Pageable pageable) {
////        findById(기본키속성)
//        Page<Comment> page = commentRepository.findAllByQnoEqualsOrderByInsertTimeAsc(qno ,pageable);
//
//        return page;
//    }


//    Todo : 위에거 안되서 테스트용도로 만들어봄
    public List<Comment> findAllByQnoEqualsOrderByInsertTimeAsc(Integer qno) {
//        findById(기본키속성)
        List<Comment> list = commentRepository.findAllByQnoEqualsOrderByInsertTimeAsc(qno);

        return list;
    }




}









