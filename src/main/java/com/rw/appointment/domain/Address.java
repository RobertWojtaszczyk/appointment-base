package com.rw.appointment.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(length = 100)
    private String city;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(length = 100)
    private String street;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(length = 30)
    private String propertyNumber;

    @NotNull
    @Size(min = 6, max = 6)
    @Column(length = 6)
    private String postCode;

    @JsonBackReference // prevent infinite loop while fetching users
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // User

    public UUID getId() {
        return id;
    }

    public Address setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public User getUser() {
        return user;
    }

    public Address setUser(User user) {
        this.user = user;
        return this;
    }

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id.equals(address.id) &&
                city.equals(address.city) &&
                street.equals(address.street) &&
                propertyNumber.equals(address.propertyNumber) &&
                postCode.equals(address.postCode) &&
                user.equals(address.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, street, propertyNumber, postCode, user);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", propertyNumber='" + propertyNumber + '\'' +
                ", postCode='" + postCode + '\'' +
                ", userId=" + user +
                '}';
    }
}
