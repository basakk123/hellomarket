package com.example.hellomarket.dto;

import com.example.hellomarket.domain.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SessionUser {
    private Long id;
    private String username;

    public SessionUser(Users user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public Users toEntity() {
        return Users.builder().id(id).username(username).build();
    }
}
