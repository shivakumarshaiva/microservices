package com.bank.accounts.dto;

import com.bank.accounts.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountDto extends BaseEntity {
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
