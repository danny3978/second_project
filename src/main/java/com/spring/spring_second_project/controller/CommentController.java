package com.spring.spring_second_project.controller;


import com.spring.spring_second_project.dto.CommentRequestDto;
import com.spring.spring_second_project.dto.CommentResponseDto;
import com.spring.spring_second_project.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;
    @PostMapping("/")
    public CommentResponseDto createComment(@Valid @RequestBody CommentRequestDto requestDto){
        return service.create(requestDto);
    }
}
