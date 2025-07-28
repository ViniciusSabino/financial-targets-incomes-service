package com.financialtargets.incomes.application.service;

import com.financialtargets.incomes.domain.exception.IncomeException;
import com.financialtargets.incomes.application.dto.IncomeCreateDTO;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.domain.model.IncomesSummary;

import java.util.List;

public interface IncomesService {
    Income create(IncomeCreateDTO incomeCreateDTO) throws IncomeException;

    List<Income> listByMonth(String month, String year);

    IncomesSummary getSummary(String month, String year);
}
