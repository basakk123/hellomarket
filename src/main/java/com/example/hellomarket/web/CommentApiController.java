package com.example.hellomarket.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RestController;

import com.example.hellomarket.service.CommentsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentsService commentsService;
    private final HttpSession session;

}
