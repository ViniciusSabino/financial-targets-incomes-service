package com.financialtargets.incomes.domain.mapper;

import com.financialtargets.incomes.application.utils.AmountUtil;
import com.financialtargets.incomes.application.utils.DateUtil;
import com.financialtargets.incomes.domain.enums.IncomeStatuses;
import com.financialtargets.incomes.domain.enums.IncomeTypes;
import com.financialtargets.incomes.application.dto.IncomeResponseDTO;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.infrastructure.entitiy.IncomesEntity;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class IncomesMapper {
    public Income toModel(IncomesEntity entity) {
        Income income = new Income();

        income.setId(entity.getId());
        income.setUserId(entity.getUser().getId());
        income.setAccountName(entity.getAccount().getName());
        income.setAmount(entity.getAmount());
        income.setDate(entity.getDate());
        income.setDescription(entity.getDescription());
        income.setCreatedAt(entity.getCreatedAt());
        income.setUpdatedAt(entity.getUpdatedAt());
        income.setStatus(entity.getIncomeStatus().getId());
        income.setType(IncomeTypes.getTypeById(entity.getIncomeType().getId()));

        return income;
    }

    public List<Income> toListModel(List<IncomesEntity> incomesEntityList) {
        return incomesEntityList.stream().map(IncomesMapper::toModel).toList();
    }

    public IncomeResponseDTO toResponse(Income income) {
        return IncomeResponseDTO.builder()
                .id(income.getId())
                .userId(income.getUserId())
                .accountName(income.getAccountName())
                .type(IncomeTypes.getLabelById(income.getType().getId()))
                .status(IncomeStatuses.getLabelById(income.getStatus().getId()))
                .amount(AmountUtil.formatAmount(income.getAmount()))
                .date(DateUtil.formatDate(income.getDate()))
                .description(income.getDescription())
                .createdAt(DateUtil.formatDateTime(income.getCreatedAt()))
                .updatedAt(DateUtil.formatDateTime(income.getUpdatedAt()))
                .build();
    }

    public List<IncomeResponseDTO> toListResponse(List<Income> incomes) {
        return incomes.stream().map(IncomesMapper::toResponse).toList();
    }
}