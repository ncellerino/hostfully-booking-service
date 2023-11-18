package com.hostfully.modules.booking.domain.exceptions;

public class PropertyBlockedException extends DomainException {
  public PropertyBlockedException(String message) {
    super(message);
  }

  public PropertyBlockedException(String messageFormat, Object... args) {
    super(messageFormat, args);
  }
}
