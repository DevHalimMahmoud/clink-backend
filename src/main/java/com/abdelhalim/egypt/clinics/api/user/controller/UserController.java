package com.abdelhalim.egypt.clinics.api.user.controller;

import com.abdelhalim.egypt.clinics.api.user.dto.UserDto;
import com.abdelhalim.egypt.clinics.api.user.dto.UserDtoWithSpecialityId;
import com.abdelhalim.egypt.clinics.api.user.entity.User;
import com.abdelhalim.egypt.clinics.api.user.service.UserService;
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
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated UserDtoWithSpecialityId userDtoWithSpecialityId) {
        userService.save(userDtoWithSpecialityId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id) {
        UserDto governorate = userService.findById(id);
        return ResponseEntity.ok(governorate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<User>> pageQuery(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<User> doctorPage = userService.findByCondition(pageable);
        return ResponseEntity.ok(doctorPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Validated UserDtoWithSpecialityId doctor) {
        userService.update(id, doctor);
        return ResponseEntity.ok().build();
    }
}