package com.financialtargets.incomes.application.usecase.summary.impl;

import com.financialtargets.incomes.application.dto.IncomesSummaryResponseDTO;
import com.financialtargets.incomes.application.usecase.summary.GetSummaryUseCase;
import com.financialtargets.incomes.domain.mapper.SummaryMapper;
import com.financialtargets.incomes.domain.model.DateFilter;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.domain.model.IncomesSummary;
import com.financialtargets.incomes.domain.service.IncomesService;
import com.financialtargets.incomes.domain.service.SummaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetSummaryUseCaseImpl implements GetSummaryUseCase {
    private final IncomesService incomesService;
    private final SummaryService service;

    @Override
    public IncomesSummaryResponseDTO byPeriod(String month, String year) throws Exception {
        log.trace("Get summary for the period {}/{}", month, year);

        DateFilter filter = new DateFilter(month, year);

        List<Income> incomes = incomesService.listByDate(filter);

        IncomesSummary incomesSummary = service.getSummaryByIncomes(incomes);

        return SummaryMapper.mapSummaryResponse(incomesSummary);
    }
}