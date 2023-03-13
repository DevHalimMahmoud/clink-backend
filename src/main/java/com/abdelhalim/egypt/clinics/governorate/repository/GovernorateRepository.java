package com.abdelhalim.egypt.clinics.governorate.repository;

import com.abdelhalim.egypt.clinics.governorate.entity.Governorate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GovernorateRepository extends JpaRepository<Governorate, Integer> {


}