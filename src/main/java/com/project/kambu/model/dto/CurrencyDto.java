package com.project.kambu.model.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {
    private String currency;

    private String code;

    private Double bid;

    private Double ask;

    private Long tableId;

    @Override
    public String toString() {
        return "CurrencyDto{" +
                "currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                ", tableId=" + tableId +
                '}';
    }
}

