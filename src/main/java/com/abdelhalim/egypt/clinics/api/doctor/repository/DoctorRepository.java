package com.abdelhalim.egypt.clinics.api.doctor.repository;

import com.abdelhalim.egypt.clinics.api.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {


}