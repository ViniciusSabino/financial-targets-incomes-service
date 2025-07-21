package com.financialtargets.incomes.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class IncomeDTO {
        @JsonProperty("id")
        Long id;

        @JsonProperty("userId")
        Long userId;

        @JsonProperty("accountName")
        String accountName;

        @JsonProperty("type")
        String type;

        @JsonProperty("status")
        String status;

        @JsonProperty("amount")
        String amount;

        @JsonProperty("date")
        String date;

        @JsonProperty("description")
        String description;

        @JsonProperty("createdAt")
        String createdAt;

        @JsonProperty("updatedAt")
        String updatedAt;
}
