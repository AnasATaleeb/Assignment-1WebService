package com.hospital.doctor.service;

import com.hospital.doctor.dto.PatientDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PatientService {
    PatientDto createPatient(PatientDto patientDto);

    List<PatientDto> getAllPatients();

    PatientDto getPatientById(long id);

    PatientDto updatePatient(PatientDto patientDto,long id);

    void deletePatient(long id);

}
