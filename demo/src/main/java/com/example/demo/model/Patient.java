package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "patient_data")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "patient_identity")
    private String patientIdentity;

    @JsonProperty(value = "firstName")
    @Column(name = "first_name")
    private String firstName;

    @JsonProperty("lastName")
    @Column(name = "last_name")
    private String lastName;

    @JsonProperty(value = "dateOfBirth")
    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @JsonProperty(value = "gender")
    @Column(name = "gender")
    private String gender;

    @JsonProperty(value = "address")
    @Column(name = "address")
    private String address;

    @JsonProperty(value = "suburb")
    @Column(name = "suburb")
    private String suburb;

    @JsonProperty(value = "state")
    @Column(name = "state")
    private String state;

    @JsonProperty(value = "postCode")
    @Column(name = "post_code")
    private int postCode;

    @JsonProperty(value = "phoneNumber")
    @Column(name = "phone_number")
    private String phoneNumber;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "deleted_by")
    private String deletedBy;

}
