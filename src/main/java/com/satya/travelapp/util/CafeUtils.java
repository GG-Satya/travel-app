package com.satya.travelapp.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CafeUtils {
    private CafeUtils(){}

    public static ResponseEntity<String> getResponseEntity(String msg, HttpStatus httpStatus){
        return new ResponseEntity<String>("message : "+msg, httpStatus);
    }
}
