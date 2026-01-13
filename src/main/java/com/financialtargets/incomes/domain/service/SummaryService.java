package com.financialtargets.incomes.domain.service;

import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.domain.model.IncomesSummary;

import java.util.List;

public interface SummaryService {
    IncomesSummary getSummaryByIncomes(List<Income> incomes) throws Exception;
}