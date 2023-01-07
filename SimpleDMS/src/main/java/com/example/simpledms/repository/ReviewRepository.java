package com.example.simpledms.repository;


import com.example.simpledms.dto.ReservationDto;
import com.example.simpledms.dto.ReviewDto;
import com.example.simpledms.model.Menu;
import com.example.simpledms.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
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

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findAllByIdContaining (Integer id);

    List<Review> findAllByDnoEquals (Integer dno);

    Optional<Review> findByRnoEquals (Integer rno);

    @Query(value = "select rv.*, di.dname, di.mainphoto " +
            "from tb_review rv, tb_diner di " +
            "where rv.dno = di.dno " +
            "and id = :id",
            countQuery = "select rv.*, di.dname, di.mainphoto " +
                    "from tb_review rv, tb_diner di " +
                    "where rv.dno = di.dno " +
                    "and id = :id"
            , nativeQuery = true)
    Page<ReviewDto> findAllById(Integer id, Pageable pageable);

}










