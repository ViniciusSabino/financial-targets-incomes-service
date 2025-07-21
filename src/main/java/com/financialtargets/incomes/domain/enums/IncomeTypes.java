package com.financialtargets.incomes.domain.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Getter
public enum IncomeTypes {
    SALARY(1L, "Salário"),
    FREELANCER(2L, "Freelancer"),
    THIRTEENTH(3L, "13"),
    PLR(4L, "PLR"),
    OTHER_ENTRIES(5L, "Outras Entradas");

    private final Long id;
    private final String label;

    IncomeTypes(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public static IncomeTypes getTypeById(Long id) {
        Optional<IncomeTypes> filtered = Arrays.stream(IncomeTypes.values()).filter(i -> Objects.equals(i.getId(), id)).findFirst();

        return filtered.orElse(null);
    }

    public static String getLabelById(Long id) {
        Optional<IncomeTypes> filtered = Arrays.stream(IncomeTypes.values()).filter(i -> Objects.equals(i.getId(), id)).findFirst();

        return filtered.map(IncomeTypes::getLabel).orElse(null);

    }

    public static boolean isValidType(Long type) {
        Optional<IncomeTypes> findType = Arrays.stream(IncomeTypes.values()).filter(i -> getTypeById(type) == i).findFirst();

        return findType.isPresent();
    }
}
