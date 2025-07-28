package com.financialtargets.incomes.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

public record IncomeCreateDTO (

        @NonNull
        @Positive
        @JsonProperty("userId")
        Long userId,

        @NonNull
        @Positive
        @JsonProperty("accountId")
        Long accountId,

        @NonNull
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
) { }