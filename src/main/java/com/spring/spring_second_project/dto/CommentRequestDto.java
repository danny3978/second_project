package com.spring.spring_second_project.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CommentRequestDto {

    @NotNull
    private Long user_id;

    @NotNull
    private String comment;
}
