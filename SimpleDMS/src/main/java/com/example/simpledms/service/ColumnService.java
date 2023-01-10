package com.example.simpledms.service;

import com.example.simpledms.model.Column;
import com.example.simpledms.repository.ColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : QnaService
 * author : ds
 * date : 2022-10-20
 * description : 부서 업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class ColumnService {

    @Autowired
    ColumnRepository columnRepository; // JPA CRUD 함수가 있는 인터페이스

    //    전체 조회 함수( 페이징 처리 )
    public Page<Column> findAll(Pageable pageable) {
        Page<Column> page = columnRepository.findAll(pageable);

        return page;
    }


    //    ✅ id로 조회하는 함수
    public Optional<Column> findById(int cid) {
//        findById(기본키)
        Optional<Column> optionalColumn = columnRepository.findById(cid);

        return optionalColumn;
    }

    //    전체 삭제 함수
    public void removeAll() {
        columnRepository.deleteAll(); // 전체 삭제
    }

    //   부서 정보 저장/수정 함수
    public Column save(Column column) {

        Column column2 = columnRepository.save(column);

        return column2;
    }


    // 부서번호(no)로 삭제하는 함수
    public boolean removeById(int cid) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if (columnRepository.existsById(cid) == true) {
            columnRepository.deleteById(cid);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

    //    question(질문) like 검색 함수 ( 페이징 처리 )
    public Page<Column> findAllByWriterContainingOrderByCidDesc(String writer, Pageable pageable) {
        Page<Column> page = columnRepository.findAllByWriterContainingOrderByCidDesc(writer, pageable);

        return page;
    }

    //    questioner(질문자) like 검색 함수 ( 페이징 처리 )
    public Page<Column> findAllByTitleContainingOrderByCidDesc(String title, Pageable pageable) {
        Page<Column> page = columnRepository.findAllByTitleContainingOrderByCidDesc(title, pageable);

        return page;
    }

    //    모든 파일 조회
    public Page<Column> findAllFiles(Pageable pageable) {
        Page<Column> page = columnRepository.findAll(pageable);

        return page;
    }

    //    이미지 저장 함수(*)
//    public Column store(String columnTitle,
//                      MultipartFile file) throws IOException
//    {
////        path(폴더경로) 제거후 순순한 fileName 가져오기
////        .getOriginalFilename() : 경로/파일명
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
////      1) Column 생성자에 경로 등 여러 정보를 저장
//        Column column = new Column(columnTitle,
//                fileName,
//                file.getContentType(), // 이미지의 타입정보( .jpg, .png 등 )
//                file.getBytes());      // 이미지 크기(size)
//
////      2) 위의 Column 를 DB 저장 + return
//        return columnRepository.save(column);
//    }

    public Column createUploadImage(int id, String writer, String title, String
            content, MultipartFile blobFile) throws IOException {

        String galleryFileName = "";
        Column column = null;
        //            업로드 파일에서 파일명 얻기
        if (blobFile != null) {
            galleryFileName = StringUtils.cleanPath(blobFile.getOriginalFilename());

             column = Column.builder()
                     .id(id)
                    .writer(writer)
                    .title(title)
                    .content(content)
                    .galleryFileName(galleryFileName)
                    .blobFile(blobFile.getBytes())
                    .build();
        }else {

             column = Column.builder()
                     .id(id)
                    .writer(writer)
                    .title(title)
                    .content(content)
                    .galleryFileName(galleryFileName)
                    .build();

        }
        Column createColumn = columnRepository.save(column);
        return createColumn;
    }

    public Column updateUploadFile(int cid, int id, String writer, String title, String
            content, MultipartFile blobFile, int views) throws IOException {

        //            업로드 파일에서 파일명 얻기
        String galleryFileName= "";
        Column column = null;
        if (blobFile != null) {
            galleryFileName = StringUtils.cleanPath(blobFile.getOriginalFilename());

            column = Column.builder()
                    .cid(cid)
                    .id(id)
                    .writer(writer)
                    .title(title)
                    .content(content)
                    .galleryFileName(galleryFileName)
                    .blobFile(blobFile.getBytes())
                    .views(views)
                    .build();
        }else{
            column = Column.builder()
                    .cid(cid)
                    .id(id)
                    .writer(writer)
                    .title(title)
                    .content(content)
                    .galleryFileName(galleryFileName)
                    .views(views)
                    .build();
        }
        Column createColumn = columnRepository.save(column);
        return createColumn;
    }

//    //    부서번호로 조회하는 함수
//    public Optional<Column> findById(int cid) {
////        findById(기본키속성)
//        Optional<Column> optionalColumn = columnRepository.findById(cid);
//
//        return optionalColumn;
//    }

    public Optional<Column> findId(int cid) {

        //            findById : parameter 값 - ID, return  값 - Optional
        Optional<Column> courseOptional = columnRepository.findById(cid);

        return courseOptional;
    }

    public Page<Column> findAllDesc(Pageable pageable) {

        Page<Column> columnList = columnRepository.findAllByOrderByInsertTimeDesc(pageable);

        return columnList;
    }

}









