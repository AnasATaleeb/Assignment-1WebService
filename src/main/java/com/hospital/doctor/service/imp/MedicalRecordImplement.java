package com.hospital.doctor.service.imp;

import com.hospital.doctor.dto.MedicalRecordDto;
import com.hospital.doctor.entity.MedicalRecord;
import com.hospital.doctor.exception.ResourceNotFoundException;
import com.hospital.doctor.repositry.MedicalRecordRepositry;
import com.hospital.doctor.service.MedicalRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordImplement implements MedicalRecordService {

    private MedicalRecordRepositry medicalRecordRepositry;

    public MedicalRecordImplement(MedicalRecordRepositry medicalRecordRepositry) {
        this.medicalRecordRepositry = medicalRecordRepositry;
    }

    @Override
    public MedicalRecordDto createMedicalRecord(MedicalRecordDto medicalRecordDto) {
        MedicalRecord medicalRecord = mapToEntity(medicalRecordDto);
        MedicalRecord savedMedicalRecord = medicalRecordRepositry.save(medicalRecord);

        MedicalRecordDto medicalRecordResponse = mapToDto(savedMedicalRecord);
        return medicalRecordResponse;
    }

    private MedicalRecordDto mapToDto(MedicalRecord savedMedicalRecord) {
        MedicalRecordDto medicalRecordDto = new MedicalRecordDto();
        medicalRecordDto.setId(savedMedicalRecord.getId());
        medicalRecordDto.setPatient_id(savedMedicalRecord.getPatient_id());
        medicalRecordDto.setDoctor_id(savedMedicalRecord.getDoctor_id());
        medicalRecordDto.setTreatment(savedMedicalRecord.getTreatment());
        medicalRecordDto.setMedicine(savedMedicalRecord.getMedicine());
        return medicalRecordDto;
    }

    private MedicalRecord mapToEntity(MedicalRecordDto medicalRecordDto) {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setId(medicalRecordDto.getId());
        medicalRecord.setPatient_id(medicalRecordDto.getPatient_id());
        medicalRecord.setDoctor_id(medicalRecordDto.getDoctor_id());
        medicalRecord.setTreatment(medicalRecordDto.getTreatment());
        medicalRecord.setMedicine(medicalRecordDto.getMedicine());
        return medicalRecord;
    }

    @Override
    public List<MedicalRecordDto> getAllMedicalRecords() {
        List<MedicalRecord> medicalRecords = medicalRecordRepositry.findAll();
        return medicalRecords.stream().map(medicalRecord -> mapToDto(medicalRecord)).collect(Collectors.toList());
    }

    @Override
    public MedicalRecordDto getMedicalRecordById(long id) {
       MedicalRecord medicalRecord = medicalRecordRepositry.findById(id).orElseThrow(() -> new ResourceNotFoundException("MedicalRecord","id", id));
        return mapToDto(medicalRecord);
    }

    @Override
    public MedicalRecordDto updateMedicalRecord(MedicalRecordDto medicalRecordDto, long id) {
        MedicalRecord medicalRecord = medicalRecordRepositry.findById(id).orElseThrow(() -> new ResourceNotFoundException("MedicalRecord","id", id));
        medicalRecord.setPatient_id(medicalRecordDto.getPatient_id());
        medicalRecord.setDoctor_id(medicalRecordDto.getDoctor_id());
        medicalRecord.setTreatment(medicalRecordDto.getTreatment());
        medicalRecord.setMedicine(medicalRecordDto.getMedicine());
        MedicalRecord savedMedicalRecord = medicalRecordRepositry.save(medicalRecord);
        return mapToDto(savedMedicalRecord);
    }

    @Override
    public void deleteMedicalRecord(long id) {
        MedicalRecord medicalRecord = medicalRecordRepositry.findById(id).orElseThrow(() -> new ResourceNotFoundException("MedicalRecord","id", id));
        medicalRecordRepositry.delete(medicalRecord);
    }
}
