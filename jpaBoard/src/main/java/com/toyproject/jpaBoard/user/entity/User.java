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

    private LocalDateTime registerDt;

    private LocalDateTime updateDt;


    public void generateEmailCheckToken() {
        this.emailCheckToken = UUID.randomUUID().toString();
    }
}
