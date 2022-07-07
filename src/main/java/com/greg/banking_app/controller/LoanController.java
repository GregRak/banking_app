package com.greg.banking_app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/loans")
public class LoanController {

    @GetMapping("{accountId}")
    public String getLoans() {
        return "This is list of Loans";
    }

    @GetMapping("loan/{loanId}")
    public String getLoan(@PathVariable Long loanId) {
        return "This is specific loan";
    }

    @PostMapping
    public String createLoan() {
        return "Create loan: ok";
    }

    @DeleteMapping("{loanId}")
    public String deactiveLoan() {
        return "loan is deleted";
    }

    @PutMapping
    public String updateLoan() {
        return "loan updated";
    }
}
