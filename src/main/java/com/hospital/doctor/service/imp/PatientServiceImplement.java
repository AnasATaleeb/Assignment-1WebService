package com.hospital.doctor.service.imp;

import com.hospital.doctor.dto.PatientDto;
import com.hospital.doctor.entity.Patient;
import com.hospital.doctor.exception.ResourceNotFoundException;
import com.hospital.doctor.repositry.PatientRepositry;
import com.hospital.doctor.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImplement implements PatientService {
    private PatientRepositry patientRepositry;

    public PatientServiceImplement(PatientRepositry patientRepositry) {
        this.patientRepositry = patientRepositry;
    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = mapToEntity(patientDto);
        Patient savedPatient = patientRepositry.save(patient);

        PatientDto patientResponse = mapToDto(savedPatient);
        return patientResponse;
    }

    private PatientDto mapToDto(Patient savedPatient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setId(savedPatient.getId());
        patientDto.setName(savedPatient.getName());
        patientDto.setAge(savedPatient.getAge());
        patientDto.setGender(savedPatient.getGender());
        patientDto.setPhoneNumber(savedPatient.getPhoneNumber());
        return patientDto;
    }

    private Patient mapToEntity(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setId(patientDto.getId());
        patient.setName(patientDto.getName());
        patient.setAge(patientDto.getAge());
        patient.setGender(patientDto.getGender());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        return patient;
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepositry.findAll();
        return patients.stream().map(patient -> mapToDto(patient)).collect(Collectors.toList());
    }

    @Override
    public PatientDto getPatientById(long id) {
        Patient patient = patientRepositry.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient","id", id));
        return mapToDto(patient);
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto, long id) {
        Patient patient = patientRepositry.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient","id", id));
        patient.setName(patientDto.getName());
        patient.setAge(patientDto.getAge());
        patient.setGender(patientDto.getGender());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        Patient savedPatient = patientRepositry.save(patient);
        return mapToDto(savedPatient);
    }

    @Override
    public void deletePatient(long id) {
        Patient patient = patientRepositry.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient","id", id));
        patientRepositry.delete(patient);
    }
}
