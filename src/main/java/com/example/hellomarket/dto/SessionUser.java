package com.example.hellomarket.dto;

import com.example.hellomarket.domain.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SessionUser {
    private Long id;
    private String username;

    public SessionUser(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public User toEntity() {
        return User.builder().id(id).username(username).build();
    }
}
