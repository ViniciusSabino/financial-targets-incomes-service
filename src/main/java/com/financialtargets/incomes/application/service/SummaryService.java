package com.financialtargets.incomes.application.service;

import com.financialtargets.incomes.domain.model.IncomesSummary;

public interface SummaryService {
    IncomesSummary getSummary(Integer month, Integer year) throws Exception;
}
