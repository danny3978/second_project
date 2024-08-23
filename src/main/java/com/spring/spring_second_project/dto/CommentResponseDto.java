package com.spring.spring_second_project.dto;

import com.spring.spring_second_project.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
public class CommentResponseDto {
    private Long id;
    private String comment;
    private String createdDate;
    private String updatedDate;

    public CommentResponseDto(CommentEntity comment) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm");
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.createdDate = formatter.format(comment.getCreateAt());
        this.updatedDate = formatter.format(comment.getModifiedAt());
    }

}
