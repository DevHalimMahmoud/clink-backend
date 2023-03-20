package com.abdelhalim.egypt.clinics.api.doctor.controller;

import com.abdelhalim.egypt.clinics.api.doctor.dto.DoctorDto;
import com.abdelhalim.egypt.clinics.api.doctor.entity.Doctor;
import com.abdelhalim.egypt.clinics.api.doctor.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/doctor")
@RestController
@Slf4j
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated DoctorDto doctorDto) {
        doctorService.save(doctorDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> findById(@PathVariable("id") int id) {
        DoctorDto governorate = doctorService.findById(id);
        return ResponseEntity.ok(governorate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        doctorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<Doctor>> pageQuery(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Doctor> doctorPage = doctorService.findByCondition(pageable);
        return ResponseEntity.ok(doctorPage);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Validated Doctor doctor) {
        doctorService.update(doctor);
        return ResponseEntity.ok().build();
    }
}