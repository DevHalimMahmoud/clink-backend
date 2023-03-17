package com.abdelhalim.egypt.clinics.api.speciality.repository;

import com.abdelhalim.egypt.clinics.api.speciality.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {

}