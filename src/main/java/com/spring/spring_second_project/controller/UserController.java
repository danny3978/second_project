package com.spring.spring_second_project.controller;


import com.spring.spring_second_project.dto.UserRequestDto;
import com.spring.spring_second_project.dto.UserResponseDto;
import com.spring.spring_second_project.entity.UserEntity;
import com.spring.spring_second_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(requestDto));
    }


    @GetMapping("/{username}")
    public ResponseEntity<UserResponseDto> findUser(@PathVariable String username){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUser(username));
    }


    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserResponseDto> userChange(@PathVariable String username, @RequestBody UserRequestDto requestDto){

        return ResponseEntity.status(HttpStatus.OK).body(userService.update(username, requestDto));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username){
        userService.deleteUser(username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("제거 완료");
    }

}
