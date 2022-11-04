package com.example.hellomarket.dto;

import com.example.hellomarket.domain.Board;
import com.example.hellomarket.domain.Comments;
import com.example.hellomarket.domain.Users;

import lombok.Getter;
import lombok.Setter;

public class CommentRespDto {

    @Setter
    @Getter
    public static class CommentSaveRespDto {
        private Long id;
        private String content;

        private UserDto user;
        private BoardDto board;

        @Setter
        @Getter
        public static class UserDto {
            private Long id;
            private String username;

            public UserDto(Users user) {
                this.id = user.getId(); // Lazy Loading
                this.username = user.getUsername();
            }
        }

        @Setter
        @Getter
        public static class BoardDto {
            private Long id;

            public BoardDto(Board board) {
                this.id = board.getId(); // Lazy Loading
            }
        }

        public CommentSaveRespDto(Comments comments) {
            this.id = comments.getId();
            this.content = comments.getContent();
            this.board = new BoardDto(comments.getBoard());
            this.user = new UserDto(comments.getUsers());
        }
    }
}
