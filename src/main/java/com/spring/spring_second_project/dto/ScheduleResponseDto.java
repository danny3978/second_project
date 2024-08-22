package com.spring.spring_second_project.dto;


import com.spring.spring_second_project.entity.ScheduleEntity;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class ScheduleResponseDto {

    private Long id;
    private String username;
    private String toDoTitle;
    private String toDoComment;
    private String createAt;
    private String modifiedAt;

    public ScheduleResponseDto(ScheduleEntity scheduleEntity){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm");

        this.id = scheduleEntity.getId();
        this.username = scheduleEntity.getUsername();
        this.toDoTitle = scheduleEntity.getToDoTitle();
        this.toDoComment = scheduleEntity.getToDoComment();
        this.createAt = scheduleEntity.getCreateAt().format(formatter);
        this.modifiedAt = scheduleEntity.getModifiedAt().format(formatter);
    }

}
