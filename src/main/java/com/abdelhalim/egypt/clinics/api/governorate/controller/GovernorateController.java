package com.abdelhalim.egypt.clinics.api.governorate.controller;

import com.abdelhalim.egypt.clinics.api.governorate.dto.GovernorateDto;
import com.abdelhalim.egypt.clinics.api.governorate.service.GovernorateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/governorate")
@RestController
@Slf4j
public class GovernorateController {

    private final GovernorateService governorateService;

    public GovernorateController(GovernorateService governorateService) {
        this.governorateService = governorateService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated GovernorateDto governorateDto) {
        governorateService.save(governorateDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GovernorateDto> findById(@PathVariable("id") int id) {
        GovernorateDto governorate = governorateService.findById(id);
        return ResponseEntity.ok(governorate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        Optional.ofNullable(governorateService.findById(id)).orElseThrow();
        governorateService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<GovernorateDto>> pageQuery(GovernorateDto governorateDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<GovernorateDto> governoratePage = governorateService.findByCondition(governorateDto, pageable);
        return ResponseEntity.ok(governoratePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated GovernorateDto governorateDto, @PathVariable("id") int id) {
        governorateService.update(governorateDto, id);
        return ResponseEntity.ok().build();
    }
}