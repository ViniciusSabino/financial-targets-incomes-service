package com.financialtargets.incomes.application.usecase;

import com.financialtargets.incomes.application.dto.IncomeCreateDTO;
import com.financialtargets.incomes.application.dto.IncomeResponseDTO;
import com.financialtargets.incomes.domain.exception.IncomeException;
import com.financialtargets.incomes.application.mapper.IncomesMapper;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.domain.service.IncomesDomainService;
import com.financialtargets.incomes.domain.validator.IncomeTypeValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateIncomeUseCase {
    private final IncomeTypeValidator incomeTypeValidator;

    private final IncomesDomainService service;

    private final IncomesMapper mapper;

    public IncomeResponseDTO create(IncomeCreateDTO incomeCreateDTO) throws IncomeException {
        incomeTypeValidator.validate(incomeCreateDTO.type());

        Income income = mapper.toModel(incomeCreateDTO);

        Income createdIncome = service.save(income);

        log.info("Income saved successfully, incomeId: {}", income.getId());

        return mapper.toResponse(createdIncome);
    }
}
