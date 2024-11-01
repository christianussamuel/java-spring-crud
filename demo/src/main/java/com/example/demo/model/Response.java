package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private int responseCode;
    private String responseDesc;
    private Object responseData;
}
