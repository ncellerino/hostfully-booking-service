package com.hostfully.booking.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;

@Value
public class CreateBlockCommand {
  @NotNull private final LocalDate startDate;
  @NotNull private final LocalDate endDate;
  @NotNull private final Long propertyId;
  @NotNull private final Long ownerId;
}
