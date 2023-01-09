package com.example.simpledms.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.persistence.Column;

/**
 * packageName : com.example.jpaexam.model
 * fileName : Dept
 * author : ds
 * date : 2022-10-19
 * description : 부서 모델(== JPA : 엔티티(Entity)) 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-19         ds          최초 생성
 */
@Entity
@Table(name = "TB_REVIEW")
@SequenceGenerator(
        name = "SQ_REVIEW_GENERATOR"
        , sequenceName = "SQ_REVIEW"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@ToString
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql = "UPDATE TB_REVIEW SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE RNO = ?")
public class Review extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_REVIEW_GENERATOR"
    )
    private Integer rno;

//    유저 id
    @javax.persistence.Column
    private Integer id;

//    식당 id
    @javax.persistence.Column
    private Integer dno;

//    리뷰내용
    @javax.persistence.Column
    private String rwriter;

    @javax.persistence.Column
    private String rcontent;

//    맛 평점
    @Column
    private Integer taste;

//    서비스 평점
    @Column
    private Integer service;

//    접근성 평점
    @Column
    private Integer loc;

//    분위기 평점
    @Column
    private Integer mood;

//    가성비 평점
    @Column
    private Integer cost;

//    성별
    @Column
    private String gender;

//    @Lob
//    @javax.persistence.Column
//    private String rphoto;

}