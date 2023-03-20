package com.abdelhalim.egypt.clinics.api.speciality.controller;

import com.abdelhalim.egypt.clinics.api.speciality.dto.SpecialityDto;
import com.abdelhalim.egypt.clinics.api.speciality.entity.Specialty;
import com.abdelhalim.egypt.clinics.api.speciality.service.SpecialtyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/speciality")
@RestController
@Slf4j
public class SpecialityController {
    @Autowired
    private SpecialtyService specialtyService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated SpecialityDto specialityDto) {
        specialtyService.save(specialityDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecialityDto> findById(@PathVariable("id") int id) {
        SpecialityDto specialityDto = specialtyService.findById(id);
        return ResponseEntity.ok(specialityDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        specialtyService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<Specialty>> pageQuery(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 20) Pageable pageable) {
        Page<Specialty> specialtyPage = specialtyService.findByCondition(pageable);
        return ResponseEntity.ok(specialtyPage);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Validated Specialty specialty) {
        specialtyService.update(specialty);
        return ResponseEntity.ok().build();
    }
}