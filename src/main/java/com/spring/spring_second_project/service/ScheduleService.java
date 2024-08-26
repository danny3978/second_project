package com.spring.spring_second_project.service;

import com.spring.spring_second_project.dto.ScheduleRequestDto;
import com.spring.spring_second_project.dto.ScheduleResponseDto;
import com.spring.spring_second_project.entity.ScheduleEntity;
import com.spring.spring_second_project.entity.UserEntity;
import com.spring.spring_second_project.repository.ScheduleRepository;
import com.spring.spring_second_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
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
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;


    public ScheduleEntity createSchedule(Long id, ScheduleRequestDto requestDto) {
        UserEntity entity = userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("사용자가 없습니다."));

        ScheduleEntity scheduleEntity = new ScheduleEntity(requestDto);

        scheduleEntity.setUserEntity(entity);

        return scheduleRepository.save(scheduleEntity);
    }

    @Transactional
    public ScheduleEntity updateSchedule(Long id, ScheduleRequestDto requestDto) {
        ScheduleEntity schedule = finById(id);
        schedule.updateSchedule(requestDto);
        return scheduleRepository.save(schedule);
    }

    @Transactional
    public void deleteSchedule(Long id) {
        scheduleRepository.delete(finById(id));
    }


    public ScheduleResponseDto getScheduleById(Long id) {
        return new ScheduleResponseDto(finById(id));
    }


    public Page<ScheduleResponseDto> getPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("modifiedAt")));
        Page<ScheduleEntity> entities = scheduleRepository.findAll(pageable);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm");

        return entities.map(entity -> new ScheduleResponseDto(
                entity.getId(),
                entity.getToDoTitle(),
                entity.getToDoComment(),
                formatter.format(entity.getCreateAt()),
                formatter.format(entity.getModifiedAt()),
                entity.getCommentEntities().size()
        ));
    }


    public ScheduleEntity finById(Long id){
        return scheduleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("작성한 일정이 없습니다."));
    }
}
