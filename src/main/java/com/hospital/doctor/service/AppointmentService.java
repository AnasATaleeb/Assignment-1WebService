package com.hospital.doctor.service;

import com.hospital.doctor.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto cereateAppointment(AppointmentDto appointmentDto);
    List<AppointmentDto> getAllAppointment();
    AppointmentDto getAppointmentById(long id);
    AppointmentDto updateAppointment(AppointmentDto appointmentDto,long id);
    void deleteAppointment(long id);
}
