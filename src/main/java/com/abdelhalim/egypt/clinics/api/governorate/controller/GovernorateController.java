package com.abdelhalim.egypt.clinics.api.governorate.controller;

import com.abdelhalim.egypt.clinics.api.governorate.dto.GovernorateDto;
import com.abdelhalim.egypt.clinics.entities.Governorate;
import com.abdelhalim.egypt.clinics.api.governorate.service.GovernorateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/governorate")
@RestController
@Slf4j
public class GovernorateController {
    @Autowired
    private GovernorateService governorateService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated GovernorateDto governorateDto) {
        governorateService.save(governorateDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GovernorateDto> findById(@PathVariable("id") Long id) {
        GovernorateDto governorate = governorateService.findById(id);
        return ResponseEntity.ok(governorate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        governorateService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<Governorate>> pageQuery(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Governorate> governoratePage = governorateService.findByCondition(pageable);
        return ResponseEntity.ok(governoratePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Validated GovernorateDto governorateDto) {
        governorateService.update(id, governorateDto);
        return ResponseEntity.ok().build();
    }
}