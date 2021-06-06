package com.project.kambu.service.impl;

import com.project.kambu.exception.ExceptionCode;
import com.project.kambu.exception.RequestException;
import com.project.kambu.model.dto.CurrencyCountDto;
import com.project.kambu.model.dto.CurrencyRatesViewDto;
import com.project.kambu.model.dto.CurrencyViewDto;
import com.project.kambu.model.entity.Currency;
import com.project.kambu.repo.CurrencyRepository;
import com.project.kambu.repo.CurrencyTableRepository;
import com.project.kambu.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyTableRepository currencyTableRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository, CurrencyTableRepository currencyTableRepository) {
        this.currencyRepository = currencyRepository;
        this.currencyTableRepository = currencyTableRepository;
    }

    @Override
    public List<CurrencyViewDto> getCurrencyList() {
        return currencyRepository.findAllByTableId(currencyTableRepository.getById(1L))
                .stream()
                .map(CurrencyServiceImpl::mapToCurrencyViewDto)
                .collect(Collectors.toList());

    }


    @Override
    public CurrencyCountDto getCounted(String fromCurrency, String toCurrency, Double amount) {
        if (fromCurrency.length() != 3 || toCurrency.length() != 3) {
            throw new RequestException(
                    "Currencies must contain only 3 special symbols during standard ISO 4217",
                    ExceptionCode.VALIDATION_ERROR);
        } else if(fromCurrency.equalsIgnoreCase(toCurrency)) {
            return mapToCurrencyCountDto(toCurrency, amount);
        }  else if(fromCurrency.equalsIgnoreCase("PLN") && !toCurrency.equalsIgnoreCase("PLN")) {
            return mapToCurrencyCountDto(toCurrency, amount / currencyRepository.findCurrencyByCode(toCurrency).getAsk());
        } else if (!fromCurrency.equalsIgnoreCase("PLN") && toCurrency.equalsIgnoreCase("PLN")) {
            return mapToCurrencyCountDto(toCurrency, amount * currencyRepository.findCurrencyByCode(fromCurrency).getBid());
        }
        throw new RequestException(
                "Wrong values were entered",
                ExceptionCode.VALIDATION_ERROR);
    }


    @Override
    public List<CurrencyRatesViewDto> getCurrentRates() {
        return currencyRepository.findAllByTableId(currencyTableRepository.getById(1L))
                .stream()
                .map(CurrencyServiceImpl::mapToCurrencyRatesViewDto)
                .collect(Collectors.toList());
    }


    private static CurrencyViewDto mapToCurrencyViewDto(Currency currency) {
        return CurrencyViewDto.builder()
                .currency(currency.getCurrency())
                .code(currency.getCode())
                .build();
    }

    private static CurrencyRatesViewDto mapToCurrencyRatesViewDto(Currency currency) {
        return CurrencyRatesViewDto.builder()
                .currency(currency.getCurrency())
                .code(currency.getCode())
                .ask(currency.getAsk())
                .bid(currency.getBid())
                .build();
    }

    private static CurrencyCountDto mapToCurrencyCountDto(String toCurrency, Double amount) {
        return CurrencyCountDto.builder()
                .currency(toCurrency)
                .amount(amount)
                .build();
    }

}
