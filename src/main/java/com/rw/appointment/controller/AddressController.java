package com.rw.appointment.controller;

import com.rw.appointment.domain.Address;
import com.rw.appointment.domain.User;
import com.rw.appointment.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private AddressRepository addressRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping(value = "/address")
    Iterable<Address> getUsers() {
        return addressRepository.findAll();
    }

    @PostMapping(value = "/address", consumes = MediaType.APPLICATION_JSON_VALUE)
    Address addUser(@RequestBody Address address) {
        return addressRepository.save(address);
    }
}
