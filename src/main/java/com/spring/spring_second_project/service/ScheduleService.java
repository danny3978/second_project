package com.spring.spring_second_project.service;

import com.spring.spring_second_project.dto.ScheduleRequestDto;
import com.spring.spring_second_project.dto.ScheduleResponseDto;
import com.spring.spring_second_project.entity.ScheduleEntity;
import com.spring.spring_second_project.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        ScheduleEntity scheduleEntity = new ScheduleEntity(requestDto);

        ScheduleEntity saveSchedule = scheduleRepository.save(scheduleEntity);

        return new ScheduleResponseDto(saveSchedule);
    }
}
