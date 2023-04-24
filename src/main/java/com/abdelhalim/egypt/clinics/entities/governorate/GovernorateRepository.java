package com.abdelhalim.egypt.clinics.entities.governorate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GovernorateRepository extends JpaRepository<Governorate, Long>, JpaSpecificationExecutor<Governorate> {


}