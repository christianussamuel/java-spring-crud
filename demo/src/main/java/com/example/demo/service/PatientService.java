package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.GetPatientDataDto;
import com.example.demo.model.Patient;

public interface PatientService {

    List<Patient> getAllPatients(GetPatientDataDto getPatientDataDto);

    Patient findByFirstName(String firstName);

    Patient createPatient(Patient patient);

    Patient deleteByPatientId(String patientId);

    Patient updatePatient(Patient patient);

    Patient findByPhoneNumber(String phoneNumber);
}