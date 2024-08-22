package com.spring.spring_second_project.service;

import com.spring.spring_second_project.dto.ScheduleRequestDto;
import com.spring.spring_second_project.dto.ScheduleResponseDto;
import com.spring.spring_second_project.entity.ScheduleEntity;
import com.spring.spring_second_project.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Validated
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {

        ScheduleEntity scheduleEntity = new ScheduleEntity(requestDto);

        ScheduleEntity saveSchedule = scheduleRepository.save(scheduleEntity);

        return new ScheduleResponseDto(saveSchedule);
    }

    public Optional<ScheduleEntity> findId(Long id) {
       return scheduleRepository.findById(id);
    }
}
