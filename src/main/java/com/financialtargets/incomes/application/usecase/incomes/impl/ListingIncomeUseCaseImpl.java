package com.financialtargets.incomes.application.usecase.incomes.impl;

import com.financialtargets.incomes.application.dto.IncomeResponseDTO;
import com.financialtargets.incomes.application.usecase.incomes.ListingIncomeUseCase;
import com.financialtargets.incomes.domain.mapper.IncomesMapper;
import com.financialtargets.incomes.domain.model.DateFilter;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.domain.service.IncomesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ListingIncomeUseCaseImpl implements ListingIncomeUseCase {
    private final IncomesService service;

    @Override
    public List<IncomeResponseDTO> byPeriod(String month, String year) throws Exception {
        DateFilter filter = new DateFilter(month, year);

        List<Income> incomes = service.listByDate(filter);

        return IncomesMapper.toListResponse(incomes);
    }
}