package com.financialtargets.incomes.domain.service.impl;

import com.financialtargets.incomes.domain.service.SummaryService;
import com.financialtargets.incomes.domain.enums.IncomeStatuses;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.domain.model.IncomesSummary;
import com.financialtargets.incomes.infrastructure.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SummaryServiceImpl implements SummaryService {
    private final IncomeRepository incomeRepository;

    @Override
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