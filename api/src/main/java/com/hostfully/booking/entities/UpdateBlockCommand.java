package com.hostfully.booking.entities;

import lombok.Value;

import java.time.LocalDate;

@Value
public class UpdateBlockCommand {
  private LocalDate startDate;
  private LocalDate endDate;
}
