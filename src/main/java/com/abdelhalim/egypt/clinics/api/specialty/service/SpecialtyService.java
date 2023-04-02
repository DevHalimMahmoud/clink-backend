package com.abdelhalim.egypt.clinics.api.specialty.service;

import com.abdelhalim.egypt.clinics.api.specialty.dto.SpecialtyDto;
import com.abdelhalim.egypt.clinics.api.specialty.entity.Specialty;
import com.abdelhalim.egypt.clinics.api.specialty.mapper.SpecialtyMapper;
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
import java.util.Base64;
import java.util.List;


@Slf4j
@Service
@Transactional
public class SpecialtyService {
    @Autowired
    private SpecialtyRepository repository;
    @Autowired
    private SpecialtyMapper specialtyMapper;

    public void save(SpecialtyDto specialtyDto) {
        Specialty entity = specialtyMapper.toEntity(specialtyDto);

        try {
            String extension = Base64Utils.getFileExtensionFromBase64(specialtyDto.getImage());
            byte[] decodedBytes = Base64.getDecoder().decode(specialtyDto.getImage().split(",")[1]);

            String url = ImageUtils.uploadObjectFromMemory("clink-3b1fe.appspot.com", "specialty/" + entity.getId(), decodedBytes, extension);
            entity.setImage(url);
            repository.save(entity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteById(Long id) {
        ImageUtils.deleteImage("clink-3b1fe.appspot.com", "specialty/" + id);
        repository.deleteById(id);
    }

    public SpecialtyDto findById(Long id) {
        Specialty specialty = repository.findById(id).orElseThrow();
        return specialtyMapper.toDto(specialty);
    }

    public Page<Specialty> findByCondition(Pageable pageable) {
        Page<Specialty> entityPage = repository.findAll(pageable);
        List<Specialty> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    public void update(Specialty specialty) {

        Specialty specialty1 = repository.getReferenceById(specialty.getId());
        specialty1.setName(specialty.getName());
        specialty1.setNameAr(specialty.getNameAr());

        try {
            ImageUtils.deleteImage("clink-3b1fe.appspot.com", "specialty/" + specialty.getId());
            String extension = Base64Utils.getFileExtensionFromBase64(specialty.getImage());
            byte[] decodedBytes = Base64.getDecoder().decode(specialty.getImage().split(",")[1]);

            String url = ImageUtils.uploadObjectFromMemory("clink-3b1fe.appspot.com", "specialty/" + specialty.getId(), decodedBytes, extension);
            specialty1.setImage(url);
            repository.save(specialty);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}