package com.example.simpledms.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * packageName : com.example.simplelogin.dto.request
 * fileName : LoginRequest
 * author : ds
 * date : 2022-11-29
 * description : 로그인 DTO
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2022-11-29         ds          최초 생성
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequest {


    @NotBlank
    private String password;

}










