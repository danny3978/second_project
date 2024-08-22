package com.spring.spring_second_project.repository;

import com.spring.spring_second_project.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
