package com.financialtargets.incomes.infrastructure.config;

import com.financialtargets.incomes.domain.repository.IncomeRepository;
import com.financialtargets.incomes.domain.service.IncomesDomainService;
import com.financialtargets.incomes.domain.service.SummaryDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainServicesConfig {

    @Bean
    public IncomesDomainService incomesDomainService(IncomeRepository repository) {
        return new IncomesDomainService(repository);
    }

    @Bean
    public SummaryDomainService summaryDomainService() {
        return new SummaryDomainService();
    }
}
