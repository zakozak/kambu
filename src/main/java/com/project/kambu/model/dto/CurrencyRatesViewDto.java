package com.project.kambu.model.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyRatesViewDto {
    private String currency;

    private String code;

    private Double bid;

    private Double ask;
}
