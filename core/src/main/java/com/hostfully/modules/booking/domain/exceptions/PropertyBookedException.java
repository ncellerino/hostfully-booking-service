package com.hostfully.modules.booking.domain.exceptions;

public class PropertyBookedException extends DomainException {
  public PropertyBookedException(String message) {
    super(message);
  }

  public PropertyBookedException(String messageFormat, Object... args) {
    super(messageFormat, args);
  }
}
