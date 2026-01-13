package com.financialtargets.incomes.application.usecase.incomes.impl;

import com.financialtargets.incomes.application.usecase.incomes.DeleteIncomeUseCase;
import com.financialtargets.incomes.domain.service.IncomesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteIncomeUseCaseImpl implements DeleteIncomeUseCase {
    private final IncomesService service;

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}