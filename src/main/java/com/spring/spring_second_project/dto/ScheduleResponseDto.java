package com.spring.spring_second_project.dto;


import com.spring.spring_second_project.entity.ScheduleEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleResponseDto {

    private Long id;
    private String username;
    private String toDoTitle;
    private String toDoComment;
    private String scheduleWriteDate;
    private String scheduleUpdateDate;

    public ScheduleResponseDto(ScheduleEntity scheduleEntity){
        this.id = scheduleEntity.getId();
        this.username = scheduleEntity.getUsername();
        this.toDoTitle = scheduleEntity.getToDoTitle();
        this.toDoComment = scheduleEntity.getToDoComment();
        this.scheduleWriteDate = scheduleEntity.getScheduleWriteDate();
        this.scheduleUpdateDate = scheduleEntity.getScheduleUpdateDate();
    }

}
