package com.hostfully.booking.entities;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;

@Value
public class CreateBookingCommand {
  @NotNull private final LocalDate startDate;
  @NotNull private final LocalDate endDate;
  @NotNull @Valid private final Guest guest;
  @NotNull private final Long propertyId;

  @Value
  public static class Guest {
    @NotBlank private final String firstName;
    @NotBlank private final String lastName;
    @NotBlank private final String phone;

    @Email(
        message = "Email is not valid",
        regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotBlank(message = "Email cannot be empty")
    private final String email;
  }
}
