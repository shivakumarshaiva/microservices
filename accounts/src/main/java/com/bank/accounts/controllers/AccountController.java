package com.bank.accounts.controllers;

import com.bank.accounts.dto.AccountDto;
import com.bank.accounts.services.AccountService;
import com.bank.accounts.utils.response.APIResponse;
import com.bank.accounts.utils.response.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
        try {
            AccountDto createdAccount = accountService.createAccount(accountsDto);
            return APIResponse.buildResponse(HttpStatus.CREATED, "Account created successfully", createdAccount);
        } catch (IllegalArgumentException e) {
            return APIResponse.buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            return APIResponse.buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create account: " + e.getMessage());
        }
    }
}
