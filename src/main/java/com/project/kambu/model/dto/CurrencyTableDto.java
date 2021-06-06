package com.project.kambu.model.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyTableDto {
    private String table;

    private String no;

    private Date tradingDate;

    private Date effectiveDate;

    private List<CurrencyDto> rates;

    @Override
    public String toString() {
        return "CurrencyTableDto{" +
                "table='" + table + '\'' +
                ", no='" + no + '\'' +
                ", tradingDate=" + tradingDate +
                ", effectiveDate=" + effectiveDate +
                ", rates=" + rates +
                '}';
    }
}
