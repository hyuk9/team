package com.example.simpledms.service;

import com.example.simpledms.model.Free;
import com.example.simpledms.model.Question;
import com.example.simpledms.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository; // JPA CRUD 함수가 있는 인터페이스

    //    전체 조회 함수( 페이징 처리 )
    public Page<Question> findAll(Pageable pageable) {
        Page<Question> page = questionRepository.findAll(pageable);

        return page;
    }

    //    전체 삭제 함수
    public void removeAll() {
        questionRepository.deleteAll(); // 전체 삭제
    }

    //   부서 정보 저장/수정 함수
    public Question save(Question question) {

        Question qna2 = questionRepository.save(question);

        return qna2;
    }

    //    부서번호로 조회하는 함수
    public Optional<Question> findById(int qno) {
//        findById(기본키속성)
        Optional<Question> optionalQuestion = questionRepository.findById(qno);

        return optionalQuestion;
    }

    // 부서번호(no)로 삭제하는 함수
    public boolean removeById(int qno) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(questionRepository.existsById(qno) == true) {
            questionRepository.deleteById(qno);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

    //    question(질문) like 검색 함수 ( 페이징 처리 )
    public Page<Question> findAllByWriterContainingOrderByInsertTimeDescQnoDesc(String  writer, Pageable pageable) {
        Page<Question> page = questionRepository.findAllByWriterContainingOrderByInsertTimeDescQnoDesc(writer, pageable);

        return page;
    }

    //    questioner(질문자) like 검색 함수 ( 페이징 처리 )
    public Page<Question> findAllByTitleContainingOrderByInsertTimeDescQnoDesc(String title, Pageable pageable) {
        Page<Question> page = questionRepository.findAllByTitleContainingOrderByInsertTimeDescQnoDesc(title, pageable);

        return page;
    }

    public Optional<Question> findId(int qno) {
        //            findById : parameter 값 - ID, return  값 - Optional
        Optional<Question> courseOptional = questionRepository.findById(qno);

        return courseOptional;
    }
}









