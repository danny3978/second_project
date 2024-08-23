package com.spring.spring_second_project.dto;

import com.spring.spring_second_project.entity.ScheduleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String username;
    private String toDoTitle;
    private String toDoComment;
    private String createdDate;
    private String updatedDate;
    private int commentCount;  // 댓글 개수


    public ScheduleResponseDto(ScheduleEntity schedule) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm");

        this.id = schedule.getId();
        this.username = schedule.getUsername();
        this.toDoTitle = schedule.getToDoTitle();
        this.toDoComment = schedule.getToDoComment();
        this.createdDate = formatter.format(schedule.getCreateAt());
        this.updatedDate = formatter.format(schedule.getModifiedAt());
        this.commentCount = schedule.getCommentEntities().size();
    }
}
