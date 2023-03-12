package com.abdelhalim.egypt.clinics.doctor.controler;

import com.abdelhalim.egypt.clinics.doctor.entity.Doctor;
import com.abdelhalim.egypt.clinics.doctor.repository.DoctorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorRepository doctorRepository;


    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Optional<Doctor> optional = doctorRepository.findById(doctor.getId());
        if (optional.isEmpty()) {
            return ResponseEntity.ok(doctorRepository.save(doctor));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


//    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
//    public ResponseEntity<List<Comment>> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
//        return ResponseEntity.ok(commentRepository.findAllByReview(new Review(reviewId)));
//    }
}