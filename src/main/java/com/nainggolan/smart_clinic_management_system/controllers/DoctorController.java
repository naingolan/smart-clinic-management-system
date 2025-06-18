package com.nainggolan.smart_clinic_management_system.controllers;

import com.nainggolan.smart_clinic_management_system.models.Doctor;
import com.nainggolan.smart_clinic_management_system.repositories.DoctorRepository;
import com.nainggolan.smart_clinic_management_system.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/availability/{user}/{doctorId}/{date}/{token}")
    public ResponseEntity<?> getDoctorAvailability(
            @PathVariable String user,
            @PathVariable Long doctorId,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @PathVariable String token) {

        // Validate token
        if (!tokenService.validateToken(token)) {
            return ResponseEntity.status(401).body("{\"error\": \"Invalid token\"}");
        }

        // Retrieve doctor by ID
        List<Doctor> doctors = doctorRepository.findById(doctorId)
                .map(List::of)
                .orElse(List.of());

        // Filter by user (optional, assuming user role or name filter)
        if (user != null && !user.isEmpty()) {
            doctors = doctors.stream()
                    .filter(d -> d.getEmail().equalsIgnoreCase(user) || d.getFirstName().equalsIgnoreCase(user))
                    .toList();
        }

        // Filter by date
        if (date != null) {
            doctors = doctors.stream()
                    .filter(d -> d.getAvailableTimes().stream()
                            .anyMatch(time -> time.isAfter(date) || time.isEqual(date)))
                    .toList();
        }

        if (doctors.isEmpty()) {
            return ResponseEntity.status(404).body("{\"message\": \"No doctors available\"}");
        }

        return ResponseEntity.ok(doctors);
    }
}