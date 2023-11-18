package com.hostfully.booking.entities;

import lombok.Value;

import java.time.LocalDate;

@Value
public class UpdateBookingCommand {
  private LocalDate startDate;
  private LocalDate endDate;
  private UpdateGuest guest;

  @Value
  public static class UpdateGuest {
    private final String firstName;
    private final String lastName;
    private final String phone;
  }
}
