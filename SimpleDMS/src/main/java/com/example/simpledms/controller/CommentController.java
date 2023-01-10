package com.example.simpledms.controller;

import com.example.simpledms.dto.FavoriteDto;
import com.example.simpledms.model.Announce;
import com.example.simpledms.model.Comment;
import com.example.simpledms.model.Favorite;
import com.example.simpledms.service.CommentService;
import com.example.simpledms.service.FavoriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.controller.exam07
 * fileName : Announce07Controller
 * author : ds
 * date : 2022-10-21
 * description : 부서 컨트롤러 쿼리 메소드
 * 요약 :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-21         ds          최초 생성
 */
@Slf4j
// CORS 보안 : 기본적으로 한사이트에서 포트를 달리 사용못함
// @CrossOrigin(허용할_사이트주소(Vue 사이트주소:포트)) : CORS 보안을 허용해주는 어노테이션
@CrossOrigin(origins = "http://localhost")
//@CrossOrigin(origins = "http://192.168.0.166")
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

    //    frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
//    frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable
//    @GetMapping("/comment")
//    public ResponseEntity<Object> getCommentAll(@RequestParam(required = false) Integer id,
//                                                @RequestParam(defaultValue = "0") int page,
//                                                @RequestParam(defaultValue = "3") int size
//    ) {
//
//        try {
//
////            페이지 변수 저장
//            Pageable pageable = PageRequest.of(page, size);
//
//            Page<Comment> commentPage;
//
//            commentPage = commentService.findAllById(id, pageable);
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("comment", commentPage.getContent());
//            response.put("currentPage", commentPage.getNumber());
//            response.put("totalItems", commentPage.getTotalElements());
//            response.put("totalPages", commentPage.getTotalPages());
//
//            if (commentPage.isEmpty() == false) {
////                성공
//                return new ResponseEntity<>(response, HttpStatus.OK);
//            } else {
////                데이터 없음
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
////            서버 에러
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    TODO: 댓글 번호로 조회하는 함수
    @GetMapping("/comment/cno/{cno}")
    public ResponseEntity<Object> getCommentId(@PathVariable int cno) {

        try {
            Optional<Comment> optionalComment = commentService.findById(cno);



            if (optionalComment.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalComment.get(), HttpStatus.OK);
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

//    Todo : 댓글 전체 삭제하는 함수 // 정상작동확인
    @DeleteMapping("/comment/all")
    public ResponseEntity<Object> removeAll() {

        try {
            commentService.removeAll();

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    Todo : 댓글 추가하는 함수
    @PostMapping("/comment")
    public ResponseEntity<Object> createComment(@RequestBody Comment comment) {

        try {
            Comment comment2 = commentService.save(comment);

            return new ResponseEntity<>(comment2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Todo : 현재 로그인한 유저pk값으로 쓴 댓글 조회하는 함수 (페이징 처리)
    @GetMapping("/comment/id")
    public ResponseEntity<Object> getCommentById(@RequestParam Integer id,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "3") int size)
    {
        try {

//            페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

            Page<Comment> commentPage;

            commentPage = commentService.findAllByIdEquals(id, pageable);

            Map<String, Object> response = new HashMap<>();
            response.put("comment", commentPage.getContent());
            response.put("currentPage", commentPage.getNumber());
            response.put("totalItems", commentPage.getTotalElements());
            response.put("totalPages", commentPage.getTotalPages());

            if (commentPage.isEmpty() == false) {
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

    //    Todo : 질문게시판 pk값에 해당하는 게시글 댓글 조회하는 함수 (페이징 처리) // 정상작동확인
    @GetMapping("/comment/qno")
    public ResponseEntity<Object> getQnoInQuestionboard(@RequestParam Integer qno,
                                           @RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "3") int size) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

            Page<Comment> commentPage;

            commentPage = commentService.findAllByQnoEqualsOrderByInsertTimeAsc(qno, pageable);

            //            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("comment", commentPage.getContent());
            response.put("currentPage", commentPage.getNumber());
            response.put("totalItems", commentPage.getTotalElements());
            response.put("totalPages", commentPage.getTotalPages());


            if (commentPage.isEmpty() == false) {
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


    //    Todo : 자유게시판 pk값에 해당하는 게시글 댓글 조회하는 함수 (페이징 처리) // 정상작동확인
    @GetMapping("/comment/fno")
    public ResponseEntity<Object> getFnoInFreeboard(@RequestParam Integer fno,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "3") int size) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

            Page<Comment> commentPage;

            commentPage = commentService.findAllByFnoEqualsOrderByInsertTimeAsc(fno, pageable);

            //            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("comment", commentPage.getContent());
            response.put("currentPage", commentPage.getNumber());
            response.put("totalItems", commentPage.getTotalElements());
            response.put("totalPages", commentPage.getTotalPages());


            if (commentPage.isEmpty() == false) {
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


    //    Todo : 공지사항 pk값에 해당하는 게시글 댓글 조회하는 함수 (페이징 처리) // 정상작동확인
    @GetMapping("/comment/aid")
    public ResponseEntity<Object> getAidInAnnouceboard(@RequestParam Integer aid,
                                           @RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "3") int size) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

            Page<Comment> commentPage;

            commentPage = commentService.findAllByAidEqualsOrderByInsertTimeAsc(aid, pageable);

            //            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("comment", commentPage.getContent());
            response.put("currentPage", commentPage.getNumber());
            response.put("totalItems", commentPage.getTotalElements());
            response.put("totalPages", commentPage.getTotalPages());


            if (commentPage.isEmpty() == false) {
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

    //    Todo : 푸드컬럼 pk값에 해당하는 게시글 댓글 조회하는 함수 (페이징 처리) // 정상작동확인함
    @GetMapping("/comment/cid")
    public ResponseEntity<Object> getCidInColumnboard(@RequestParam Integer cid,
                                           @RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "3") int size) {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

            Page<Comment> commentPage;

            commentPage = commentService.findAllByCidEqualsOrderByInsertTimeAsc(cid, pageable);

            //            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("comment", commentPage.getContent());
            response.put("currentPage", commentPage.getNumber());
            response.put("totalItems", commentPage.getTotalElements());
            response.put("totalPages", commentPage.getTotalPages());


            if (commentPage.isEmpty() == false) {
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


//    @GetMapping("/comment/{id}/{dno}")
//    public ResponseEntity<Object> getCommentId(@PathVariable Integer id) {
//
//        try {
//            Optional<Comment> optionalComment = commentService.findAllByQnoEquals(id, dno);
//
//
//            if (optionalComment.isPresent() == true) {
////                데이터 + 성공 메세지 전송
//                return new ResponseEntity<>(optionalComment.get(), HttpStatus.OK);
//            } else {
////                데이터 없음 메세지 전송(클라이언트)
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//        } catch (Exception e) {
//            log.debug(e.getMessage());
//            // 서버에러 발생 메세지 전송(클라이언트)
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PutMapping("/comment/{cno}")
    public ResponseEntity<Object> updateComment(@PathVariable int cno,
                                                @RequestBody Comment comment) {

        try {
            Comment comment2 = commentService.save(comment);

            return new ResponseEntity<>(comment2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    Todo : 댓글 삭제하는 함수 // 정상작동확인함
    @DeleteMapping("/comment/deletion/{cno}")
    public ResponseEntity<Object> deleteComment(@PathVariable int cno) {

        try {
            boolean bSuccess = commentService.removeById(cno);

            if (bSuccess == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(HttpStatus.OK);
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





