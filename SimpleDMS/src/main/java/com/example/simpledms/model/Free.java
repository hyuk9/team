package com.example.simpledms.model;

import lombok.*;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.persistence.Column;

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
@Table(name = "TB_FREE")
@SequenceGenerator(
        name= "SQ_FREE_GENERATOR"
        , sequenceName = "SQ_FREE"
        , initialValue = 1
        , allocationSize = 1
)
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Where(clause = "DELETE_YN = 'N'")
@SQLDelete(sql="UPDATE TB_FREE SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE FNO = ?")
public class Free extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
                   , generator = "SQ_FREE_GENERATOR"
    )
    private Integer fno;

    @javax.persistence.Column(columnDefinition = "VARCHAR2(255)")
    private String writer;

    @javax.persistence.Column(columnDefinition = "VARCHAR2(255)")
    private String title;

    @javax.persistence.Column(columnDefinition = "VARCHAR2(4000)")
    private String content;

    @javax.persistence.Column
    private String galleryTitle;

    @javax.persistence.Column
    private String galleryFileName;

    @javax.persistence.Column
    private String galleryType;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] blobFile; // 이미지

//    public Free(String galleryTitle, String galleryFileName, String galleryType, byte[] blobFile) {
//        this.galleryTitle = galleryTitle;
//        this.galleryFileName = galleryFileName;
//        this.galleryType = galleryType;
//        this.blobFile = blobFile;
//    }

}










