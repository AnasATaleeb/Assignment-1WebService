package com.hospital.doctor.dto;

import lombok.Data;

@Data
public class MedicalRecordDto {
    private long id;
    private long patient_id;
    private long doctor_id;
    private String treatment;
    private String medicine;
}
