package com.financialtargets.incomes.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IncomeDTO {
        @JsonProperty("id")
        private Long id;

        @JsonProperty("userId")
        private Long userId;

        @JsonProperty("accountName")
        private String accountName;

        @JsonProperty("type")
        private String type;

        @JsonProperty("status")
        private String status;

        @JsonProperty("amount")
        private String amount;

        @JsonProperty("date")
        private String date;

        @JsonProperty("description")
        private String description;

        @JsonProperty("createdAt")
        private String createdAt;

        @JsonProperty("updatedAt")
        private String updatedAt;
}
