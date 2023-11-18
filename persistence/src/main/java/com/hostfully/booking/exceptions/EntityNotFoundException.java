package com.hostfully.booking.exceptions;

import com.hostfully.modules.booking.domain.exceptions.DomainException;

public class EntityNotFoundException extends DomainException {
  public EntityNotFoundException(String message) {
    super(message);
  }

  public EntityNotFoundException(String messageFormat, Object... args) {
    super(String.format(messageFormat, args));
  }
}
