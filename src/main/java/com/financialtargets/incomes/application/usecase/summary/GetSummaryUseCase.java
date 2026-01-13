package com.financialtargets.incomes.application.usecase.summary;

import com.financialtargets.incomes.application.dto.IncomesSummaryResponseDTO;
import org.springframework.http.ResponseEntity;

public interface GetSummaryUseCase {
    IncomesSummaryResponseDTO byPeriod(String month, String year) throws Exception;
}