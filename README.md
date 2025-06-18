# Smart Clinic Management System

Welcome to the Smart Clinic Management System, a robust web application designed to streamline clinic operations in an African healthcare context. Built with Spring Boot, this system enables Admins, Patients, and Doctors to manage appointments, patient records, prescriptions, and more. The project leverages JPA for database interactions, RESTful APIs for communication, and stored procedures for reporting.

- **Last Updated**: June 18, 2025
- **Developed by**: Kelvin Chaula
- **License**: Apache 2.0

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Database Schema](#database-schema)
- [User Stories](#user-stories)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features
- **Admin**: Add doctors, manage patient records, assign schedules, and generate reports.
- **Patient**: Search for doctors, book/cancel appointments, view schedules, and request prescription refills.
- **Doctor**: View appointments, update statuses, generate reports, and request consultation notes.
- **Security**: JWT-based authentication for secure access.
- **Reporting**: Stored procedures for daily, monthly, and yearly appointment reports.

## Technologies
- **Backend**: Spring Boot 3.x
- **Database**: H2 (in-memory) with JPA/Hibernate
- **Authentication**: JWT (using JJWT library)
- **Build Tool**: Maven
- **REST**: Spring Web
- **Version Control**: Git/GitHub

## Prerequisites
- Java 17 or higher
- Maven 3.6+
- Git
- IDE (e.g., IntelliJ IDEA or VS Code)
- Postman or cURL (for API testing)

## Installation
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/smart-clinic-management-system.git
   cd smart-clinic-management-system
