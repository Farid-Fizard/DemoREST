package com.myself.rest_demo.response;

import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class APIResponse <T>{
    private String message;
    private HttpStatus httpStatus;
    private T data;
    private LocalDateTime timestamp;

    public APIResponse(String message, HttpStatus httpStatus, T data) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

