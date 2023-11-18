package com.hostfully.modules.booking.features.booking.usecases;

import com.hostfully.framework.usecase.BaseUseCase;
import com.hostfully.modules.booking.domain.entity.Booking;
import com.hostfully.modules.booking.domain.exceptions.PropertyBlockedException;
import com.hostfully.modules.booking.domain.exceptions.PropertyBookedException;
import com.hostfully.modules.booking.features.block.BlockRepository;
import com.hostfully.modules.booking.features.booking.*;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class CreateBookingUseCase
    extends BaseUseCase<CreateBookingUseCase.InputValues, CreateBookingUseCase.OutputValues> {
  private final BookingRepository repository;
  private final BlockRepository blockRepository;

  @Override
  public OutputValues execute(InputValues input) {
    Booking newBooking =
        Booking.newInstance(
            input.startDate, input.endDate, input.propertyId, GuestMapper.fromDTO(input.guestDTO));

    boolean bookingExist =
        repository.isPropertyBookedBetweenDates(input.propertyId, input.startDate, input.endDate);

    if (bookingExist) {
      throw new PropertyBookedException(
          "The property %s is already booked for the provided dates %s %s",
          input.propertyId, input.startDate, input.endDate);
    }

    boolean blockExist =
        blockRepository.isPropertyBlockedBetweenDates(
            input.propertyId, input.startDate, input.endDate);

    if (blockExist) {
      throw new PropertyBlockedException(
          "The property %s is already blocked by the owner for the provided dates %s %s",
          input.propertyId, input.startDate, input.endDate);
    }

    Booking booking = repository.persist(newBooking);
    return new OutputValues(BookingMapper.toDTO(booking));
  }

  @Value
  public static class InputValues implements BaseUseCase.InputValues {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Long propertyId;
    private final GuestDTO guestDTO;
  }

  @Value
  public static class OutputValues implements BaseUseCase.OutputValues {
    private final BookingDTO bookingDTO;
  }
}
