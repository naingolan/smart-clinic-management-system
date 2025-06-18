package com.nainggolan.smart_clinic_management_system.controllers;

import com.nainggolan.smart_clinic_management_system.models.Prescription;
import com.nainggolan.smart_clinic_management_system.services.PrescriptionService;
import com.nainggolan.smart_clinic_management_system.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity<?> createPrescription(
            @RequestHeader("Authorization") String token,
             @RequestBody Prescription prescription){

        if(!tokenService.validateToken(token.replace("Bearer", ""))){
            return ResponseEntity.status(401).body("{\"error\": \"Invalid token\"}");
        }

        try{
            Prescription savedPrescription = prescriptionService.savePrescription(prescription);
            return ResponseEntity.ok("{\"message\":\"Prescription saved successfully\", \"id\": "+savedPrescription.getId() + "}");
        }catch(Exception e){
            return ResponseEntity.badRequest().body("{\"error\":\"Failed to save prescription: "+e.getMessage() + "\"}");
        }

    };

}
