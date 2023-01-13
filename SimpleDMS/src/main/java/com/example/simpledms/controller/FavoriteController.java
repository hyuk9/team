package com.example.simpledms.controller;

import com.example.simpledms.dto.FavoriteDto;
import com.example.simpledms.model.Favorite;
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
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService; // @Autowired : 스프링부트가 가동될때 생성된 객체를 하나 받아오기

    //    frontend url(쿼리스트링방식) : ? 매개변수 전송방식 사용했으면 ------> backend @RequestParam
//    frontend url(파라메터방식) : /{} 매개변수 전송방식 사용했으면 ------> backend @PathVariable
    @GetMapping("/favorite")
    public ResponseEntity<Object> getFavoriteAll(@RequestParam(required = false) Integer id,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "3") int size
    ) {

        try {

//            페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

            Page<FavoriteDto> favoritePage;

            favoritePage = favoriteService.findAllById(id, pageable);

            Map<String, Object> response = new HashMap<>();
            response.put("favorite", favoritePage.getContent());
            response.put("currentPage", favoritePage.getNumber());
            response.put("totalItems", favoritePage.getTotalElements());
            response.put("totalPages", favoritePage.getTotalPages());

            if (favoritePage.isEmpty() == false) {
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


    @DeleteMapping("/favorite/all")
    public ResponseEntity<Object> removeAll() {

        try {
            favoriteService.removeAll();

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/favorite")
    public ResponseEntity<Object> createFavorite(@RequestBody Favorite favorite) {

        try {
            Favorite favorite2 = favoriteService.save(favorite);

            return new ResponseEntity<>(favorite2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    Todo : 페이징처리 테스트용
@GetMapping("/favorite/{fid}")
public ResponseEntity<Object> getQnoId(@PathVariable Integer fid,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "3") int size) {

    try {
//            Pageable 객체 정의 ( page, size 값 설정 )
        Pageable pageable = PageRequest.of(page, size);

        Page<Favorite> favoritePage;

        favoritePage = favoriteService.findAllByFidEquals(fid,pageable);

        //            맵 자료구조에 넣어서 전송
        Map<String, Object> response = new HashMap<>();
        response.put("favorite", favoritePage.getContent());
        response.put("currentPage", favoritePage.getNumber());
        response.put("totalItems", favoritePage.getTotalElements());
        response.put("totalPages", favoritePage.getTotalPages());


        if (favoritePage.isEmpty() == false) {
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



    @GetMapping("/favorite/{id}/{dno}")
    public ResponseEntity<Object> getFavoriteId(@PathVariable Integer id, @PathVariable Integer dno) {

        try {
            Optional<Favorite> optionalFavorite = favoriteService.findByIdAndDno(id, dno);


            if (optionalFavorite.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalFavorite.get(), HttpStatus.OK);
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

    @PutMapping("/favorite/{fid}")
    public ResponseEntity<Object> updateFavorite(@PathVariable int fid,
                                             @RequestBody Favorite favorite) {

        try {
            Favorite favorite2 = favoriteService.save(favorite);

            return new ResponseEntity<>(favorite2, HttpStatus.OK);

        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/favorite/deletion/{fid}")
    public ResponseEntity<Object> deleteFavorite(@PathVariable int fid) {

        try {
            boolean bSuccess = favoriteService.removeById(fid);

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


//    Todo: 1.4 추가 currentUserId로 찜한목록 찾기함수

    @GetMapping("/favorite/id/{id}")
    public ResponseEntity<Object> getUserId(@PathVariable Integer id,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "3") int size)
    {
        try {

//            페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

            Page<FavoriteDto> favoritePage;

            favoritePage = favoriteService.findAllById(id, pageable);

            Map<String, Object> response = new HashMap<>();
            response.put("favorite", favoritePage.getContent());
            response.put("currentPage", favoritePage.getNumber());
            response.put("totalItems", favoritePage.getTotalElements());
            response.put("totalPages", favoritePage.getTotalPages());

            if (favoritePage.isEmpty() == false) {
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
//    Todo: 1.4 추가 currentUserId로 찜한목록 조회함수

    @GetMapping("/favorite/desc")
    public ResponseEntity<Object> getFavorite()
    {
        try {

            List<FavoriteDto> favoriteDtoList;

            favoriteDtoList = favoriteService.findAllBy();

            if (favoriteDtoList.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(favoriteDtoList, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    dno로 검색함수
    @GetMapping("/favorite/dno/{dno}")
    public ResponseEntity<Object> getFavoriteId(@PathVariable Integer dno) {

        try {
            Optional<FavoriteDto> optionalFavorite = favoriteService.findDnoBy(dno);

            if (optionalFavorite.isPresent() == true) {
//                데이터 + 성공 메세지 전송
                return new ResponseEntity<>(optionalFavorite.get(), HttpStatus.OK);
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










