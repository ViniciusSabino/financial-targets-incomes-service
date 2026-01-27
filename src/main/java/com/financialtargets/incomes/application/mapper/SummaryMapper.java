package com.financialtargets.incomes.application.mapper;

import com.financialtargets.incomes.application.dto.IncomesSummaryResponseDTO;
import com.financialtargets.incomes.domain.utils.AmountUtil;
import com.financialtargets.incomes.domain.model.IncomesSummary;
import org.springframework.stereotype.Component;

@Component
public class SummaryMapper {
    public IncomesSummaryResponseDTO toResponse(IncomesSummary incomesSummary) {
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
