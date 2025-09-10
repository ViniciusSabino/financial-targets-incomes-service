package com.financialtargets.incomes.application.service;

import com.financialtargets.incomes.domain.exception.IncomeException;
import com.financialtargets.incomes.application.dto.IncomeCreateDTO;
import com.financialtargets.incomes.domain.model.Income;

import java.util.List;

public interface IncomesService {
    Income create(IncomeCreateDTO incomeCreateDTO) throws IncomeException;

    void delete(Long id);

    List<Income> listByMonth(Integer month, Integer year) throws Exception;
}
