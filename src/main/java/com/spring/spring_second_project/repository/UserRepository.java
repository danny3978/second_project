package com.spring.spring_second_project.repository;


import com.spring.spring_second_project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByUsername(String username);
}
