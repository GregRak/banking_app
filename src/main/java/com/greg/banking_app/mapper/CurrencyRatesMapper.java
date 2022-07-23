package com.greg.banking_app.mapper;

import com.greg.banking_app.domain.CurrencyRates;
import com.greg.banking_app.dto.NBPClient.NBPCurrencyDto;
import com.greg.banking_app.dto.NBPClient.NBPTableCDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyRatesMapper {

    public List<CurrencyRates> mapToCurrencyValue(final NBPTableCDto nbpTableCDto) {
        List<CurrencyRates> list = new ArrayList<>();
        List<NBPCurrencyDto> currencies = nbpTableCDto.getRates();
        String table = nbpTableCDto.getTable();
        String tableNo = nbpTableCDto.getTableNo();
        String date = nbpTableCDto.getEffectiveDate();
        for (NBPCurrencyDto currency : currencies) {
            CurrencyRates currentCurrency = new CurrencyRates(
                    table,
                    tableNo,
                    date,
                    currency.getCurrencyCode(),
                    currency.getBuyRate(),
                    currency.getSellRate()
            );
            list.add(currentCurrency);
        }
        return list;
    }
}
