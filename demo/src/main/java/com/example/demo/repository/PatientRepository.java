package com.example.demo.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    Optional<Patient> findByFirstName(String firstName);

    Optional<Patient> findByPhoneNumber(String phoneNumber);

    List<Patient> findAllByFirstNameContaining(Pageable pages, String firstName);

    List<Patient> findAllByLastNameContaining(Pageable pages, String lastName);

    List<Patient> findAllByPatientIdentityContaining(Pageable pages, String patientIdentity);

}
