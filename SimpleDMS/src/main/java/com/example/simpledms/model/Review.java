package com.example.simpledms.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

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
        name= "SQ_REVIEW_GENERATOR"
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
@SQLDelete(sql="UPDATE TB_REVIEW SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE RNO = ?")
public class Review extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_REVIEW_GENERATOR"
    )
    private Integer rno;

    @javax.persistence.Column
    private Integer dno;

    @javax.persistence.Column
    private String review_title;

    @javax.persistence.Column
    private String review_content;

    @javax.persistence.Column
    private String review_photo;

    @javax.persistence.Column
    private String review_writer;

    public Integer getRno() {
        return rno;
    }

    public void setRno(Integer rno) {
        this.rno = rno;
    }

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }

    public String getReview_title() {
        return review_title;
    }

    public void setReview_title(String review_title) {
        this.review_title = review_title;
    }

    public String getReview_content() {
        return review_content;
    }

    public void setReview_content(String review_content) {
        this.review_content = review_content;
    }

    public String getReview_photo() {
        return review_photo;
    }

    public void setReview_photo(String review_photo) {
        this.review_photo = review_photo;
    }

    public String getReview_writer() {
        return review_writer;
    }

    public void setReview_writer(String review_writer) {
        this.review_writer = review_writer;
    }
}










