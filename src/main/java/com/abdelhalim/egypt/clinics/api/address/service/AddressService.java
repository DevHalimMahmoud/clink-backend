package com.abdelhalim.egypt.clinics.api.address.service;

import com.abdelhalim.egypt.clinics.api.address.dto.AddressDto;
import com.abdelhalim.egypt.clinics.api.address.entity.Address;
import com.abdelhalim.egypt.clinics.api.address.mapper.AddressMapper;
import com.abdelhalim.egypt.clinics.api.address.repository.AddressRepository;
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
    private AddressMapper doctorMapper;

    public void save(AddressDto doctorDto) {
        Address entity = doctorMapper.toEntity(doctorDto);
        doctorMapper.toDto(repository.save(entity));
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

    public void update(Address address) {

        Address address1 = repository.getReferenceById(address.getId());
        address1.setName(address.getName());
        address1.setNameAr(address.getNameAr());
        repository.save(address1);

    }
}