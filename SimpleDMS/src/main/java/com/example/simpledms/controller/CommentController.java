package com.example.simpledms.controller;

import com.example.simpledms.model.Comment;
import com.example.simpledms.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * packageName : com.example.jpaexam.controller.exam07
 * fileName : Qna07Controller
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
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기


    //    frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
//    frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable
    @GetMapping("/comment")
    public ResponseEntity<Object> getAnswerAll(@RequestParam String searchSelect,
                                            @RequestParam(required = false) String searchKeyword,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "3") int size)
    {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

            Page<Comment> commentPage;

            commentPage = commentService.findAll(pageable);

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

    @PostMapping("/comment")
    public ResponseEntity<Object> createAnswer(@RequestBody Comment comment) {

        try {
            Comment comment2 = commentService.save(comment);

            return new ResponseEntity<>(comment2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//  Todo : 유저 id로 검색해서 내가 쓴 댓글 모아보는 함수
    @GetMapping("/comment/{id}")
    public ResponseEntity<Object> getAnswerId(@PathVariable int qno) {

        try {
            Optional<Comment> optionalAnswer = commentService.findById(qno);



            if (optionalAnswer.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalAnswer.get(), HttpStatus.OK);
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



    @PutMapping("/comment/{qno}")
    public ResponseEntity<Object> updateAnswer(@PathVariable int qno,
                                            @RequestBody Comment comment) {

        try {
            Comment comment2 = commentService.save(comment);

            return new ResponseEntity<>(comment2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping ("/comment/deletion/{qno}")
    public ResponseEntity<Object> deleteAnswer(@PathVariable int qno) {

        try {
            boolean bSuccess = commentService.removeById(qno);

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










