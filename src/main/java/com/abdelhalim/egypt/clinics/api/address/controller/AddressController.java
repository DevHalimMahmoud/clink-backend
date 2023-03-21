package com.abdelhalim.egypt.clinics.api.address.controller;

import com.abdelhalim.egypt.clinics.api.address.dto.AddressDto;
import com.abdelhalim.egypt.clinics.api.address.entity.Address;
import com.abdelhalim.egypt.clinics.api.address.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/address")
@RestController
@Slf4j
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated AddressDto addressDto) {
        addressService.save(addressDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> findById(@PathVariable("id") int id) {
        AddressDto addressDto = addressService.findById(id);
        return ResponseEntity.ok(addressDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        addressService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<Address>> pageQuery(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Address> doctorPage = addressService.findByCondition(pageable);
        return ResponseEntity.ok(doctorPage);
    }

//    @PutMapping
//    public ResponseEntity<Void> update(@RequestBody @Validated Doctor doctor) {
//        addressService.update(doctor);
//        return ResponseEntity.ok().build();
//    }
}