package com.spring.spring_second_project.service;


import com.spring.spring_second_project.dto.CommentRequestDto;
import com.spring.spring_second_project.dto.CommentResponseDto;
import com.spring.spring_second_project.entity.CommentEntity;
import com.spring.spring_second_project.entity.ScheduleEntity;
import com.spring.spring_second_project.repository.CommentRepository;
import com.spring.spring_second_project.repository.ScheduleRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;
    private final ScheduleRepository scheduleRepository;

    public CommentResponseDto create(CommentRequestDto requestDto) {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(requestDto.getUser_id()).
                orElseThrow(() -> new IllegalArgumentException("가 없습니다."));

        CommentEntity commentEntity = new CommentEntity(requestDto);
        commentEntity.setScheduleEntity(scheduleEntity);

        repository.save(commentEntity);

        return new CommentResponseDto(commentEntity);
    }
}
