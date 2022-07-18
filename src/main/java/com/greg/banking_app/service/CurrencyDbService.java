package com.greg.banking_app.service;

import com.greg.banking_app.domain.CurrencyRates;
import com.greg.banking_app.repository.CurrencyRatesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyDbService {

    private final CurrencyRatesRepository currencyRatesRepository;

    public void saveCurrencyRates(final List<CurrencyRates> currencies) {
        for (CurrencyRates currentCurrency : currencies) {
            if (currencyRatesRepository.existsByCurrencyIsoCode(currentCurrency.getCurrencyIsoCode())) {
                CurrencyRates currencyRates = currencyRatesRepository.findByCurrencyIsoCode(currentCurrency.getCurrencyIsoCode());
                currencyRates.setTable(currentCurrency.getTable());
                currencyRates.setTableDate(currentCurrency.getTableDate());
                currencyRates.setTableNo(currentCurrency.getTableNo());
                currencyRates.setBuyRate(currentCurrency.getBuyRate());
                currencyRates.setSellRate(currentCurrency.getSellRate());
                currencyRatesRepository.save(currencyRates);
            } else {
                currencyRatesRepository.save(currentCurrency);
            }
        }
    }
}
