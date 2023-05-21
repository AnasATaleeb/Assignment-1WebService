package com.hospital.doctor.repositry;

import com.hospital.doctor.entity.Appointment;
import com.hospital.doctor.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepositry  extends JpaRepository<MedicalRecord, Long> {
}
