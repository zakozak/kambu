package com.project.kambu.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "currency_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyTable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String idD;

    @Column(nullable = false)
    private String no;

    @Column(nullable = false)
    private Date tradingDate;

    @Column(nullable = false)
    private Date effectiveDate;

    @OneToMany(mappedBy = "tableId", fetch = FetchType.EAGER)
    @Column(nullable = false)
    private List<Currency> rates;

}

