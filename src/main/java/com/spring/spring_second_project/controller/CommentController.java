package com.spring.spring_second_project.controller;

import com.spring.spring_second_project.dto.CommentRequestDto;
import com.spring.spring_second_project.dto.CommentResponseDto;
import com.spring.spring_second_project.entity.CommentEntity;
import com.spring.spring_second_project.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/schedule/{scheduleId}")
    public ResponseEntity<CommentResponseDto> createComment(@PathVariable Long scheduleId, @RequestBody CommentRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(scheduleId, requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.updateComment(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("댓글 제거 완료");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDto> getCommentById(@PathVariable Long id) {
        return  commentService.getCommentById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> getComment(){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getComment());
    }
}
