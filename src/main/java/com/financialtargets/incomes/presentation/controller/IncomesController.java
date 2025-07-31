package com.financialtargets.incomes.presentation.controller;

import com.financialtargets.incomes.application.dto.IncomeCreateDTO;
import com.financialtargets.incomes.application.dto.IncomeDTO;
import com.financialtargets.incomes.domain.exception.IncomeException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IncomesController {
    ResponseEntity<IncomeDTO> create(IncomeCreateDTO incomeCreateDTO) throws IncomeException;

    ResponseEntity<List<IncomeDTO>> listByMonth(String month, String year);
}
