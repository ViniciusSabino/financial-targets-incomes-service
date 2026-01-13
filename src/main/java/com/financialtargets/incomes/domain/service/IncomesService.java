package com.financialtargets.incomes.domain.service;

import com.financialtargets.incomes.domain.exception.IncomeException;
import com.financialtargets.incomes.domain.model.DateFilter;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.infrastructure.entitiy.IncomesEntity;

import java.util.List;

public interface IncomesService {
    void validIncomeType(Long type) throws IncomeException;

    IncomesEntity buildIncomeEntity(Income income);

    Income saveIncome(IncomesEntity entity);

    void delete(Long id);

    List<Income> listByDate(DateFilter filter) throws Exception;
}