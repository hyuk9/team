package com.example.simpledms.dto;

/**
 * packageName : com.example.simpledms.dto
 * fileName : DinerDTO
 * author : hyuk
 * date : 2023/01/06
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/01/06         hyuk          최초 생성
 */
public interface DinerDto {
//    diner 테이블에서 가져올 속성
    String getDname();
    String getScore();
    String getLoc();
    String getPhone();
    String getMenu();
    String getTheme();
    String getMainphoto();
    String getPhoto1();
    String getPhoto2();
    String getPhoto3();
    Double getLat();
    Double getLng();
    Integer getView();
    Integer getDno_count();

//    review 테이블에서 가져올 속성
    String getRcontent();
    Integer getRating();

//    user 테이블에서 가져올 속성
    String getName();

}
