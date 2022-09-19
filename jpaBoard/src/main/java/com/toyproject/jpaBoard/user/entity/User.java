package com.toyproject.jpaBoard.user.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private LocalDateTime registerDt;

    private LocalDateTime updateDt;


}
