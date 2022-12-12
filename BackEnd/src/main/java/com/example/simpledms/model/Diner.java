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
@Table(name = "TB_DINNER")
@SequenceGenerator(
        name= "SQ_DINNER_GENERATOR"
        , sequenceName = "SQ_DINNER"
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
@SQLDelete(sql="UPDATE TB_DINNER SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE SNO = ?")
public class Diner extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
                   , generator = "SQ_DINNER_GENERATOR"
    )
    private Integer sno;

    @Column
    private String sname;

    @Column
    private String score;

    @Column
    private String loc;

    @Column
    private String phone;

    @Column
    private String menu;

    @Column
    private String review;
}










