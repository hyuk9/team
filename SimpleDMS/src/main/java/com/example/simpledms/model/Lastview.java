package com.example.simpledms.model;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "TB_LASTVIEW")
@SequenceGenerator(
        name= "SQ_LASTVIEW_GENERATOR"
        , sequenceName = "SQ_LASTVIEW"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
//@SQLInsert(sql="INSERT TB_LASTVIEW SET INSERT_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE LID = ?")
public class Lastview extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
                   , generator = "SQ_LASTVIEW_GENERATOR"
    )
    private Integer lid;

    @Column
    private Integer id;

    @Column
    private Integer dno;

}










