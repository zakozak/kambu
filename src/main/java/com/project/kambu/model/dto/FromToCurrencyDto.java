package com.project.kambu.model.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FromToCurrencyDto {
    private String fromCurrency;

    private String toCurrency;

    private Double amount;
}
