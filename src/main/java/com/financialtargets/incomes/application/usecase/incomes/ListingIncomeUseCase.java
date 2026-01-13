package com.financialtargets.incomes.application.usecase.incomes;

import com.financialtargets.incomes.application.dto.IncomeResponseDTO;

import java.util.List;

public interface ListingIncomeUseCase {
    List<IncomeResponseDTO> byPeriod(String month, String year) throws Exception;
}