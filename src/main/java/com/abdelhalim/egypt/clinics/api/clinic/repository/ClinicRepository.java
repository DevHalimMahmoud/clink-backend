package com.abdelhalim.egypt.clinics.api.clinic.repository;

import com.abdelhalim.egypt.clinics.api.address.entity.Address;
import com.abdelhalim.egypt.clinics.api.clinic.entity.Clinic;
import com.abdelhalim.egypt.clinics.api.doctor.entity.Doctor;
import com.abdelhalim.egypt.clinics.api.speciality.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Integer>, JpaSpecificationExecutor<Clinic> {
    @Modifying
    @Query("""
            update Clinic c set c.name = ?1, c.address = ?2, c.phoneNumber = ?3, c.specialty = ?4, c.doctor = ?5
            where c.id = ?6""")
    void updateNameAndAddressAndPhoneNumberAndSpecialtyAndDoctorById(String name, Address address, String phoneNumber, Specialty specialty, Doctor doctor, Long id);

}
