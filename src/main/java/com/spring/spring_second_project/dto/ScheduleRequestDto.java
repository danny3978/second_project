package com.spring.spring_second_project.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    @NotNull
    private String toDoTitle;

    @NotNull
    private String toDoComment;

}
