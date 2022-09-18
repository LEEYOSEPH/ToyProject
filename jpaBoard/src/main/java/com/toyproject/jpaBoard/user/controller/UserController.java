package com.toyproject.jpaBoard.user.controller;

import com.toyproject.jpaBoard.user.dto.MemberForm;
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
    public void createUser(@Valid MemberForm memberForm) {

        userService.createUser(memberForm);

    }
}
