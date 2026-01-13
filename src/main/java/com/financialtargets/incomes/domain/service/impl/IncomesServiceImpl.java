package com.financialtargets.incomes.domain.service.impl;

import com.financialtargets.incomes.domain.model.DateFilter;
import com.financialtargets.incomes.domain.service.IncomesService;
import com.financialtargets.incomes.domain.enums.IncomeTypes;
import com.financialtargets.incomes.domain.exception.IncomeException;
import com.financialtargets.incomes.domain.mapper.IncomesMapper;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.infrastructure.entitiy.IncomesEntity;
import com.financialtargets.incomes.infrastructure.repository.AccountRepository;
import com.financialtargets.incomes.infrastructure.repository.IncomeRepository;
import com.financialtargets.incomes.infrastructure.repository.IncomeStatusesRepository;
import com.financialtargets.incomes.infrastructure.repository.IncomeTypesRepository;
import com.financialtargets.incomes.infrastructure.repository.UserRepository;
import com.financialtargets.incomes.infrastructure.repository.specification.IncomeSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IncomesServiceImpl implements IncomesService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final IncomeTypesRepository incomeTypesRepository;
    private final IncomeStatusesRepository incomeStatusesRepository;
    private final IncomeRepository incomeRepository;

    @Override
    public void validIncomeType(Long type) throws IncomeException {
        if (!IncomeTypes.isValidType(type)) {
            throw new IncomeException("Incorrect type for input");
        }
    }

    @Override
    public IncomesEntity buildIncomeEntity(Income income) {
        IncomesEntity entity = new IncomesEntity();

        entity.setAmount(income.getAmount());
        entity.setDate(income.getDate());
        entity.setCreatedAt(income.getCreatedAt());
        entity.setUpdatedAt(income.getUpdatedAt());
        entity.setDescription(income.getDescription());

        entity.setUser(userRepository.getReferenceById(income.getUserId()));
        entity.setAccount(accountRepository.getReferenceById(income.getAccountId()));
        entity.setIncomeType(incomeTypesRepository.getReferenceById(income.getType().getId()));
        entity.setIncomeStatus(incomeStatusesRepository.getReferenceById(income.getStatus().getId()));

        return entity;
    }

    @Override
    public Income saveIncome(IncomesEntity entity) {
        Income income = incomeRepository.save(entity).toModel();

        log.info("Income saved successfully, incomeId: {}", income.getId());

        return income;
    }

    @Override
    public void delete(Long id) {
        incomeRepository.deleteById(id);

        log.info("Income delete successfully, incomeId: {}", id);
    }

    @Override
    public List<Income> listByDate(DateFilter filter) throws Exception {
        log.trace("Listing incomes for the period {} to {}", filter.getStartDate(), filter.getEndDate());

        List<IncomesEntity> incomes = incomeRepository.findAll(IncomeSpecification.byFilter(filter)).stream().toList();

        log.info("Listed {} incomes successfully", incomes.stream().toList().size());

        return IncomesMapper.toListModel(incomes);
    }
}