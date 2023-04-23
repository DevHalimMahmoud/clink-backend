package com.abdelhalim.egypt.clinics.api.clinic.controller;

import com.abdelhalim.egypt.clinics.api.clinic.dto.ClinicDto;
import com.abdelhalim.egypt.clinics.api.clinic.dto.ClinicDtoWithIds;
import com.abdelhalim.egypt.clinics.entities.Clinic;
import com.abdelhalim.egypt.clinics.api.clinic.service.ClinicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/clinic")
@RestController
@Slf4j
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated ClinicDtoWithIds clinicDtoWithIds) {
        clinicService.save(clinicDtoWithIds);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicDto> findById(@PathVariable("id") Long id) {
        ClinicDto governorate = clinicService.findById(id);
        return ResponseEntity.ok(governorate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        clinicService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<Clinic>> pageQuery(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Clinic> clinicPage = clinicService.findByCondition(pageable);
        return ResponseEntity.ok(clinicPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Validated ClinicDtoWithIds clinic) {

        clinicService.update(id, clinic);
        return ResponseEntity.ok().build();
    }
}