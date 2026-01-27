package com.financialtargets.incomes.infrastructure.repository;

import com.financialtargets.incomes.infrastructure.entitiy.IncomeTypesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeTypesJpaRepository extends JpaRepository<IncomeTypesEntity, Long> { }
