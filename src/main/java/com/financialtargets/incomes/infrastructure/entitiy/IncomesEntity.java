package com.financialtargets.incomes.infrastructure.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@NoArgsConstructor
@Data
@Table(name = "incomes")
@Entity
public class IncomesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UsersEntity user;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false, unique = true)
    private AccountEntity account;

    @ManyToOne
    @JoinColumn(name = "income_type_id", nullable = false, unique = true)
    private IncomeTypesEntity incomeType;

    @ManyToOne
    @JoinColumn(name = "income_status_id", nullable = false, unique = true)
    private IncomeStatusesEntity incomeStatus;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Instant date;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Instant updatedAt;
}
