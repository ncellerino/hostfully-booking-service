package com.hostfully.framework.exceptions;

public abstract class DomainException extends RuntimeException {
  public DomainException(String message) {
    super(message);
  }

  public DomainException(String messageFormat, Object... args) {
    super(String.format(messageFormat, args));
  }
}
