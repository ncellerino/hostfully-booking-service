package com.hostfully.modules.booking.domain.exceptions;

public class EntityNotFoundException extends DomainException {
  public EntityNotFoundException(String message) {
    super(message);
  }

  public EntityNotFoundException(String messageFormat, Object... args) {
    super(messageFormat, args);
  }
}
