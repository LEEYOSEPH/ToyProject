package com.toyproject.jpaBoard.board.controller;

import com.toyproject.jpaBoard.board.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class PostController {
    
    /*게시글 등록*/
    @PostMapping("/posts")
    public Map<String,String> posts(@RequestBody @Valid PostCreate params) {

        return Map.of();
    }
}
