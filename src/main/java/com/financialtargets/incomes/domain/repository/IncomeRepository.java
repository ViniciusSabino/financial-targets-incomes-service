package com.financialtargets.incomes.domain.repository;

import com.financialtargets.incomes.domain.model.DateFilter;
import com.financialtargets.incomes.domain.model.Income;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository {
    Income save(Income income);

    List<Income> findByDate(DateFilter dateFilter);

    void delete(Long id);
}