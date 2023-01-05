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
public interface FavoriteDto {
//    Diner에서 가져올 속성
    String getDname();

    String getScore();
    String getPhone();
    String getLoc();

    String getMenu();
    String getPhoto();

    String getTheme();

    String getReview();

    String getViews();

//    Favorite에서 가져올 속성
    Integer getFid();
    Integer getId();
    Integer getDno();

//    그룹함수 속성
    Integer getDno_count();
}
