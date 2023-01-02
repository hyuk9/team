package com.example.simpledms.controller;

import com.example.simpledms.model.Qna;
import com.example.simpledms.model.Question;
import com.example.simpledms.service.QnaService;
import com.example.simpledms.service.QuestionService;
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
public class QuestionController {

    @Autowired
    QuestionService questionService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기


    //    frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
//    frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable
    @GetMapping("/question")
    public ResponseEntity<Object> getQuestionAll(@RequestParam String searchSelect,
                                            @RequestParam(required = false) String searchKeyword,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "3") int size)
    {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

            Page<Question> questionPage;

//            Page 객체 정의
            if( searchSelect.equals("제목")) {
                questionPage = questionService.findAllByTitleContainingOrderByInsertTimeDescQuestionNoDesc(searchKeyword, pageable);
            } else {
                questionPage = questionService.findAllByWriterContainingOrderByInsertTimeDescQuestionNoDesc(searchKeyword, pageable);
            }

            //            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("question", questionPage.getContent());
            response.put("currentPage", questionPage.getNumber());
            response.put("totalItems", questionPage.getTotalElements());
            response.put("totalPages", questionPage.getTotalPages());

            if (questionPage.isEmpty() == false) {
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


    @DeleteMapping("/question/all")
    public ResponseEntity<Object> removeAll() {

        try {
            questionService.removeAll();

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/question")
    public ResponseEntity<Object> createQuestion(@RequestBody Question question) {

        try {
            Question question2 = questionService.save(question);

            return new ResponseEntity<>(question2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/question/{questionNo}")
    public ResponseEntity<Object> getQuestionId(@PathVariable int questionNo) {

        try {
            Optional<Question> optionalQuestion = questionService.findById(questionNo);



            if (optionalQuestion.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalQuestion.get(), HttpStatus.OK);
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

    @PutMapping("/question/{questionNo}")
    public ResponseEntity<Object> updateQuestion(@PathVariable int questionNo,
                                            @RequestBody Question question) {

        try {
            Question question2 = questionService.save(question);

            return new ResponseEntity<>(question2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping ("/question/deletion/{questionNo}")
    public ResponseEntity<Object> deleteQuestion(@PathVariable int questionNo) {

        try {
            boolean bSuccess = questionService.removeById(questionNo);

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










