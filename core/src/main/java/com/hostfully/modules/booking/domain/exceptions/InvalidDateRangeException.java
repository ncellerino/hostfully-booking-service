package com.hostfully.modules.booking.domain.exceptions;

public class InvalidDateRangeException extends DomainException {
  public InvalidDateRangeException(String message) {
    super(message);
  }

  public InvalidDateRangeException(String messageFormat, Object... args) {
    super(messageFormat, args);
  }
}
