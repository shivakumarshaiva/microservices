package com.bank.accounts.services.impl;

import com.bank.accounts.dto.AccountDto;
import com.bank.accounts.entity.Account;
import com.bank.accounts.mapper.AccountsMapper;
import com.bank.accounts.repository.AccountsRepository;
import com.bank.accounts.services.AccountService;
import com.bank.accounts.utils.RandomLoginGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service("Account Service")
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountsRepository accountsRepository;

    public AccountDto createAccount(AccountDto accountsDto) {
        Account account = AccountsMapper.convertToEntity(accountsDto);
        account.setAccountNumber(RandomLoginGenerator.generate10DigitNumber());
        account.setCreatedAt(LocalDate.now());
        account.setCreatedBy("Shiva");
        accountsRepository.save(account);
        accountsDto.setAccountNumber(account.getAccountNumber());
        accountsDto.setCreatedAt(account.getCreatedAt());
        accountsDto.setCreatedBy(account.getCreatedBy());
        return accountsDto;
    }
}
