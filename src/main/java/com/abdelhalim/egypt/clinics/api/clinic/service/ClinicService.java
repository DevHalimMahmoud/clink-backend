package com.abdelhalim.egypt.clinics.api.clinic.service;

import com.abdelhalim.egypt.clinics.api.clinic.dto.ClinicDto;
import com.abdelhalim.egypt.clinics.api.clinic.entity.Clinic;
import com.abdelhalim.egypt.clinics.api.clinic.mapper.ClinicMapper;
import com.abdelhalim.egypt.clinics.api.clinic.repository.ClinicRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Transactional
public class ClinicService {
    @Autowired
    private ClinicRepository repository;
    @Autowired
    private ClinicMapper clinicMapper;

    public void save(ClinicDto clinicDto) {
        Clinic entity = clinicMapper.toEntity(clinicDto);
        clinicMapper.toDto(repository.save(entity));
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ClinicDto findById(int id) {

        return clinicMapper.toDto(repository.findById(id).orElseThrow());
    }

    public Page<Clinic> findByCondition(Pageable pageable) {
        Page<Clinic> entityPage = repository.findAll(pageable);
        List<Clinic> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    public void update(Clinic clinic) {

        repository.updateNameAndAddressAndPhoneNumberAndSpecialtyAndDoctorById(clinic.getName(), clinic.getAddress(), clinic.getPhoneNumber(), clinic.getSpecialty(), clinic.getDoctor(), clinic.getId());
    }
}