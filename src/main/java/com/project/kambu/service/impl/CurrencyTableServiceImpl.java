package com.project.kambu.service.impl;

import com.project.kambu.exception.ExceptionCode;
import com.project.kambu.exception.RequestException;
import com.project.kambu.model.dto.CurrencyDto;
import com.project.kambu.model.dto.CurrencyTableDto;
import com.project.kambu.model.entity.Currency;
import com.project.kambu.model.entity.CurrencyTable;
import com.project.kambu.repo.CurrencyRepository;
import com.project.kambu.repo.CurrencyTableRepository;
import com.project.kambu.service.CurrencyTableService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CurrencyTableServiceImpl implements CurrencyTableService {

    private final CurrencyTableRepository tableRepository;
    private final CurrencyRepository currencyRepository;

    public CurrencyTableServiceImpl(CurrencyTableRepository tableRepository, CurrencyRepository currencyRepository) {
        this.tableRepository = tableRepository;
        this.currencyRepository = currencyRepository;
    }


    @Override
    public void getCurrencyTable() {
        RestTemplate restTemplate = new RestTemplate();

        CurrencyTableDto[] apiCurrencyTable =
                restTemplate.getForObject(
                        "http://api.nbp.pl/api/exchangerates/tables/C", CurrencyTableDto[].class);
        if (apiCurrencyTable.length != 1) {
            throw new RequestException(
                    "Currency table length must be equal to 1",
                    ExceptionCode.VALIDATION_ERROR);
        }
        CurrencyTableDto currencyTableDto = apiCurrencyTable[0];

        CurrencyTable currencyTable = mapCurrencyTable(currencyTableDto);
        tableRepository.save(currencyTable);

        List<Currency> currencies =
                currencyTableDto.getRates().stream()
                        .map(rate -> mapCurrency(rate, currencyTable))
                        .collect(Collectors.toList());
        currencyRepository.saveAll(currencies);

    }

    private static CurrencyTable mapCurrencyTable(CurrencyTableDto currencyTableDto) {
        return CurrencyTable.builder()
                .idD(currencyTableDto.getTable())
                .no(currencyTableDto.getNo())
                .tradingDate(currencyTableDto.getTradingDate())
                .effectiveDate(currencyTableDto.getEffectiveDate())
                .build();
    }

    private static Currency mapCurrency(CurrencyDto rate, CurrencyTable currencyTable) {
        return Currency.builder()
                .tableId(currencyTable)
                .currency(rate.getCurrency())
                .code(rate.getCode())
                .bid(rate.getBid())
                .ask(rate.getAsk())
                .build();
    }


}
