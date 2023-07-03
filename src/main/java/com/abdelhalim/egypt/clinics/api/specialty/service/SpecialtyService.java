package com.abdelhalim.egypt.clinics.api.specialty.service;

import com.abdelhalim.egypt.clinics.api.specialty.dto.SpecialtyDto;
import com.abdelhalim.egypt.clinics.api.specialty.mapper.SpecialtyMapper;
import com.abdelhalim.egypt.clinics.entities.specialty.Specialty;
import com.abdelhalim.egypt.clinics.entities.specialty.SpecialtyRepository;
import com.abdelhalim.egypt.clinics.utils.ImageUtils;
import com.abdelhalim.egypt.clinics.utils.RandomUtils;
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
public class SpecialtyService {
    @Autowired
    private SpecialtyRepository repository;
    @Autowired
    private SpecialtyMapper specialtyMapper;

    public void save(SpecialtyDto specialtyDto) {
        Specialty entity = Specialty.builder()
                .name(specialtyDto.getName())
                .nameAr(specialtyDto.getNameAr())
                .image(ImageUtils.saveImageBase64(specialtyDto.getImage(), "specialty/" + RandomUtils.getRandomLong()))
                .build();

        repository.save(entity);

    }

    public void deleteById(Long id) {
        ImageUtils.deleteImage("specialty/" + id);
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
        specialty1.setImage(ImageUtils.saveImageBase64(specialty.getImage(), "specialty/" + RandomUtils.getRandomLong()));

        repository.save(specialty);


    }
}