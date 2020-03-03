package com.rw.appointment.web.rest;

import com.rw.appointment.service.AddressService;
import com.rw.appointment.service.dto.AddressDto;
import com.rw.appointment.service.dto.NewAddressDto;
import com.rw.appointment.web.rest.validation.ValidUuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated // @PathVariable Validation + ClientWebConfigJava
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/addresses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AddressDto findById(@PathVariable(value = "id") @ValidUuid String uuid) {
        return addressService.findOne(uuid);
    }

    @GetMapping(value = "/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AddressDto> getAddresses() {
        return addressService.findAll();
    }

    @PostMapping(value = "/addresses", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AddressDto addAddress(@RequestBody @Valid NewAddressDto newAddressDto) {
        return addressService.createAddress(newAddressDto);
    }
}
