package com.financialtargets.incomes.application.utils;

import com.financialtargets.incomes.domain.constants.DateConstants;
import com.financialtargets.incomes.domain.exception.BadRequestException;
import lombok.experimental.UtilityClass;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtil {
    public Instant createDateTime(String isoDate) {
        LocalDateTime ldt = LocalDateTime.parse(isoDate);

        return ldt.atZone(DateConstants.DEFAULT_TIME_ZONE).toInstant();
    }

    public Instant now() {
        return Instant.now();
    }

    public String formatDate(Instant date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DateConstants.DEFAULT_DATE_FORMAT).withZone(DateConstants.DEFAULT_TIME_ZONE);

        return fmt.format(date);
    }

    public String formatDateTime(Instant date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DateConstants.DEFAULT_DATE_TIME_FORMAT).withZone(DateConstants.DEFAULT_TIME_ZONE);

        return fmt.format(date);
    }

    public Instant getStartDateByFilter(Integer month, Integer year) throws Exception {
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DateConstants.DEFAULT_DATE_FORMAT).withZone(DateConstants.DEFAULT_TIME_ZONE);

            String adjustedMonth = month.toString().length() < 2 ? "0" + month : month.toString();

            LocalDate firstDateOfMonth = LocalDate.parse(String.format("01/%s/%s", adjustedMonth, year), fmt);

            return firstDateOfMonth.atStartOfDay(DateConstants.DEFAULT_TIME_ZONE).toInstant();
        } catch (DateTimeException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Instant getEndDateByFilter(Integer month, Integer year) throws Exception {
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DateConstants.DEFAULT_DATE_FORMAT).withZone(DateConstants.DEFAULT_TIME_ZONE);

            String adjustedMonth = month.toString().length() < 2 ? "0" + month : month.toString();

            LocalDate firstDateOfMonth = LocalDate.parse(String.format("01/%s/%s", adjustedMonth, year), fmt);
            LocalDate lastDateOfMonth = firstDateOfMonth.withDayOfMonth(firstDateOfMonth.lengthOfMonth());

            return lastDateOfMonth.atTime(23, 59, 59, 999).atZone(DateConstants.DEFAULT_TIME_ZONE).toInstant();
        } catch (DateTimeException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }
}
