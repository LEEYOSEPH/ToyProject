package com.toyproject.jpaBoard.user.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder
public class User {

    @Id @GeneratedValue
    @Column(name = "userId")
    private Long id;

    private String email;

    private String password;

    private String name;

    private String emailCheckToken;
    private boolean emailVerified;

    private LocalDateTime registerDt;

    private LocalDateTime updateDt;


    public void generateEmailCheckToken() {
        this.emailCheckToken = UUID.randomUUID().toString();
    }

    public boolean isValidToken(String token) {
        return this.emailCheckToken.equals(token);
    }

    public void completeCreated() {
        this.emailVerified = true;
        this.registerDt = LocalDateTime.now();
    }
}
