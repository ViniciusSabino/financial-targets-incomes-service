package com.financialtargets.incomes.application.service.impl;

import com.financialtargets.incomes.application.service.SummaryService;
import com.financialtargets.incomes.application.utils.DateUtil;
import com.financialtargets.incomes.domain.enums.IncomeStatuses;
import com.financialtargets.incomes.domain.mapper.IncomesMapper;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.domain.model.IncomesSummary;
import com.financialtargets.incomes.infrastructure.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService {
    private final IncomeRepository incomeRepository;

    @Override
    public IncomesSummary getSummary(String month, String year) {
        Instant start = DateUtil.getStartDateByFilter(month, year);
        Instant end = DateUtil.getEndDateByFilter(month, year);

        List<Income> incomes = IncomesMapper.toListModel(incomeRepository.findByDateBetween(start, end).stream().toList());

        List<Income> expectedIncomes = incomes.stream().filter(i -> i.getStatus() == IncomeStatuses.PLANNED).toList();
        List<Income> receivedIncomes = incomes.stream().filter(i -> i.getStatus() == IncomeStatuses.EFFECTIVE).toList();

        IncomesSummary incomesSummary = new IncomesSummary();

        incomesSummary.setCountExpected(expectedIncomes.size());
        incomesSummary.setTotalExpected(expectedIncomes.stream().reduce(0.0F, (total, income) -> total + income.getAmount(), Float::sum));

        incomesSummary.setCountReceived(receivedIncomes.size());
        incomesSummary.setTotalReceived(receivedIncomes.stream().reduce(0.0F, (total, income) -> total + income.getAmount(), Float::sum));

        return incomesSummary;
    }
}