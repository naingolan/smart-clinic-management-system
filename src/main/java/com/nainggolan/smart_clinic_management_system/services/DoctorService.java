package com.nainggolan.smart_clinic_management_system.services;

import com.nainggolan.smart_clinic_management_system.models.Doctor;
import com.nainggolan.smart_clinic_management_system.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<LocalDateTime> getAvailableTimeSlots(Long doctorId, LocalDate date) {
        Optional<Doctor> doctorOpt = doctorRepository.findById(doctorId);
        if (doctorOpt.isEmpty()) {
            return List.of(); // Return empty list if doctor not found
        }
        Doctor doctor = doctorOpt.get();
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.plusDays(1).atStartOfDay();
        return doctor.getAvailableTimes().stream()
                .filter(time -> time.isAfter(startOfDay) && time.isBefore(endOfDay))
                .toList();
    }

    public String validateDoctorLogin(String email, String password) {
        Optional<Doctor> doctorOpt = doctorRepository.findByEmail(email);
        if (doctorOpt.isEmpty()) {
            return "{\"error\": \"Doctor not found\"}";
        }
        Doctor doctor = doctorOpt.get();
        // Simple password check (replace with secure hashing in production)
        if ("securePassword".equals(password)) { // Placeholder logic
            return "{\"message\": \"Login successful\", \"doctorId\": " + doctor.getId() + "}";
        }
        return "{\"error\": \"Invalid credentials\"}";
    }
}