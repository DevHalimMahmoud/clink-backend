package com.abdelhalim.egypt.clinics.api.address.service;

import com.abdelhalim.egypt.clinics.api.address.dto.AddressDto;
import com.abdelhalim.egypt.clinics.api.address.dto.AddressDtoWithGovernorateId;
import com.abdelhalim.egypt.clinics.api.address.mapper.AddressMapperBase;
import com.abdelhalim.egypt.clinics.entities.Address;
import com.abdelhalim.egypt.clinics.api.address.repository.AddressRepository;
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
public class AddressService {
    @Autowired
    private AddressRepository repository;
    @Autowired
    private AddressMapperBase doctorMapper;
    @Autowired
    private GovernorateRepository governorateRepository;

    public void save(AddressDtoWithGovernorateId doctorDto) {

        Address entity = new Address();
        entity.setName(doctorDto.getName());
        entity.setNameAr(doctorDto.getNameAr());
        entity.setGovernorate(governorateRepository.getReferenceById(doctorDto.getGovernorateId()));
        repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public AddressDto findById(Long id) {

        return doctorMapper.toDto(repository.findById(id).orElseThrow());
    }

    public Page<Address> findByCondition(Pageable pageable) {


        Page<Address> entityPage = repository.findAll(pageable);
        List<Address> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    public void update(Long id, AddressDtoWithGovernorateId address) {

        Address address1 = repository.getReferenceById(id);
        address1.setName(address.getName());
        address1.setNameAr(address.getNameAr());
        address1.setGovernorate(governorateRepository.getReferenceById(address.getGovernorateId()));
        repository.save(address1);

    }
}