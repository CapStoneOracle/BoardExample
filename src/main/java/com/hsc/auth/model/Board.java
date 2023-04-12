package com.hsc.auth.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardId")
    private int id; // 게시글 아이디

    @Column(nullable = false, length = 100)
    private String title; // 게시글 제목

    @Lob // 대용량 데이터
    private String content; // 게시글 내용

    @Column(name = "userId")
    private String userId; // 작성한 유저 id

    @Lob
    @Column(name = "fileUrl")
    private String fileUrl; // s3 파일 주소

    private int views; // 조회수



}
