package com.toyproject.jpaBoard.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping("/posts")
    public String getPosts() {
        return "zzz";
    }
}