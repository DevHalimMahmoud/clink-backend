package com.abdelhalim.egypt.clinics.api.speciality.repository;

import com.abdelhalim.egypt.clinics.api.speciality.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer>, JpaSpecificationExecutor<Specialty> {


    @Modifying
    @Query("update Specialty s set s.name = ?1 where s.id = ?2")
    void updateNameById(String name, int id);

}