package com.example.simpledms.service;

import com.example.simpledms.model.Favorite;
import com.example.simpledms.model.Free;
import com.example.simpledms.model.Menu;
import com.example.simpledms.repository.FavoriteRepository;
import com.example.simpledms.repository.FreeRepository;
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
 * fileName : QnaService
 * author : ds
 * date : 2022-10-20
 * description : 부서 업무 서비스 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-10-20         ds          최초 생성
 */
@Service
public class FavoriteService {

    @Autowired
    FavoriteRepository favoriteRepository; // JPA CRUD 함수가 있는 인터페이스

    //    전체 조회 함수( 페이징 처리 )
    public Page<Favorite> findAll(Pageable pageable) {
        Page<Favorite> page = favoriteRepository.findAll(pageable);

        return page;
    }

    //    전체 삭제 함수
    public void removeAll() {
        favoriteRepository.deleteAll(); // 전체 삭제
    }

    //   부서 정보 저장/수정 함수
    public Favorite save(Favorite favorite) {

        Favorite favorite2 = favoriteRepository.save(favorite);

        return favorite2;
    }

    //    부서번호로 조회하는 함수
    public Optional<Favorite> findById(int fid) {
//        findById(기본키속성)
        Optional<Favorite> optionalFavorite = favoriteRepository.findById(fid);

        return optionalFavorite;
    }

    // 부서번호(no)로 삭제하는 함수
    public boolean removeById(int dno) {
//        existsById(기본키) 있으면 삭제 실행 + true 리턴
        if(favoriteRepository.existsById(dno) == true) {


            favoriteRepository.deleteById(dno);
            return true;
        }

//        없으면 그냥 false 리턴
        return false;
    }

    //    question(질문) like 검색 함수 ( 페이징 처리 )
    public Page<Favorite> findAllByFidOrderByDno(Integer dno, Pageable pageable) {
        Page<Favorite> page = favoriteRepository.findAllByFidOrderByDno(dno, pageable);
        return page;
    }

    //    ✅ dname like 검색 함수
    public Optional<Favorite> findByIdAndDno(Integer id, Integer dno) {
        Optional<Favorite> optional = favoriteRepository.findByIdAndDno(id, dno);

        return optional;
    }


}









