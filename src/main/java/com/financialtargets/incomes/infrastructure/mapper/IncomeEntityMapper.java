package com.financialtargets.incomes.infrastructure.mapper;

import com.financialtargets.incomes.domain.enums.IncomeStatuses;
import com.financialtargets.incomes.domain.enums.IncomeTypes;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.infrastructure.entitiy.IncomesEntity;
import com.financialtargets.incomes.infrastructure.repository.AccountJpaRepository;
import com.financialtargets.incomes.infrastructure.repository.IncomeStatusesJpaRepository;
import com.financialtargets.incomes.infrastructure.repository.IncomeTypesJpaRepository;
import com.financialtargets.incomes.infrastructure.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IncomeEntityMapper {
    private final UserJpaRepository userJpaRepository;
    private final AccountJpaRepository accountJpaRepository;
    private final IncomeTypesJpaRepository incomeTypesJpaRepository;
    private final IncomeStatusesJpaRepository incomeStatusesJpaRepository;

    public IncomesEntity toEntity(Income income) {
        IncomesEntity entity = new IncomesEntity();

        entity.setAmount(income.getAmount());
        entity.setDate(income.getDate());
        entity.setCreatedAt(income.getCreatedAt());
        entity.setUpdatedAt(income.getUpdatedAt());
        entity.setDescription(income.getDescription());

        entity.setUser(userJpaRepository.getReferenceById(income.getUserId()));
        entity.setAccount(accountJpaRepository.getReferenceById(income.getAccountId()));
        entity.setIncomeType(incomeTypesJpaRepository.getReferenceById(income.getType().getId()));
        entity.setIncomeStatus(incomeStatusesJpaRepository.getReferenceById(income.getStatus().getId()));

        return entity;
    }

    public Income toModel(IncomesEntity entity) {
        return Income.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .accountName(entity.getUser().getName())
                .amount(entity.getAmount())
                .date(entity.getDate())
                .description(entity.getDescription())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .status(IncomeStatuses.getStatusById(entity.getIncomeStatus().getId()))
                .type(IncomeTypes.getTypeById(entity.getIncomeType().getId()))
                .build();
    }
}