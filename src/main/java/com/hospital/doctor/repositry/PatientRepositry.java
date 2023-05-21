package com.hospital.doctor.repositry;

import com.hospital.doctor.entity.MedicalRecord;
import com.hospital.doctor.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepositry extends JpaRepository<Patient, Long> {
}
