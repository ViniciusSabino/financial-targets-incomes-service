package com.financialtargets.incomes.application.service.impl;

import com.financialtargets.incomes.application.dto.IncomeCreateDTO;
import com.financialtargets.incomes.application.service.IncomesService;
import com.financialtargets.incomes.application.utils.DateUtil;
import com.financialtargets.incomes.domain.constants.DateConstants;
import com.financialtargets.incomes.domain.enums.IncomeStatuses;
import com.financialtargets.incomes.domain.enums.IncomeTypes;
import com.financialtargets.incomes.domain.exception.IncomeException;
import com.financialtargets.incomes.domain.mapper.IncomesMapper;
import com.financialtargets.incomes.domain.model.Income;
import com.financialtargets.incomes.infrastructure.entitiy.AccountEntity;
import com.financialtargets.incomes.infrastructure.entitiy.IncomeStatusesEntity;
import com.financialtargets.incomes.infrastructure.entitiy.IncomeTypesEntity;
import com.financialtargets.incomes.infrastructure.entitiy.IncomesEntity;
import com.financialtargets.incomes.infrastructure.entitiy.UsersEntity;
import com.financialtargets.incomes.infrastructure.repository.AccountRepository;
import com.financialtargets.incomes.infrastructure.repository.IncomeRepository;
import com.financialtargets.incomes.infrastructure.repository.IncomeStatusesRepository;
import com.financialtargets.incomes.infrastructure.repository.IncomeTypesRepository;
import com.financialtargets.incomes.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomesServiceImpl implements IncomesService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final IncomeTypesRepository incomeTypesRepository;
    private final IncomeStatusesRepository incomeStatusesRepository;
    private final IncomeRepository incomeRepository;

    @Override
    public Income create(IncomeCreateDTO incomeCreateDTO) throws IncomeException {
        if(!DateUtil.isCurrentMonth(incomeCreateDTO.date())) throw new IncomeException("A data deve fazer parte do mês atual", HttpStatus.BAD_REQUEST);

        if(!IncomeTypes.isValidType(incomeCreateDTO.type())) throw new IncomeException("Tipo incorreto para a entrada", HttpStatus.BAD_REQUEST);

        Income income = new Income(incomeCreateDTO);

        income.setStatus(DateUtil.getNowGlobalDate().isBefore(income.getDate()) ? IncomeStatuses.PLANNED : IncomeStatuses.EFFECTIVE);

        UsersEntity usersEntity = userRepository.getReferenceById(incomeCreateDTO.userId());
        AccountEntity accountEntity = accountRepository.getReferenceById(incomeCreateDTO.accountId());
        IncomeTypesEntity incomeTypesEntity = incomeTypesRepository.getReferenceById(incomeCreateDTO.type());
        IncomeStatusesEntity incomeStatusesEntity = incomeStatusesRepository.getReferenceById(income.getStatus().getId());

        IncomesEntity incomeEntity = new IncomesEntity();

        incomeEntity.setUser(usersEntity);
        incomeEntity.setAccount(accountEntity);
        incomeEntity.setIncomeType(incomeTypesEntity);
        incomeEntity.setIncomeStatus(incomeStatusesEntity);
        incomeEntity.setAmount(income.getAmount());
        incomeEntity.setDate(income.getDate());
        incomeEntity.setCreatedAt(income.getCreatedAt());
        incomeEntity.setUpdatedAt(income.getUpdatedAt());
        incomeEntity.setDescription(income.getDescription());

        return incomeRepository.save(incomeEntity).toModel();
    }

    @Override
    public List<Income> listByMonth(String month, String year) {
        Instant start = DateUtil.getStartDateByFilter(month, year);
        Instant end = DateUtil.getEndDateByFilter(month, year);

        List<IncomesEntity> incomesEntityList = incomeRepository.findByDateBetween(start, end).stream().toList();

        return IncomesMapper.toModelList(incomesEntityList);
    }
}
