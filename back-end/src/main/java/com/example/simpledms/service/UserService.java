package com.example.simpledms.service;

import com.example.simpledms.dao.UserMapper;
import com.example.simpledms.dto.page.Criteria;
import com.example.simpledms.dto.response.UserRoleCDto;
import com.example.simpledms.dto.response.UserRoleDto;
import com.example.simpledms.model.User;
import com.example.simpledms.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.simpledms.service
 * fileName : UserServcie
 * author : hyuk
 * date : 2022/11/30
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022/11/30         hyuk          최초 생성
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository; // JPA CRUD 함수가 있는 인터페이스

    @Autowired
    UserMapper userMapper; // Mybatis CRUD 함수가 있는 인터페이스

    //    ✅ 전체 조회 함수 findAll() 👉 변경 findAll(Pageable pageable)
    public Page<User> findAll(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);

        return page;
    }

//    ✅ id로 조회하는 함수

    public Optional<User> findById(long id) {
//        findById(기본키)
        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser;
    }


    //    ✅ 전체 삭제 함수
    public void removeAll() {
        userRepository.deleteAll();
    }


    //       ✅ 부서 정보 저장 함수
    public User save(User user) {
        User user2 = userRepository.save(user);
        return user2;
    }

    //       ✅ 부서 정보 삭제 함수
    public boolean removeById(long id) {
//        existById(기본키) 있으면 삭제 실행 + true 리턴
        if (userRepository.existsById(id) == true) {
            userRepository.deleteById(id);
            return true;
        }
//        없으면 그냥 false 리턴
        return false;
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

//    //    ✅ username like 검색 함수 ( 페이징 처리 추가 )
//    public Page<UserRoleDto> findAllByUsernameContaining(String username, Pageable pageable) {
//        Page<UserRoleDto> list = userRepository.findAllByUsernameContaining(username, pageable);
//
//        return list;
//    }


    //    dname like 검색
    public List<UserRoleCDto> findAllByUsernameContaining(Criteria criteria) {

//        페이징 처리를 위한 총건수 구하기 위해 검색 테이블 건수 세기 함수 실행
        long totalCount = userMapper.countByUsername(criteria.getUsername());

//		Tutorials 총 건수
        criteria.setTotalItems(totalCount);
        //	테이블 총 건수 / 페이지당 출력할 데이터 개수(size)
        criteria.setTotalPages(totalCount/criteria.getSize());

        List<UserRoleCDto> userList = userMapper.findByName(criteria);

        return userList;
    }


}
