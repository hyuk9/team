package com.example.simpledms.service;

import com.example.simpledms.model.Review;
import com.example.simpledms.repository.ReviewRepository;
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
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository; // JPA CRUD 함수가 있는 인터페이스

    //    ✅ 전체 조회 함수 findAll() 👉 변경 findAll(Pageable pageable)
    public Page<Review> findAll(Pageable pageable) {
        Page<Review> page = reviewRepository.findAll(pageable);

        return page;
    }

//    ✅ id로 조회하는 함수
    public Optional<Review> findById(int rno) {
//        findById(기본키)
        Optional<Review> optionalReview = reviewRepository.findById(rno);

        return optionalReview;
    }

//    writer으로 조회하는 함수
    public Optional<Review> findByDno(int dno) {
        Optional<Review> optionalReview2 = reviewRepository.findByDno(dno);

        return optionalReview2;
    }

    //    ✅ 전체 삭제 함수
    public void removeAll() {
        reviewRepository.deleteAll();
    }


    //       ✅ 부서 정보 저장 함수
    public Review save(Review review) {
        Review review2 = reviewRepository.save(review);
        return review2;
    }

    //       ✅ 부서 정보 삭제 함수
    public boolean removeById(int rno) {
//        existById(기본키) 있으면 삭제 실행 + true 리턴
        if (reviewRepository.existsById(rno) == true) {
            reviewRepository.deleteById(rno);
            return true;
        }
//        없으면 그냥 false 리턴
        return false;
    }

    //    ✅ dname like 검색 함수 ( 페이징 처리 추가 )
    public Page<Review> findByDno(int dno, Pageable pageable) {
        Page<Review> list = reviewRepository.findByDno(dno, pageable);

        return list;
    }

}








