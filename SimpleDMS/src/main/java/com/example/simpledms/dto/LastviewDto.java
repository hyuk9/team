package com.example.simpledms.dto;

/**
 * packageName : com.example.simpledms.dto
 * fileName : FavoriteDto
 * author : hyuk
 * date : 2023/01/04
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/01/04         hyuk          최초 생성
 */
public interface LastviewDto {
//    Diner에서 가져올 속성
    String getDname();
    String getPhone();
    String getLoc();
    String getMainphoto();
    Integer getDno();
    String getScore();
    String getMenu();
    String getTheme();

//    Lastview에서 가져올 속성
    String getIt();
}
