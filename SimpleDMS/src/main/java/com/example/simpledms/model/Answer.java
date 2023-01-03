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
@Table(name = "TB_ANSWER")
@SequenceGenerator(
        name= "SQ_ANSWER_GENERATOR"
        , sequenceName = "SQ_ANSWER"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_ANSWER SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD') WHERE ANSWER_NO = ?")
public class Answer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_ANSWER_GENERATOR"
    )
    private Integer answerNo;

//    조인용 컬럼
    @javax.persistence.Column(columnDefinition = "NUMBER")
    private String questionNo;

    @javax.persistence.Column(columnDefinition = "VARCHAR2(255)")
    private String content;

//   조인용 컬럼
    @javax.persistence.Column(columnDefinition = "VARCHAR2(255)")
    private String writer;
}

