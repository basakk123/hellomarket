package com.example.hellomarket.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hellomarket.domain.Board;
import com.example.hellomarket.domain.BoardRepository;
import com.example.hellomarket.domain.Comments;
import com.example.hellomarket.domain.CommentsRepository;
import com.example.hellomarket.dto.CommentReqDto.CommentSaveReqDto;
import com.example.hellomarket.dto.CommentRespDto.CommentSaveRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentsService {

    private final CommentsRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public CommentSaveRespDto save(CommentSaveReqDto commentSaveReqDto) {
        // 1. Board 가 있는지 확인
        Optional<Board> boardOP = boardRepository.findById(commentSaveReqDto.getBoardId());
        if (boardOP.isPresent()) {
            // 2. Comment 객체 만들기
            Comments comments = commentSaveReqDto.toEntity(boardOP.get());
            Comments commentsPS = commentRepository.save(comments);
            CommentSaveRespDto commentSaveRespDto = new CommentSaveRespDto(commentsPS);
            return commentSaveRespDto;
        } else {
            throw new RuntimeException("게시글이 없어서 댓글을 쓸 수 없습니다");
        }

    }

}
