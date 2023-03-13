package com.abdelhalim.egypt.clinics.address.repository;

import com.abdelhalim.egypt.clinics.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {


}