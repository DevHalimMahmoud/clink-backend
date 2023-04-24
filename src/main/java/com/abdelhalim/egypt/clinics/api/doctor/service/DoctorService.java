package com.abdelhalim.egypt.clinics.api.doctor.service;

import com.abdelhalim.egypt.clinics.api.doctor.dto.DoctorDto;
import com.abdelhalim.egypt.clinics.api.doctor.dto.DoctorDtoWithSpecialityId;
import com.abdelhalim.egypt.clinics.api.doctor.mapper.DoctorMapper;
import com.abdelhalim.egypt.clinics.entities.specialty.Specialty;
import com.abdelhalim.egypt.clinics.entities.specialty.SpecialtyRepository;
import com.abdelhalim.egypt.clinics.entities.user.User;
import com.abdelhalim.egypt.clinics.entities.user.UserRepository;
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
    private UserRepository repository;
    @Autowired
    private DoctorMapper doctorMapper;

    public void save(DoctorDtoWithSpecialityId dto) {
        User entity = new User();
        entity.setName(dto.getName());
        entity.setNameAr(dto.getNameAr());
        List<Specialty> specialtyList = new ArrayList<>(specialtyRepository.findAllById(dto.getSpecialityIds()));
        entity.setSpecialtyList(specialtyList);

        try {
            String extension = Base64Utils.getFileExtensionFromBase64(dto.getImage());
            byte[] decodedBytes = Base64.getDecoder().decode(dto.getImage().split(",")[1]);

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

        return doctorMapper.toDto(repository.findById(id).orElseThrow());
    }

    public Page<User> findByCondition(Pageable pageable) {
        Page<User> entityPage = repository.findAll(pageable);
        List<User> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    public void update(Long id, DoctorDtoWithSpecialityId doctor) {

        User user1 = repository.getReferenceById(id);
        user1.setName(doctor.getName());
        user1.setNameAr(doctor.getNameAr());
        List<Specialty> specialtyList = new ArrayList<>(specialtyRepository.findAllById(doctor.getSpecialityIds()));
        user1.setSpecialtyList(specialtyList);
        try {
            ImageUtils.deleteImage("clink-3b1fe.appspot.com", "doctor/" + id);
            String extension = Base64Utils.getFileExtensionFromBase64(doctor.getImage());
            byte[] decodedBytes = Base64.getDecoder().decode(doctor.getImage().split(",")[1]);

            String url = ImageUtils.uploadObjectFromMemory("clink-3b1fe.appspot.com", "specialty/" + id, decodedBytes, extension);
            user1.setImage(url);
            repository.save(user1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}