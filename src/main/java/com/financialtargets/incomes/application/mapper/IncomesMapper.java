package com.financialtargets.incomes.application.mapper;

import com.financialtargets.incomes.application.dto.IncomeCreateDTO;
import com.financialtargets.incomes.domain.utils.AmountUtil;
import com.financialtargets.incomes.domain.utils.DateUtil;
import com.financialtargets.incomes.domain.enums.IncomeStatuses;
import com.financialtargets.incomes.domain.enums.IncomeTypes;
import com.financialtargets.incomes.application.dto.IncomeResponseDTO;
import com.financialtargets.incomes.domain.model.Income;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class IncomesMapper {
    public Income toModel(IncomeCreateDTO incomeCreateDTO) {
        Instant incomeDate = DateUtil.createDateTime(incomeCreateDTO.date());

        return Income.builder()
                .userId(incomeCreateDTO.userId())
                .accountId(incomeCreateDTO.accountId())
                .amount(incomeCreateDTO.amount())
                .description(incomeCreateDTO.description())
                .createdAt(DateUtil.now())
                .updatedAt(DateUtil.now())
                .date(incomeDate)
                .status(DateUtil.now().isBefore(incomeDate) ? IncomeStatuses.PLANNED : IncomeStatuses.EFFECTIVE)
                .build();
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
}