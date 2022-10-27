package com.example.hellomarket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hellomarket.domain.Board;
import com.example.hellomarket.domain.BoardRepository;
import com.example.hellomarket.domain.UserRepository;
import com.example.hellomarket.dto.BoardReqDto.BoardSaveReqDto;
import com.example.hellomarket.dto.BoardReqDto.BoardUpdateReqDto;
import com.example.hellomarket.dto.BoardRespDto.BoardAllRespDto;
import com.example.hellomarket.dto.BoardRespDto.BoardDetailRespDto;
import com.example.hellomarket.dto.BoardRespDto.BoardSaveRespDto;
import com.example.hellomarket.dto.BoardRespDto.BoardUpdateRespDto;

import lombok.RequiredArgsConstructor;

// 트랜잭션 관리
// Dto 변환해서 컨트롤러에게 돌려줘야 함

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public BoardSaveRespDto save(BoardSaveReqDto boardSaveReqDto) {
        // 핵심 로직
        Board boardPS = boardRepository.save(boardSaveReqDto.toEntity());

        // DTO 전환
        BoardSaveRespDto boardSaveRespDto = new BoardSaveRespDto(boardPS);

        return boardSaveRespDto;
    }

    @Transactional(readOnly = true)
    public BoardDetailRespDto findById(Long id) {
        Optional<Board> boardOP = boardRepository.findById(id);
        if (boardOP.isPresent()) {
            BoardDetailRespDto boardDetailRespDto = new BoardDetailRespDto(boardOP.get());
            return boardDetailRespDto;
        } else {
            throw new RuntimeException("해당 " + id + "로 상세보기를 할 수 없습니다");
        }
    }

    @Transactional
    public BoardUpdateRespDto update(BoardUpdateReqDto boardUpdateReqDto) {
        Long id = boardUpdateReqDto.getId();
        Optional<Board> boardOP = boardRepository.findById(id);
        if (boardOP.isPresent()) {
            Board boardPS = boardOP.get();
            boardPS.update(boardUpdateReqDto.getTitle(), boardUpdateReqDto.getContent());
            return new BoardUpdateRespDto(boardPS);
        } else {
            throw new RuntimeException("해당 " + id + "로 수정을 할 수 없습니다.");
        }

    } // 트랜잭션 종료시 -> 더티체킹을 함

    @Transactional(readOnly = true)
    public List<BoardAllRespDto> findAll() {
        List<Board> boardList = boardRepository.findAll();

        List<BoardAllRespDto> boardAllRespDtoList = new ArrayList<>();
        for (Board board : boardList) {
            boardAllRespDtoList.add(new BoardAllRespDto(board));
        }
        return boardAllRespDtoList;
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Board> boardOP = boardRepository.findById(id);
        if (boardOP.isPresent()) {
            boardRepository.deleteById(id);
        } else {
            throw new RuntimeException("해당 " + id + "로 삭제를 할 수 없습니다");
        }

    }
}
