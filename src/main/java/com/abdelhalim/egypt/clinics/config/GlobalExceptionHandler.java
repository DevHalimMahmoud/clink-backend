package com.abdelhalim.egypt.clinics.config;

import com.abdelhalim.egypt.clinics.base.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

// Target all Controllers annotated with @RestController
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<BaseResponse<Object>> handleException(Exception exc) {

        BaseResponse<Object> error = BaseResponse
                .builder()
                .message(exc.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(System.currentTimeMillis()).build();


        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
