package com.example.simpledms.controller;


import com.example.simpledms.dto.ReservationDto;
import com.example.simpledms.dto.ReviewDto;
import com.example.simpledms.dto.ScoreDto;
import com.example.simpledms.model.Comment;
import com.example.simpledms.model.Menu;
import com.example.simpledms.model.Review;
import com.example.simpledms.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * packageName    : com.example.jpaexam.controller.exam07
 * fileName       : Review07Controller
 * author         : ds
 * date           : 2022-10-21
 * description    : 부서 컨트롤러 쿼리 메소드
 * 요약 :
 * 쿼리 메소드 : 자동으로 사용자 정의 sql 문을 생성해주는 함수
 * 목적 : 기본 함수보다 다양한 sql 문 작성하기 위해 사용
 * 사용법 : 함수이름으로 sql 문장을 작성함 ( Repository 안에 함수명만 작성 )
 * ex) JPA 클래스 == 대상 테이블
 * find == select
 * all == *
 * by == from
 * 속성 == where 컬럼
 * orderBy == order by
 * 속성 desc == 컬럼 desc
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-10-21        ds       최초 생성
 */
@Slf4j
// CORS 보안 : 한사이트레서 포트를 달리 사용 못함
// @CrossOrigin(허용할 사이트주소(Vue 사이트주소:포트) : CORS 보안을 허용해주는 어노테이션
@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    ReviewService reviewService; // @Autowired : 스프링부트가 가동될 때 생성된 객체를 하나 받아오기

    //    frontend url ( 쿼리 스트링 방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
//    frontend url (파라메터 방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable
//    @RequestParam(required = false) : false 매개변수에 값이 없어도 에러가 발생하지 않음
//                                      기본값은 required = true
//    @RequestParam(defaultValue = "값") : 매개변수의 값이 없을떄 기본값을 설정함
    @GetMapping("/review")
    public ResponseEntity<Object> getReviewAll(@RequestParam(required = false) Integer id) {

        try {
//            1) menuName == null : 전체 검색
//            2) menuName != null : 부서명 like 검색
            List<Review> list = Collections.emptyList(); // null 대신 초기화

//            1) menuName == null : 전체 검색
            if (id == null) {
                list = reviewService.findAll();
            } else {
//            2) menuName != null : 부서명 like 검색
                list = reviewService.findAllByIdContaining(id);
            }

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/review/all")
    public ResponseEntity<Object> removeAll() {

        try {
            reviewService.removeAll();

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/review")
    public ResponseEntity<Object> createReview(@RequestBody Review review) {

        try {
            Review review2 = reviewService.save(review);

            return new ResponseEntity<>(review2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    Optional 객체 : null 방지 객체
//    주요함수 : get() 안에 있는 객체 꺼내기 함수
//             .isPresent() 안에 있으면 true , 없으면 false
    @GetMapping("/review/{dno}")
    public ResponseEntity<Object> getReviewId(@PathVariable Integer dno) {

        try {
            List<Review> list = reviewService.findAllByDnoEquals(dno);

            if (list.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/review/rno/{rno}")
    public ResponseEntity<Object> getReviewRno(@PathVariable Integer rno) {

        try {
            Optional<Review> optionalReview = reviewService.findByRnoEquals(rno);

            if (optionalReview.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalReview, HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/review/dno")
    public ResponseEntity<Object> getReviewDno(@RequestParam Integer dno,
                                               @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "3") int size) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

            Page<Review> reviewPage;

            reviewPage = reviewService.findAllByDnoEqualsOrderByInsertTimeDesc(dno, pageable);

            //            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("review", reviewPage.getContent());
            response.put("currentPage", reviewPage.getNumber());
            response.put("totalItems", reviewPage.getTotalElements());
            response.put("totalPages", reviewPage.getTotalPages());


            if (reviewPage.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/review/{rno}")
    public ResponseEntity<Object> updateReview(@PathVariable int rno,
                                               @RequestBody Review review) {

        try {
            Review review2 = reviewService.save(review);

            return new ResponseEntity<>(review2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/review/deletion/{rno}")
    public ResponseEntity<Object> deleteReview(@PathVariable int rno) {

        try {
            boolean bSuccess = reviewService.removeById(rno);

            if (bSuccess == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트에)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
//           서버 에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    Todo: 1.6 추가 currentUserId로 내가쓴리뷰 목록 찾기함수
    @GetMapping("/review/id")
    public ResponseEntity<Object> getUserId(@RequestParam Integer id,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "3") int size) {
        try {

//            페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

            Page<ReviewDto> reviewPage;

            reviewPage = reviewService.findAllById(id, pageable);

            Map<String, Object> response = new HashMap<>();
            response.put("review", reviewPage.getContent());
            response.put("currentPage", reviewPage.getNumber());
            response.put("totalItems", reviewPage.getTotalElements());
            response.put("totalPages", reviewPage.getTotalPages());

            if (reviewPage.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Todo : dno에 해당하는 평균 평점 조회하는 함수
    @GetMapping("/review/dno/{dno}")
    public ResponseEntity<Object> findByDnoScoreAvg(@PathVariable Integer dno) {

        try {
            List<ScoreDto> reviewDtoList = reviewService.findByDnoScoreAvg(dno);

            if (reviewDtoList.isEmpty() == false) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(reviewDtoList, HttpStatus.OK);
            } else {
//                데이터 없음 메세지 전송(클라이언트)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            log.debug(e.getMessage());
            // 서버에러 발생 메세지 전송(클라이언트)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
