package com.example.simpledms.service;

import com.example.simpledms.model.Menu;
import com.example.simpledms.model.Review;
import com.example.simpledms.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
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

    //    ✅ 전체 조회 함수
    public List<Review> findAll() {
        List<Review> list = reviewRepository.findAll();

        return list;
    }

//    ✅ id로 조회하는 함수

    public List<Review> findAllByDnoEquals(int dno) {
//        findById(기본키)
        List<Review> list = reviewRepository.findAllByDnoEquals(dno);

        return list;
    }

//    writer으로 조회하는 함수
//    public Optional<Review> findByDno(int dno) {
//        Optional<Review> optionalReview2 = reviewRepository.findByDno(dno);
//
//        return optionalReview2;
//    }

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

    //    ✅ dname like 검색 함수
    public List<Review> findAllByRwriterContaining(String rwriter) {
        List<Review> list = reviewRepository.findAllByRwriterContaining(rwriter);

        return list;
    }

//    //    이미지 저장 함수
//    public Review store(MultipartFile rphoto) throws IOException
//    {
////        path(폴더경로) 제거 후 순수한 galleryName 가져오기
////        .getOriginalGalleryname() : 경로/파일명
//        String galleryFileName = StringUtils.cleanPath(gallery.getOriginalFilename());
//
////        1) GalleryDb 생성자에 경로 등 여러 정보를 저장
//        Review galleryDb = new Review(galleryTitle
//                , galleryFileName
//                , gallery.getContentType() // 이미지의 타입정보( .jpg, .png 등 )
//                , gallery.getBytes());     // 이미지 크기(size)
//
////        2) 위의 GalleryDb 를 DB 저장 + return
//        return ReviewRepository.save(galleryDb);
//    }

}








