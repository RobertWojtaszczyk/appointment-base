package com.rw.appointment.service.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.rw.appointment.domain.User;

import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) // Jackson does not need getters: https://www.baeldung.com/jackson-jsonmappingexception
public class AddressDto {

    private UUID id;
    private String city;
    private String street;
    private String propertyNumber;
    private String postCode;
    private User user;

    public static final class AddressDtoBuilder {
        private UUID id;
        private String city;
        private String street;
        private String propertyNumber;
        private String postCode;
        private User user;

        private AddressDtoBuilder() {
        }

        public static AddressDtoBuilder anAddressDto() {
            return new AddressDtoBuilder();
        }

        public AddressDtoBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public AddressDtoBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public AddressDtoBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressDtoBuilder withPropertyNumber(String propertyNumber) {
            this.propertyNumber = propertyNumber;
            return this;
        }

        public AddressDtoBuilder withPostCode(String postCode) {
            this.postCode = postCode;
            return this;
        }

        public AddressDtoBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public AddressDto build() {
            AddressDto addressDto = new AddressDto();
            addressDto.user = this.user;
            addressDto.city = this.city;
            addressDto.id = this.id;
            addressDto.propertyNumber = this.propertyNumber;
            addressDto.postCode = this.postCode;
            addressDto.street = this.street;
            return addressDto;
        }
    }
}
