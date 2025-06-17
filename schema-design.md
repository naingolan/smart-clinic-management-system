# Smart Clinic Management System - MySQL Database Design

## Table Definitions

### 1. doctors
- `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
- `first_name` (VARCHAR(50), NOT NULL)
- `last_name` (VARCHAR(50), NOT NULL)
- `specialty` (VARCHAR(100), NOT NULL)
- `email` (VARCHAR(100), UNIQUE, NOT NULL)
- `phone` (VARCHAR(20))

### 2. patients
- `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
- `first_name` (VARCHAR(50), NOT NULL)
- `last_name` (VARCHAR(50), NOT NULL)
- `email` (VARCHAR(100), UNIQUE, NOT NULL)
- `date_of_birth` (DATE, NOT NULL)
- `phone` (VARCHAR(20))

### 3. appointments
- `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
- `doctor_id` (INT, FOREIGN KEY REFERENCES doctors(id), NOT NULL)
- `patient_id` (INT, FOREIGN KEY REFERENCES patients(id), NOT NULL)
- `appointment_date_time` (DATETIME, NOT NULL)
- `status` (ENUM('scheduled', 'completed', 'canceled'), DEFAULT 'scheduled')
- `notes` (TEXT)

### 4. prescriptions
- `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
- `appointment_id` (INT, FOREIGN KEY REFERENCES appointments(id), NOT NULL)
- `medication` (VARCHAR(100), NOT NULL)
- `dosage` (VARCHAR(50), NOT NULL)
- `instructions` (TEXT)
- `issue_date` (DATE, NOT NULL)

## Relationships
- `appointments.doctor_id` links to `doctors.id` to associate appointments with doctors.
- `appointments.patient_id` links to `patients.id` to associate appointments with patients.
- `prescriptions.appointment_id` links to `appointments.id` to track prescriptions per appointment.
