package com.greg.banking_app.controller;

import com.greg.banking_app.client.NBPClient;
import com.greg.banking_app.dto.NBPClient.NBPTableCDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/nbp")
@RequiredArgsConstructor
public class NBPController {

    private final NBPClient client;

    @GetMapping("tableC")
    public ResponseEntity<List<NBPTableCDto>> getNBPTable() {
        return ResponseEntity.ok(client.getNBPTableC());
    }
}
