package com.spring.spring_second_project.dto;

import com.spring.spring_second_project.entity.ScheduleEntity;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private String username;
    private String toDoTitle;
    private String toDoComment;

}
