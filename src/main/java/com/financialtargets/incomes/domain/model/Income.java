package com.financialtargets.incomes.domain.model;

import com.financialtargets.incomes.application.utils.DateUtil;
import com.financialtargets.incomes.domain.enums.IncomeStatuses;
import com.financialtargets.incomes.domain.enums.IncomeTypes;
import com.financialtargets.incomes.application.dto.IncomeCreateDTO;
import lombok.Data;

import java.time.Instant;

@Data
public class Income {

    private Long id;

    private Long userId;

    private String accountName;

    private IncomeTypes type;

    private IncomeStatuses status;

    private Float amount;

    private Instant date;

    private String description;

    private Instant createdAt;

    private Instant updatedAt;

    public Income() {}

    public Income(IncomeCreateDTO incomeCreateDTO) {
        this.userId = incomeCreateDTO.userId();
        this.amount = incomeCreateDTO.amount();
        this.description = incomeCreateDTO.description();
        this.setDate(incomeCreateDTO.date());

        this.createdAt = DateUtil.getNowGlobalDate();
        this.updatedAt = DateUtil.getNowGlobalDate();
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public void setDate(String date) {
        this.date = DateUtil.getStartOfDayByDate(date);
    }

    public void setType(Long id) {
        this.type = IncomeTypes.getTypeById(id);
    }

    public void setStatus(IncomeStatuses incomeStatus) {
        this.status = incomeStatus;
    }

    public void setStatus(Long id) {
        this.status = IncomeStatuses.getStatusById(id);
    }
}
