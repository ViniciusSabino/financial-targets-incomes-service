package com.financialtargets.incomes.infrastructure.repository;

import com.financialtargets.incomes.infrastructure.entitiy.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> { }
