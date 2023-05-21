package com.hospital.doctor.controller;

import com.hospital.doctor.dto.PatientDto;
import com.hospital.doctor.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final Logger log = LoggerFactory.getLogger(PatientController.class);

    private PatientService  patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients(){
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientById(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping
    public ResponseEntity<PatientDto> createPatient
            (@RequestBody PatientDto patientDto) {
        return ResponseEntity.ok(patientService.createPatient(patientDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatient
            (@RequestBody PatientDto patientDto
                    , @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(patientService.updatePatient(patientDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable(name = "id") long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Deleted successfully.");
    }


}
