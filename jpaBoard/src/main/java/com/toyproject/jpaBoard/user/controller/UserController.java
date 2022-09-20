package com.toyproject.jpaBoard.user.controller;

import com.toyproject.jpaBoard.user.dto.UserForm;
import com.toyproject.jpaBoard.user.entity.User;
import com.toyproject.jpaBoard.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;


    /*회원 가입 화면*/
    @GetMapping("/users/new")
    public void createForm() {

    }

    /*회원 가입*/
    @PostMapping("/users/new")
    public void createUser(@Valid UserForm userForm) {

         userService.createUser(userForm);

    }

    /*Email 인증 토큰*/
    @GetMapping("/users/checkEmailToken")
    public void checkEmailToken(String token, String email) {
        User user = userService.findByEmail(email);

        if (user == null) {
            /*return 
            에러 메세지 출력 wrong.email
            이메일 확인 화면으로 반환*/

        } else if (!user.isValidToken(token)) {
            /*return
            에러 메세지 출려 wrong.token
            이메일 확인 화면으로 반환*/
        }
        
        /*가입 완료 처리*/
        user.completeCreated();
        /*이메일 인증 완료 페이지로 이동*/
    }

    /*Email 인증 화면*/
    @GetMapping("/users/checkEmail")
    public void checkEmail() {
    }
}
