package com.example.hellomarket.service;

import org.springframework.stereotype.Service;

import com.example.hellomarket.domain.UsersRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UsersRepository userRepository;

}
