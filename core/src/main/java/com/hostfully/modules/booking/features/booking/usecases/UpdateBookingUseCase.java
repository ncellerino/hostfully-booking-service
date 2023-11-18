package com.hostfully.modules.booking.features.booking.usecases;

import com.hostfully.framework.entitybase.Identity;
import com.hostfully.framework.usecase.BaseUseCase;
import com.hostfully.modules.booking.domain.entity.Booking;
import com.hostfully.modules.booking.domain.exceptions.EntityNotFoundException;
import com.hostfully.modules.booking.features.booking.*;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class UpdateBookingUseCase
    extends BaseUseCase<UpdateBookingUseCase.InputValues, UpdateBookingUseCase.OutputValues> {
  private final BookingRepository repository;

  @Override
  public OutputValues execute(InputValues input) {
    Booking savedBooking =
        repository
            .getById(input.id)
            .orElseThrow(
                () -> new EntityNotFoundException("Booking with id %s not found.", input.id));
    Booking updatedBooking =
        savedBooking.update(input.startDate, input.endDate, GuestMapper.fromDTO(input.guestDTO));
    Booking booking = repository.persist(updatedBooking);
    return new OutputValues(BookingMapper.toDTO(booking));
  }

  @Value
  public static class InputValues implements BaseUseCase.InputValues {
    private final Identity id;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final GuestDTO guestDTO;
  }

  @Value
  public static class OutputValues implements BaseUseCase.OutputValues {
    private final BookingDTO bookingDTO;
  }
}
