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
    String getMainphoto();

//    review 테이블에서 가져올 속성
    Integer getRno();
    Integer getId();
    Integer getDno();
    String getRcontent();
    Integer getRating();
    String  getRphoto(); // 나중에(버전2) 이사진이 진짜 리뷰 사진
}
