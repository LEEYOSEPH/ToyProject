package com.toyproject.jpaBoard.board.controller;

import com.toyproject.jpaBoard.board.request.PostCreate;
import com.toyproject.jpaBoard.board.request.PostSearch;
import com.toyproject.jpaBoard.board.response.PostResponse;
import com.toyproject.jpaBoard.board.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    
    /*게시글 등록*/
    @PostMapping("/posts")
    public void posts(@RequestBody @Valid PostCreate request) {
        postService.write(request);
    }
    
    /*게시글 단건 조회*/
    @GetMapping("/posts/{postId}")
    public PostResponse get(@PathVariable Long postId) {
        return postService.get(postId);
    }
    
    /*게시글 전체조회*/
    @GetMapping("/posts")
    public List<PostResponse> getList() {
        return postService.getList();
    }

    /*게시글 페이징 처리*/
   @GetMapping("/posts")
    public List<PostResponse> getList(@ModelAttribute PostSearch postSearch ) {
        return postService.getList(postSearch);
    }
}
