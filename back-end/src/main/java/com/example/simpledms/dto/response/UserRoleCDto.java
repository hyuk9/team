package com.example.simpledms.dto.response;

import com.example.simpledms.model.ERole;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * packageName : com.example.simpledms.dto
 * fileName : UserDto
 * author : kangtaegyung
 * date : 2022/11/27
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/27         kangtaegyung          최초 생성
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleCDto {

    private Long id;

    //  로그인 ID 임
    private String username;

    private String email;

    private String password;

    private Integer rid;

    private ERole name;
}
