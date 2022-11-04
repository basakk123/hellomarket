package com.example.hellomarket.dto;

import com.example.hellomarket.domain.Board;
import com.example.hellomarket.domain.Comments;

import lombok.Getter;
import lombok.Setter;

public class CommentReqDto {

    @Setter
    @Getter
    public static class CommentSaveReqDto {
        private String content;
        private Long boardId;
        private SessionUser sessionUser; // 서비스 로직

        public Comments toEntity(Board board) {
            return Comments.builder()
                    .content(content)
                    .board(board)
                    .users(sessionUser.toEntity())
                    .build();
        }
    }
}
