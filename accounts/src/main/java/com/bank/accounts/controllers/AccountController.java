package com.bank.accounts.controllers;

import com.bank.accounts.dto.AccountDto;
import com.bank.accounts.dto.ResponseDto;
import com.bank.accounts.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @PostMapping(path = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDto> createAccount(@RequestBody AccountDto accountsDto) {
        ResponseDto responseDto = null;
        try {
            responseDto = ResponseDto.builder()
                    .message("Account created successfully")
                    .statusCode("200")
                    .data(accountService.createAccount(accountsDto)) // Explicit cast
                    .build();
        } catch (NullPointerException e) {
            responseDto = ResponseDto.builder()
                    .message("Account object is null")
                    .statusCode("400")
                    .build();
        } catch (Exception e) {
            responseDto = ResponseDto.builder()
                    .message("Something went wrong")
                    .statusCode("500")
                    .build();
        }
        return ResponseEntity.ok(responseDto);
    }
}
