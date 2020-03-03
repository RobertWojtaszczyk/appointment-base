package com.rw.appointment.service.dto;

import com.rw.appointment.config.Constants;
import com.rw.appointment.domain.Address;
import com.rw.appointment.domain.Authority;
import com.rw.appointment.domain.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserDto {

    private UUID id;

    @NotBlank
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    private String login;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @Email
    @Size(min = 5, max = 254)
    private String email;

    @Size(max = 256)
    private String imageUrl;

    private boolean activated = false;

    private List<Address> address;

    private String createdBy;

    private long createdDate;

    private String lastModifiedBy;

    private long lastModifiedDate;

    private Set<String> authorities;

    public UserDto() {
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.activated = user.isActivated();
        this.imageUrl = user.getImageUrl();
        this.createdDate = user.getCreatedDate();
        this.lastModifiedDate = user.getModifiedDate();
        this.authorities = user.getAuthorities().stream()
                .map(Authority::getName)
                .collect(Collectors.toSet());
        this.address = user.getAddress();
    }

    public UUID getId() {
        return id;
    }

    public UserDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public boolean isActivated() {
        return activated;
    }

    public UserDto setActivated(boolean activated) {
        this.activated = activated;
        return this;
    }

    public List<Address> getAddress() {
        return address;
    }

    public UserDto setAddress(List<Address> address) {
        this.address = address;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public UserDto setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public UserDto setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public UserDto setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
        return this;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public UserDto setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public long getLastModifiedDate() {
        return lastModifiedDate;
    }

    public UserDto setLastModifiedDate(long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", activated=" + activated +
                ", address=" + address +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                ", authorities=" + authorities +
                '}';
    }
}
