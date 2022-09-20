package com.toyproject.jpaBoard.user.repository;

import com.toyproject.jpaBoard.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
