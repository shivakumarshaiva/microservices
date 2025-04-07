package com.bank.accounts.utils.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResponseDto<T> {
    private String statusCode;
    private String message;
    private T data;
}
