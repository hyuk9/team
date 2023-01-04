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
@Table(name = "TB_PROFILE")
@SequenceGenerator(
        name= "SQ_PROFILE_GENERATOR"
        , sequenceName = "SQ_PROFILE"
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
@SQLDelete(sql="UPDATE TB_PROFILE SET DELETE_YN = 'Y', DELETE_TIME = TO_CHAR(SYSDATE, 'YYYY-MM-DD') WHERE PNO = ?")
public class Profile extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "SQ_PROFILE_GENERATOR"
    )
    private Integer pno;



    @javax.persistence.Column
    private String imageFileName;


    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] blobFile; // 이미지

//    public Profile(String galleryTitle, String galleryFileName, String galleryType, byte[] blobFile) {
//        this.galleryTitle = galleryTitle;
//        this.galleryFileName = galleryFileName;
//        this.galleryType = galleryType;
//        this.blobFile = blobFile;
//    }

}










