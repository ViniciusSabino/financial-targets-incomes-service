package com.financialtargets.incomes.infrastructure.repository.specification;

import com.financialtargets.incomes.domain.model.DateFilter;
import com.financialtargets.incomes.infrastructure.entitiy.IncomesEntity;
import org.springframework.data.jpa.domain.Specification;

public class IncomeSpecification {
    public static Specification<IncomesEntity> byFilter(DateFilter filter) {
        return (root, query, cb) ->
                cb.between(root.get("date"), filter.getStartDate(), filter.getEndDate());
    }
}