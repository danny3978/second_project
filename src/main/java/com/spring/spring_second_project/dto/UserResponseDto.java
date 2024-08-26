package com.spring.spring_second_project.dto;


import com.spring.spring_second_project.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
public class UserResponseDto {

    private Long id;
    private String username;
    private String email;
    private String createDate;
    private String updateDate;



    public UserResponseDto(UserEntity userEntity){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm");

        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.email = userEntity.getEmail();
        this.createDate = formatter.format(userEntity.getCreateAt());
        this.updateDate = formatter.format(userEntity.getModifiedAt());

    }
}
