package com.example.simpledms.repository;

import com.example.simpledms.model.Answer;
import com.example.simpledms.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

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

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    //    like 검색 함수
//    1) 쿼리메소드 방식으로 함수 정의
//    질문 테이블에 답글 다는 용도라서 따로 like 검색함수 안만들어도 될듯??
}











