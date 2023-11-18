package com.hostfully.booking.mappers;

import com.hostfully.booking.entities.BookingResponse;
import com.hostfully.booking.entities.CreateBookingCommand;
import com.hostfully.booking.entities.UpdateBookingCommand;
import com.hostfully.framework.entitybase.Identity;
import com.hostfully.modules.booking.features.booking.BookingDTO;
import com.hostfully.modules.booking.features.booking.GuestDTO;
import com.hostfully.modules.booking.features.booking.usecases.CreateBookingUseCase;
import com.hostfully.modules.booking.features.booking.usecases.DeleteBookingUseCase;
import com.hostfully.modules.booking.features.booking.usecases.UpdateBookingUseCase;

public class BookingMapper {
  public static CreateBookingUseCase.InputValues map(CreateBookingCommand createBookingCommand) {
    return new CreateBookingUseCase.InputValues(
        createBookingCommand.getStartDate(),
        createBookingCommand.getEndDate(),
        createBookingCommand.getPropertyId(),
        map(createBookingCommand.getGuest()));
  }

  public static UpdateBookingUseCase.InputValues map(
      Long id, UpdateBookingCommand updateBookingCommand) {
    return new UpdateBookingUseCase.InputValues(
        new Identity(id),
        updateBookingCommand.getStartDate(),
        updateBookingCommand.getEndDate(),
        map(updateBookingCommand.getGuest()));
  }

  public static BookingResponse map(CreateBookingUseCase.OutputValues outputValues) {
    BookingDTO bookingDTO = outputValues.getBookingDTO();
    return fromBookingDTO(bookingDTO);
  }

  public static BookingResponse map(UpdateBookingUseCase.OutputValues outputValues) {
    BookingDTO bookingDTO = outputValues.getBookingDTO();
    return fromBookingDTO(bookingDTO);
  }

  public static BookingResponse map(DeleteBookingUseCase.OutputValues outputValues) {
    BookingDTO bookingDTO = outputValues.getBookingDTO();
    return fromBookingDTO(bookingDTO);
  }

  private static BookingResponse fromBookingDTO(BookingDTO bookingDTO) {
    return BookingResponse.builder()
        .id(bookingDTO.getId())
        .startDate(bookingDTO.getStartDate())
        .endDate(bookingDTO.getEndDate())
        .state(bookingDTO.getState())
        .propertyId(bookingDTO.getPropertyId())
        .guest(map(bookingDTO.getGuest()))
        .build();
  }

  private static BookingResponse.Guest map(GuestDTO guestDTO) {
    return BookingResponse.Guest.builder()
        .id(guestDTO.getId())
        .firstName(guestDTO.getFirstName())
        .lastName(guestDTO.getLastName())
        .phone(guestDTO.getPhone())
        .email(guestDTO.getEmail())
        .build();
  }

  private static GuestDTO map(CreateBookingCommand.Guest guest) {
    return GuestDTO.builder()
        .firstName(guest.getFirstName())
        .lastName(guest.getLastName())
        .phone(guest.getPhone())
        .email(guest.getEmail())
        .build();
  }

  private static GuestDTO map(UpdateBookingCommand.UpdateGuest guest) {
    return GuestDTO.builder()
        .firstName(guest.getFirstName())
        .lastName(guest.getLastName())
        .phone(guest.getPhone())
        .build();
  }
}
