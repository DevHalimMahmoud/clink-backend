package com.abdelhalim.egypt.clinics.api.doctor.service;

import com.abdelhalim.egypt.clinics.api.doctor.dto.DoctorDto;
import com.abdelhalim.egypt.clinics.api.doctor.entity.Doctor;
import com.abdelhalim.egypt.clinics.api.doctor.mapper.DoctorMapper;
import com.abdelhalim.egypt.clinics.api.doctor.repository.DoctorRepository;
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
public class DoctorService {
    @Autowired
    private DoctorRepository repository;
    @Autowired
    private DoctorMapper doctorMapper;

    public void save(DoctorDto doctorDto) {
        Doctor entity = doctorMapper.toEntity(doctorDto);
        doctorMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public DoctorDto findById(Long id) {

        return doctorMapper.toDto(repository.findById(id).orElseThrow());
    }

    public Page<Doctor> findByCondition(Pageable pageable) {
        Page<Doctor> entityPage = repository.findAll(pageable);
        List<Doctor> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    public void update(Doctor doctor) {

        Doctor doctor1 = repository.getReferenceById(doctor.getId());
        doctor1.setName(doctor.getName());
        doctor1.setName_ar(doctor.getName_ar());
        doctor1.setImage(doctor.getImage());
        repository.save(doctor1);
    }
}