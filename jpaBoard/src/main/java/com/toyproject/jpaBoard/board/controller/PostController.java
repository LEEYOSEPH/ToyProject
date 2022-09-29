package com.toyproject.jpaBoard.board.controller;

import com.toyproject.jpaBoard.board.request.PostCreate;
import com.toyproject.jpaBoard.board.request.PostEdit;
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

    /*게시글 페이징 처리*/
   @GetMapping("/posts")
    public List<PostResponse> getList(@ModelAttribute PostSearch postSearch ) {
        return postService.getList(postSearch);
    }

    /*게시글 수정*/
    @PatchMapping("/posts/{postId}")
    public void edit(@PathVariable Long postId, @RequestBody @Valid PostEdit request) {
        postService.edit(postId,request);
    }

    /*게시글 삭제*/
    @DeleteMapping("/posts/{postId}")
    public void delete(@PathVariable Long postId) {
        postService.delete(postId);
    }
}
