package com.example.demo.dto;

import com.example.demo.model.Patient;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetPatientDataDto {    
    
    @JsonProperty(value = "pagination")
    private PaginationDto paginationDto;

    @JsonProperty(value = "filter") 
    private Patient patient;
}
