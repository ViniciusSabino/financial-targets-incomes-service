package com.financialtargets.incomes.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class IncomesSummaryDTO extends RepresentationModel<IncomesSummaryDTO> implements Serializable {
    @JsonProperty("totalExpected")
    String totalExpected;

    @JsonProperty("totalExpectedValue")
    BigDecimal totalExpectedValue;

    @JsonProperty("totalReceived")
    String totalReceived;

    @JsonProperty("totalReceivedValue")
    BigDecimal totalReceivedValue;

    @JsonProperty("countExpected")
    Integer countExpected;

    @JsonProperty("countReceived")
    Integer countReceived;
}

