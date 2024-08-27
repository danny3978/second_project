package com.spring.spring_second_project.entity;

import com.spring.spring_second_project.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schedule")
@Getter
@Setter
@NoArgsConstructor
public class ScheduleEntity extends Timetamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String toDoTitle;
    private String toDoComment;

    @OneToMany(mappedBy = "scheduleEntity", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CommentEntity> commentEntities = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public ScheduleEntity(ScheduleRequestDto requestDto) {
        this.toDoTitle = requestDto.getToDoTitle();
        this.toDoComment = requestDto.getToDoComment();
    }

    public void updateSchedule(ScheduleRequestDto requestDto) {
        this.toDoTitle = requestDto.getToDoTitle();
        this.toDoComment = requestDto.getToDoComment();
    }

    public void addComment(CommentEntity commentEntity) {
        this.commentEntities.add(commentEntity);
        commentEntity.setScheduleEntity(this);
    }
}
