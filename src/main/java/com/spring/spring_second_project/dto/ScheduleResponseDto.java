package com.spring.spring_second_project.dto;

import com.spring.spring_second_project.entity.ScheduleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private Long user_id;
    private String username;
    private String email;
    private String toDoTitle;
    private String toDoComment;
    private int commentCount;  // 댓글 개수


    public ScheduleResponseDto(ScheduleEntity schedule) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm");

        this.id = schedule.getId();
        this.user_id = schedule.getUserEntity().getId();
        this.username = schedule.getUserEntity().getUsername();
        this.email = schedule.getUserEntity().getEmail();
        this.toDoTitle = schedule.getToDoTitle();
        this.toDoComment = schedule.getToDoComment();
        this.commentCount = schedule.getCommentEntities().size();
    }
}
