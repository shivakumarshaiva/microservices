package com.bank.accounts.mapper;

import com.bank.accounts.dto.AccountDto;
import com.bank.accounts.entity.Account;

public class AccountsMapper {

    public static Account convertToEntity(AccountDto accountsDto) {
        Account account = new Account();
        account.setAccountNumber(accountsDto.getAccountNumber());
        account.setAccountType(accountsDto.getAccountType());
        account.setBranchAddress(accountsDto.getBranchAddress());
        return account;
    }

    public static AccountDto convertToDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setBranchAddress(account.getBranchAddress());
        return accountDto;
    }
}
