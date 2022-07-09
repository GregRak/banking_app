package com.greg.banking_app.dto.user;

import com.greg.banking_app.dto.account.AccountBaseDto;
import com.greg.banking_app.dto.account.AccountWithLoansDto;
import com.greg.banking_app.dto.useraddress.UserAddressDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserWholeDataDto {

    private Long userId;
    private String peselNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private boolean active;
    private List<UserAddressDto> addresses;
    private List<AccountBaseDto> accounts;
}
