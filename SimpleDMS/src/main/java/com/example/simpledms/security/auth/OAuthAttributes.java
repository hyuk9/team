package com.example.simpledms.security.auth;


import com.example.simpledms.model.ERole;
import com.example.simpledms.model.Role;
import com.example.simpledms.model.User;
import lombok.Builder;
import lombok.Getter;
import net.minidev.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * packageName : com.example.simplelogin.security.auth
 * fileName : OAuthAttributes
 * author : kangtaegyung
 * date : 2022/12/16
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/16         kangtaegyung          최초 생성
 */

@Getter
public class OAuthAttributes {
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String username;
    private String email;

    private String name;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey, String username,
                           String email, String name) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.username = username;
        this.email = email;
        this.name = name;
    }
    //    registrationId 를 체크해서 구글 / 네이버 / 카카오 정보 가져오기
    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {
        switch (registrationId) {
            case "google":
                return ofGoogle(userNameAttributeName, attributes);
            case "naver":
                return ofNaver(userNameAttributeName, attributes);
            case "kakao":
                return ofKakao(userNameAttributeName, attributes);
            default:
                return ofGoogle(userNameAttributeName, attributes);
        }
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName,
                                            Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .username(((String) attributes.get("email")).split("@")[0])
                .email((String) attributes.get("email"))
                .name((String) attributes.get("family_name") + (String) attributes.get("given_name"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName,
                                           Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .username(((String) response.get("email")).split("@")[0])
                .email((String) response.get("email"))
                .name((String) response.get("name"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName,
                                           Map<String, Object> attributes) {
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");

        // 이름 받을 수 없어서 대신 프로필 정보의 닉네일을 이름으로 쓰기
        JSONObject jsonObject = new JSONObject((Map<String, ?>) kakaoAccount.get("profile"));
        String nickname = (String) jsonObject.get("nickname");

        return OAuthAttributes.builder()
                .username(((String) kakaoAccount.get("email")).split("@")[0])
                .email((String) kakaoAccount.get("email"))
                .name(nickname)
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }


    //    OAuthAttributes에서 엔티티를 생성하는 시점은 처음 가입할 때
//    User 엔티티를 생성
    public User toEntity() {
        Set<Role> roles = new HashSet<>();
        Role userRole = new Role();
        userRole.setRid(1);
        userRole.setRname(ERole.ROLE_USER);

        roles.add(userRole); // 기본 User 롤 추가

        return User.builder()
                .username((String)this.email.split("@")[0])
                .email(this.email)
                .name(this.name)
                .password(encoder.encode("123456"))
                .role(roles)
                .build();
    }
}
