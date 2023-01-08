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
@Table(name = "TB_COMMENT")
@SequenceGenerator(
        name= "SQ_COMMENT_GENERATOR"
        , sequenceName = "SQ_COMMENT"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_COMMENT SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD') WHERE COMMENT_NO = ?")
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_COMMENT_GENERATOR"
    )
    private Integer cno;

//    조인용 컬럼
    @javax.persistence.Column
    private String qno;

//    조인용 컬럼
    @javax.persistence.Column
    private String id;

//    조인용 컬럼
    @javax.persistence.Column
    private String fno;

    @javax.persistence.Column
    private String content;

    @javax.persistence.Column
    private String writer;

}

