package com.example.hellomarket.dto;

import com.example.hellomarket.domain.Users;

import lombok.Getter;
import lombok.Setter;

public class UsersRespDto {

    @Setter
    @Getter
    public static class JoinRespDto {
        private Long id;
        private String username;

        // 응답의 DTO는 생성자로 처리한다 엔티티를 받아서 dto로
        public JoinRespDto(Users user) {
            this.id = user.getId();
            this.username = user.getUsername();
        }
    }

    @Setter
    @Getter
    public static class UpdatePasswordRespDto {
        private Long id;
        private String username;

        public UpdatePasswordRespDto(Users user) {
            this.id = user.getId();
            this.username = user.getUsername();
        }
    }

    @Setter
    @Getter
    public static class InfoRespDto {
        private Long id;
        private String username;

        public InfoRespDto(Users user) {
            this.id = user.getId();
            this.username = user.getUsername();
        }
    }
}
