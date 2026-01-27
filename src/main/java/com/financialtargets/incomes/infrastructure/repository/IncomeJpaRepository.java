package com.financialtargets.incomes.infrastructure.repository;

import com.financialtargets.incomes.infrastructure.entitiy.IncomesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeJpaRepository extends JpaRepository<IncomesEntity, Long>, JpaSpecificationExecutor<IncomesEntity> { }