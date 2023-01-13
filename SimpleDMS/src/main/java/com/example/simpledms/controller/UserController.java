package com.example.simpledms.controller;

import com.example.simpledms.dto.ResponseMessageDto;
import com.example.simpledms.dto.request.ChangePasswordRequest;
import com.example.simpledms.dto.request.SignupRequest;
import com.example.simpledms.dto.response.UserRoleDto;
import com.example.simpledms.model.ERole;
import com.example.simpledms.model.Role;
import com.example.simpledms.model.User;
import com.example.simpledms.security.jwt.JwtUtils;
import com.example.simpledms.service.RoleService;
import com.example.simpledms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * packageName : com.example.modelexam.controller
 * fileName : UserController
 * author : kangtaegyung
 * date : 2022/10/12
 * description : 부서 컨트롤러
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/10/12         kangtaegyung          최초 생성
 */
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost")
//@CrossOrigin(origins = "http://192.168.0.166")
@RequestMapping("/api")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager; // 인증/권한체크 처리를 위한 객체

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/user")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> getUserAll(@RequestParam(required = false) String username,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "3") int size
    ) {

        try {

//            페이지 변수 저장
            Pageable pageable = PageRequest.of(page, size);

            Page<UserRoleDto> userPage;

            userPage = userService.findAllByUsernameContaining(username, pageable);

            Map<String, Object> response = new HashMap<>();
            response.put("user", userPage.getContent());
            response.put("currentPage", userPage.getNumber());
            response.put("totalItems", userPage.getTotalElements());
            response.put("totalPages", userPage.getTotalPages());

            if (userPage.isEmpty() == false) {
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

    @GetMapping("/user/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> getUserId(@PathVariable int id) {

        try {
            Optional<User> optionalUser = userService.findById(id);

            if (optionalUser.isPresent()) {
//                성공
                return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//    사용자가 DB 에 있는 지 확인
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessageDto("Error: Username is already taken!"));
        }

//    이메일이 DB 에 있는 지 확인
        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessageDto("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getName(),
                signUpRequest.getBirthday(),
                signUpRequest.getGender(),
                signUpRequest.getPhone(),
                signUpRequest.getAddress());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleService.findByRname(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleService.findByRname(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    case "manager":
                      Role managerRole = roleService.findByRname(ERole.ROLE_MANAGER)
                          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                      roles.add(managerRole);

                      break;

                    default:
                        Role userRole = roleService.findByRname(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRole(roles);
        userService.save(user);

        return ResponseEntity.ok(new ResponseMessageDto("User create successfully!"));
    }

    @PutMapping("/user/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> updateUser(@PathVariable long id, @RequestBody SignupRequest signUpRequest) {

//        패스워드 변수
        String password = "";

        log.debug("signUpRequest {}", signUpRequest);
        // Create new user's account
        if(signUpRequest.isChangePwd()) {
            password = encoder.encode(signUpRequest.getPassword());
        } else {
            password = signUpRequest.getPassword();
        }
        User user = new User( id,
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                password,
                signUpRequest.getName(),
                signUpRequest.getBirthday(),
                signUpRequest.getGender(),
                signUpRequest.getPhone(),
                signUpRequest.getAddress());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleService.findByRname(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "ROLE_ADMIN":
                        Role adminRole = roleService.findByRname(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    case "ROLE_MANAGER":
                        Role managerRole = roleService.findByRname(ERole.ROLE_MANAGER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(managerRole);

                        break;

                    default:
                        Role userRole = roleService.findByRname(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRole(roles);
        userService.save(user);

        return ResponseEntity.ok(new ResponseMessageDto("User update successfully!"));
    }

    @DeleteMapping("/user/deletion/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {

//        프론트엔드 쪽으로 상태정보를 보내줌
        try {
            boolean bSuccess = userService.removeById(id);

            if (bSuccess == true) {
//                delete 문이 성공했을 경우
                return new ResponseEntity<>(HttpStatus.OK);
            }
//            delete 실패했을 경우( 0건 삭제가 될경우 )
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
//            DB 에러가 날경우
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/user/all")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> deleteAll() {

//        프론트엔드 쪽으로 상태정보를 보내줌
        try {
            userService.removeAll();

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
//            DB 에러가 날경우
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    todo: (12/30 추가) : 아이디 찾을 시 이메일 입력 받은 걸로 회원 확인 후 아이디 정보 주기 함수
    @GetMapping("/user/email/{email}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> getUserEmail(@PathVariable String  email) {

        try {
            Optional<User> optionalUser = userService.findByEmail(email);
            if (!optionalUser.get().getUsername().isEmpty() ) {
//                성공
                return new ResponseEntity<>(optionalUser.get().getUsername().charAt(0) + "**" + optionalUser.get().getUsername().substring(3) , HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    todo: (12/30 추가) : 비번 찾을 시 아이디,이메일 입력 받은 걸로 회원 있는지 확인하는 함수
    @GetMapping("/user/findPw/username/{username}/email/{email}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> getUsernameAndEmail(@PathVariable String  username, @PathVariable String  email) {

        try {
            boolean existsUsername = userService.existsByUsername(username);
            boolean existsEmail = userService.existsByEmail(email);
            if (existsUsername && existsEmail) {
//                성공
                    return new ResponseEntity<>(email, HttpStatus.OK);

            } else {
//                데이터 없음
                return new ResponseEntity<>( HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
//            서버 에러
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//   todo: 12/30 비밀번호 재설정 함수
@PutMapping("/user/changePw/email/{email}")
//    @PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<Object> updatePassword(@PathVariable String  email, @RequestBody ChangePasswordRequest changePasswordRequest) {
    log.debug(changePasswordRequest.getPassword());
    try {
        String password = encoder.encode(changePasswordRequest.getPassword());

//       이메일에 맞는 유저 정보 들고와서
        Optional<User> optionalUser = userService.findByEmail(email);

        User userData = optionalUser.get();

        User user = new User(
                userData.getId(),
                userData.getUsername(),
                userData.getEmail(),
                password,
                userData.getName(),
                userData.getBirthday(),
                userData.getGender(),
                userData.getPhone(),
                userData.getAddress(),
                userData.getRole()
        );
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
}

















