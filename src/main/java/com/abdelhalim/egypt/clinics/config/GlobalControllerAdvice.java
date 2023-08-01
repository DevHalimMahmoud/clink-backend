package com.abdelhalim.egypt.clinics.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

// Target all Controllers annotated with @RestController
@ControllerAdvice(annotations = RestController.class)
public class GlobalControllerAdvice {

}
