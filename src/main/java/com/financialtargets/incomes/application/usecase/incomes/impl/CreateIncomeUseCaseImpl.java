package com.financialtargets.incomes.application.usecase.incomes.impl;

import com.financialtargets.incomes.application.dto.IncomeCreateDTO;
import com.financialtargets.incomes.application.dto.IncomeResponseDTO;
import com.financialtargets.incomes.application.usecase.incomes.CreateIncomeUseCase;
import com.financialtargets.incomes.domain.exception.IncomeException;
import com.financialtargets.incomes.domain.mapper.IncomesMapper;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.domain.service.IncomesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateIncomeUseCaseImpl implements CreateIncomeUseCase {
    private final IncomesService service;

    @Override
    public IncomeResponseDTO create(IncomeCreateDTO incomeCreateDTO) throws IncomeException {
        service.validIncomeType(incomeCreateDTO.type());

        Income income = new Income(incomeCreateDTO);

        Income savedIncome = service.saveIncome(service.buildIncomeEntity(income));

        return IncomesMapper.toResponse(savedIncome);
    }
}
