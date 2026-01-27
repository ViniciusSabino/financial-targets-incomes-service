package com.financialtargets.incomes.domain.service;

import com.financialtargets.incomes.domain.model.DateFilter;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.domain.repository.IncomeRepository;

import java.util.List;

public class IncomesDomainService {
    private final IncomeRepository repository;

    public IncomesDomainService(IncomeRepository repository) {
        this.repository = repository;
    }

    public Income save(Income income) {
        return repository.save(income);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public List<Income> listByDate(String month, String year) throws Exception {
        DateFilter dateFilter = new DateFilter(month, year);

        return repository.findByDate(dateFilter);
    }
}