package com.hospital.doctor.service;

import com.hospital.doctor.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto cereateDoctor(DoctorDto doctorDto);

    List<DoctorDto> getAllDoctors();

    DoctorDto getDoctorById(long id);

    DoctorDto updateDoctor(DoctorDto doctorDto,long id);

    void deleteDoctor(long id);

}
