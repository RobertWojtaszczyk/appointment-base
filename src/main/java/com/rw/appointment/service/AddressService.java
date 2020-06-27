package com.rw.appointment.service;

import com.rw.appointment.domain.errors.AddressResourceException;
import com.rw.appointment.repository.AddressRepository;
import com.rw.appointment.service.dto.AddressDto;
import com.rw.appointment.service.dto.NewAddressDto;
import com.rw.appointment.service.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AddressService {

    private AddressRepository addressRepository;
    private AddressMapper addressMapper;

    @Autowired
    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public AddressDto createAddress(NewAddressDto newAddressDto) {
        return addressMapper.addressToAddressDto(addressRepository.save(addressMapper.newAddressDtoToAddress(newAddressDto)));
    }

    public List<AddressDto> findAll() {
        return addressMapper.addressesToAddressesDto(addressRepository.findAll());
    }

    public AddressDto findOne(String id) { // dodać validator id-uuid w wywołującej metodzie
        UUID uuid = UUID.fromString(id);
        return addressRepository.findById(uuid)
                .map(addressMapper::addressToAddressDto)
                .orElseThrow(() -> new AddressResourceException("Address not found: " + uuid));
    }
}
