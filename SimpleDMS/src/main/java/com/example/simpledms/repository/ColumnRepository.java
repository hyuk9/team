package com.example.simpledms.repository;


import com.example.simpledms.model.Column;
import com.example.simpledms.model.Free;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : com.example.jpaexam.repository
 * fileName : DeptRepository
 * author : ds
 * date : 2022-10-20
 * description : JPA CRUD를 위한 인터페이스(==DAO)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */

public interface ColumnRepository extends JpaRepository<Column, Integer> {
Page<Column> findAllByWriterContainingOrderByCidDesc(String writer, Pageable pageable);
    Page<Column> findAllByTitleContainingOrderByCidDesc(String title, Pageable pageable);

    public Page<Column> findAllByOrderByInsertTimeDesc(Pageable pageable);
}










