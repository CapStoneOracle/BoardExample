package com.hsc.auth.dto;

import com.hsc.auth.model.Board;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDto {

    private int id; // 게시글 아이디

    private String title; // 게시글 제목

    private String content; // 게시글 내용

    private String userId; // 작성한 유저 id

    private String fileUrl; // s3 파일 주소

    private int views; // 조회수

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.userId = board.getUserId();
        this.fileUrl = board.getFileUrl();
        this.views = board.getViews();
        this.createDate = board.getCreateDate();
        this.modifyDate = board.getModifyDate();
    }
}
