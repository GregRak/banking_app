package com.greg.banking_app.mapper;

import com.greg.banking_app.domain.CurrencyRates;
import com.greg.banking_app.dto.NBPClient.NBPCurrencyDto;
import com.greg.banking_app.dto.NBPClient.NBPTableCDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurrencyRatesMapperTest {

    @Autowired
    private CurrencyRatesMapper mapper;

    @Test
    void mapToCurrencyValueTest() {
        //Given
        NBPCurrencyDto currencyDto1 =
                new NBPCurrencyDto("USD", new BigDecimal("4.4321"), new BigDecimal("4.5432"));
        NBPCurrencyDto currencyDto2 =
                new NBPCurrencyDto("EUR", new BigDecimal("5.4321"), new BigDecimal("5.5432"));
        NBPCurrencyDto currencyDto3 =
                new NBPCurrencyDto("CHF", new BigDecimal("6.4321"), new BigDecimal("6.5432"));
        List<NBPCurrencyDto> rates = List.of(currencyDto1, currencyDto2, currencyDto3);
        NBPTableCDto dto = new NBPTableCDto("C", "1111/C/Test", "TestDate", rates);
        //When
        List<CurrencyRates> list = mapper.mapToCurrencyValue(dto);
        //Then
        assertEquals(3, list.size());
        assertEquals("1111/C/Test", list.get(0).getTableNo());
        assertEquals(new BigDecimal("5.4321"), list.get(1).getBuyRate());
        assertEquals(new BigDecimal("6.5432"), list.get(2).getSellRate());
        assertNotEquals("USD", list.get(1).getCurrencyIsoCode());
        assertEquals("CHF", list.get(2).getCurrencyIsoCode());
    }
}