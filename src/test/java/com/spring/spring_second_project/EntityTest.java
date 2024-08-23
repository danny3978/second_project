package com.spring.spring_second_project;

import com.spring.spring_second_project.repository.CommentRepository;
import com.spring.spring_second_project.repository.ScheduleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class EntityTest {

    private static final Logger log = LoggerFactory.getLogger(EntityTest.class);
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    @Rollback(value = false)
    void test(){

        LocalDateTime dateTime = LocalDateTime.now();

        String today = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

//        ScheduleEntity scheduleEntity = new ScheduleEntity(null, "name","할일 제목","할일 내용", today,today);
//        scheduleRepository.save(scheduleEntity);

//        CommentEntity commentEntity = new CommentEntity(null,today,today,scheduleEntity);
//        commentRepository.save(commentEntity);
    }





}
