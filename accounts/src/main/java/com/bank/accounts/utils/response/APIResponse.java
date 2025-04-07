package com.bank.accounts.utils.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class APIResponse<T> {
    public static  <T> ResponseEntity<ResponseDto> buildResponse(HttpStatus status, String message, T data) {
        ResponseDto response = ResponseDto.builder()
                .statusCode(String.valueOf(status.value()))
                .message(message)
                .data(data)
                .build();
        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<ResponseDto> buildErrorResponse(HttpStatus status, String message) {
        return buildResponse(status, message, null);
    }
}
