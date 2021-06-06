package com.project.kambu.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Currency {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private Double bid;

    @Column(nullable = false)
    private Double ask;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private CurrencyTable tableId;
}

