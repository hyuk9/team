package com.example.simpledms.configuration;

import com.example.simpledms.security.auth.CustomOAuth2UserService;
import com.example.simpledms.security.auth.OAuth2SuccessHandler;
import com.example.simpledms.security.jwt.AuthEntryPointJwt;
import com.example.simpledms.security.jwt.AuthTokenFilter;
import com.example.simpledms.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration : 스프링부트 설정 클래스
@Configuration
// @EnableGlobalMethodSecurity : 시큐리티 적용을 위한 @ , prePostEnabled ( 권한관리 옵션 )
@EnableGlobalMethodSecurity(
    prePostEnabled = true)
// spring security 버젼 올라가면서 : extends WebSecurityConfigurerAdapter 사용 않함
public class WebSecurityConfig {

// DB 조회해서 User 객체가 있으면 UserDetails 로 리턴하는 함수가 있는 객체
  @Autowired
UserDetailsServiceImpl userDetailsService;

  @Autowired
  private AuthEntryPointJwt unauthorizedHandler; // 웹토큰 예외처리 객체


  // todo : 소셜 로그인으로 인한 추가
  @Autowired
  private OAuth2SuccessHandler oAuth2SuccessHandler;

  // todo : 소셜 로그인으로 인한 추가, 구글 로그인 이후 가져온 사용자의 정보(email,name,picture등) 들을 기반으로 가입 및 정보수정, 세션 저장 등의 기능을 지원
  @Autowired
  private CustomOAuth2UserService customOAuth2UserService;

//  spring security 웹토큰 필터 클래스 없음
//  JWT 웹토큰 필터 객체 생성
  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

//  DB 에서 가져온 정보와 input 된 정보를 비교하는 함수
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    //  db에서 가져온 정보와 input 된 정보를 비교하는 객체
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       
      authProvider.setUserDetailsService(userDetailsService); // DB 유저 조회 함수 객체
      authProvider.setPasswordEncoder(passwordEncoder()); // 암호 적용된 페스워드
   
      return authProvider;
  }

//  AuthenticationManager 클래스 : 인증을 담당하는 클래스
//  AuthenticationManager 를 클래스 외부에서(컨트롤러) 사용하기 위해
//  아래 함수 정의 않하면 @Autodwired 로 가져올 때 에러가 발생할 수 있음
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

//  패스워드 암호화 함수
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(); // BCrypt 암호화 알고리즘 적용
  }

  /*
   * 스프링 시큐리티 룰을 무시하게 하는 Url 규칙(여기 등록하면 규칙 적용하지 않음)
   */
  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.ignoring().antMatchers("/js/**", "/images/**", "/css/**");
  }

//  스프링 시큐리티 룰을 무시하게 하는 Url 규칙(여기 등록하면 규칙 적용하지 않음)
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors()     // REST API 연결 cors (url 체크)
            .and(). // 연결
            csrf().disable() // csrf 보안 비활성화
            // 인증 예외처리는 AuthEntryPointJwt(웹토큰 예외처리클래스)
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
            // 세션안쓰고(stateful) JWT 사용 예정
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            // /api/auth/** url 은 모든 사용자 접근 허용
//            TODO: /api/** 통과시키는(접속허영) 걸로 수정
        .authorizeRequests().antMatchers("/api/**").permitAll()
            //            TODO 4) /auth-redirect 추가(front 쪽에서 리다이렉트)
            .antMatchers("/api/test/**", "/auth-redirect").permitAll()
            // 그 외 url 은 인증 필요
        .anyRequest().authenticated()
//    TODO 5) OAUTH2 로그인 기능에 대한 진입점 추가 -> 실행될 클래스 정의
            .and()
            .oauth2Login()// 간편로그인 인증
            // 성공하면 실행됨(#2), 토큰발행 , Vue 리다이렉트(/auth-redirect?토큰&이메일등)
            .successHandler(oAuth2SuccessHandler)
//                로그인 성공 이후 토큰 발행
//                OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당합니다.
            .userInfoEndpoint()
////                소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록
////                리소스 서버(즉, 소셜 서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있음
            .userService(customOAuth2UserService); // 성공하면 실행됨(#1), 유저정보 DB저장

    // DB와 입력값(id, pwd) 비교 함수 호출(내부적으로 패스워드 암호화)
    http.authenticationProvider(authenticationProvider());

//    authenticationJwtTokenFilter() : 웹토큰 필터 적용하는 부분
//    (유저패스워드체크 필터 앞에 끼여넣기)
    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class); // JWT 토큰 필터 적용
    
    return http.build();
  }
}








