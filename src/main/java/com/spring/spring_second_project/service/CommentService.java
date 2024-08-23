package com.spring.spring_second_project.service;

import com.spring.spring_second_project.dto.CommentRequestDto;
import com.spring.spring_second_project.dto.CommentResponseDto;
import com.spring.spring_second_project.entity.CommentEntity;
import com.spring.spring_second_project.entity.ScheduleEntity;
import com.spring.spring_second_project.repository.CommentRepository;
import com.spring.spring_second_project.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {


    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentEntity createComment(Long scheduleId, CommentRequestDto requestDto) {
        ScheduleEntity schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 작성한 일정이 없습니다."));
        CommentEntity comment = new CommentEntity(requestDto);
        comment.setScheduleEntity(schedule);
        return commentRepository.save(comment);
    }

    @Transactional
    public CommentEntity updateComment(Long id, CommentRequestDto requestDto) {
        CommentEntity comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("작성한 댓글이 없습니다."));
        comment.setComment(requestDto.getComment());
        return commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(Long id) {
        CommentEntity comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("작성한 댓글이 없습니다."));
        commentRepository.delete(comment);
    }

    public Optional<CommentResponseDto> getCommentById(Long id) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm");
        return commentRepository.findById(id).map(comment -> new CommentResponseDto(
                comment.getId(),
                comment.getComment()
        ));
    }

    public List<CommentResponseDto> getComment() {
        List<CommentEntity> commentEntities = commentRepository.findAll(Sort.by(Sort.Order.desc("id")));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm");

        return commentEntities.stream().map(commentEntity -> new CommentResponseDto(
                commentEntity.getId(),
                commentEntity.getComment()
        )).toList();
    }
}
