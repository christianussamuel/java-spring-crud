package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constant.HttpConstant;
import com.example.demo.dto.GetPatientDataDto;
import com.example.demo.model.Patient;
import com.example.demo.model.Response;
import com.example.demo.service.PatientService;

@RestController
@RequestMapping("api/v1")
@SpringBootApplication
public class PatientController {

    Response response = new Response();

    @Autowired
    private PatientService patientService;

    @PostMapping("/create/patient")
    public ResponseEntity<Response> createPatientData(@RequestBody Patient patient) {
        try {
            patientService.createPatient(patient);

            response.setResponseCode(HttpConstant.SUCCESS_CODE);
            response.setResponseDesc(HttpConstant.SUCCESS_STATUS);
            response.setResponseData(patient);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        } catch (Exception e) {

            response.setResponseCode(HttpConstant.INTERNAL_SERVER_ERROR_CODE);
            response.setResponseDesc(HttpConstant.INTERNAL_SERVER_ERROR_STATUS);
            response.setResponseData(e);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
    }

    @PostMapping("/get/patient")
    public ResponseEntity<Response> getPatientData(@RequestBody GetPatientDataDto getPatientDataDto) {
        try {

            response.setResponseCode(HttpConstant.SUCCESS_CODE);
            response.setResponseDesc(HttpConstant.SUCCESS_STATUS);
            response.setResponseData(patientService.getAllPatients(getPatientDataDto));

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {

            response.setResponseCode(HttpConstant.INTERNAL_SERVER_ERROR_CODE);
            response.setResponseDesc(HttpConstant.INTERNAL_SERVER_ERROR_STATUS);
            response.setResponseData(e);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
    }

    @PostMapping("/delete/patient")
    public ResponseEntity<Response> deletePatientData(@RequestBody Patient patient) {
        try {

            response.setResponseCode(HttpConstant.SUCCESS_CODE);
            response.setResponseDesc(HttpConstant.SUCCESS_STATUS);
            response.setResponseData(patientService.deleteByPatientId(patient.getPatientIdentity()));

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {

            response.setResponseCode(HttpConstant.INTERNAL_SERVER_ERROR_CODE);
            response.setResponseDesc(HttpConstant.INTERNAL_SERVER_ERROR_STATUS);
            response.setResponseData(e);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
    }

    @PostMapping("/update/patient")
    public ResponseEntity<Response> updatePatientData(@RequestBody Patient patient) {
        try {

            response.setResponseCode(HttpConstant.SUCCESS_CODE);
            response.setResponseDesc(HttpConstant.SUCCESS_STATUS);
            response.setResponseData(patientService.updatePatient(patient));

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {

            response.setResponseCode(HttpConstant.INTERNAL_SERVER_ERROR_CODE);
            response.setResponseDesc(HttpConstant.INTERNAL_SERVER_ERROR_STATUS);
            response.setResponseData(e);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
    }

}
