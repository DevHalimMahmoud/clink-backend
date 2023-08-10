package com.abdelhalim.egypt.clinics.entities.base_user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BaseUserRepository extends JpaRepository<BaseUser, Long>, JpaSpecificationExecutor<BaseUser> {

    Optional<BaseUser> findByPhone(String phone);

    Optional<BaseUser> findByEmail(String email);
}