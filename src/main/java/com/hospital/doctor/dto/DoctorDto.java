package com.hospital.doctor.dto;

import lombok.Data;

@Data
public class DoctorDto {
    private long id;
    private long emp_id;
    private String name;
    private String specialization;
    private char gender;

    private String phoneNumber;

    private long salary;
}
