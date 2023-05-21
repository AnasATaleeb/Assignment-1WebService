package com.hospital.doctor.service;

import com.hospital.doctor.dto.DoctorDto;
import com.hospital.doctor.dto.MedicalRecordDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MedicalRecordService {
    MedicalRecordDto createMedicalRecord(MedicalRecordDto medicalRecordDto);

    List<MedicalRecordDto> getAllMedicalRecords();

    MedicalRecordDto getMedicalRecordById(long id);

    MedicalRecordDto updateMedicalRecord(MedicalRecordDto medicalRecordDto,long id);

    void deleteMedicalRecord(long id);


}
