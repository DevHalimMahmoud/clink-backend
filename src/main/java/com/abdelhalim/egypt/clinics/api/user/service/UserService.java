package com.abdelhalim.egypt.clinics.api.user.service;

import com.abdelhalim.egypt.clinics.api.user.dto.UserDto;
import com.abdelhalim.egypt.clinics.api.user.dto.UserDtoWithSpecialityId;
import com.abdelhalim.egypt.clinics.entities.User;
import com.abdelhalim.egypt.clinics.api.user.mapper.UserDtoMapperBase;
import com.abdelhalim.egypt.clinics.api.user.repository.UserRepository;
import com.abdelhalim.egypt.clinics.entities.Specialty;
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
public class UserService {
    @Autowired
    private SpecialtyRepository specialtyRepository;
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserDtoMapperBase userDtoMapper;

    public void save(UserDtoWithSpecialityId userDtoWithSpecialityId) {
        User entity = new User();
        entity.setName(userDtoWithSpecialityId.getName());
        entity.setNameAr(userDtoWithSpecialityId.getNameAr());
        List<Specialty> specialtyList = new ArrayList<>(specialtyRepository.findAllById(userDtoWithSpecialityId.getSpecialityIds()));
        entity.setSpecialtyList(specialtyList);

        try {
            String extension = Base64Utils.getFileExtensionFromBase64(userDtoWithSpecialityId.getImage());
            byte[] decodedBytes = Base64.getDecoder().decode(userDtoWithSpecialityId.getImage().split(",")[1]);

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

    public UserDto findById(Long id) {

        return userDtoMapper.toDto(repository.findById(id).orElseThrow());
    }

    public Page<User> findByCondition(Pageable pageable) {
        Page<User> entityPage = repository.findAll(pageable);
        List<User> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    public void update(Long id, UserDtoWithSpecialityId doctor) {

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