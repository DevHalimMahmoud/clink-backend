package com.abdelhalim.egypt.clinics.api.governorate.service;

import com.abdelhalim.egypt.clinics.api.governorate.dto.GovernorateDto;
import com.abdelhalim.egypt.clinics.api.governorate.entity.Governorate;
import com.abdelhalim.egypt.clinics.api.governorate.mapper.GovernorateMapper;
import com.abdelhalim.egypt.clinics.api.governorate.repository.GovernorateRepository;
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
public class GovernorateService {
    @Autowired
    private GovernorateRepository repository;
    @Autowired
    private GovernorateMapper governorateMapper;

    public GovernorateDto save(GovernorateDto governorateDto) {
        Governorate entity = governorateMapper.toEntity(governorateDto);
        return governorateMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public GovernorateDto findById(Long id) {
        return governorateMapper.toDto(repository.findById(id).orElseThrow());
    }

    public Page<Governorate> findByCondition(Pageable pageable) {
        Page<Governorate> entityPage = repository.findAll(pageable);
        List<Governorate> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    public void update(Governorate governorate) {

        repository.updateNameAndName_arById(governorate.getName(), governorate.getName_ar(), governorate.getId());
    }
}