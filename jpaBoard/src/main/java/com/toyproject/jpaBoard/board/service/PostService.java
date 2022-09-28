package com.toyproject.jpaBoard.board.service;

import com.toyproject.jpaBoard.board.domain.Post;
import com.toyproject.jpaBoard.board.repository.PostRepository;
import com.toyproject.jpaBoard.board.request.PostCreate;
import com.toyproject.jpaBoard.board.request.PostSearch;
import com.toyproject.jpaBoard.board.response.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void write(PostCreate postCreate) {

        Post post = Post.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();

        postRepository.save(post);
    }

    public PostResponse get(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow();

        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public List<PostResponse> getList() {
        return postRepository.findAll().stream()
                .map(post -> new PostResponse(post))
                        .collect(Collectors.toList());
    }

    public List<PostResponse> getList(PostSearch postSearch ) {
        return postRepository.getList(postSearch).stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }
}
