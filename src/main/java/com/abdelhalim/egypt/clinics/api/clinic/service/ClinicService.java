package com.abdelhalim.egypt.clinics.api.clinic.service;

import com.abdelhalim.egypt.clinics.api.address.repository.AddressRepository;
import com.abdelhalim.egypt.clinics.api.clinic.dto.ClinicDto;
import com.abdelhalim.egypt.clinics.api.clinic.dto.ClinicDtoWithIds;
import com.abdelhalim.egypt.clinics.api.clinic.entity.Clinic;
import com.abdelhalim.egypt.clinics.api.clinic.mapper.ClinicMapper;
import com.abdelhalim.egypt.clinics.api.clinic.repository.ClinicRepository;
import com.abdelhalim.egypt.clinics.api.doctor.repository.DoctorRepository;
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
public class ClinicService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    private ClinicRepository repository;
    @Autowired
    private ClinicMapper clinicMapper;

    public void save(ClinicDtoWithIds clinicDto) {
        Clinic entity = new Clinic();
        entity.setName(clinicDto.getName());
        entity.setNameAr(clinicDto.getNameAr());
        entity.setImage(clinicDto.getImage());
        entity.setPhoneNumber(clinicDto.getPhoneNumber());
        entity.setAddressList(addressRepository.findAllById(clinicDto.getAddressIds()));
        entity.setDoctorList(doctorRepository.findAllById(clinicDto.getDoctorIds()));
        repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ClinicDto findById(Long id) {

        return clinicMapper.toDto(repository.findById(id).orElseThrow());
    }

    public Page<Clinic> findByCondition(Pageable pageable) {
        Page<Clinic> entityPage = repository.findAll(pageable);
        List<Clinic> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    public void update(Long id, ClinicDtoWithIds clinic) {
        Clinic clinic1 = repository.getReferenceById(id);
        clinic1.setName(clinic.getName());
        clinic1.setPhoneNumber(clinic.getPhoneNumber());
        clinic1.setImage(clinic.getImage());
        clinic1.setNameAr(clinic.getNameAr());
        clinic1.setAddressList(addressRepository.findAllById(clinic.getAddressIds()));
        clinic1.setDoctorList(doctorRepository.findAllById(clinic.getDoctorIds()));
        repository.save(clinic1);
    }
}