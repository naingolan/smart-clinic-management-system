package com.nainggolan.smart_clinic_management_system.services;

import com.nainggolan.smart_clinic_management_system.models.Appointment;
import com.nainggolan.smart_clinic_management_system.models.Doctor;
import com.nainggolan.smart_clinic_management_system.models.Patient;
import com.nainggolan.smart_clinic_management_system.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    private Appointment bookAppointment(Doctor doctor, Patient patient, LocalDateTime appoitmentTime){
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentTime(appoitmentTime);
        appointment.setStatus("scheduled");

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByDoctorAndDate(Long doctorId, LocalDate date){
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.plusDays(1).atStartOfDay();
        return appointmentRepository.findByDoctorIdAndAppointmentTimeBetween(doctorId, startOfDay, endOfDay);
    }

}
