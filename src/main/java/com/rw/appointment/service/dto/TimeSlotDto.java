package com.rw.appointment.service.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.rw.appointment.domain.Address;
import com.rw.appointment.domain.User;

import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) // Jackson does not need getters: https://www.baeldung.com/jackson-jsonmappingexception
public class TimeSlotDto {

    private UUID id;
    private String timeSlotStart;
    private String timeSlotEnd;
    private String timeSlotStatus;
    private User contractor;
    private User client;
    private Address address;
    private String contractorComment;
    private String clientComment;
    private String createdDate;
    private String modifiedDate;

    public static final class TimeSlotDtoBuilder {
        private UUID id;
        private String timeSlotStart;
        private String timeSlotEnd;
        private int timeSlotLength;
        private String timeSlotStatus;
        private User contractor;
        private User client;
        private Address address;
        private String contractorComment;
        private String clientComment;
        private String createdDate;
        private String modifiedDate;

        private TimeSlotDtoBuilder() {
        }

        public static TimeSlotDtoBuilder aTimeSlotDto() {
            return new TimeSlotDtoBuilder();
        }

        public TimeSlotDtoBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public TimeSlotDtoBuilder withTimeSlotStart(String timeSlotStart) {
            this.timeSlotStart = timeSlotStart;
            return this;
        }

        public TimeSlotDtoBuilder withTimeSlotEnd(String timeSlotEnd) {
            this.timeSlotEnd = timeSlotEnd;
            return this;
        }

        public TimeSlotDtoBuilder withTimeSlotStatus(String timeSlotStatus) {
            this.timeSlotStatus = timeSlotStatus;
            return this;
        }

        public TimeSlotDtoBuilder withContractor(User contractor) {
            this.contractor = contractor;
            return this;
        }

        public TimeSlotDtoBuilder withClient(User client) {
            this.client = client;
            return this;
        }

        public TimeSlotDtoBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public TimeSlotDtoBuilder withContractorComment(String contractorComment) {
            this.contractorComment = contractorComment;
            return this;
        }

        public TimeSlotDtoBuilder withClientComment(String clientComment) {
            this.clientComment = clientComment;
            return this;
        }

        public TimeSlotDtoBuilder withCreatedDate(String createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public TimeSlotDtoBuilder withModifiedDate(String modifiedDate) {
            this.modifiedDate = modifiedDate;
            return this;
        }

        public TimeSlotDto build() {
            TimeSlotDto timeSlotDto = new TimeSlotDto();
            timeSlotDto.timeSlotEnd = this.timeSlotEnd;
            timeSlotDto.timeSlotStart = this.timeSlotStart;
            timeSlotDto.address = this.address;
            timeSlotDto.contractorComment = this.contractorComment;
            timeSlotDto.clientComment = this.clientComment;
            timeSlotDto.timeSlotStatus = this.timeSlotStatus;
            timeSlotDto.client = this.client;
            timeSlotDto.id = this.id;
            timeSlotDto.createdDate = this.createdDate;
            timeSlotDto.contractor = this.contractor;
            timeSlotDto.modifiedDate = this.modifiedDate;
            return timeSlotDto;
        }
    }

    public UUID getId() {
        return id;
    }

    public String getTimeSlotStart() {
        return timeSlotStart;
    }

    public String getTimeSlotEnd() {
        return timeSlotEnd;
    }

    public String getTimeSlotStatus() {
        return timeSlotStatus;
    }

    public User getContractor() {
        return contractor;
    }

    public User getClient() {
        return client;
    }

    public Address getAddress() {
        return address;
    }

    public String getContractorComment() {
        return contractorComment;
    }

    public String getClientComment() {
        return clientComment;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    @Override
    public String toString() {
        return "TimeSlotDto{" +
                "id=" + id +
                ", timeSlotStart='" + timeSlotStart + '\'' +
                ", timeSlotEnd='" + timeSlotEnd + '\'' +
                ", timeSlotStatus='" + timeSlotStatus + '\'' +
                ", contractorComment='" + contractorComment + '\'' +
                ", clientComment='" + clientComment + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                '}';
    }
}
