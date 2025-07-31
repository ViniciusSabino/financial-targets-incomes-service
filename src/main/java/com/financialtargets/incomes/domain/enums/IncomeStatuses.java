package com.financialtargets.incomes.domain.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Getter
public enum IncomeStatuses {
    PLANNED(1L, "Planejado"),
    EFFECTIVE(2L, "Efetivado");

    private final Long id;
    private final String label;

    IncomeStatuses(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public static IncomeStatuses getStatusById(Long id) {
        Optional<IncomeStatuses> filtered = Arrays.stream(IncomeStatuses.values()).filter(i -> Objects.equals(i.getId(), id)).findFirst();

        return filtered.orElse(IncomeStatuses.EFFECTIVE);
    }

    public static String getLabelById(Long id) {
        Optional<IncomeStatuses> filtered = Arrays.stream(IncomeStatuses.values()).filter(i -> Objects.equals(i.getId(), id)).findFirst();

        if (filtered.isPresent()) {
            return filtered.get().getLabel();
        }

        return IncomeStatuses.EFFECTIVE.getLabel();
    }
}