package com.hsc.auth.controller;

import com.hsc.auth.dto.BoardRequestDto;
import com.hsc.auth.dto.BoardResponseDto;
import com.hsc.auth.model.Board;
import com.hsc.auth.service.AmazonS3Service;
import com.hsc.auth.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    private final AmazonS3Service amazonS3Service;

    @PostMapping(value = "/board", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<BoardRequestDto> save(@RequestPart("boardRequestDto") BoardRequestDto boardRequestDto, @RequestPart("file") List<MultipartFile> multipartFiles) throws IOException {
        boardService.save(boardRequestDto, amazonS3Service.upload(multipartFiles).toString());
        return ResponseEntity.ok(boardRequestDto);
    }

    @PutMapping("/board/{id}")
    public ResponseEntity<BoardRequestDto> update(@RequestPart("boardDto") BoardRequestDto boardRequestDto, @RequestPart("file") List<MultipartFile> multipartFiles) throws IOException{
        boardService.save(boardRequestDto, amazonS3Service.upload(multipartFiles).toString());
        return ResponseEntity.ok(boardRequestDto);
    }

    @GetMapping("/board")
    public ResponseEntity<List<BoardResponseDto>> findAll() {
        return ResponseEntity.ok(boardService.findAll());
    }

}
