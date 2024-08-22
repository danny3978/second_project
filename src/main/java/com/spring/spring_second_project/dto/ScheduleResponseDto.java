package com.spring.spring_second_project.dto;


import com.spring.spring_second_project.entity.ScheduleEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class ScheduleResponseDto {

    private Long id;
    private String username;
    private String toDoTitle;
    private String toDoComment;
    private String scheduleWriteDate;
    private String scheduleUpdateDate;

    public ScheduleResponseDto(ScheduleEntity scheduleEntity){
        this.id = scheduleEntity.getId();
        this.username = scheduleEntity.getUsername();
        this.toDoTitle = scheduleEntity.getToDoTitle();
        this.toDoComment = scheduleEntity.getToDoComment();
        this.scheduleWriteDate = scheduleEntity.getScheduleWriteDate();
        this.scheduleUpdateDate = scheduleEntity.getScheduleUpdateDate();
    }

}
