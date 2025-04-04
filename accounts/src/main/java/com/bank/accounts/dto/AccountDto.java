package com.bank.accounts.dto;

import com.bank.accounts.entity.BaseEntity;
import lombok.Data;

@Data
public class AccountDto extends BaseEntity {
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
