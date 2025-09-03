package com.financialtargets.incomes.application.service.impl;

import com.financialtargets.incomes.application.service.SummaryService;
import com.financialtargets.incomes.application.utils.DateUtil;
import com.financialtargets.incomes.domain.enums.IncomeStatuses;
import com.financialtargets.incomes.domain.mapper.IncomesMapper;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.domain.model.IncomesSummary;
import com.financialtargets.incomes.infrastructure.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SummaryServiceImpl implements SummaryService {
    private final IncomeRepository incomeRepository;

    @Override
    public IncomesSummary getSummary(Integer month, Integer year) throws Exception {
        Instant start = DateUtil.getStartDateByFilter(month, year);
        Instant end = DateUtil.getEndDateByFilter(month, year);

        log.trace("Get summary for the period {} to {}", start, end);

        List<Income> incomes = IncomesMapper.toListModel(incomeRepository.findByDateBetween(start, end).stream().toList());

        List<Income> expectedIncomes = incomes.stream().filter(i -> i.getStatus() == IncomeStatuses.PLANNED).toList();
        List<Income> receivedIncomes = incomes.stream().filter(i -> i.getStatus() == IncomeStatuses.EFFECTIVE).toList();

        IncomesSummary incomesSummary = new IncomesSummary();

        incomesSummary.setCountExpected(expectedIncomes.size());
        incomesSummary.setTotalExpected(expectedIncomes.stream().reduce(new BigDecimal(0), (total, income) -> total.add(income.getAmount()), BigDecimal::add));

        incomesSummary.setCountReceived(receivedIncomes.size());
        incomesSummary.setTotalReceived(receivedIncomes.stream().reduce(new BigDecimal(0), (total, income) -> total.add(income.getAmount()), BigDecimal::add));

        return incomesSummary;
    }
}