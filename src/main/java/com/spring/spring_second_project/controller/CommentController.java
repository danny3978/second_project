package com.spring.spring_second_project.controller;


import com.spring.spring_second_project.dto.CommentRequestDto;
import com.spring.spring_second_project.dto.CommentResponseDto;
import com.spring.spring_second_project.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //댓글 전체 조회
    @GetMapping("/")
    public List<CommentResponseDto> commentFindAll(){
        return service.commentFindAll();
    }

    //댓글 수정
    @PutMapping("/{id}")
    public CommentResponseDto commentUpdate(@Valid @PathVariable Long id, @Valid @RequestBody CommentRequestDto requestDto){
        return service.commentUpdate(id, requestDto);
    }


    //댓글 삭제
    @DeleteMapping("/{id}")
    public String commentDelete(@Valid @PathVariable Long id){
        service.commentDelete(id);
        return "제거 완료";
    }
}
