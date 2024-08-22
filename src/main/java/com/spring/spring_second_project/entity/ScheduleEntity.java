package com.spring.spring_second_project.entity;

import com.spring.spring_second_project.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.internal.build.AllowNonPortable;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "schedule")
@Getter
@Setter
@NoArgsConstructor
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String toDoTitle;
    private String toDoComment;
    private String scheduleWriteDate;
    private String scheduleUpdateDate;



    public ScheduleEntity(ScheduleRequestDto requestDto){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        this.username = requestDto.getUsername();
        this.toDoTitle = requestDto.getToDoTitle();
        this.toDoComment = requestDto.getToDoComment();
        this.scheduleWriteDate = date.format(formatter);
        this.scheduleUpdateDate = date.format(formatter);
    }







}

