package com.hospital.doctor.controller;


import com.hospital.doctor.dto.MedicalRecordDto;
import com.hospital.doctor.service.MedicalRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {
    private final Logger log = LoggerFactory.getLogger(MedicalRecordController.class);

    private MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping
    public ResponseEntity<List<MedicalRecordDto>> getAllMedicalRecords(){
        return ResponseEntity.ok().body(medicalRecordService.getAllMedicalRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecordDto> getMedicalRecordById(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(medicalRecordService.getMedicalRecordById(id));
    }

    @PostMapping
    public ResponseEntity<MedicalRecordDto> createMedicalRecord
            (@RequestBody MedicalRecordDto medicalRecordDto) {
        return ResponseEntity.ok(medicalRecordService.createMedicalRecord(medicalRecordDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecordDto> updateMedicalRecord
            (@RequestBody MedicalRecordDto medicalRecordDto
                    , @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(medicalRecordService.updateMedicalRecord(medicalRecordDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicalRecord(@PathVariable(name = "id") long id) {
        medicalRecordService.deleteMedicalRecord(id);
        return ResponseEntity.ok("Deleted successfully.");
    }

}
