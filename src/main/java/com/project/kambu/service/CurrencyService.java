package com.project.kambu.service;

import com.project.kambu.model.dto.CurrencyCountDto;
import com.project.kambu.model.dto.CurrencyRatesViewDto;
import com.project.kambu.model.dto.CurrencyViewDto;

import java.util.List;

public interface CurrencyService {
    List<CurrencyViewDto> getCurrencyList();

    CurrencyCountDto getCounted(String fromCurrency, String toCurrency, Double amount);

    List<CurrencyRatesViewDto> getCurrentRates();

}
