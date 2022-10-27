package com.example.hellomarket.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RestController;

import com.example.hellomarket.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final HttpSession session;

}
