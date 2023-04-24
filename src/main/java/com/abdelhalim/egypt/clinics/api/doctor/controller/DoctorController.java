package com.abdelhalim.egypt.clinics.api.doctor.controller;

import com.abdelhalim.egypt.clinics.api.doctor.dto.DoctorDto;
import com.abdelhalim.egypt.clinics.api.doctor.dto.DoctorDtoWithSpecialityId;
import com.abdelhalim.egypt.clinics.api.doctor.service.DoctorService;
import com.abdelhalim.egypt.clinics.entities.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/no_auth/doctor")
@RestController
@Slf4j
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated DoctorDtoWithSpecialityId doctorDtoWithSpecialityId) {
        doctorService.save(doctorDtoWithSpecialityId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> findById(@PathVariable("id") Long id) {
        DoctorDto doctorDto = doctorService.findById(id);
        return ResponseEntity.ok(doctorDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        doctorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<User>> pageQuery(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<User> doctorPage = doctorService.findByCondition(pageable);
        return ResponseEntity.ok(doctorPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Validated DoctorDtoWithSpecialityId doctorDtoWithSpecialityId) {
        doctorService.update(id, doctorDtoWithSpecialityId);
        return ResponseEntity.ok().build();
    }
}