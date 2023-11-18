package com.hostfully.modules.booking.utils;

import com.hostfully.modules.booking.domain.exceptions.InvalidDateRangeException;

import java.time.LocalDate;

public class DateRangeValidator {
  public static void validateDateRange(LocalDate startDate, LocalDate endDate) {
    if (startDate.isBefore(LocalDate.now())) {
      throw new InvalidDateRangeException(
          "The start date provided cannot be in the past.", startDate);
    }
    if (endDate.isBefore(startDate)) {
      throw new InvalidDateRangeException(
          "The end date %s provided cannot be older than the start date %s.", endDate, startDate);
    }
  }
}
