package com.financialtargets.incomes.presentation.controller.impl;

import com.financialtargets.incomes.application.usecase.incomes.CreateIncomeUseCase;
import com.financialtargets.incomes.application.usecase.incomes.DeleteIncomeUseCase;
import com.financialtargets.incomes.application.usecase.incomes.ListingIncomeUseCase;
import com.financialtargets.incomes.domain.exception.IncomeException;
import com.financialtargets.incomes.application.dto.IncomeCreateDTO;
import com.financialtargets.incomes.application.dto.IncomeResponseDTO;
import com.financialtargets.incomes.presentation.controller.IncomesController;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/incomes", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class IncomesControllerImpl implements IncomesController {
    private final CreateIncomeUseCase createIncomeUseCase;
    private final DeleteIncomeUseCase deleteIncomeUseCase;
    private final ListingIncomeUseCase listingIncomeUseCase;

    @PostMapping
    @Override
    public ResponseEntity<IncomeResponseDTO> create(@RequestBody @Valid IncomeCreateDTO incomeCreateDTO) throws IncomeException {
        log.trace("POST /incomes - Creating new income for user {}", incomeCreateDTO.userId());
        log.debug("Request body: {}", incomeCreateDTO);

        IncomeResponseDTO income = createIncomeUseCase.create(incomeCreateDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(income);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        log.trace("DELETE /incomes - Deleting a income for id {}", id);

        deleteIncomeUseCase.delete(Long.valueOf(id));

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    @Override
    public ResponseEntity<List<IncomeResponseDTO>> listByMonth(@RequestParam @Valid @NonNull String month, @RequestParam @NonNull @Valid String year) throws Exception {
        log.trace("GET /incomes - List Incomes by month: {} and year: {}", month, year);

        List<IncomeResponseDTO> incomes = listingIncomeUseCase.byPeriod(month, year);

        return ResponseEntity.status(HttpStatus.OK).body(incomes);
    }
}