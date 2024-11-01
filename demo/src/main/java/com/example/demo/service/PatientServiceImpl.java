package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.constant.StatusConstant;
import com.example.demo.constant.ValidationConstant;
import com.example.demo.dto.GetPatientDataDto;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientValidationService patientValidationService;

    @Override
    public List<Patient> getAllPatients(GetPatientDataDto getPatientDataDto) {
        patientValidationService.getPatientDataValidation(getPatientDataDto);

        Pageable pages = PageRequest.of(getPatientDataDto.getPaginationDto().getPage(),
                getPatientDataDto.getPaginationDto().getSize(),
                Sort.by(getPatientDataDto.getPaginationDto().getField()).ascending());

        if (getPatientDataDto.getPaginationDto().getSort().toLowerCase().equals(StatusConstant.DESC)) {
            pages = PageRequest.of(getPatientDataDto.getPaginationDto().getPage(),
                    getPatientDataDto.getPaginationDto().getSize(),
                    Sort.by(getPatientDataDto.getPaginationDto().getField()).descending());
        }

        if (getPatientDataDto.getPatient().getFirstName().length() > 2) {
            return patientRepository
                    .findAllByFirstNameContaining(pages,
                            getPatientDataDto.getPatient().getFirstName().toLowerCase());
        }
        if (getPatientDataDto.getPatient().getLastName().length() > 2) {
            return patientRepository
                    .findAllByLastNameContaining(pages,
                            getPatientDataDto.getPatient().getLastName().toLowerCase());
        }
        if (getPatientDataDto.getPatient().getPatientIdentity().length() > 2) {
            return patientRepository
                    .findAllByPatientIdentityContaining(pages,
                            getPatientDataDto.getPatient().getPatientIdentity());
        }

        return patientRepository.findAll(pages).getContent();
    }

    @Override
    public Patient createPatient(Patient patient) {
        patientValidationService.createPatientDataValidation(patient);

        patient.setFirstName(patient.getFirstName().toLowerCase());
        patient.setLastName(patient.getLastName().toLowerCase());
        patient.setCreatedAt(LocalDateTime.now());
        patient.setCreatedBy(ValidationConstant.SYSTEM);
        return patientRepository.save(patient);

    }

    @Override
    public Patient findByFirstName(String firstName) {
        Optional<Patient> patient = patientRepository.findByFirstName(firstName);
        if (patient.isPresent()) {
            return patient.get();
        }

        return null;
    }

    @Override
    public Patient deleteByPatientId(String patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException(ValidationConstant.PATIENT_NOT_FOUND));
        patient.setDeletedAt(LocalDateTime.now());
        patient.setDeletedBy(ValidationConstant.SYSTEM);
        patientRepository.save(patient);

        return null;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        patient.setPatientIdentity(patient.getPatientIdentity());
        patient.setUpdatedBy(ValidationConstant.SYSTEM);
        return patientRepository.save(patient);
    }

    @Override
    public Patient findByPhoneNumber(String phoneNumber) {
        Optional<Patient> patient = patientRepository.findByPhoneNumber(phoneNumber);
        if (patient.isPresent()) {
            return patient.get();
        }

        return null;
    }

}
