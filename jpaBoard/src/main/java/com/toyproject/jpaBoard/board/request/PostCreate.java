package com.toyproject.jpaBoard.board.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Setter @Getter
@ToString
public class PostCreate {

    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotBlank
    private String name;
}
