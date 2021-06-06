package com.project.kambu.controller;

import com.project.kambu.model.dto.CurrencyRatesViewDto;
import com.project.kambu.model.dto.CurrencyViewDto;
import com.project.kambu.model.dto.FromToCurrencyDto;
import com.project.kambu.service.CurrencyService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping(path ="/available",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurrencyViewDto>> getCurrencyList() {
        return ResponseEntity.ok(currencyService.getCurrencyList());
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCount(@RequestBody FromToCurrencyDto fromToCurrencyDto) {
        return ResponseEntity.ok(currencyService.getCounted(
                fromToCurrencyDto.getFromCurrency(),
                fromToCurrencyDto.getToCurrency(),
                fromToCurrencyDto.getAmount())
        );
    }

    @GetMapping(path = "/current-rate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurrencyRatesViewDto>> getCurrentRates() {
        return ResponseEntity.ok(currencyService.getCurrentRates());
    }
}
