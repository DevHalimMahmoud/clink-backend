package com.abdelhalim.egypt.clinics.api.doctor.service;

import com.abdelhalim.egypt.clinics.api.doctor.dto.DoctorDto;
import com.abdelhalim.egypt.clinics.api.doctor.dto.DoctorDtoWithSpecialityId;
import com.abdelhalim.egypt.clinics.api.doctor.entity.Doctor;
import com.abdelhalim.egypt.clinics.api.doctor.mapper.DoctorDtoMapper;
import com.abdelhalim.egypt.clinics.api.doctor.repository.DoctorRepository;
import com.abdelhalim.egypt.clinics.api.specialty.entity.Specialty;
import com.abdelhalim.egypt.clinics.api.specialty.repository.SpecialtyRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class DoctorService {
    @Autowired
    private SpecialtyRepository specialtyRepository;
    @Autowired
    private DoctorRepository repository;
    @Autowired
    private DoctorDtoMapper doctorDtoMapper;

    public void save(DoctorDtoWithSpecialityId doctorDtoWithSpecialityId) {
        Doctor entity = new Doctor();
        entity.setName(doctorDtoWithSpecialityId.getName());
        entity.setNameAr(doctorDtoWithSpecialityId.getNameAr());
        entity.setImage(doctorDtoWithSpecialityId.getImage());
        List<Specialty> specialtyList = new ArrayList<>(specialtyRepository.findAllById(doctorDtoWithSpecialityId.getSpecialityIds()));
        entity.setSpecialtyList(specialtyList);
        repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public DoctorDto findById(Long id) {

        return doctorDtoMapper.toDto(repository.findById(id).orElseThrow());
    }

    public Page<Doctor> findByCondition(Pageable pageable) {
        Page<Doctor> entityPage = repository.findAll(pageable);
        List<Doctor> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    public void update(Long id, DoctorDtoWithSpecialityId doctor) {

        Doctor doctor1 = repository.getReferenceById(id);
        doctor1.setName(doctor.getName());
        doctor1.setNameAr(doctor.getNameAr());
        doctor1.setImage(doctor.getImage());
        List<Specialty> specialtyList = new ArrayList<>(specialtyRepository.findAllById(doctor.getSpecialityIds()));
        doctor1.setSpecialtyList(specialtyList);
        repository.save(doctor1);
    }
}