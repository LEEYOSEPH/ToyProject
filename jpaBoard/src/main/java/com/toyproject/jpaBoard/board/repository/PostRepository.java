package com.toyproject.jpaBoard.board.repository;

import com.toyproject.jpaBoard.board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long>,PostRepositoryCustom {
}
