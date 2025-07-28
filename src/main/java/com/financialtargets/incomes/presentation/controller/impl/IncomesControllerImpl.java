package com.financialtargets.incomes.presentation.controller.impl;

import com.financialtargets.incomes.application.dto.IncomesSummaryDTO;
import com.financialtargets.incomes.application.service.IncomesService;
import com.financialtargets.incomes.domain.exception.IncomeException;
import com.financialtargets.incomes.domain.mapper.IncomesMapper;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.domain.model.IncomesSummary;
import com.financialtargets.incomes.application.dto.IncomeCreateDTO;
import com.financialtargets.incomes.application.dto.IncomeDTO;
import com.financialtargets.incomes.presentation.controller.IncomesController;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/incomes")
@RequiredArgsConstructor
public class IncomesControllerImpl implements IncomesController {
    private final IncomesService incomesService;

    @PostMapping
    @Override
    public ResponseEntity<IncomeDTO> create(@RequestBody @Valid IncomeCreateDTO incomeCreateDTO) throws IncomeException {
        Income income = incomesService.create(incomeCreateDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(IncomesMapper.toDTO(income));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<IncomeDTO>> listByMonth(@RequestParam @Valid @NonNull String month, @RequestParam @NonNull @Valid String year) {
        List<Income> incomes = incomesService.listByMonth(month, year);

        return ResponseEntity.status(HttpStatus.OK).body(IncomesMapper.toListDTO(incomes));
    }

    @GetMapping("/summary")
    @Override
    public ResponseEntity<IncomesSummaryDTO> getSummary(@RequestParam @Valid @NonNull String month, @RequestParam @NonNull @Valid String year) {
        IncomesSummary incomesSummary = incomesService.getSummary(month, year);

        return ResponseEntity.status(HttpStatus.OK).body(IncomesMapper.mapSummaryDTO(incomesSummary));
    }
}