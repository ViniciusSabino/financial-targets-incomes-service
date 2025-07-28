package com.financialtargets.incomes.domain.model;

import lombok.Data;

@Data
public class IncomesSummary {

    private Float totalExpected;

    private Float totalReceived;

    private Integer countExpected;

    private Integer countReceived;
}