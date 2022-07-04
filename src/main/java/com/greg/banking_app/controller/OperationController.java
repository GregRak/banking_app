package com.greg.banking_app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/operations")
public class OperationController {

    @GetMapping("{accountId}")
    public String getOperations(@PathVariable Long accountId) {
        return "This is list of operations";
    }

    @GetMapping("{accountId}/{operationId}")
    public String getOperation(@PathVariable Long accountId, @PathVariable Long operationId) {
        return "This is a specific operation";
    }

    @PostMapping
    public String addOperation() {
        return "Operation ok";
    }
}
