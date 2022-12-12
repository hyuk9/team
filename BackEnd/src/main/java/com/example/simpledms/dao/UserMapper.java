package com.example.simpledms.dao;

import com.example.simpledms.dto.page.Criteria;
import com.example.simpledms.dto.response.UserRoleCDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.taegyungboard.dao
 * fileName : UserMapper
 * author : kangtaegyung
 * date : 2022/05/25
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/05/25         kangtaegyung          최초 생성
 */
@Mapper
public interface UserMapper {

    List<UserRoleCDto> findByName(Criteria criteria);

    long countByUsername(String username);
}
