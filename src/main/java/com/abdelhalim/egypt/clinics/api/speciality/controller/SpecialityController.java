package com.abdelhalim.egypt.clinics.api.speciality.controller;

import com.abdelhalim.egypt.clinics.api.speciality.dto.SpecialityDto;
import com.abdelhalim.egypt.clinics.api.speciality.entity.Specialty;
import com.abdelhalim.egypt.clinics.api.speciality.service.SpecialtyService;
import lombok.extern.slf4j.Slf4j;
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

    private final SpecialtyService specialtyService;

    public SpecialityController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> save(@RequestBody @Validated SpecialityDto specialityDto) {
        specialtyService.save(specialityDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SpecialityDto> findById(@PathVariable("id") int id) {
        SpecialityDto specialityDto = specialtyService.findById(id);
        return ResponseEntity.ok(specialityDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        specialtyService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<Specialty>> pageQuery(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Specialty> specialtyPage = specialtyService.findByCondition(pageable);
        return ResponseEntity.ok(specialtyPage);
    }

    @PutMapping("/update_name")
    public ResponseEntity<Void> update(@RequestBody @Validated Specialty specialty) {
        specialtyService.update(specialty);
        return ResponseEntity.ok().build();
    }
}