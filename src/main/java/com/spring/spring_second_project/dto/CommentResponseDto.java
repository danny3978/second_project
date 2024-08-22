package com.spring.spring_second_project.dto;


import com.spring.spring_second_project.entity.CommentEntity;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class CommentResponseDto {

    private Long id;
    private Long user_id;
    private String comment;
    private String createAt;
    private String modifiedAt;

    public CommentResponseDto(CommentEntity commentEntity) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm");

        this.id = commentEntity.getId();
        this.user_id = commentEntity.getScheduleEntity().getId();
        this.comment = commentEntity.getComment();
        this.createAt = formatter.format(commentEntity.getCreateAt());
        this.modifiedAt = formatter.format(commentEntity.getModifiedAt());

    }
}
