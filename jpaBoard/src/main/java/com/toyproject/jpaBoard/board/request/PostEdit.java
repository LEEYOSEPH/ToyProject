package com.toyproject.jpaBoard.board.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class PostEdit {

    @NotBlank(message = "타이틀을 입력해주세요")
    private String title;
    @NotBlank(message = "내용을 입력해주세요")
    private String content;



    @Builder
    public PostEdit(String title, String content) {
        this.title = title;
        this.content = content;

    }
}
