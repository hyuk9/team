package com.example.simpledms.model;

import lombok.*;
import org.hibernate.annotations.*;

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
@Table(name = "TB_RESERVE")
@SequenceGenerator(
        name= "SQ_RESERVE_GENERATOR"
        , sequenceName = "SQ_RESERVE"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
// null 인 컬럼 데이터는 sql 문 자동 생성시 제외시킴
@DynamicInsert
@DynamicUpdate
@ToString
//  soft delete : 삭제하는 척만 하기 (화면에서는 안보이고, db는 데이터를 삭제하지 않음)
//  법정 의무 보관 기간을 위해 실제 데이터를 삭제하지 않음
//  사용법 1) @SQLDelete(sql="update문") : delete 문이 실행되지 않고, 매개변수의 update문이 실행되게함
//       2) @Where(clause="조건") : 대상클래스 붙이면 sql문 실행 시 강제 조건을 부여함
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_RESERVE SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE RID = ?")
public class Reserve extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
                   , generator = "SQ_RESERVE_GENERATOR"
    )
    private Integer rid;

    @Column
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String sights;

    @Column
    private String startDate;

    @Column
    private String endDate;

    @Column
    private String reservationYn;

    @Column
    private String address;

    @Column
    private String phone;
}










