package com.spring.spring_second_project.controller;

import com.spring.spring_second_project.dto.ScheduleRequestDto;
import com.spring.spring_second_project.dto.ScheduleResponseDto;
import com.spring.spring_second_project.entity.ScheduleEntity;
import com.spring.spring_second_project.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {


    private final ScheduleService scheduleService;

    @PostMapping("/users/{id}")
    public ResponseEntity<ScheduleResponseDto> createSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.createSchedule(id, requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.updateSchedule(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("일정 제거 완료");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getScheduleById(id));
    }


    @GetMapping("/")
    public ResponseEntity<Page<ScheduleResponseDto>> getPage(@RequestParam(value = "page" , defaultValue = "0") int page,
                                                            @RequestParam(value = "size", defaultValue = "10") int size){

        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getPage(page, size));
    }



}
