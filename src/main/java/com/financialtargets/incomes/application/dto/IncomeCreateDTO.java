package com.financialtargets.incomes.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record IncomeCreateDTO(
        @NotNull
        @Positive
        @JsonProperty("userId")
        Long userId,

        @NotNull
        @Positive
        @JsonProperty("accountId")
        Long accountId,

        @NotNull
        @Positive
        @JsonProperty("type")
        Long type,

        @NotNull
        @Positive
        @JsonProperty("amount")
        Float amount,

        @NotNull
        @JsonProperty("date")
        String date,

        @Length(max = 50)
        @JsonProperty("description")
        String description
) {
}