package com.example.simpledms.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * packageName : com.example.jpaexam.model
 * fileName : Faq
 * author : ds
 * date : 2022-10-19
 * description : QNA 모델(== JPA : 엔티티(Entity)) 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-19         ds          최초 생성
 */
@Entity
@Table(name = "TB_QUESTION")
@SequenceGenerator(
        name= "SQ_QUESTION_GENERATOR"
        , sequenceName = "SQ_QUESTION"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_QUESTION SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD') WHERE QUESTION_NO = ?")
public class Question extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_QUESTION_GENERATOR"
    )
    private Integer questionNo;

    @javax.persistence.Column(columnDefinition = "VARCHAR2(255)")
    private String title;

    @javax.persistence.Column(columnDefinition = "VARCHAR2(255)")
    private String content;

    @javax.persistence.Column(columnDefinition = "VARCHAR2(255)")
    private String writer;
}

