package com.financialtargets.incomes.application.usecase;

import com.financialtargets.incomes.application.dto.IncomesSummaryResponseDTO;
import com.financialtargets.incomes.application.mapper.SummaryMapper;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.domain.model.IncomesSummary;
import com.financialtargets.incomes.domain.service.IncomesDomainService;
import com.financialtargets.incomes.domain.service.SummaryDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class GetSummaryUseCase {
    private final IncomesDomainService incomesDomainService;
    private final SummaryDomainService summaryDomainService;

    private final SummaryMapper mapper;

    public IncomesSummaryResponseDTO byPeriod(String month, String year) throws Exception {
        log.trace("Get summary for the period {}/{}", month, year);

        List<Income> incomes = incomesDomainService.listByDate(month, year);

        IncomesSummary incomesSummary = summaryDomainService.getSummaryByIncomes(incomes);

        return mapper.toResponse(incomesSummary);
    }
}