package com.spring.spring_second_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.internal.build.AllowNonPortable;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "schedule")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String toDoTitle;
    private String toDoComment;
    private String scheduleWriteDay;
    private String scheduleUpdateDay;
}

