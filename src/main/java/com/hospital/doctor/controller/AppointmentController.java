package com.hospital.doctor.controller;


import com.hospital.doctor.dto.AppointmentDto;
import com.hospital.doctor.exception.BadRequestException;
import com.hospital.doctor.service.AppointmentService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final Logger log = LoggerFactory.getLogger(AppointmentController.class);

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointment(){
        return ResponseEntity.ok().body(appointmentService.getAllAppointment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment
            (@Valid @RequestBody AppointmentDto appointmentDto) {
        if (appointmentDto.getId() == 0) {
            log.error("Cannot have an ID {}", appointmentDto);
            throw new BadRequestException(AppointmentController.class.getSimpleName(),"Id");
        }
        return new ResponseEntity(appointmentService.cereateAppointment(appointmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> updateDoctor
            (@Valid @RequestBody AppointmentDto appointmentDto
                    , @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(appointmentService.updateAppointment(appointmentDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable(name = "id") long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }







}
