package com.hostfully.booking.controllers;

import com.hostfully.booking.entities.BookingResponse;
import com.hostfully.booking.entities.CreateBookingCommand;
import com.hostfully.booking.entities.UpdateBookingCommand;
import com.hostfully.booking.mappers.BookingMapper;
import com.hostfully.framework.entitybase.Identity;
import com.hostfully.modules.booking.features.booking.usecases.CreateBookingUseCase;
import com.hostfully.modules.booking.features.booking.usecases.DeleteBookingUseCase;
import com.hostfully.modules.booking.features.booking.usecases.UpdateBookingUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookings")
public class BookingController {

  private final CreateBookingUseCase createBookingUseCase;
  private final UpdateBookingUseCase updateBookingUseCase;
  private final DeleteBookingUseCase deleteBookingUseCase;

  @PostMapping("")
  BookingResponse createBooking(@RequestBody @Valid CreateBookingCommand createBookingCommand) {
    CreateBookingUseCase.OutputValues outputValues =
        createBookingUseCase.execute(BookingMapper.map(createBookingCommand));
    return BookingMapper.map(outputValues);
  }

  @PatchMapping("/{id}")
  BookingResponse updateBooking(
      @PathVariable Long id, @RequestBody @Valid UpdateBookingCommand updateBookingCommand) {
    UpdateBookingUseCase.OutputValues outputValues =
        updateBookingUseCase.execute(BookingMapper.map(id, updateBookingCommand));
    return BookingMapper.map(outputValues);
  }

  @DeleteMapping("/{id}")
  BookingResponse deleteBooking(@PathVariable Long id) {
    DeleteBookingUseCase.OutputValues outputValues =
        deleteBookingUseCase.execute(new DeleteBookingUseCase.InputValues(new Identity(id)));
    return BookingMapper.map(outputValues);
  }
}
