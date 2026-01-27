package com.financialtargets.incomes.application.usecase;

import com.financialtargets.incomes.domain.service.IncomesDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DeleteIncomeUseCase {
    private final IncomesDomainService service;

    public void delete(Long id) {
        service.delete(id);

        log.info("Income delete successfully, incomeId: {}", id);
    }
}