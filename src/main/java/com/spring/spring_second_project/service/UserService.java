package com.spring.spring_second_project.service;


import com.spring.spring_second_project.dto.UserRequestDto;
import com.spring.spring_second_project.dto.UserResponseDto;
import com.spring.spring_second_project.entity.UserEntity;
import com.spring.spring_second_project.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto addUser(UserRequestDto requestDto) {
        UserEntity userEntity = new UserEntity(requestDto);
        userRepository.save(userEntity);
        return new UserResponseDto(userEntity);
    }

    public UserResponseDto findUser(String username) {
        UserEntity entity = findByUsername(username);
        return new UserResponseDto(entity);
    }


    public List<UserResponseDto> findAll() {
        List<UserEntity> responseDtos = userRepository.findAll();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm");
         return responseDtos.stream().map(userEntity -> new UserResponseDto(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                formatter.format(userEntity.getCreateAt()),
                formatter.format(userEntity.getModifiedAt())
        )).toList();

    }

    @Transactional
    public UserResponseDto update(String username, UserRequestDto requestDto) {
        UserEntity entity = findByUsername(username);
        entity.update(requestDto);
        return new UserResponseDto(entity);
    }

    @Transactional
    public void deleteUser(String username) {
        userRepository.delete(findByUsername(username));
    }



    public UserEntity findByUsername(String username) {
        try {
            return userRepository.findByUsername(username);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("없는 사용자입니다.");
        }

    }

}
