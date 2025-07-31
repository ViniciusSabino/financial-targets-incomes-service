package com.financialtargets.incomes.presentation.controller;

import com.financialtargets.incomes.application.dto.IncomesSummaryDTO;
import org.springframework.http.ResponseEntity;

public interface SummaryController {
    ResponseEntity<IncomesSummaryDTO> getSummary(String month, String year);
}
