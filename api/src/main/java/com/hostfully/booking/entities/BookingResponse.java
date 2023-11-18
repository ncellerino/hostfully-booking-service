package com.hostfully.booking.entities;

import com.hostfully.modules.booking.domain.enums.BookingState;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class BookingResponse {

  private final Long id;
  private final LocalDate startDate;
  private final LocalDate endDate;
  private final BookingState state;
  private final Long propertyId;
  private final Guest guest;

  @Value
  @Builder
  public static class Guest {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String email;
  }
}
