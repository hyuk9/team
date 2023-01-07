package com.example.simpledms.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
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
@Table(name = "TB_SCORE")
@SequenceGenerator(
        name= "SQ_SCORE_GENERATOR"
        , sequenceName = "SQ_SCORE"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
                   , generator = "SQ_SCORE_GENERATOR"
    )
    private Integer sid;

    @Column
    private Integer taste;

    @Column
    private Integer service;

    @Column
    private Integer loc;
    @Column
    private Integer mood;
    @Column
    private Integer cost;
    @Column
    private Integer dno;
    @Column
    private String gender;
}










