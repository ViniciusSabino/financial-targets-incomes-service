package com.financialtargets.incomes.infrastructure.repository.impl;

import com.financialtargets.incomes.domain.model.DateFilter;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.domain.repository.IncomeRepository;
import com.financialtargets.incomes.infrastructure.entitiy.IncomesEntity;
import com.financialtargets.incomes.infrastructure.mapper.IncomeEntityMapper;
import com.financialtargets.incomes.infrastructure.repository.IncomeJpaRepository;
import com.financialtargets.incomes.infrastructure.repository.specification.IncomeSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class IncomeRepositoryImpl implements IncomeRepository {
    private final IncomeJpaRepository repository;

    private final IncomeEntityMapper mapper;

    @Override
    public Income save(Income income) {
        IncomesEntity entity = mapper.toEntity(income);

        IncomesEntity savedIncome = repository.save(entity);

        return mapper.toModel(savedIncome);
    }

    @Override
    public List<Income> findByDate(DateFilter dateFilter) {
        List<IncomesEntity> incomes = repository.findAll(IncomeSpecification.byFilter(dateFilter)).stream().toList();

        return incomes.stream().map(mapper::toModel).toList();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}