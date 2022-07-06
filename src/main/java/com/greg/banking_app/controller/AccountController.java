package com.greg.banking_app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/accounts")
public class AccountController {

    @GetMapping("{userId}")
    public String getAccounts(@PathVariable Long userId) {
        return "This is list of accounts";
    }

    @GetMapping("{userId}/{accountId}")
    public String getAccount(@PathVariable Long userId, @PathVariable Long accountId) {
        return "This is specific account";
    }

    @PostMapping
    public String createAccount() {
        return "Create account: ok";
    }

    @DeleteMapping("{accountId}")
    public String deactiveAccount() {
        return "account is deleted";
    }

    @PutMapping
    public String updateAccount() {
        return "account updated";
    }
}
