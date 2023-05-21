package com.hospital.doctor.service.imp;

import com.hospital.doctor.dto.AppointmentDto;
import com.hospital.doctor.entity.Appointment;
import com.hospital.doctor.entity.Doctor;
import com.hospital.doctor.exception.ResourceNotFoundException;
import com.hospital.doctor.repositry.AppointmentRepositry;
import com.hospital.doctor.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImplement implements AppointmentService {
    private AppointmentRepositry appointmentRepositry;

    public AppointmentServiceImplement(AppointmentRepositry appointmentRepositry) {
        this.appointmentRepositry = appointmentRepositry;
    }

    @Override
    public AppointmentDto cereateAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = mapToEntity(appointmentDto);
        Appointment savedAppointment = appointmentRepositry.save(appointment);

        AppointmentDto appointmentResponse = mapToDto(savedAppointment);
        return appointmentResponse;
    }

    @Override
    public List<AppointmentDto> getAllAppointment() {
        List<Appointment> appointments = appointmentRepositry.findAll();
        return appointments.stream().map(appointment -> mapToDto(appointment)).collect(Collectors.toList());
    }

    @Override
    public AppointmentDto getAppointmentById(long id) {
        Appointment appointment = appointmentRepositry.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment","id", id));
        return mapToDto(appointment);
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto appointmentDto, long id) {
        Appointment appointment = appointmentRepositry.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment","id", id));
        appointment.setPatient_id(appointmentDto.getPatient_id());
        appointment.setDoctor_id(appointmentDto.getDoctor_id());
        appointment.setDate(appointmentDto.getDate());
        appointment.setTime(appointmentDto.getTime());
        Appointment savedAppointment = appointmentRepositry.save(appointment);
        return mapToDto(savedAppointment);
    }

    @Override
    public void deleteAppointment(long id) {
        Appointment appointment = appointmentRepositry.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment","id", id));
    }

    private AppointmentDto mapToDto(Appointment savedAppointment) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setPatient_id(savedAppointment.getPatient_id());
        appointmentDto.setDoctor_id(savedAppointment.getDoctor_id());
        appointmentDto.setDate(savedAppointment.getDate());
        appointmentDto.setTime(savedAppointment.getTime());
        return appointmentDto;
    }

    private Appointment mapToEntity(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setPatient_id(appointmentDto.getPatient_id());
        appointment.setDoctor_id(appointmentDto.getDoctor_id());
        appointment.setDate(appointmentDto.getDate());
        appointment.setTime(appointmentDto.getTime());
        return appointment;
    }

}
