package com.financialtargets.incomes.domain.service;

import com.financialtargets.incomes.domain.enums.IncomeStatuses;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.domain.model.IncomesSummary;

import java.math.BigDecimal;
import java.util.List;

public class SummaryDomainService {

    public IncomesSummary getSummaryByIncomes(List<Income> incomes) {
        List<Income> expectedIncomes = incomes.stream().filter(i -> i.getStatus() == IncomeStatuses.PLANNED).toList();
        List<Income> effectiveIncomes = incomes.stream().filter(i -> i.getStatus() == IncomeStatuses.EFFECTIVE).toList();

        IncomesSummary incomesSummary = new IncomesSummary();

        incomesSummary.setCountExpected(expectedIncomes.size());
        incomesSummary.setTotalExpected(expectedIncomes.stream().reduce(new BigDecimal(0), (total, income) -> total.add(income.getAmount()), BigDecimal::add));

        incomesSummary.setCountReceived(effectiveIncomes.size());
        incomesSummary.setTotalReceived(effectiveIncomes.stream().reduce(new BigDecimal(0), (total, income) -> total.add(income.getAmount()), BigDecimal::add));

        return incomesSummary;
    }
}