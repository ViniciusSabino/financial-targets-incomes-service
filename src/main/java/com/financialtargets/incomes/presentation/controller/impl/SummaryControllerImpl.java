package com.financialtargets.incomes.presentation.controller.impl;

import com.financialtargets.incomes.application.dto.IncomesSummaryDTO;
import com.financialtargets.incomes.application.service.SummaryService;
import com.financialtargets.incomes.domain.mapper.IncomesMapper;
import com.financialtargets.incomes.domain.model.IncomesSummary;
import com.financialtargets.incomes.presentation.controller.SummaryController;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SummaryControllerImpl implements SummaryController {
    private final SummaryService service;

    @GetMapping("/incomes")
    @Override
    public ResponseEntity<IncomesSummaryDTO> getSummary(@RequestParam @Valid @NonNull String month, @RequestParam @NonNull @Valid String year) {
        IncomesSummary incomesSummary = service.getSummary(month, year);

        return ResponseEntity.status(HttpStatus.OK).body(IncomesMapper.mapSummaryDTO(incomesSummary));
    }
}
