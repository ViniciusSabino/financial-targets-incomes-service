package com.financialtargets.incomes.domain.model;

import com.financialtargets.incomes.domain.enums.IncomeStatuses;
import com.financialtargets.incomes.domain.enums.IncomeTypes;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class Income {
    private Long id;

    private Long userId;

    private Long accountId;

    private String accountName;

    private IncomeTypes type;

    private IncomeStatuses status;

    private BigDecimal amount;

    private Instant date;

    private String description;

    private Instant createdAt;

    private Instant updatedAt;
}