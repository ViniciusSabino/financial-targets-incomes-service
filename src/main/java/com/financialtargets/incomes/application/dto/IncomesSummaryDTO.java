package com.financialtargets.incomes.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record IncomesSummaryDTO (

        @JsonProperty("totalExpected")
        String totalExpected,

        @JsonProperty("totalReceived")
        String totalReceived,

        @JsonProperty("countExpected")
        Integer countExpected,

        @JsonProperty("countReceived")
        Integer countReceived
) {}

