package com.hostfully.modules.booking.domain.exceptions;

public class BookingAlreadyCancelledException extends DomainException {
  public BookingAlreadyCancelledException(String message) {
    super(message);
  }

  public BookingAlreadyCancelledException(String messageFormat, Object... args) {
    super(messageFormat, args);
  }
}
