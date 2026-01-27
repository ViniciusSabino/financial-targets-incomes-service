package com.financialtargets.incomes.infrastructure.repository;

import com.financialtargets.incomes.infrastructure.entitiy.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UsersEntity, Long> { }