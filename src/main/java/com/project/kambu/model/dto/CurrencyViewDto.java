package com.project.kambu.model.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyViewDto {
    private String currency;

    private String code;
}
