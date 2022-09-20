package com.toyproject.jpaBoard.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    /*로그인 화면*/
    @GetMapping("/login")
    public void login() {
    }
}
