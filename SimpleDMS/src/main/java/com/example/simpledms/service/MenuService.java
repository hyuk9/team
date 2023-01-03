package com.example.simpledms.service;

import com.example.simpledms.model.Menu;
import com.example.simpledms.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class MenuService {

    @Autowired
    MenuRepository menuRepository; // JPA CRUD 함수가 있는 인터페이스

    //    ✅ 전체 조회 함수
    public List<Menu> findAll() {
        List<Menu> list = menuRepository.findAll();

        return list;
    }

//    ✅ id로 조회하는 함수

    public List<Menu> findAllByDnoEquals(int dno) {
//        findById(기본키)
        List<Menu> list = menuRepository.findAllByDnoEquals(dno);

        return list;
    }


    //    ✅ 전체 삭제 함수
    public void removeAll() {
        menuRepository.deleteAll();
    }


    //       ✅ 부서 정보 저장 함수
    public Menu save(Menu menu) {
        Menu menu2 = menuRepository.save(menu);
        return menu2;
    }

    //       ✅ 부서 정보 삭제 함수
    public boolean removeById(int menuId) {
//        existById(기본키) 있으면 삭제 실행 + true 리턴
        if (menuRepository.existsById(menuId) == true) {
            menuRepository.deleteById(menuId);
            return true;
        }
//        없으면 그냥 false 리턴
        return false;
    }

    //    ✅ dname like 검색 함수
    public List<Menu> findAllByMenuNameContaining(String menuName) {
        List<Menu> list = menuRepository.findAllByMenuNameContaining(menuName);

        return list;
    }

}








