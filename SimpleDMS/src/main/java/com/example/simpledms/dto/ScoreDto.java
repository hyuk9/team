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
public interface ScoreDto {

    String getGender();

    double getAvgtaste();
    double getAvgservice();
    double getAvgloc();
    double getAvgmood();
    double getAvgcost();

}
