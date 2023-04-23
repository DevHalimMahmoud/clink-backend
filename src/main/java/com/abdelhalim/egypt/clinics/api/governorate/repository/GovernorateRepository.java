package com.abdelhalim.egypt.clinics.api.governorate.repository;

import com.abdelhalim.egypt.clinics.entities.Governorate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GovernorateRepository extends JpaRepository<Governorate, Long>, JpaSpecificationExecutor<Governorate> {


}