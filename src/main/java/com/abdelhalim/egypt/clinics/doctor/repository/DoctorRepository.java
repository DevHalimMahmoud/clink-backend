package com.abdelhalim.egypt.clinics.doctor.repository;

import com.abdelhalim.egypt.clinics.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}