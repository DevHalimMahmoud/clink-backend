package com.abdelhalim.egypt.clinics.api.address.repository;

import com.abdelhalim.egypt.clinics.api.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>, JpaSpecificationExecutor<Address> {

    @Modifying
    @Query("update Address a set a.name = ?1 where a.id = ?2")
    void updateNameById(@NonNull String name, @NonNull Long id);


}