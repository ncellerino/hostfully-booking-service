package com.hostfully.booking.entities;

import lombok.Value;

@Value
public class ApiResponse {
  private final Boolean success;
  private final String message;
}
