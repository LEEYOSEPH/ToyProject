package com.toyproject.jpaBoard.board.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostEditor {

    // 수정 가능한 필드들만 정리
    private final String title;
    private final String content;

    @Builder
    public PostEditor(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
