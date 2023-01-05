package com.example.simpledms.dto;

/**
 * packageName : com.example.simpledms.dto
 * fileName : QuestionDto
 * author : hyuk
 * date : 2023/01/04
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/01/04         hyuk          최초 생성
 */
public interface QuestionDto {
//    질문 테이블에서 가져올 속성
    String getTitle();
    String getQcontent();
    String getQwriter();

//    답변 테이블에서 가져올 속성
    String getAcontent();
    String getAwriter();

}
