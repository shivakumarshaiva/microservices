package com.bank.accounts;
import com.bank.accounts.controllers.AccountController;
import com.bank.accounts.dto.AccountDto;
import com.bank.accounts.services.AccountService;
import com.bank.accounts.utils.response.ResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountControllerUnitTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @Test
    void createAccount_success() {
        // Arrange
        AccountDto accountsDto = new AccountDto(123L, "Savings", "Bengaluru");
        AccountDto createdAccount = new AccountDto(456L, "Savings", "Bengaluru");
        when(accountService.createAccount(accountsDto)).thenReturn(createdAccount);

        // Act
        ResponseEntity<ResponseDto> responseEntity = accountController.createAccount(accountsDto);
        ResponseDto<AccountDto> responseDto = responseEntity.getBody();

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(String.valueOf(HttpStatus.CREATED.value()), responseDto.getStatusCode());
        assertEquals("Account created successfully", responseDto.getMessage());
        assertEquals(createdAccount, responseDto.getData());
    }

    @Test
    void createAccount_badRequest() {
        // Arrange
        AccountDto accountsDto = new AccountDto(null, null, null);
        String errorMessage = "Invalid account details provided.";
        when(accountService.createAccount(any(AccountDto.class))).thenThrow(new IllegalArgumentException(errorMessage));

        // Act
        ResponseEntity<ResponseDto> responseEntity = accountController.createAccount(accountsDto);
        ResponseDto<Object> responseDto = responseEntity.getBody();

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(String.valueOf(HttpStatus.BAD_REQUEST.value()), responseDto.getStatusCode());
        assertEquals(errorMessage, responseDto.getMessage());
        assertEquals(null, responseDto.getData());
    }

    @Test
    void createAccount_internalServerError() {
        // Arrange
        AccountDto accountsDto = new AccountDto(789L, "Current", "Mumbai");
        String errorMessage = "Database error during account creation.";
        when(accountService.createAccount(accountsDto)).thenThrow(new RuntimeException(errorMessage));

        // Act
        ResponseEntity<ResponseDto> responseEntity = accountController.createAccount(accountsDto);
        ResponseDto<Object> responseDto = responseEntity.getBody();

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), responseDto.getStatusCode());
        assertEquals("Failed to create account: " + errorMessage, responseDto.getMessage());
        assertEquals(null, responseDto.getData());
    }
}