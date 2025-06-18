# User Stories for Smart Clinic Management System

## Admin Role

### Admin: Add New Doctor
- **Description**: As an Admin, I want to add a new doctor to the system so that the clinic can expand its medical staff.
- **Acceptance Criteria**:
  - Include fields for name, specialty, and contact info.
  - Validate required fields before submission.
  - Notify the admin of successful addition.
- **Priority**: High
- **Story Points**: 3

### Admin: View Monthly Doctor Performance
- **Description**: As an Admin, I want to view a report of doctors with the most patients by month so that I can recognize high-performing staff.
- **Acceptance Criteria**:
  - Display doctor ID, name, and patient count.
  - Filter by selected month and year.
  - Export report as CSV.
- **Priority**: Medium
- **Story Points**: 5

### Admin: Manage Patient Records
- **Description**: As an Admin, I want to manage patient records so that I can ensure data accuracy and compliance.
- **Acceptance Criteria**:
  - Allow editing of patient details (e.g., phone, email).
  - Prevent deletion of active patients with appointments.
  - Log all changes.
- **Priority**: High
- **Story Points**: 4

### Admin: Assign Doctor Schedules
- **Description**: As an Admin, I want to assign available time slots to doctors so that patients can book appointments.
- **Acceptance Criteria**:
  - Set multiple time slots per doctor.
  - Validate no overlapping slots.
  - Update doctor availability in real-time.
- **Priority**: Medium
- **Story Points**: 3

### Admin: Generate Annual Clinic Report
- **Description**: As an Admin, I want to generate an annual report of clinic operations so that I can assess performance.
- **Acceptance Criteria**:
  - Include total appointments and revenue.
  - Filter by year.
  - Provide downloadable PDF format.
- **Priority**: Low
- **Story Points**: 5

## Patient Role

### Patient: Search for Doctor by Name or Specialty
- **Description**: As a Patient, I want to search for a doctor by name or specialty so that I can find the right healthcare provider.
- **Acceptance Criteria**:
  - Include a search bar in the patient portal.
  - Return a list of doctors matching the search term.
  - Filter results by availability if possible.
- **Priority**: High
- **Story Points**: 2

### Patient: Book an Appointment
- **Description**: As a Patient, I want to book an appointment with a doctor so that I can schedule a consultation.
- **Acceptance Criteria**:
  - Select doctor and time slot.
  - Confirm booking with email notification.
  - Prevent double-booking.
- **Priority**: High
- **Story Points**: 3

### Patient: View Upcoming Appointments
- **Description**: As a Patient, I want to view my upcoming appointments so that I can manage my healthcare schedule.
- **Acceptance Criteria**:
  - Display appointment date, time, and doctor.
  - Sort by date in ascending order.
  - Show status (e.g., scheduled, canceled).
- **Priority**: Medium
- **Story Points**: 2

### Patient: Cancel an Appointment
- **Description**: As a Patient, I want to cancel an appointment so that I can adjust my plans.
- **Acceptance Criteria**:
  - Allow cancellation up to 24 hours before.
  - Notify doctor and patient via email.
  - Update availability slot.
- **Priority**: Medium
- **Story Points**: 3

### Patient: Request Prescription Refill
- **Description**: As a Patient, I want to request a prescription refill so that I can continue my treatment.
- **Acceptance Criteria**:
  - Submit request with prescription ID.
  - Receive approval/rejection notification.
  - Track request status.
- **Priority**: Low
- **Story Points**: 4

## Doctor Role

### Doctor: View Patient Appointments
- **Description**: As a Doctor, I want to view a list of my patient appointments so that I can prepare for consultations.
- **Acceptance Criteria**:
  - Display appointments with patient name, date, and time.
  - Sort appointments by date in ascending order.
  - Show only appointments assigned to the logged-in doctor.
- **Priority**: High
- **Story Points**: 2

### Doctor: Update Appointment Status
- **Description**: As a Doctor, I want to update the status of an appointment so that I can keep my schedule accurate.
- **Acceptance Criteria**:
  - Allow status changes (e.g., completed, canceled).
  - Notify patient of status change.
  - Log update timestamp.
- **Priority**: High
- **Story Points**: 3

### Doctor: Generate Daily Report
- **Description**: As a Doctor, I want to generate a daily appointment report so that I can review my workload.
- **Acceptance Criteria**:
  - Include patient names and times.
  - Filter by current date.
  - Export as PDF.
- **Priority**: Medium
- **Story Points**: 4

### Doctor: View Patient Details
- **Description**: As a Doctor, I want to view patient details during an appointment so that I can provide informed care.
- **Acceptance Criteria**:
  - Display name, email, and medical history.
  - Accessible only for scheduled patients.
  - Updateable during consultation.
- **Priority**: Medium
- **Story Points**: 3

### Doctor: Request Consultation Notes
- **Description**: As a Doctor, I want to request consultation notes from another doctor so that I can continue patient care.
- **Acceptance Criteria**:
  - Submit request with patient ID.
  - Receive notes via secure channel.
  - Track request status.
- **Priority**: Low
- **Story Points**: 4
