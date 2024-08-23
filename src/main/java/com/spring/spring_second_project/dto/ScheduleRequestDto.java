package com.spring.spring_second_project.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    @NotNull(message = "작성자명을 꼭 적어야합니다.")
    private String username;

    @NotNull
    private String toDoTitle;

    @NotNull
    private String toDoComment;

}
