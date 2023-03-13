package com.abdelhalim.egypt.clinics.address.controler;

import com.abdelhalim.egypt.clinics.address.entity.Address;
import com.abdelhalim.egypt.clinics.address.repository.AddressRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressRepository addressRepository;


    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Address> addDoctor(@RequestBody Address address) {
        Optional<Address> optional = addressRepository.findById(address.getId());
        if (optional.isEmpty()) {
            return ResponseEntity.ok(addressRepository.save(address));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


//    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
//    public ResponseEntity<List<Comment>> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
//        return ResponseEntity.ok(commentRepository.findAllByReview(new Review(reviewId)));
//    }
}