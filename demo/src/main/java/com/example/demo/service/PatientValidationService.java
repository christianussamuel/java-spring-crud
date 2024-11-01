package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.constant.StatusConstant;
import com.example.demo.constant.ValidationConstant;
import com.example.demo.dto.GetPatientDataDto;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientValidationService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatientDataValidation(Patient patient) {
        if (patient.getFirstName() == null || patient.getFirstName().isEmpty()) {
            throw new IllegalArgumentException(ValidationConstant.FIRST_NAME_REQUIRED);
        }

        if (patient.getGender() == null || patient.getGender().isEmpty()) {
            throw new IllegalArgumentException(ValidationConstant.GENDER_REQUIRED);
        }

        if (patient.getAddress() == null || patient.getAddress().isEmpty()) {
            throw new IllegalArgumentException(ValidationConstant.ADDRESS_REQUIRED);
        }

        if (patient.getDateOfBirth() == null || patient.getDateOfBirth().isEmpty()) {
            throw new IllegalArgumentException(ValidationConstant.DATE_OF_BIRTH_REQUIRED);
        }

        if (patient.getSuburb() == null || patient.getSuburb().isEmpty()) {
            throw new IllegalArgumentException(ValidationConstant.SUBURB_REQUIRED);
        }

        if (patient.getState() == null || patient.getState().isEmpty()) {
            throw new IllegalArgumentException(ValidationConstant.STATE_REQUIRED);
        }

        if (patient.getPostCode() == 0) {
            throw new IllegalArgumentException(ValidationConstant.POST_CODE_REQUIRED);
        }

        if (patient.getPhoneNumber() == null || patient.getPhoneNumber().isEmpty()) {
            throw new IllegalArgumentException(ValidationConstant.PHONE_NUMBER_REQUIRED);
        }

        if (patientRepository.findByPhoneNumber(patient.getPhoneNumber()).isPresent()) {
            throw new IllegalArgumentException(ValidationConstant.PHONE_NUMBER_ALREADY_REGISTERED);
        }
        return patient;
    }

    public void getPatientDataValidation(GetPatientDataDto getPatientDataDto) {
        if (!getPatientDataDto.getPaginationDto().getSort().isEmpty()) {
            if ((!getPatientDataDto.getPaginationDto().getSort().toLowerCase().equals(StatusConstant.ASC))
                    && (!getPatientDataDto.getPaginationDto().getSort().toLowerCase().equals(StatusConstant.DESC))) {
                throw new IllegalArgumentException(ValidationConstant.SORT_VALIDATION_ERROR);
            }
        }
    }
}
