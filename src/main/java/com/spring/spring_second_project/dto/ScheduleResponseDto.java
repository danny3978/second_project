package com.spring.spring_second_project.dto;

import com.spring.spring_second_project.entity.ScheduleEntity;
import com.spring.spring_second_project.entity.UserEntity;
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
    private String createDate;
    private String updateDate;
    private int commentCount;


    public ScheduleResponseDto(ScheduleEntity schedule) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm");

        this.id = schedule.getId();
        this.toDoTitle = schedule.getToDoTitle();
        this.toDoComment = schedule.getToDoComment();
        this.createDate = formatter.format(schedule.getCreateAt());
        this.updateDate = formatter.format(schedule.getModifiedAt());
        this.commentCount = schedule.getCommentEntities().size();

        UserEntity userEntity = schedule.getUserEntity();
        if (userEntity != null) {
            this.user_id = userEntity.getId();
            this.username = userEntity.getUsername();
            this.email = userEntity.getEmail();
        }
    }

    public ScheduleResponseDto(Long id, String toDoTitle, String toDoComment, String format, String format1, int size) {
        this.id= id;
        this.toDoTitle = toDoTitle;
        this.toDoComment = toDoComment;
        this.createDate = format;
        this.updateDate = format1;
        this.commentCount = size;
    }
}
