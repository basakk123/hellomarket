package com.example.hellomarket.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.example.hellomarket.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;
    private final HttpSession session;

    @GetMapping(value = "/join")
    public String join() {
        return "users/joinForm";
    }

}
