package com.myself.rest_demo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static <T> ResponseEntity<APIResponse<T>> responseBuilder(
            String message, HttpStatus httpStatus, T data
    ){
        APIResponse<T> response= new APIResponse<>(message,httpStatus,data);
        return  new  ResponseEntity(response,httpStatus);
    }
}
