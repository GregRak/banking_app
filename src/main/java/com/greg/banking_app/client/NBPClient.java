package com.greg.banking_app.client;

import com.greg.banking_app.dto.NBPClient.NBPTableCDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NBPClient {

    private final RestTemplate restTemplate;

    @Value("${nbp.api.exchange.endpoint}")
    private String NBPApiEndpoint;

    public List<NBPTableCDto> getNBPTableC() {
        NBPTableCDto[] tableResponse = restTemplate.getForObject(
                NBPApiEndpoint + "/tables/c", NBPTableCDto[].class);

        return Optional.ofNullable(tableResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }
}
