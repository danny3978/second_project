package com.spring.spring_second_project.service;

import com.spring.spring_second_project.dto.ScheduleRequestDto;
import com.spring.spring_second_project.dto.ScheduleResponseDto;
import com.spring.spring_second_project.entity.ScheduleEntity;
import com.spring.spring_second_project.repository.ScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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

    public ScheduleResponseDto findId(Long id) {
       ScheduleEntity scheduleEntity =  scheduleRepository.findById(id).orElseThrow(() ->
               new EntityNotFoundException("값을 못 찾았습니다."));

       return new ScheduleResponseDto(scheduleEntity);
    }

    @Transactional
    public ScheduleResponseDto update(@Validated Long id, @Validated ScheduleRequestDto requestDto) {
            ScheduleEntity scheduleEntity = scheduleRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("값을 못 찾았습니다."));
            scheduleEntity.updateSchedule(requestDto);
            return new ScheduleResponseDto(scheduleEntity);
    }
}
