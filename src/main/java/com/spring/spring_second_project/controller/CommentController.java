package com.spring.spring_second_project.controller;


import com.spring.spring_second_project.dto.CommentRequestDto;
import com.spring.spring_second_project.dto.CommentResponseDto;
import com.spring.spring_second_project.repository.CommentRepository;
import com.spring.spring_second_project.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;

    //댓글 등록
    @PostMapping("/")
    public CommentResponseDto createComment(@Valid @RequestBody CommentRequestDto requestDto){
        return service.create(requestDto);
    }

    //댓글 단건 조회
    @GetMapping("/{id}")
    public CommentResponseDto commentFindId(@Valid @PathVariable Long id){
        return service.commentFindId(id);
    }
}
