package com.spring.spring_second_project.service;

import com.spring.spring_second_project.dto.ScheduleRequestDto;
import com.spring.spring_second_project.dto.ScheduleResponseDto;
import com.spring.spring_second_project.entity.ScheduleEntity;
import com.spring.spring_second_project.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleEntity createSchedule(ScheduleRequestDto requestDto) {
        ScheduleEntity schedule = new ScheduleEntity(requestDto);
        return scheduleRepository.save(schedule);
    }

    @Transactional
    public ScheduleEntity updateSchedule(Long id, ScheduleRequestDto requestDto) {
        ScheduleEntity schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        schedule.updateSchedule(requestDto);
        return scheduleRepository.save(schedule);
    }

    @Transactional
    public void deleteSchedule(Long id) {
        ScheduleEntity schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        scheduleRepository.delete(schedule);
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto getScheduleById(Long id) {
        ScheduleEntity schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));


        return new ScheduleResponseDto(schedule);
    }


    public Page<ScheduleResponseDto> getPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("modifiedAt")));
        Page<ScheduleEntity> entities = scheduleRepository.findAll(pageable);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm");

        return entities.map(entity -> new ScheduleResponseDto(
                entity.getId(),
                entity.getUsername(),
                entity.getToDoTitle(),
                entity.getToDoComment(),
                formatter.format(entity.getCreateAt()),
                formatter.format(entity.getModifiedAt()),
                entity.getCommentEntities().size()
        ));
    }
}
