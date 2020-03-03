package com.rw.appointment.service.mapper;

import com.rw.appointment.domain.Address;
import com.rw.appointment.domain.User;
import com.rw.appointment.repository.UserRepository;
import com.rw.appointment.service.dto.AddressDto;
import com.rw.appointment.service.dto.NewAddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class AddressMapper {

    private UserRepository userRepository;

    @Autowired
    public AddressMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Address newAddressDtoToAddress(NewAddressDto newAddressDto) {
        UUID userUuid = UUID.fromString(newAddressDto.getUserId());
        User user = userRepository.findById(userUuid)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + newAddressDto.getUserId()));
        Address address = new Address();
        address.setCity(newAddressDto.getCity());
        address.setStreet(newAddressDto.getStreet());
        address.setPropertyNumber(newAddressDto.getPropertyNumber());
        address.setPostCode(newAddressDto.getPostCode());
        address.setUser(user);
        return address;
    }

    public AddressDto addressToAddressDto(Address address) {
        return AddressDto.AddressDtoBuilder.anAddressDto()
                .withId(address.getId())
                .withCity(address.getCity())
                .withStreet(address.getStreet())
                .withPropertyNumber(address.getPropertyNumber())
                .withPostCode(address.getPostCode())
                .withUser(address.getUser())
                .build();
    }

    public List<AddressDto> addressesToAddressesDto(Iterable<Address> addresses) {
        return StreamSupport.stream(addresses.spliterator(), false)
                .map(this::addressToAddressDto)
                .collect(Collectors.toList());
    }
}
