package com.project.kambu.repo;

import com.project.kambu.model.entity.CurrencyTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrencyTableRepository extends JpaRepository<CurrencyTable, Long> {

}
