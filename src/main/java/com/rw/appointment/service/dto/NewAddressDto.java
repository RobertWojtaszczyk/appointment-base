package com.rw.appointment.service.dto;

import com.rw.appointment.web.rest.validation.ValidUuid;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class NewAddressDto {

    @NotNull(message = "Pole city nie może być puste")
    @Size(min=1, max = 100, message = "Zła długość pola city")
    private String city;

    @NotNull(message = "Pole street nie może być puste")
    @Size(min=1, max = 100, message = "Zła długość pola street")
    private String street;

    @NotNull(message = "Pole propertyNumber nie może być puste")
    @Size(min=1, max = 30, message = "Zła długość pola propertyNumber")
    private String propertyNumber;

    @NotNull(message = "Pole postCode nie może być puste")
    @Size(min=6, max = 6, message = "Zła długość pola postCode")
    // TODO postalCode custom validator
    private String postCode;

    @NotNull(message = "Pole userId nie może być puste")
    @ValidUuid(message = "Nieprawidłowa wartość pola userId")
    private String userId;

    public String getCity() {
        return city;
    }

    public NewAddressDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public NewAddressDto setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public NewAddressDto setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
        return this;
    }

    public String getPostCode() {
        return postCode;
    }

    public NewAddressDto setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public NewAddressDto setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public String toString() {
        return "NewAddressDto{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", propertyNumber='" + propertyNumber + '\'' +
                ", postCode='" + postCode + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewAddressDto that = (NewAddressDto) o;
        return city.equals(that.city) &&
                street.equals(that.street) &&
                propertyNumber.equals(that.propertyNumber) &&
                postCode.equals(that.postCode) &&
                userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, propertyNumber, postCode, userId);
    }
}
