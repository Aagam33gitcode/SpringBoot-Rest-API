package com.example.springComplete.Exception;
import ch.qos.logback.core.status.Status;
import lombok.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
@Getter
@Setter
class ApiError {
    private String msg;
    private int status;
    private LocalDateTime timestamp;

    public ApiError(String msg,int status) {
        this.msg = msg;
        this.status = status;
        this.timestamp = LocalDateTime.now();}

}
