package com.abdelhalim.egypt.clinics.api.governorate.service;

import cn.hutool.core.bean.BeanUtil;
import com.abdelhalim.egypt.clinics.api.governorate.dto.GovernorateDto;
import com.abdelhalim.egypt.clinics.api.governorate.entity.Governorate;
import com.abdelhalim.egypt.clinics.api.governorate.mapper.GovernorateMapper;
import com.abdelhalim.egypt.clinics.api.governorate.repository.GovernorateRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Transactional
public class GovernorateService {
    private final GovernorateRepository repository;
    private final GovernorateMapper governorateMapper;

    public GovernorateService(GovernorateRepository repository, GovernorateMapper governorateMapper) {
        this.repository = repository;
        this.governorateMapper = governorateMapper;
    }

    public GovernorateDto save(GovernorateDto governorateDto) {
        Governorate entity = governorateMapper.toEntity(governorateDto);
        return governorateMapper.toDto(repository.save(entity));
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public GovernorateDto findById(int id) {
        return governorateMapper.toDto(repository.findById(id).orElseThrow());
    }

    public Page<GovernorateDto> findByCondition( Pageable pageable) {
        Page<Governorate> entityPage = repository.findAll(pageable);
        List<Governorate> entities = entityPage.getContent();
        return new PageImpl<>(governorateMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public GovernorateDto update(GovernorateDto governorateDto, int id) {
        GovernorateDto data = findById(id);
        Governorate entity = governorateMapper.toEntity(governorateDto);
        BeanUtil.copyProperties(data, entity);
        return save(governorateMapper.toDto(entity));
    }
}