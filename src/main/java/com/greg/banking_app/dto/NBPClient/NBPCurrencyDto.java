package com.greg.banking_app.dto.NBPClient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NBPCurrencyDto {

    @JsonProperty("code")
    private String currencyCode;

    @JsonProperty("bid")
    private BigDecimal buyRate;

    @JsonProperty("ask")
    private BigDecimal sellRate;
}
