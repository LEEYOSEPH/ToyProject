package com.toyproject.jpaBoard.board.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter @Getter
@ToString
public class PostCreate {

    @NotBlank(message = "타이틀을 입력해주세요")
    private String title;
    @NotBlank(message = "내용을 입력해주세요")
    private String content;
    @NotBlank
    private String name;


    @Builder
    public PostCreate(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }
}
