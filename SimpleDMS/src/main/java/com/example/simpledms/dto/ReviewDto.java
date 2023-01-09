package com.example.simpledms.dto;

/**
 * packageName : com.example.simpledms.dto
 * fileName : ReservationDto
 * author : hyuk
 * date : 2023/01/05
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/01/05         hyuk          최초 생성
 */
public interface ReviewDto {
//    diner 테이블에서 가져올 속성
    String getDname();

//    review 테이블에서 가져올 속성

    String getContent();

    Double getSumscore();

    String getIt(); // 리뷰생성시간


//    평균 점수 성별 구분으로 그룹화해서 찍는 함수

    String getGender();

    double getAvgtaste();
    double getAvgservice();
    double getAvgloc();
    double getAvgmood();
    double getAvgcost();
}
