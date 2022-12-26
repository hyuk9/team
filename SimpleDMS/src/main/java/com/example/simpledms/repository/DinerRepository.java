package com.example.simpledms.repository;


import com.example.simpledms.model.Diner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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

@Repository
public interface DinerRepository extends JpaRepository<Diner, Integer> {
    Page<Diner> findAllByLocContaining(String loc, Pageable pageable);

    Optional<Diner> findByDname(String dname);

}










