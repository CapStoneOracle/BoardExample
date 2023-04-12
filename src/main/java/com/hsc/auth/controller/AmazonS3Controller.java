package com.hsc.auth.controller;

import com.hsc.auth.service.AmazonS3Service;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/s3")
public class AmazonS3Controller {

    private final AmazonS3Service amazonS3Service;


    @PostMapping( "/upload")
    public ResponseEntity<List<String>> uploadFile(@RequestPart("file") List<MultipartFile> multipartFile) throws IOException {
        return ResponseEntity.ok(amazonS3Service.upload(multipartFile));
    }

}

