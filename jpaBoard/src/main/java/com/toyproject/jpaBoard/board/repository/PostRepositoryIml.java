package com.toyproject.jpaBoard.board.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toyproject.jpaBoard.board.domain.Post;
import com.toyproject.jpaBoard.board.domain.QPost;
import com.toyproject.jpaBoard.board.request.PostSearch;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.toyproject.jpaBoard.board.domain.QPost.post;

@RequiredArgsConstructor
public class PostRepositoryIml implements PostRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Post> getList(PostSearch postSearch) {
       return jpaQueryFactory.selectFrom(post)
                .limit(postSearch.getSize())
                .offset(postSearch.getOffset())
               .orderBy(post.id.desc())
                .fetch();
    }
}
