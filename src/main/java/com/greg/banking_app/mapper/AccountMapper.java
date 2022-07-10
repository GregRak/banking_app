package com.greg.banking_app.mapper;

import com.greg.banking_app.domain.Account;
import com.greg.banking_app.domain.User;
import com.greg.banking_app.dto.account.AccountBaseDto;
import com.greg.banking_app.exception.UserNotFoundException;
import com.greg.banking_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountMapper {

    @Autowired
    private UserRepository userRepository;

    public Account mapToAccount(final AccountBaseDto accountDto) throws UserNotFoundException {
        User currentUser = userRepository.findById(accountDto.getUserId()).orElseThrow(UserNotFoundException::new);
            return new Account(
                    accountDto.getAccountId(),
                    accountDto.getAccountNumber(),
                    accountDto.getOpenDate(),
                    accountDto.getCloseDate(),
                    accountDto.getPresentValue(),
                    accountDto.getCurrencySymbol(),
                    accountDto.isActive(),
                    currentUser
            );
    }

    public AccountBaseDto mapToAccountBaseDto(final Account account) {
        return new AccountBaseDto(
                account.getAccountId(),
                account.getAccountNumber(),
                account.getOpenDate(),
                account.getCloseDate(),
                account.getPresentValue(),
                account.getCurrencySymbol(),
                account.isActive(),
                account.getUser().getUserId()
        );
    }

    public List<AccountBaseDto> mapToAccountBaseDtoList(final List<Account> accounts) {
        return accounts.stream()
                .map(this::mapToAccountBaseDto)
                .collect(Collectors.toList());
    }
}
