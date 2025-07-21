package com.financialtargets.incomes.domain.mapper;

import com.financialtargets.incomes.application.dto.IncomeDTO;
import com.financialtargets.incomes.application.utils.AmountUtil;
import com.financialtargets.incomes.application.utils.DateUtil;
import com.financialtargets.incomes.domain.enums.IncomeStatuses;
import com.financialtargets.incomes.domain.enums.IncomeTypes;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.infrastructure.entitiy.IncomesEntity;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class IncomesMapper {

    public Income toModel(IncomesEntity incomeEntity) {
        Income income = new Income();

        income.setId(incomeEntity.getId());
        income.setUserId(incomeEntity.getUser().getId());
        income.setAccountName(incomeEntity.getAccount().getName());
        income.setAmount(incomeEntity.getAmount());
        income.setDate(incomeEntity.getDate());
        income.setDescription(incomeEntity.getDescription());
        income.setCreatedAt(incomeEntity.getCreatedAt());
        income.setUpdatedAt(incomeEntity.getUpdatedAt());
        income.setStatus(incomeEntity.getIncomeStatus().getId());
        income.setType(incomeEntity.getIncomeType().getId());

        return income;
    }

    public List<Income> toModelList(List<IncomesEntity> incomesEntityList) {
        return incomesEntityList.stream().map(IncomesMapper::toModel).toList();
    }

    public IncomeDTO toDTO(Income income) {
        return IncomeDTO.builder()
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

    public List<IncomeDTO> toListDTO(List<Income> incomes) {
        return incomes.stream().map(IncomesMapper::toDTO).toList();
    }
}
