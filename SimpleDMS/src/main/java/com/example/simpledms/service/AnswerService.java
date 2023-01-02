package com.example.simpledms.service;

import com.example.simpledms.model.Answer;
import com.example.simpledms.model.Question;
import com.example.simpledms.repository.AnswerRepository;
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
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository; // JPA CRUD 함수가 있는 인터페이스

    //    전체 조회 함수( 페이징 처리 )
    public Page<Answer> findAll(Pageable pageable) {
        Page<Answer> page = answerRepository.findAll(pageable);

        return page;
    }

    //    전체 삭제 함수
    public void removeAll() {
        answerRepository.deleteAll(); // 전체 삭제
    }

    //   부서 정보 저장/수정 함수
    public Answer save(Answer answer) {

        Answer answer2 = answerRepository.save(answer);

        return answer2;
    }

    //    질문번호로 조회하는 함수
    public Optional<Answer> findById(int questionNo) {
//        findById(기본키속성)
        Optional<Answer> optionalAnswer = answerRepository.findById(questionNo);

        return optionalAnswer;
    }

    // 부서번호(no)로 삭제하는 함수
    public boolean removeById(int answerNo) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(answerRepository.existsById(answerNo) == true) {
            answerRepository.deleteById(answerNo);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

}









