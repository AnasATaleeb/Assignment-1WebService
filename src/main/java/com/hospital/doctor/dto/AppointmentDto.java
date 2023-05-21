package com.hospital.doctor.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentDto {
    private long id;
    private long patient_id;
    private long doctor_id;
    private Date date;
    private String time;
}
