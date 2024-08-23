package com.spring.spring_second_project.controller;


import com.spring.spring_second_project.dto.ChangeUserEmail;
import com.spring.spring_second_project.dto.ChangeUsername;
import com.spring.spring_second_project.dto.UserRequestDto;
import com.spring.spring_second_project.dto.UserResponseDto;
import com.spring.spring_second_project.entity.UserEntity;
import com.spring.spring_second_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController{

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto requestDto){
        UserEntity entity = userService.addUser(requestDto);
        return ResponseEntity.ok(new UserResponseDto(entity));
    }


    @GetMapping("/{username}")
    public ResponseEntity<UserResponseDto> findUser(@PathVariable String username){
        UserEntity entity = userService.findUser(username);
        return ResponseEntity.ok(new UserResponseDto(entity));
    }


    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll(){
        List<UserResponseDto> userResponseDtos = userService.findAll();
        return ResponseEntity.ok(userResponseDtos);
    }

    @PutMapping("/username/{username}")
    public ResponseEntity<UserResponseDto> usernameChange(@PathVariable String username, @RequestBody ChangeUsername changeName){
        UserEntity entity = userService.updateUser(username, changeName);
        return ResponseEntity.ok(new UserResponseDto(entity));
    }

    @PutMapping("/userEmail/{username}")
    public ResponseEntity<UserResponseDto> userEmailChange(@PathVariable String username, @RequestBody ChangeUserEmail changeEmail){
        UserEntity entity = userService.updateEmail(username, changeEmail);
        return ResponseEntity.ok(new UserResponseDto(entity));
    }

    @PutMapping("/user/{username}")
    public ResponseEntity<UserResponseDto> userChange(@PathVariable String username, @RequestBody UserRequestDto requestDto){
        UserEntity entity = userService.update(username, requestDto);
        return ResponseEntity.ok(new UserResponseDto(entity));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username){
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

}
