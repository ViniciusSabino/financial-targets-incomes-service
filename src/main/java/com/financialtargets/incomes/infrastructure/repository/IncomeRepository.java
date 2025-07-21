package com.financialtargets.incomes.infrastructure.repository;

import com.financialtargets.incomes.infrastructure.entitiy.IncomesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface IncomeRepository extends JpaRepository<IncomesEntity, Long> {
    List<IncomesEntity> findByDateBetween(Instant dateStart, Instant dateEnd);
}