package com.abdelhalim.egypt.clinics.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse<T> {
    private T data;
    private int status;
    private String message;
    private long timeStamp;
}
