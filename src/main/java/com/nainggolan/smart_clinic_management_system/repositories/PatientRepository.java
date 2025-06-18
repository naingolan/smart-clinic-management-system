package com.nainggolan.smart_clinic_management_system.repositories;

import com.nainggolan.smart_clinic_management_system.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);

    @Query("Select p from patient p where p.email = :identifier or p.phone= :identifier")
    Optional<Patient> findByEmailOrPhone(String identifier);
}
