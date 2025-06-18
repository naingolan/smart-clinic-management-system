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

    @GetMapping("/availability")
    public ResponseEntity<?> getDoctorAvailability(
            @RequestParam(required=false) String speciality,
            @RequestParam(required=false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
            @RequestHeader("Authorization") String token){

        if(!tokenService.validateToken(token.replace("Bearer ", ""))){
            return ResponseEntity.status(401).body("{\"error\": \"Invalid token\"}");
        }

        List<Doctor> doctors = doctorRepository.findAll();
        if(speciality !=null){
            doctors = doctors.stream()
                    .filter(d->d.getSpeciality().equalsIgnoreCase(speciality))
                    .toList();
        }
        if(dateTime!=null){
            doctors = doctors.stream()
                    .filter(d->d.getAvailableTimes().stream()
                            .anyMatch(time->time.isAfter(dateTime) || time.isEqual(dateTime)))
                    .toList();

        }

        if(doctors.isEmpty()){
            return ResponseEntity.status(404).body("{\"message\": \"No doctors available\"}");
        }

        return ResponseEntity.ok(doctors);


      }

}
