package com.financialtargets.incomes.domain.model;

import com.financialtargets.incomes.application.utils.DateUtil;
import com.financialtargets.incomes.domain.enums.IncomeStatuses;
import com.financialtargets.incomes.domain.enums.IncomeTypes;
import com.financialtargets.incomes.application.dto.IncomeCreateDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class Income {

    private Long id;
    private Long userId;
    private String accountName;
    private IncomeTypes type;
    private IncomeStatuses status;
    private BigDecimal amount;
    private Instant date;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;

    public Income() {
    }

    public Income(IncomeCreateDTO incomeCreateDTO) {
        this.userId = incomeCreateDTO.userId();
        this.amount = incomeCreateDTO.amount();
        this.description = incomeCreateDTO.description();

        this.createdAt = DateUtil.now();
        this.updatedAt = DateUtil.now();

        this.setDate(incomeCreateDTO.date());
        this.setStatus(DateUtil.now().isBefore(this.getDate()) ? IncomeStatuses.PLANNED : IncomeStatuses.EFFECTIVE);
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public void setDate(String date) {
        this.date = DateUtil.createDateTime(date);
    }

    public void setStatus(IncomeStatuses incomeStatus) {
        this.status = incomeStatus;
    }

    public void setStatus(Long id) {
        this.status = IncomeStatuses.getStatusById(id);
    }
}
