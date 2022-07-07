package com.greg.banking_app.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/operations")
public class OperationController {

    @GetMapping("/account/{accountId}")
    public String getOperations(@PathVariable Long accountId) {
        return "This is list of operations";
    }

    @GetMapping(value = "dateRange", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getDateRangeOperations(@RequestBody String cos) {
        return "Description";
    }

    @GetMapping(value = "date/type", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void getDateAndTypeOperations(@RequestBody String cos) {
        //do something
    }

    @GetMapping("/operation/{operationId}")
    public String getOperation(@PathVariable Long operationId) {
        return "This is a specific operation";
    }

    @GetMapping(value = "date", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void getOperationsOfTheDay(@RequestBody String cos) {
        //Do something
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addOperation(@RequestBody String cos) {
        return "Operation ok";
    }
}
