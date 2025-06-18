package com.nainggolan.smart_clinic_management_system.repositories;
import com.nainggolan.smart_clinic_management_system.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
