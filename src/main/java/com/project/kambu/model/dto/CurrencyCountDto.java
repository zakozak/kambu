package com.project.kambu.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyCountDto {

    @NotBlank
    @Size(min = 3, max = 3, message = "Currency code must contain 3 symbols")
    private String currency;

    @NotBlank
    @Size(min = 1, message = "Currency amount must contain at least 1 symbol")
    private Double amount;
}
