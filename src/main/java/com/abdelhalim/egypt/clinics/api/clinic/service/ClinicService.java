package com.abdelhalim.egypt.clinics.api.clinic.service;

import com.abdelhalim.egypt.clinics.api.clinic.dto.ClinicDto;
import com.abdelhalim.egypt.clinics.api.clinic.dto.ClinicDtoWithIds;
import com.abdelhalim.egypt.clinics.api.clinic.mapper.ClinicMapper;
import com.abdelhalim.egypt.clinics.entities.address.AddressRepository;
import com.abdelhalim.egypt.clinics.entities.clinic.Clinic;
import com.abdelhalim.egypt.clinics.entities.clinic.ClinicRepository;
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
import java.util.Base64;
import java.util.List;

@Slf4j
@Service
@Transactional
public class ClinicService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private ClinicRepository repository;
    @Autowired
    private ClinicMapper clinicMapper;

    public void save(ClinicDtoWithIds clinicDto) {
        Clinic entity = new Clinic();
        entity.setName(clinicDto.getName());
        entity.setNameAr(clinicDto.getNameAr());
        entity.setPhoneNumber(clinicDto.getPhoneNumber());
        entity.setAddressList(addressRepository.findAllById(clinicDto.getAddressIds()));
        entity.setUserList(userRepository.findAllById(clinicDto.getDoctorIds()));
        try {
            String extension = Base64Utils.getFileExtensionFromBase64(clinicDto.getImage());
            byte[] decodedBytes = Base64.getDecoder().decode(clinicDto.getImage().split(",")[1]);

            String url = ImageUtils.uploadObjectFromMemory("clink-3b1fe.appspot.com", "clinic/" + entity.getId(), decodedBytes, extension);
            entity.setImage(url);
            repository.save(entity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        repository.save(entity);
    }

    public void deleteById(Long id) {
        ImageUtils.deleteImage("clink-3b1fe.appspot.com", "specialty/" + id);
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
        clinic1.setUserList(userRepository.findAllById(clinic.getDoctorIds()));
        try {
            ImageUtils.deleteImage("clink-3b1fe.appspot.com", "specialty/" + id);
            String extension = Base64Utils.getFileExtensionFromBase64(clinic.getImage());
            byte[] decodedBytes = Base64.getDecoder().decode(clinic.getImage().split(",")[1]);

            String url = ImageUtils.uploadObjectFromMemory("clink-3b1fe.appspot.com", "specialty/" + id, decodedBytes, extension);
            clinic1.setImage(url);
            repository.save(clinic1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}