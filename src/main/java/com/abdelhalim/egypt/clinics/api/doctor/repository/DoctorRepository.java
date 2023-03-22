package com.abdelhalim.egypt.clinics.api.doctor.repository;

import com.abdelhalim.egypt.clinics.api.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>, JpaSpecificationExecutor<Doctor> {

    @Modifying
    @Query("update Doctor d set d.name = ?1 where d.id = ?2")
    void updateNameById(String name, Long id);


}