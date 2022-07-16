package com.greg.banking_app.dto.NBPClient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NBPTableCDto {

    @JsonProperty("table")
    private String table;

    @JsonProperty("no")
    private String tableNo;

    @JsonProperty("effectiveDate")
    private String effectiveDate;

    @JsonProperty("rates")
    private List<NBPCurrencyDto> rates;
}
