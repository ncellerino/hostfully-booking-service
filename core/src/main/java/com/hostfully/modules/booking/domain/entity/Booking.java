package com.hostfully.modules.booking.domain.entity;

import com.hostfully.framework.entitybase.Entity;
import com.hostfully.framework.entitybase.Identity;
import com.hostfully.modules.booking.domain.enums.BookingState;
import com.hostfully.modules.booking.domain.exceptions.BookingAlreadyCancelledException;
import com.hostfully.modules.booking.utils.DateRangeValidator;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Booking extends Entity {
  private final Identity id;
  private final LocalDate startDate;
  private final LocalDate endDate;
  private final BookingState state;
  private final Long propertyId;
  private final Guest guest;

  public static Booking newInstance(
      LocalDate startDate, LocalDate endDate, Long propertyId, Guest guest) {
    DateRangeValidator.validateDateRange(startDate, endDate);
    return Booking.builder()
        .startDate(startDate)
        .endDate(endDate)
        .propertyId(propertyId)
        .state(BookingState.CREATED)
        .guest(guest)
        .build();
  }

  public Booking newInstanceWith(BookingState state) {
    return Booking.builder()
        .id(id)
        .startDate(startDate)
        .endDate(endDate)
        .propertyId(propertyId)
        .state(state)
        .guest(guest)
        .build();
  }

  public Booking update(LocalDate startDate, LocalDate endDate, Guest guestUpdateData) {
    DateRangeValidator.validateDateRange(startDate, endDate);
    Guest updatedGuest =
        guest.update(
            guestUpdateData.getFirstName(),
            guestUpdateData.getLastName(),
            guestUpdateData.getPhone());
    return new Booking(id, startDate, endDate, state, propertyId, updatedGuest);
  }

  public Booking delete() {
    if (this.state == BookingState.CANCELLED) {
      throw new BookingAlreadyCancelledException("Booking is already canceled");
    }
    return newInstanceWith(BookingState.CANCELLED);
  }
}
