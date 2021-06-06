package com.project.kambu.controller;

import com.project.kambu.service.CurrencyTableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final CurrencyTableService currencyTableService;

    public ApiController(CurrencyTableService currencyTableService) {
        this.currencyTableService = currencyTableService;
    }

    @PostMapping()
    public ResponseEntity<Object> createCurrencyTable() throws IOException {
        currencyTableService.getCurrencyTable();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
