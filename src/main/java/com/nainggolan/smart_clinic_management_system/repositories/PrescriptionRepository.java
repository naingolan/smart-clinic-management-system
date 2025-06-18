package com.nainggolan.smart_clinic_management_system.repositories;

import com.nainggolan.smart_clinic_management_system.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}
