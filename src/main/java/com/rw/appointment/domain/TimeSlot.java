package com.rw.appointment.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDateTime timeSlotStart;

    private LocalDateTime timeSlotEnd;

    private TimeSlotStatus timeSlotStatus;

    @ManyToOne
    @JoinColumn(name = "contractor_id")
    private User contractor;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private String contractorComment;

    private String clientComment;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;

    public UUID getId() {
        return id;
    }

    public TimeSlot setId(UUID id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getTimeSlotStart() {
        return timeSlotStart;
    }

    public TimeSlot setTimeSlotStart(LocalDateTime timeSlotStart) {
        this.timeSlotStart = timeSlotStart;
        return this;
    }

    public LocalDateTime getTimeSlotEnd() {
        return timeSlotEnd;
    }

    public TimeSlot setTimeSlotEnd(LocalDateTime timeSlotEnd) {
        this.timeSlotEnd = timeSlotEnd;
        return this;
    }

    public TimeSlotStatus getTimeSlotStatus() {
        return timeSlotStatus;
    }

    public TimeSlot setTimeSlotStatus(TimeSlotStatus timeSlotStatus) {
        this.timeSlotStatus = timeSlotStatus;
        return this;
    }

    public User getContractor() {
        return contractor;
    }

    public TimeSlot setContractor(User contractor) {
        this.contractor = contractor;
        return this;
    }

    public User getClient() {
        return client;
    }

    public TimeSlot setClient(User client) {
        this.client = client;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public TimeSlot setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getContractorComment() {
        return contractorComment;
    }

    public TimeSlot setContractorComment(String contractorComment) {
        this.contractorComment = contractorComment;
        return this;
    }

    public String getClientComment() {
        return clientComment;
    }

    public TimeSlot setClientComment(String clientComment) {
        this.clientComment = clientComment;
        return this;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    /*public TimeSlot setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
        return this;
    }*/

    public long getModifiedDate() {
        return modifiedDate;
    }

    /*public TimeSlot setModifiedDate(long modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }*/

    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", timeSlotStart=" + timeSlotStart +
                ", timeSlotLength=" + timeSlotEnd +
                ", timeSlotStatus=" + timeSlotStatus +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
