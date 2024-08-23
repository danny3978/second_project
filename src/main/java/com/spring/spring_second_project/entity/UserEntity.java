package com.spring.spring_second_project.entity;

import com.spring.spring_second_project.dto.UserRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
public class UserEntity extends Timetamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;


    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ScheduleEntity> scheduleEntities = new ArrayList<>();

    public UserEntity(UserRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.email = requestDto.getEmail();
    }


    public void addSchedule(ScheduleEntity scheduleEntity){
        this.scheduleEntities.add(scheduleEntity);
        scheduleEntity.setUserEntity(this);
    }

    public void update(UserRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.email = requestDto.getEmail();
    }
}
