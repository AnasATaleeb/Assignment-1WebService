package com.hospital.doctor.service.imp;

import com.hospital.doctor.dto.DoctorDto;
import com.hospital.doctor.entity.Doctor;
import com.hospital.doctor.exception.ResourceNotFoundException;
import com.hospital.doctor.repositry.DoctorRepositry;
import com.hospital.doctor.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorSreviceImplement implements DoctorService {
    private DoctorRepositry doctorRepositry;

    public DoctorSreviceImplement(DoctorRepositry doctorRepositry) {
        this.doctorRepositry = doctorRepositry;
    }

    @Override
    public DoctorDto cereateDoctor(DoctorDto doctorDto) {
        Doctor doctor = mapToEntity(doctorDto);
        Doctor savedDoctor = doctorRepositry.save(doctor);

        DoctorDto doctorResponse = mapToDto(savedDoctor);
        return doctorResponse;
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepositry.findAll();
        return doctors.stream().map(doctor -> mapToDto(doctor)).collect(Collectors.toList());
    }

    @Override
    public DoctorDto getDoctorById(long id) {
        Doctor doctor = doctorRepositry.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor","id", id));
        return mapToDto(doctor);
    }

    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto, long id) {
        Doctor doctor = doctorRepositry.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor","id", id));
        doctor.setEmp_id(doctorDto.getEmp_id());
        doctor.setName(doctorDto.getName());
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setGender(doctorDto.getGender());
        doctor.setPhoneNumber(doctorDto.getPhoneNumber());
        doctor.setSalary(doctorDto.getSalary());
        Doctor savedDoctor = doctorRepositry.save(doctor);
        return mapToDto(savedDoctor);
    }

    @Override
    public void deleteDoctor(long id) {
        Doctor doctor = doctorRepositry.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor","id", id));
        doctorRepositry.delete(doctor);
    }

    // convert Doctor into DTO
    private DoctorDto mapToDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setEmp_id(doctor.getEmp_id());
        doctorDto.setName(doctor.getName());
        doctorDto.setSpecialization(doctor.getSpecialization());
        doctorDto.setGender(doctor.getGender());
        doctorDto.setPhoneNumber(doctor.getPhoneNumber());
        doctorDto.setSalary(doctor.getSalary());
        return doctorDto;
    }

    // convert DTO to entity
    private Doctor mapToEntity(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setEmp_id(doctorDto.getEmp_id());
        doctor.setName(doctorDto.getName());
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setGender(doctorDto.getGender());
        doctor.setPhoneNumber(doctorDto.getPhoneNumber());
        doctor.setSalary(doctorDto.getSalary());
        return doctor;
    }
}
