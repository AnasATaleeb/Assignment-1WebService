package com.hospital.doctor.controller;


import com.hospital.doctor.dto.DoctorDto;
import com.hospital.doctor.exception.BadRequestException;
import com.hospital.doctor.service.DoctorService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final Logger log = LoggerFactory.getLogger(DoctorController.class);

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        return ResponseEntity.ok().body(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getCategoryById(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor
            (@Valid @RequestBody DoctorDto doctorDto) {
        if (doctorDto.getId() == 0) {
            log.error("Cannot have an ID {}", doctorDto);
            throw new BadRequestException(DoctorController.class.getSimpleName(),"Id");
        }
        return new ResponseEntity(doctorService.cereateDoctor(doctorDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor
            (@Valid @RequestBody DoctorDto doctorDto
                    , @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(doctorService.updateDoctor(doctorDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable(name = "id") long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }




}
