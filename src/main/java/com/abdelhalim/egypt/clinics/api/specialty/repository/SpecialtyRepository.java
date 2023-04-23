package com.abdelhalim.egypt.clinics.api.specialty.repository;

import com.abdelhalim.egypt.clinics.entities.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long>, JpaSpecificationExecutor<Specialty> {


}