package com.toyproject.jpaBoard.board.repository;

import com.toyproject.jpaBoard.board.domain.Post;
import com.toyproject.jpaBoard.board.request.PostSearch;

import java.util.List;

public interface PostRepositoryCustom {

    List<Post> getList(PostSearch postSearch);
}
