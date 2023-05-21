package com.hospital.doctor.repositry;

import com.hospital.doctor.entity.Appointment;
import com.hospital.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepositry extends JpaRepository<Appointment, Long> {
}
