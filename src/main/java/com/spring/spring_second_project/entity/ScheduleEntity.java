package com.spring.spring_second_project.entity;

import com.spring.spring_second_project.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "schedule")
@Getter
@NoArgsConstructor
public class ScheduleEntity extends Timetamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "작성자명을 꼭 적어야합니다.")
    private String username;

    private String toDoTitle;
    private String toDoComment;



    public ScheduleEntity(ScheduleRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.toDoTitle = requestDto.getToDoTitle();
        this.toDoComment = requestDto.getToDoComment();

    }


    public void updateSchedule(ScheduleRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.toDoTitle = requestDto.getToDoTitle();
        this.toDoComment = requestDto.getToDoComment();

    }






}

