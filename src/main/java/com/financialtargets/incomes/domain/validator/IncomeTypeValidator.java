package com.financialtargets.incomes.domain.validator;

import com.financialtargets.incomes.domain.enums.IncomeTypes;
import com.financialtargets.incomes.domain.exception.IncomeException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class IncomeTypeValidator {
    public void validate(Long type) throws IncomeException {
        Optional<IncomeTypes> typeName = Arrays.stream(IncomeTypes.values()).filter(i -> IncomeTypes.getTypeById(type) == i).findFirst();

        if (typeName.isEmpty()) {
            throw new IncomeException("Incorrect type for input");
        }
    }
}