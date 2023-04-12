package com.hsc.auth.service;

import com.hsc.auth.dto.BoardRequestDto;
import com.hsc.auth.dto.BoardResponseDto;
import com.hsc.auth.model.Board;
import com.hsc.auth.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board save(BoardRequestDto boardRequestDto, String fileUrl) {
        System.out.println("------------------" + fileUrl +"-----------------");
        fileUrl = fileUrl.replace("[", "").replace("]", "");
        System.out.println("------------------" + fileUrl +"-----------------");
        boardRequestDto.setFileUrl(fileUrl);
        boardRequestDto.setViews(0);
        return boardRepository.save(boardRequestDto.toEntity());
    }

    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAll() {
        List<Board> entity = boardRepository.findAll();
        return entity.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

}
