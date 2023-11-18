package com.hostfully.modules.booking.features.booking.usecases;

import com.hostfully.framework.entitybase.Identity;
import com.hostfully.framework.usecase.BaseUseCase;
import com.hostfully.modules.booking.domain.entity.Booking;
import com.hostfully.modules.booking.features.booking.BookingDTO;
import com.hostfully.modules.booking.features.booking.BookingMapper;
import com.hostfully.modules.booking.features.booking.BookingRepository;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteBookingUseCase
    extends BaseUseCase<DeleteBookingUseCase.InputValues, DeleteBookingUseCase.OutputValues> {
  private final BookingRepository repository;

  @Override
  public OutputValues execute(InputValues input) {
    Booking booking = repository.getByIdOrThrow(input.getId());
    Booking deletedBooking = booking.delete();
    Booking result = repository.persist(deletedBooking);

    return new OutputValues(BookingMapper.toDTO(result));
  }

  @Value
  public static class InputValues implements BaseUseCase.InputValues {
    private final Identity id;
  }

  @Value
  public static class OutputValues implements BaseUseCase.OutputValues {
    private final BookingDTO bookingDTO;
  }
}
