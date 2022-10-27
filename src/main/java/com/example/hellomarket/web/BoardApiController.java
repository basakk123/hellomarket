package com.example.hellomarket.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RestController;

import com.example.hellomarket.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;
    private final HttpSession session;

}