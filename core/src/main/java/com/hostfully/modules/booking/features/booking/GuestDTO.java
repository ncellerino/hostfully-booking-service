package com.hostfully.modules.booking.features.booking;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GuestDTO {
  private final Long id;
  private final String firstName;
  private final String lastName;
  private final String phone;
  private final String email;
}
