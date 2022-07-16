package com.greg.banking_app.controller;

import com.greg.banking_app.client.NBPClient;
import com.greg.banking_app.dto.NBPClient.NBPTableCDto;
import lombok.RequiredArgsConstructor;
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
    public void getNBPTable() {
        List<NBPTableCDto> NBPDtoList = client.getNBPTableC();
        NBPDtoList.forEach(NBPTableCDto -> {
            System.out.println("Table: " + NBPTableCDto.getTable());
            System.out.println("Table number : " + NBPTableCDto.getTableNo());
            System.out.println("Date : " + NBPTableCDto.getEffectiveDate());
            System.out.println("Currencies:");
            NBPTableCDto.getRates().forEach(NBPCurrencyDto -> {
                System.out.println("Name: " + NBPCurrencyDto.getCurrencyCode());
                System.out.println("Buy: " + NBPCurrencyDto.getBuyRate());
                System.out.println("Sell: " + NBPCurrencyDto.getSellRate());
            });
        });
    }
}
