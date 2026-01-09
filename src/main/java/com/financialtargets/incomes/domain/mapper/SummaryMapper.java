package com.financialtargets.incomes.domain.mapper;

import com.financialtargets.incomes.application.dto.IncomesSummaryResponseDTO;
import com.financialtargets.incomes.application.utils.AmountUtil;
import com.financialtargets.incomes.domain.model.IncomesSummary;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SummaryMapper {
    public IncomesSummaryResponseDTO mapSummaryResponse(IncomesSummary incomesSummary) {
        return IncomesSummaryResponseDTO.builder()
                .countExpected(incomesSummary.getCountExpected())
                .totalExpected(AmountUtil.formatAmount(incomesSummary.getTotalExpected()))
                .totalExpectedValue(incomesSummary.getTotalExpected())
                .countReceived(incomesSummary.getCountReceived())
                .totalReceived(AmountUtil.formatAmount(incomesSummary.getTotalReceived()))
                .totalReceivedValue(incomesSummary.getTotalReceived())
                .build();
    }
}
