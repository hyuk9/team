package com.example.simpledms.controller;

import com.example.simpledms.model.Announce;
import com.example.simpledms.model.Qna;
import com.example.simpledms.model.User;
import com.example.simpledms.service.AnnounceService;
import com.example.simpledms.service.QnaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
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
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AnnounceController {

    @Autowired
    AnnounceService announceService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

//    frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
//    frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable
    @GetMapping("/announce")
    public ResponseEntity<Object> getAnnounceAll(@RequestParam String searchSelect,
                                            @RequestParam(required = false) String searchKeyword,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "3") int size)
    {

        try {
//            Pageable 객체 정의 ( page, size 값 설정 )
            Pageable pageable = PageRequest.of(page, size);

            Page<Announce> announcePage;

//            Page 객체 정의
            if( searchSelect.equals("작성자")) {
                announcePage = announceService.findAllByWriterContainingOrderByInsertTimeDescAnoDesc(searchKeyword, pageable);
            } else {
                announcePage = announceService.findAllByTitleContainingOrderByInsertTimeDescAnoDesc(searchKeyword, pageable);
            }

            //            맵 자료구조에 넣어서 전송
            Map<String, Object> response = new HashMap<>();
            response.put("announce", announcePage.getContent());
            response.put("currentPage", announcePage.getNumber());
            response.put("totalItems", announcePage.getTotalElements());
            response.put("totalPages", announcePage.getTotalPages());

            if (announcePage.isEmpty() == false) {
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


    @DeleteMapping("/announce/all")
    public ResponseEntity<Object> removeAll() {

        try {
            announceService.removeAll();

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/announce")
    public ResponseEntity<Object> createAnnounce(@RequestBody Announce announce) {

        try {
            Announce announce2 = announceService.save(announce);

            return new ResponseEntity<>(announce2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/announce/{ano}")
    public ResponseEntity<Object> getAnnounceId(@PathVariable int ano) {

        try {
            Optional<Announce> optionalAnnounce = announceService.findById(ano);

            

            if (optionalAnnounce.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalAnnounce.get(), HttpStatus.OK);
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

    @PutMapping("/announce/{ano}")
    public ResponseEntity<Object> updateAnnounce(@PathVariable int ano,
                                            @RequestBody Announce announce) {

        try {
            Announce announce2 = announceService.save(announce);

            return new ResponseEntity<>(announce2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping ("/announce/deletion/{ano}")
    public ResponseEntity<Object> deleteAnnounce(@PathVariable int ano) {

        try {
            boolean bSuccess = announceService.removeById(ano);

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

//    조회수 추가 함수0104
@PutMapping("/announce/plusviews/{ano}")
public ResponseEntity<Object> updateAnnounceViews(@PathVariable int ano) {

    try {


//       이메일에 맞는 유저 정보 들고와서
        Optional<Announce> optionalAnnounce = announceService.findById(ano);

        Announce announceData = optionalAnnounce.get();
        Integer plusViews = announceData.getViews() +1;

        announceData.setViews(plusViews);

        announceService.save(announceData);
        return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

}










