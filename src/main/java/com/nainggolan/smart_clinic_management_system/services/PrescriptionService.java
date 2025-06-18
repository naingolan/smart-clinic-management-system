package com.nainggolan.smart_clinic_management_system.services;

import com.nainggolan.smart_clinic_management_system.models.Prescription;
import com.nainggolan.smart_clinic_management_system.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public Prescription savePrescription(Prescription prescription){
        if(prescription.getAppointment()==null){
            throw new IllegalArgumentException("Appointmentis required");
        }
        prescription.setIssueDate(new java.sql.Date(System.currentTimeMillis()));
        return prescriptionRepository.save(prescription);
    }

}
