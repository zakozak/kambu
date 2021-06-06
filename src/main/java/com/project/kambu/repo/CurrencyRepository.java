package com.project.kambu.repo;

import com.project.kambu.model.entity.Currency;
import com.project.kambu.model.entity.CurrencyTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    List<Currency> findAllByTableId(CurrencyTable tableId);

    Currency findCurrencyByCode(String code);
}
