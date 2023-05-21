package com.hospital.doctor.dto;

import lombok.Data;

@Data
public class PatientDto {
    long id;
    String name;
    int age;
    char gender;
    String phoneNumber;
}
