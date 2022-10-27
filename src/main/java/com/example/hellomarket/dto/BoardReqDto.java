package com.example.hellomarket.dto;

import com.example.hellomarket.domain.Board;

import lombok.Getter;
import lombok.Setter;

public class BoardReqDto {

    @Setter
    @Getter
    public static class BoardSaveReqDto {
        private String title;
        private String content;
        private SessionUser sessionUser;; // 서비스 로직

        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .user(sessionUser.toEntity())
                    .build();
        }
    }

    @Setter
    @Getter
    public static class BoardUpdateReqDto {
        private String title;
        private String content;
        private Long id; // 서비스 로직

        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .id(id)
                    .build();
        }
    }

}
