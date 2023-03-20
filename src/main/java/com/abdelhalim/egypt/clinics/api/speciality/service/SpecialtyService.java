package com.abdelhalim.egypt.clinics.api.speciality.service;

import com.abdelhalim.egypt.clinics.api.speciality.dto.MultiLangSpecialityDto;
import com.abdelhalim.egypt.clinics.api.speciality.entity.Specialty;
import com.abdelhalim.egypt.clinics.api.speciality.mapper.MultiLangSpecialityMapper;
import com.abdelhalim.egypt.clinics.api.speciality.repository.SpecialtyRepository;
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
    private MultiLangSpecialityMapper multiLangSpecialityMapper;


    public void save(MultiLangSpecialityDto multiLangSpecialityDto) {
        Specialty entity = multiLangSpecialityMapper.toEntity(multiLangSpecialityDto);
        multiLangSpecialityMapper.toDto(repository.save(entity));
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public MultiLangSpecialityDto findById(int id) {
        Specialty specialty = repository.findById(id).orElseThrow();
            return multiLangSpecialityMapper.toDto(specialty);
    }

    public Page<Specialty> findByCondition(Pageable pageable) {
        Page<Specialty> entityPage = repository.findAll(pageable);
        List<Specialty> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    public void update(Specialty specialty) {

        repository.updateNameById(specialty.getName(), specialty.getId());
    }
}