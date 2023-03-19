package com.abdelhalim.egypt.clinics.api.governorate.repository;

import com.abdelhalim.egypt.clinics.api.governorate.entity.Governorate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GovernorateRepository extends JpaRepository<Governorate, Integer>, JpaSpecificationExecutor<Governorate> {
    @Modifying
    @Query("update Governorate g set g.name = ?1 where g.id = ?2")
    void updateNameById(String name, Long id);


}