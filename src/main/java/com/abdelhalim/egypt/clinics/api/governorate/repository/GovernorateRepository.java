package com.abdelhalim.egypt.clinics.api.governorate.repository;

import com.abdelhalim.egypt.clinics.api.governorate.entity.Governorate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GovernorateRepository extends JpaRepository<Governorate, Integer>, JpaSpecificationExecutor<Governorate> {
}