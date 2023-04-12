package com.hsc.auth.dto;

import com.hsc.auth.model.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequestDto {
    private String title; // 게시글 제목 board_title이 나으려나

    private String content; // 게시글 내용 board_content가 나으려나

    private String userId; // 작성한 유저 id

    private int views; // 조회수

    private String fileUrl; // s3 파일 주소


    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .userId(userId)
                .fileUrl(fileUrl)
                .views(views)
                .build();
    }
}
