package com.example.simpledms.service;

import com.example.simpledms.model.Column;
import com.example.simpledms.repository.ColumnRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : com.example.jpaexam.service.exam01
 * fileName : DeptService
 * author : ds
 * date : 2022-10-20
 * description : 부서 업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
@Slf4j
public class ColumnService {

    @Autowired
    ColumnRepository columnRepository; // JPA CRUD 함수가 있는 인터페이스

    //    ✅ 전체 조회 함수 findAll() 👉 변경 findAll(Pageable pageable)
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

    //    ✅ 전체 삭제 함수
    public void removeAll() {
        columnRepository.deleteAll();
    }


    //       ✅ 부서 정보 저장 함수
    public Column save(Column column) {
        Column column2 = columnRepository.save(column);
        return column2;
    }

    //       ✅ 부서 정보 삭제 함수
    public boolean removeById(int cid) {
//        existById(기본키) 있으면 삭제 실행 + true 리턴
        if (columnRepository.existsById(cid) == true) {
            columnRepository.deleteById(cid);
            return true;
        }
//        없으면 그냥 false 리턴
        return false;
    }

    //    ✅ title like 검색 함수 ( 페이징 처리 추가 )
    public Page<Column> findAllByColumnTitleContainingOrderByCidDesc(String title, Pageable pageable) {
        Page<Column> list = columnRepository.findAllByColumnTitleContainingOrderByCidDesc(title, pageable);
        return list;
    }

    //    ✅ writer like 검색 함수 ( 페이징 처리 추가 )
    public Page<Column> findAllByColumnWriterContainingOrderByCidDesc(String writer, Pageable pageable) {
        Page<Column> list = columnRepository.findAllByColumnWriterContainingOrderByCidDesc(writer, pageable);
        return list;
    }


}








