package com.spring.spring_second_project.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequestDto {

    @NotNull
    private String username;

    @NotNull
    private String email;

}
