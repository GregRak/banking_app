package com.greg.banking_app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/installments")
public class InstallmentController {

    @GetMapping("loan/{loanId}")
    public String getInstallments(@PathVariable Long loanId) {
        return "This is list of Installments";
    }

    @GetMapping("{loanId}/{installmentId}")
    public String getInstallment(@PathVariable Long loanId, @PathVariable Long installmentId) {
        return "This is specific installment";
    }

    @PutMapping
    public String updateInstallment() {
        return "loan updated";
    }
}
