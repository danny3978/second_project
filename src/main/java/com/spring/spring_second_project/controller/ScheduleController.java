package com.spring.spring_second_project.controller;

import com.spring.spring_second_project.dto.ScheduleRequestDto;
import com.spring.spring_second_project.dto.ScheduleResponseDto;
import com.spring.spring_second_project.entity.ScheduleEntity;
import com.spring.spring_second_project.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {


    private final ScheduleService scheduleService;

    @PostMapping("/users/{id}")
    public ResponseEntity<ScheduleResponseDto> createSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        ScheduleEntity schedule = scheduleService.createSchedule(id, requestDto);
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return ResponseEntity.ok(scheduleResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        ScheduleEntity updatedSchedule = scheduleService.updateSchedule(id, requestDto);

        return ResponseEntity.ok(new ScheduleResponseDto(updatedSchedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id){
        ScheduleResponseDto responseDto = scheduleService.getScheduleById(id);
        return ResponseEntity.ok(responseDto);
    }


    @GetMapping("/")
    public ResponseEntity<Page<ScheduleResponseDto>> getPage(@RequestParam(value = "page" , defaultValue = "0") int page,
                                                            @RequestParam(value = "size", defaultValue = "10") int size){
       Page<ScheduleResponseDto> schedule = scheduleService.getPage(page, size);
        return ResponseEntity.ok(schedule);
    }



}
