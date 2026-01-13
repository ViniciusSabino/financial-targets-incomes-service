package com.financialtargets.incomes.application.usecase.incomes;

import com.financialtargets.incomes.application.dto.IncomeCreateDTO;
import com.financialtargets.incomes.application.dto.IncomeResponseDTO;
import com.financialtargets.incomes.domain.exception.IncomeException;

public interface CreateIncomeUseCase {
    IncomeResponseDTO create(IncomeCreateDTO incomeCreateDTO) throws IncomeException;
}