package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationDto {
    private int page;

    private int size;

    private String field;

    private String sort;
}
