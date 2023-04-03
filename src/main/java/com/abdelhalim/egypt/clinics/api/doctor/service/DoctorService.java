package com.abdelhalim.egypt.clinics.api.doctor.service;

import com.abdelhalim.egypt.clinics.api.doctor.dto.DoctorDto;
import com.abdelhalim.egypt.clinics.api.doctor.dto.DoctorDtoWithSpecialityId;
import com.abdelhalim.egypt.clinics.api.doctor.entity.Doctor;
import com.abdelhalim.egypt.clinics.api.doctor.mapper.DoctorDtoMapper;
import com.abdelhalim.egypt.clinics.api.doctor.repository.DoctorRepository;
import com.abdelhalim.egypt.clinics.api.specialty.entity.Specialty;
import com.abdelhalim.egypt.clinics.api.specialty.repository.SpecialtyRepository;
import com.abdelhalim.egypt.clinics.utils.Base64Utils;
import com.abdelhalim.egypt.clinics.utils.ImageUtils;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
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
        List<Specialty> specialtyList = new ArrayList<>(specialtyRepository.findAllById(doctorDtoWithSpecialityId.getSpecialityIds()));
        entity.setSpecialtyList(specialtyList);

        try {
            String extension = Base64Utils.getFileExtensionFromBase64(doctorDtoWithSpecialityId.getImage());
            byte[] decodedBytes = Base64.getDecoder().decode(doctorDtoWithSpecialityId.getImage().split(",")[1]);

            String url = ImageUtils.uploadObjectFromMemory("clink-3b1fe.appspot.com", "doctor/" + entity.getId(), decodedBytes, extension);
            entity.setImage(url);
            repository.save(entity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(Long id) {
        ImageUtils.deleteImage("clink-3b1fe.appspot.com", "doctor/" + id);
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
        List<Specialty> specialtyList = new ArrayList<>(specialtyRepository.findAllById(doctor.getSpecialityIds()));
        doctor1.setSpecialtyList(specialtyList);
        try {
            ImageUtils.deleteImage("clink-3b1fe.appspot.com", "doctor/" + id);
            String extension = Base64Utils.getFileExtensionFromBase64(doctor.getImage());
            byte[] decodedBytes = Base64.getDecoder().decode(doctor.getImage().split(",")[1]);

            String url = ImageUtils.uploadObjectFromMemory("clink-3b1fe.appspot.com", "specialty/" + id, decodedBytes, extension);
            doctor1.setImage(url);
            repository.save(doctor1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}